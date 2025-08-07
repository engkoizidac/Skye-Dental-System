package app.view.signature.doctor;

import app.global.Transparent;
import app.global.FileFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.RGBImageFilter;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class SignatureDoctor extends javax.swing.JDialog {

    public static CurrentSignatureDoctor frmParent;
    public static int DentistId;
    static Rectangle clip;

    public SignatureDoctor(CurrentSignatureDoctor parent, boolean modal) {
        this.frmParent = parent;
        this.setModal(modal);
        initComponents();
        paint();
        setLocationRelativeTo(this);
    }

    void paint() {
        Container content = this.sigpanel;
        //Creates a new container
        content.setLayout(new BorderLayout());
        //sets the layout

        final PadDraw drawPad = new PadDraw();
        //creates a new padDraw, which is pretty much the paint program

        content.add(drawPad, BorderLayout.CENTER);
    }

    class PadDraw extends JComponent {
        Image image;
        Graphics2D graphics2D;
        int currentX, currentY, oldX, oldY;

        public PadDraw() {
            setDoubleBuffered(false);
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    oldX = e.getX();
                    oldY = e.getY();
                }
            });
            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    currentX = e.getX();
                    currentY = e.getY();
                    if (graphics2D != null) {
                        graphics2D.drawLine(oldX, oldY, currentX, currentY);
                    }
                    repaint();
                    oldX = currentX;
                    oldY = currentY;
                }
            });
        }

        public void paintComponent(Graphics g) {
            if (image == null) {
                image = createImage(getSize().width, getSize().height);
                graphics2D = (Graphics2D) image.getGraphics();
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                clear();
            }
            g.drawImage(image, 0, 0, null);
        }

        public void clear() {
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            repaint();
        }

        public void black() {
            graphics2D.setPaint(Color.black);
            repaint();
        }
    }

    private static class BackgroundFilter extends RGBImageFilter {

        boolean setUp = false;
        int bgColor;

        @Override
        public int filterRGB(int x, int y, int rgb) {
            int colorWOAlpha = rgb & 0xFFFFFF;
            if (!setUp && x == 0 && y == 0) {
                bgColor = colorWOAlpha;
                setUp = true;
            } else if (colorWOAlpha == bgColor) {
                return colorWOAlpha;
            }
            return rgb;
        }
    }

    public void save() {
        BufferedImage bImg = new BufferedImage(sigpanel.getWidth(), sigpanel.getWidth(), BufferedImage.TYPE_INT_ARGB);
        // BufferedImage bImg = new BufferedImage(jPanel1.getWidth(), jPanel1.getWidth(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D cg = bImg.createGraphics();
//       cg.setComposite(AlphaComposite.Clear);
//        cg.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getWidth());
//        cg.setComposite(AlphaComposite.Src);
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        cg.setRenderingHints(rh);

        sigpanel.paintAll(cg);

        try {
            if (ImageIO.write(bImg, "png", new File("./map.png"))) {
                System.out.println("-- saved");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void capsave() {

    }

    public void saveImg() {
        BufferedImage bImg = new BufferedImage(400, 120, BufferedImage.TYPE_INT_ARGB);
        // BufferedImage bImg = new BufferedImage(jPanel1.getWidth(), jPanel1.getWidth(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D cg = bImg.createGraphics();
//       cg.setComposite(AlphaComposite.Clear);
//        cg.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getWidth());
//        cg.setComposite(AlphaComposite.Src);
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        cg.setRenderingHints(rh);

        sigpanel.paintAll(cg);

        try {
            if (ImageIO.write(bImg, "png", new File("./etc/temp/img.png"))) {
                //System.out.println("-- saved");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static BufferedImage readImage(String fileLocation) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fileLocation));
        } catch (IOException e) {
        }
        return img;
    }

    public static void writeImage(BufferedImage img, String fileLocation, String extension) {
        try {
            BufferedImage bi = img;
            File outputfile = new File(fileLocation);
            ImageIO.write(bi, extension, outputfile);
        } catch (IOException e) {
        }
    }

    public static BufferedImage cropMyImage(BufferedImage img, int cropWidth, int cropHeight, int cropStartX, int cropStartY) throws Exception {
        BufferedImage clipped = null;
        Dimension size = new Dimension(cropWidth, cropHeight);

        createClip(img, size, cropStartX, cropStartY);

        try {
            int w = clip.width;
            int h = clip.height;
            clipped = img.getSubimage(clip.x, clip.y, w, h);
        } catch (RasterFormatException rfe) {
            return null;
        }
        return clipped;
    }

    private static void createClip(BufferedImage img, Dimension size,
            int clipX, int clipY) throws Exception {

        boolean isClipAreaAdjusted = false;

        if (clipX < 0) {
            clipX = 0;
            isClipAreaAdjusted = true;
        }

        if (clipY < 0) {
            clipY = 0;
            isClipAreaAdjusted = true;
        }

        if ((size.width + clipX) <= img.getWidth()
                && (size.height + clipY) <= img.getHeight()) {
            clip = new Rectangle(size);
            clip.x = clipX;
            clip.y = clipY;
        } else {
            if ((size.width + clipX) > img.getWidth()) {
                size.width = img.getWidth() - clipX;
            }

            if ((size.height + clipY) > img.getHeight()) {
                size.height = img.getHeight() - clipY;
            }

            clip = new Rectangle(size);
            clip.x = clipX;
            clip.y = clipY;

            isClipAreaAdjusted = true;

        }
        if (isClipAreaAdjusted) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        sigpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Signature Pad - Client or Parent/Guardian");
        setResizable(false);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/leaveapp3.png"))); // NOI18N
        jButton1.setText("     Sign Now    ");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator3);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        jButton2.setMnemonic('C');
        jButton2.setText("      Clear     ");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        sigpanel.setBackground(new java.awt.Color(255, 255, 255));
        sigpanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout sigpanelLayout = new javax.swing.GroupLayout(sigpanel);
        sigpanel.setLayout(sigpanelLayout);
        sigpanelLayout.setHorizontalGroup(
            sigpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        sigpanelLayout.setVerticalGroup(
            sigpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(sigpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sigpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            saveImg();
            crop();
            resize();
            Transparent ti = new Transparent();
            ti.croppedNow();
        } catch (Exception ex) {
            Logger.getLogger(SignatureDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }

        FileFactory SigFile = new FileFactory();
        SigFile.setFileName(DentistId+".png");
        SigFile.SaveSignatureDoc();
        
        frmParent.DisplaySig();
        this.dispose();
        JOptionPane.showMessageDialog(null, "Signature saved successfully!");
    }//GEN-LAST:event_jButton1ActionPerformed

//    public static String getSigPathConfig() {
////        String Str = memsys.others.paths.getSigPathConfig();
////        return Str;
//    }
//
    void crop() {
        try {
            BufferedImage originalImage = readImage("etc/temp/img.png");

            BufferedImage processedImage = cropMyImage(originalImage, 390, 100, 5, 5);
            writeImage(processedImage, "etc/temp/imgcrop.png", "PNG");
        } catch (Exception ex) {
            Logger.getLogger(SignatureDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void resize() {

        try {
            BufferedImage originalImage = readImage("etc/temp/imgcrop.png");

            BufferedImage processedImage = resizeImage(originalImage, 300, 80);
            writeImage(processedImage, "etc/temp/imgresize.png", "PNG");
        } catch (IOException ex) {
            Logger.getLogger(SignatureDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
////PadDraw drawPad = new PadDraw();
////drawPad.paintComponent(null);
//
        sigpanel.removeAll();
        sigpanel.updateUI();
        paint();
////this.repaint();
//        //paint();
//        this.revalidate();
//this.dispose(t;
        this.repaint();

    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignatureDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignatureDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignatureDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignatureDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SignatureDoctor dialog = new SignatureDoctor(frmParent, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel sigpanel;
    // End of variables declaration//GEN-END:variables
}
