/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.informedConsent;

import app.global.FunctionFactory;
import static app.global.FunctionFactory.getSystemNowDateTimeString;
import app.global.helper.ComboBoxItem;
import app.model.controller.DentistController;
import app.model.controller.InformedConsentController;
import javax.swing.JOptionPane;

/**
 *
 * @author EngkoiZidac
 */
public class NewIC extends javax.swing.JDialog {

    public static InformedConcent frmParent;
    public static int Id, DentistId;
    InformedConsentController Controller = new InformedConsentController();
    DentistController DentistController = new DentistController();
    
    static String nowDate = getSystemNowDateTimeString();

    public NewIC(InformedConcent parent, boolean modal) {
        this.frmParent = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(this);
        getRootPane().setDefaultButton(cmdadd);

        DentistController.PopulateComboBoxData(cmbdentist);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        c10 = new javax.swing.JCheckBox();
        c9 = new javax.swing.JCheckBox();
        c8 = new javax.swing.JCheckBox();
        c7 = new javax.swing.JCheckBox();
        c6 = new javax.swing.JCheckBox();
        c5 = new javax.swing.JCheckBox();
        c4 = new javax.swing.JCheckBox();
        c3 = new javax.swing.JCheckBox();
        c2 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        c1 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        cmbdentist = new javax.swing.JComboBox();
        cmdadd = new javax.swing.JButton();
        cmdexit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create New Informed Consent");

        c10.setText("DENTURES");

        c9.setText("FILLINGS");

        c8.setText("PERIODONTAL DISEASE");

        c7.setText("ENDODONTICS (ROOT CANAL)");

        c6.setText("CRONWS (CAPS) & BRIDGES");

        c5.setText("REMOVAL OF TEETH");

        c4.setText("RADIOGRAPH");

        c3.setText("CHANGES IN TREATMENT PLAN");

        c2.setText("DRUGS & MEDICATIONS");

        jLabel1.setText("Informed Consent Procedures:");

        c1.setText("TREATMENT TO BE DONE");
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Dentist");

        cmbdentist.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbdentist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdentistActionPerformed(evt);
            }
        });

        cmdadd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        cmdadd.setMnemonic('A');
        cmdadd.setText("Add");
        cmdadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdaddActionPerformed(evt);
            }
        });

        cmdexit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        cmdexit.setMnemonic('C');
        cmdexit.setText("Cancel");
        cmdexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdexitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdadd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdexit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c8, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c9, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c10, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbdentist, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(c1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c10)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbdentist, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdadd)
                    .addComponent(cmdexit))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c1ActionPerformed

    private void cmbdentistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdentistActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) cmbdentist.getSelectedItem();
            DentistId = item.getId();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbdentistActionPerformed

    private void cmdaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdaddActionPerformed
        if (cmbdentist.getSelectedItem() == "SELECT") {
            JOptionPane.showMessageDialog(null, "Please fill-up the required fields!");
        }else{
            Controller.setPatientId(Id);
            Controller.setC1((c1.isSelected() == true) ? 1 : 0);
            Controller.setC2((c2.isSelected() == true) ? 1 : 0);
            Controller.setC3((c3.isSelected() == true) ? 1 : 0);
            Controller.setC4((c4.isSelected() == true) ? 1 : 0);
            Controller.setC5((c5.isSelected() == true) ? 1 : 0);
            Controller.setC6((c6.isSelected() == true) ? 1 : 0);
            Controller.setC7((c7.isSelected() == true) ? 1 : 0);
            Controller.setC8((c8.isSelected() == true) ? 1 : 0);
            Controller.setC9((c9.isSelected() == true) ? 1 : 0);
            Controller.setC10((c10.isSelected() == true) ? 1 : 0);
            Controller.setDentistId(DentistId);
            Controller.Add(nowDate);
            this.dispose();
            JOptionPane.showMessageDialog(null, "Created Successfully!");
        }
    }//GEN-LAST:event_cmdaddActionPerformed

    private void cmdexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdexitActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdexitActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(NewIC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewIC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewIC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewIC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewIC dialog = new NewIC(frmParent, true);
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
    private javax.swing.JCheckBox c1;
    private javax.swing.JCheckBox c10;
    private javax.swing.JCheckBox c2;
    private javax.swing.JCheckBox c3;
    private javax.swing.JCheckBox c4;
    private javax.swing.JCheckBox c5;
    private javax.swing.JCheckBox c6;
    private javax.swing.JCheckBox c7;
    private javax.swing.JCheckBox c8;
    private javax.swing.JCheckBox c9;
    private javax.swing.JComboBox cmbdentist;
    private javax.swing.JButton cmdadd;
    private javax.swing.JButton cmdexit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    // End of variables declaration//GEN-END:variables
}
