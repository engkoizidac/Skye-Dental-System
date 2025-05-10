/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.toothchart;

import app.global.helper.ComboBoxItem;
import app.model.controller.PatientToothPartStatusController;
import app.model.controller.PatientToothStatusController;
import app.model.controller.ToothStatusController;
import javax.swing.JOptionPane;

/**
 *
 * @author EngkoiZidac
 */
public class SetToothStatus extends javax.swing.JDialog {

    public static ToothChart frmParent;
    public static String lbl;
    public static int ToothId, ToothPartId, PatientId, ToothStatusId;
    ToothStatusController TSController = new ToothStatusController();
    PatientToothStatusController PTSC = new PatientToothStatusController();
    PatientToothPartStatusController PTPSC = new PatientToothPartStatusController();

    public SetToothStatus(ToothChart parent, boolean modal) {
        this.frmParent = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(this);
        this.setTitle("Tooth Status Setting: " + lbl);
        c.setText("All " + lbl);
        TSController.PopulateComboBoxData(cmbstatus);
        //System.out.println(PatientId);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cmdsave = new javax.swing.JButton();
        cmdexit = new javax.swing.JButton();
        cmbstatus = new javax.swing.JComboBox();
        c = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tooth Chart Status");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Status");

        cmdsave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        cmdsave.setMnemonic('S');
        cmdsave.setText("Save");
        cmdsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsaveActionPerformed(evt);
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

        cmbstatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbstatusActionPerformed(evt);
            }
        });

        c.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        c.setText("All");
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdsave, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdexit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addComponent(c)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdsave)
                    .addComponent(cmdexit))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsaveActionPerformed
        PTSC.setPatientId(PatientId);
        PTSC.setToothId(ToothId);
        PTPSC.setToothPartId(ToothPartId);
        boolean IsSet = PTSC.IsStatusSet();

        if (IsSet == true) {
            if (c.isSelected() == true) {
                PTPSC.setToothId(ToothId);
                PTPSC.setPatientId(PatientId);
                PTPSC.setToothStatusId(ToothStatusId);
                PTPSC.UpdateAllPartStatus();
                
                PTSC.setToothStatusId(ToothStatusId);
                PTSC.setToothId(ToothId);
                PTSC.Update();
                
                this.dispose();
                frmParent.RefreshPatientToothStatus();
                JOptionPane.showMessageDialog(null, "Tooth Status Successfully Updated!");
            } else if (c.isSelected() == false) {

                PTPSC.setToothId(ToothId);
                PTPSC.setPatientId(PatientId);
                PTPSC.setToothPartId(ToothPartId);
                PTPSC.setToothStatusId(ToothStatusId);
                
                                PTSC.setToothStatusId(ToothStatusId);
                PTSC.setToothId(ToothId);
                PTSC.Update();

                boolean tp = PTPSC.IsToothPartSet();

                if (tp == true) {
                    PTPSC.UpdatePerPartStatus();
                } else {
                    PTPSC.AddToothPartStatus();
                }

                System.out.println(tp);
                
                frmParent.RefreshPatientToothStatus();
                this.dispose();
                JOptionPane.showMessageDialog(null, "Tooth Status Successfully Updated!");
            }
        } else {
            if (c.isSelected() == true) {
                PTSC.setToothId(ToothId);
                PTSC.setPatientId(PatientId);
                PTSC.setToothStatusId(ToothStatusId);
                PTSC.Add();
                PTPSC.setToothId(ToothId);
                PTPSC.setPatientId(PatientId);
                PTPSC.setToothStatusId(ToothStatusId);
                PTPSC.AddAllToothPartStatus();
                
                frmParent.RefreshPatientToothStatus();
                this.dispose();
                JOptionPane.showMessageDialog(null, "Tooth Status Successfully Updated!");
            } else if (c.isSelected() == false) {
                PTSC.setToothId(ToothId);
                PTSC.setPatientId(PatientId);
                PTSC.setToothStatusId(ToothStatusId);
                PTSC.Add();
                PTPSC.setToothId(ToothId);
                PTPSC.setPatientId(PatientId);
                PTPSC.setToothPartId(ToothPartId);
                PTPSC.setToothStatusId(ToothStatusId);
                PTPSC.AddToothPartStatus();
                
               frmParent.RefreshPatientToothStatus();
                this.dispose();
                JOptionPane.showMessageDialog(null, "Tooth Status Successfully Updated!");
            }
        }
        
        // frmParent.AddRow();
         this.dispose();
    }//GEN-LAST:event_cmdsaveActionPerformed

    private void cmdexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdexitActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdexitActionPerformed

    private void cmbstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbstatusActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) cmbstatus.getSelectedItem();
            ToothStatusId = item.getId();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbstatusActionPerformed

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cActionPerformed

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
            java.util.logging.Logger.getLogger(SetToothStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetToothStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetToothStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetToothStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SetToothStatus dialog = new SetToothStatus(frmParent, true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox c;
    private javax.swing.JComboBox cmbstatus;
    private javax.swing.JButton cmdexit;
    private javax.swing.JButton cmdsave;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
