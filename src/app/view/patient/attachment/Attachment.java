/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.patient.attachment;

import app.global.FTPFactory;
import static app.global.FunctionFactory.msgboxYesNo;
import app.model.controller.PatientAttachmentController;
import app.view.toothchart.ToothChart;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Attachment extends javax.swing.JDialog {

    public static ToothChart frmParent;
    public static int PatientId;
    public static AddAttachment frmAddAttachment;
    public static EditAttachment frmEditAttachment;
    public static ViewAttachment frmViewAttachment;
    PatientAttachmentController Controller = new PatientAttachmentController();

    public Attachment(ToothChart parent, boolean modal) {
        this.frmParent = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(this);
        PopulateData();
    }

    public void ShowFrmAddAttachment() {
        frmAddAttachment = new AddAttachment(this, true);
        frmAddAttachment.setVisible(true);
    }

    public void ShowFrmEditAttachment() {
        frmEditAttachment = new EditAttachment(this, true);
        frmEditAttachment.setVisible(true);
    }

    public void ShowFrmViewAttachment() {
        frmViewAttachment = new ViewAttachment(this, true);
        frmViewAttachment.setVisible(true);
    }

    public void PopulateData() {
        Controller.setPatientId(PatientId);
        Controller.PopulateTableData(tbl);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        cmdadd = new javax.swing.JButton();
        cmdexit = new javax.swing.JButton();
        cmdsave = new javax.swing.JButton();
        cmdadd1 = new javax.swing.JButton();
        cmdsave1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Patient Attachment");

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Date", "Attachment Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl.setColumnSelectionAllowed(true);
        tbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl);
        tbl.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(600);

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
        cmdexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        cmdexit.setMnemonic('C');
        cmdexit.setText("Exit");
        cmdexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdexitActionPerformed(evt);
            }
        });

        cmdsave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        cmdsave.setMnemonic('d');
        cmdsave.setText("Edit");
        cmdsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsaveActionPerformed(evt);
            }
        });

        cmdadd1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdadd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/openstudy.png"))); // NOI18N
        cmdadd1.setMnemonic('V');
        cmdadd1.setText("View Attachment");
        cmdadd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdadd1ActionPerformed(evt);
            }
        });

        cmdsave1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdsave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png"))); // NOI18N
        cmdsave1.setMnemonic('R');
        cmdsave1.setText("Remove");
        cmdsave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsave1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdadd1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdadd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdsave, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdsave1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdexit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdadd)
                    .addComponent(cmdexit)
                    .addComponent(cmdsave)
                    .addComponent(cmdadd1)
                    .addComponent(cmdsave1))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdaddActionPerformed

        AddAttachment.PatientId = PatientId;
        ShowFrmAddAttachment();

//        if (txtname.getText().isEmpty() == true) {
//            JOptionPane.showMessageDialog(null, "Please fill-up the required fields!");
//        } else {
//            Controller.setName(txtname.getText());
//            Controller.setNickName(txtnickname.getText());
//            Controller.setGenderID(genderid);
//            Controller.setCivilStatusId(civilstatusid);
//            Controller.setAddress(txtaddress.getText());
//            Controller.setReligion(txtreligion.getText());
//            Controller.setOfficeContactNo(txtofficecontact.getText());
//            Controller.setOfficeAddress(txtofficeaddress.getText());
//            Controller.setContactNo(txtcontact.getText());
//            Controller.setParentGuardian(txtparentguardian.getText());
//            Controller.setOccupation(txtoccupation.getText());
//            Controller.setCompanyName(txtcompanyname.getText());
//            Controller.setOtherAllergies(txtoa.getText());
//            Controller.setPreviousExtraction(txtpe.getText());
//
//            DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String DateFormatted = DateFormat.format(txtdate.getDate());
//
//            int Id = Controller.Add(DateFormatted, nowDate);
//
//            PatientMDHController mdh = new PatientMDHController();
//            mdh.setPatientId(Id);
//
//            if (mdh.GetSelectedCount(tbl1) != 0) {
//                mdh.Add(tbl1);
//            }
//
//            if (mdh.GetSelectedCount(tbl2) != 0) {
//                mdh.Add(tbl2);
//            }
//
//            if (mdh.GetSelectedCount(tbl3) != 0) {
//                mdh.Add(tbl3);
//            }
//
//            if (mdh.GetSelectedCount(tbl4) != 0) {
//                mdh.Add(tbl4);
//            }
//
//            if (mdh.GetSelectedCount(tbl5) != 0) {
//                mdh.Add(tbl5);
//            }
//
//            this.dispose();
//            JOptionPane.showMessageDialog(null, "Added Successfully");
//        }
    }//GEN-LAST:event_cmdaddActionPerformed

    private void cmdexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdexitActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdexitActionPerformed

    private void cmdsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsaveActionPerformed
        int col = 0; //set column value to 0
        int row = tbl.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (tbl.isRowSelected(row) != true) {
            JOptionPane.showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String id = tbl.getValueAt(row, col).toString();
            EditAttachment.PatientId = PatientId;
            ShowFrmEditAttachment();
        }

//        if (txtname.getText().isEmpty() == true) {
//            JOptionPane.showMessageDialog(null, "Please fill-up the required fields!");
//        } else {
//            Controller.setName(txtname.getText());
//            Controller.setNickName(txtnickname.getText());
//            Controller.setGenderID(genderid);
//            Controller.setCivilStatusId(civilstatusid);
//            Controller.setAddress(txtaddress.getText());
//            Controller.setReligion(txtreligion.getText());
//            Controller.setOfficeContactNo(txtofficecontact.getText());
//            Controller.setOfficeAddress(txtofficeaddress.getText());
//            Controller.setContactNo(txtcontact.getText());
//            Controller.setParentGuardian(txtparentguardian.getText());
//            Controller.setOccupation(txtoccupation.getText());
//            Controller.setCompanyName(txtcompanyname.getText());
//
//            DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String DateFormatted = DateFormat.format(txtdate.getDate());
//
//            Controller.Update(DateFormatted);
//            frmParent.PopulateData();
//            this.dispose();
//            JOptionPane.showMessageDialog(null, "Changes Saved Successfully");
//        }
    }//GEN-LAST:event_cmdsaveActionPerformed

    private void cmdadd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdadd1ActionPerformed

        int col = 0; //set column value to 0
        int row = tbl.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (tbl.isRowSelected(row) != true) {
            JOptionPane.showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String id = tbl.getValueAt(row, col).toString();
            //   ViewAttachment.AttachmentId = Integer.parseInt(id);
            //  ShowFrmViewAttachment();

            //  try {
            FTPFactory ftp = new FTPFactory();
            ftp.FTPDownloadFile(Integer.parseInt(id));

    //    i.FTPViewImage(i.GetFTPImagePath()+ AttachmentId + ".jpg", lbl);
           //     String path =i.GetFTPImagePath()+ Integer.parseInt(id) + ".jpg";
                File file = new File("./preview/preview.jpg");
                if (!Desktop.isDesktopSupported())
                {
                    System.out.println("not supported");
                    return;
                }
                Desktop desktop = Desktop.getDesktop();
                if (file.exists()) 
                {
                try {      
                    desktop.open(file);
                } catch (IOException ex) {
                    Logger.getLogger(Attachment.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
//          /
        }
    }//GEN-LAST:event_cmdadd1ActionPerformed

    private void cmdsave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsave1ActionPerformed
                int col = 0; //set column value to 0
        int row = tbl.getSelectedRow(); //get value of selected value

        //trap user incase if no row selected
        if (tbl.isRowSelected(row) != true) {
            JOptionPane.showMessageDialog(this, "No record selected! Please select a record from the list!");
        } else {
            String Id = tbl.getValueAt(row, col).toString();
            int i = msgboxYesNo("Are you sure you want to delete this record");
            switch (i) {
                case 0:
                Controller.setAttachmentId(Integer.valueOf(Id));
                Controller.Remove();
                PopulateData();
                JOptionPane.showMessageDialog(null, "Successfully Removed!");
                break;
                case 1:
                break;
                case 2:
                this.dispose(); //exit window
                break;
                default:
                break;
            }
        }
    }//GEN-LAST:event_cmdsave1ActionPerformed

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
            java.util.logging.Logger.getLogger(Attachment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attachment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attachment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attachment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Attachment dialog = new Attachment(frmParent, true);
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
    private javax.swing.JButton cmdadd;
    private javax.swing.JButton cmdadd1;
    private javax.swing.JButton cmdexit;
    private javax.swing.JButton cmdsave;
    private javax.swing.JButton cmdsave1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
