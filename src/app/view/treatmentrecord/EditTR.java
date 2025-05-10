/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.treatmentrecord;

import app.global.FunctionFactory;
import static app.global.FunctionFactory.getSystemNowDateTimeString;
import app.global.helper.ComboBoxItem;
import app.global.helper.TextFieldSelectAllFunction;
import app.model.controller.ClinicController;
import app.model.controller.DentistController;
import app.model.controller.PaymentController;
import app.model.controller.TreatmentRecordController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author EngkoiZidac
 */
public class EditTR extends javax.swing.JDialog {

    DentistController DentistController = new DentistController();
    ClinicController ClinicController = new ClinicController();
    TreatmentRecordController TRController = new TreatmentRecordController();
    PaymentController PayController = new PaymentController();
    static int ClinicId, DentistId;
    public static int PatientId, TRId;

    static String nowDate = getSystemNowDateTimeString();

    public static TreatmentRecord frmParent;

    public EditTR(TreatmentRecord parent, boolean modal) {
        this.frmParent = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(this);
        getRootPane().setDefaultButton(cmdadd);

        //  DentistController.PopulateComboBoxData(cmbdentist);
        //  ClinicController.PopulateComboBoxData(cmbclinic);
        //    SetDate();
        TRController.setTRId(TRId);
        PopulateData();
        TextFieldSelectAllFunction F = new TextFieldSelectAllFunction();
        //  F.Inject(txtamountpaid);
        F.Inject(txtamountcharge);
    }

    public void PopulateData() {
        TRController.PopulateDataOnEdit();
        txtdate.setDate(TRController.getTreatmentDate());
        txttoothno.setText(TRController.getToothNos());
        txtprocedure.setText(TRController.getTProcedure());
        DentistId = TRController.getDentistId();
        ClinicId = TRController.getClinicId();
        txtamountcharge.setText(FunctionFactory.amountFormat(TRController.getAmountCharged()));
        txtnote.setText(TRController.getNote());
        txtbp.setText(TRController.getBloodPressure());

        DentistController.setDentistId(DentistId);
        DentistController.PopulateDataOnEdit();
        DentistController.PopulateComboBoxDataOnEdit(cmbdentist, DentistId, DentistController.getName());

        ClinicController.setClinicId(ClinicId);
        ClinicController.PopulateDataOnEdit();
        ClinicController.PopulateComboBoxDataOnEdit(cmbclinic, ClinicId, ClinicController.getName());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtdate = new com.toedter.calendar.JDateChooser();
        cmdadd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmdexit = new javax.swing.JButton();
        txttoothno = new javax.swing.JTextField();
        txtprocedure = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbdentist = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cmbclinic = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtamountcharge = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtnote = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        txtbp = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Treatment Record");

        txtdate.setDateFormatString("yyyy/MM/dd ");
        txtdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtdate.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                txtdateHierarchyChanged(evt);
            }
        });
        txtdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtdateMouseReleased(evt);
            }
        });
        txtdate.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtdateInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtdateCaretPositionChanged(evt);
            }
        });
        txtdate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtdatePropertyChange(evt);
            }
        });
        txtdate.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                txtdateVetoableChange(evt);
            }
        });

        cmdadd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        cmdadd.setMnemonic('S');
        cmdadd.setText("Save");
        cmdadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdaddActionPerformed(evt);
            }
        });

        jLabel7.setText("Tooth No./s");

        cmdexit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        cmdexit.setMnemonic('C');
        cmdexit.setText("Cancel");
        cmdexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdexitActionPerformed(evt);
            }
        });

        txttoothno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttoothno.setForeground(new java.awt.Color(51, 51, 51));
        txttoothno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txttoothnoFocusGained(evt);
            }
        });

        txtprocedure.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtprocedure.setForeground(new java.awt.Color(51, 51, 51));
        txtprocedure.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtprocedureFocusGained(evt);
            }
        });

        jLabel8.setText("Procedure");

        cmbdentist.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbdentist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdentistActionPerformed(evt);
            }
        });

        jLabel11.setText("Dentist");

        cmbclinic.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbclinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbclinicActionPerformed(evt);
            }
        });

        jLabel12.setText("Clinic");

        jLabel6.setText("Amount Charge");

        jLabel13.setText("Date");

        txtamountcharge.setForeground(new java.awt.Color(0, 102, 0));
        txtamountcharge.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtamountcharge.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtamountcharge.setText("0.00");
        txtamountcharge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtamountcharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamountchargeActionPerformed(evt);
            }
        });

        txtnote.setColumns(20);
        txtnote.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtnote.setRows(5);
        jScrollPane1.setViewportView(txtnote);

        jLabel14.setText("Note");

        txtbp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtbp.setForeground(new java.awt.Color(51, 51, 51));
        txtbp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtbpFocusGained(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("If with high blood pressure history, Please indicate Blood Pressure:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttoothno, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprocedure, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbdentist, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdadd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdexit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtamountcharge, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbclinic, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txttoothno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtprocedure, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbdentist, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbclinic, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtamountcharge, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdadd)
                    .addComponent(cmdexit))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdateHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_txtdateHierarchyChanged

    }//GEN-LAST:event_txtdateHierarchyChanged

    private void txtdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdateMouseReleased

    }//GEN-LAST:event_txtdateMouseReleased

    private void txtdateCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtdateCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdateCaretPositionChanged

    private void txtdateInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtdateInputMethodTextChanged

    }//GEN-LAST:event_txtdateInputMethodTextChanged

    private void txtdatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtdatePropertyChange
        try {
            //            AutoCalculate();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_txtdatePropertyChange

    private void txtdateVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_txtdateVetoableChange

    }//GEN-LAST:event_txtdateVetoableChange

    private void cmdaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdaddActionPerformed
        if (txtprocedure.getText().isEmpty() == true || cmbdentist.getSelectedItem() == "SELECT" || cmbclinic.getSelectedItem() == "SELECT") {
            JOptionPane.showMessageDialog(null, "Please fill-up the required fields!");
        } else {

            TRController.setToothNos(txttoothno.getText());
            TRController.setTProcedure(txtprocedure.getText());
            TRController.setAmountCharged(Double.valueOf(txtamountcharge.getText().replace(",", "")));
            TRController.setDentistId(DentistId);
            TRController.setClinicId(ClinicId);
            TRController.setNote(txtnote.getText());
            TRController.setBloodPressure(txtbp.getText());

            DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String DateFormatted = DateFormat.format(txtdate.getDate());

            TRController.Update(DateFormatted);

            frmParent.PopulateData();
            this.dispose();
            JOptionPane.showMessageDialog(null, "Changes saved Successfully");
        }

    }//GEN-LAST:event_cmdaddActionPerformed

    private void cmdexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdexitActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdexitActionPerformed

    private void txttoothnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttoothnoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txttoothnoFocusGained

    private void txtprocedureFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtprocedureFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprocedureFocusGained

    private void cmbdentistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdentistActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) cmbdentist.getSelectedItem();
            DentistId = item.getId();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbdentistActionPerformed

    private void cmbclinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbclinicActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) cmbclinic.getSelectedItem();
            ClinicId = item.getId();
        } catch (Exception e) {
        }
        System.out.println(ClinicId);
    }//GEN-LAST:event_cmbclinicActionPerformed

    private void txtamountchargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamountchargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtamountchargeActionPerformed

    private void txtbpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbpFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbpFocusGained

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
            java.util.logging.Logger.getLogger(EditTR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditTR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditTR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditTR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditTR dialog = new EditTR(frmParent, true);
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
    private javax.swing.JComboBox cmbclinic;
    private javax.swing.JComboBox cmbdentist;
    private javax.swing.JButton cmdadd;
    private javax.swing.JButton cmdexit;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField txtamountcharge;
    private javax.swing.JTextField txtbp;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextArea txtnote;
    private javax.swing.JTextField txtprocedure;
    private javax.swing.JTextField txttoothno;
    // End of variables declaration//GEN-END:variables
}
