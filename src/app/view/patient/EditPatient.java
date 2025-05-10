/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.patient;

import app.global.helper.ComboBoxItem;
import app.model.controller.CivilStatusController;
import app.model.controller.GenderController;
import app.model.controller.PatientController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author EngkoiZidac
 */
public class EditPatient extends javax.swing.JDialog {

    public static PatientManage frmParent;
    public static int PatientId;
    public static String nym;
    public static int genderid, civilstatusid;
    PatientController Controller = new PatientController();
    GenderController GenderController = new GenderController();
    CivilStatusController CivilStatusController = new CivilStatusController();

    public EditPatient(PatientManage parent, boolean modal) {
        this.frmParent = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(this);
        getRootPane().setDefaultButton(cmdsave);
        //this.setTitle("Edit Patient Record: " + nym);
        Controller.setPatientId(PatientId);
        PopulateData();
    }

    private void PopulateData() {
        Controller.PopulateDataOnEdit();
        txtname.setText(Controller.getName());
        txtnickname.setText(Controller.getNickName());
        txtaddress.setText(Controller.getAddress());
        txtreligion.setText(Controller.getReligion());
        txtdate.setDate(Controller.getBirthDate());
        txtoccupation.setText(Controller.getOccupation());
        txtcompanyname.setText(Controller.getCompanyName());
        txtofficeaddress.setText(Controller.getOfficeAddress());
        txtofficecontact.setText(Controller.getOfficeContactNo());
        txtcontact.setText(Controller.getContactNo());
        txtparentguardian.setText(Controller.getParentGuardian());
        genderid = Controller.getGenderID();
        civilstatusid = Controller.getCivilStatusId();

        GenderController.setGenderId(genderid);
        GenderController.PopulateDataOnEdit();
        GenderController.PopulateComboBoxDataOnEdit(cmbgender, genderid, genderid, GenderController.getDescription());

        CivilStatusController.setCivilStatusId(civilstatusid);
        CivilStatusController.PopulateDataOnEdit();
        CivilStatusController.PopulateComboBoxDataOnEdit(cmbcivilstatus, civilstatusid, civilstatusid, CivilStatusController.getDescription());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdsave = new javax.swing.JButton();
        cmdexit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbcivilstatus = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtoccupation = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcompanyname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtofficeaddress = new javax.swing.JTextField();
        cmbgender = new javax.swing.JComboBox();
        txtname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtdate = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        txtnickname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtreligion = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtcontact = new javax.swing.JTextField();
        txtofficecontact = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtparentguardian = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Patient Record");

        cmdsave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
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

        jLabel1.setText("Name");

        cmbcivilstatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbcivilstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcivilstatusActionPerformed(evt);
            }
        });

        jLabel2.setText("Address");

        txtaddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtaddress.setForeground(new java.awt.Color(51, 51, 51));
        txtaddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtaddressFocusGained(evt);
            }
        });

        jLabel3.setText("Occupation");

        txtoccupation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtoccupation.setForeground(new java.awt.Color(51, 51, 51));
        txtoccupation.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtoccupationFocusGained(evt);
            }
        });

        jLabel4.setText("Company Name");

        txtcompanyname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcompanyname.setForeground(new java.awt.Color(51, 51, 51));
        txtcompanyname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcompanynameFocusGained(evt);
            }
        });

        jLabel5.setText("Office Address");

        txtofficeaddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtofficeaddress.setForeground(new java.awt.Color(51, 51, 51));
        txtofficeaddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtofficeaddressFocusGained(evt);
            }
        });

        cmbgender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbgenderActionPerformed(evt);
            }
        });

        txtname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtname.setForeground(new java.awt.Color(51, 51, 51));
        txtname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnameFocusGained(evt);
            }
        });

        jLabel10.setText("Gender");

        jLabel11.setText("Civil Status");

        txtdate.setDateFormatString("yyyy/MM/dd ");
        txtdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        jLabel13.setText("Birthdate");

        txtnickname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtnickname.setForeground(new java.awt.Color(51, 51, 51));
        txtnickname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnicknameFocusGained(evt);
            }
        });

        jLabel7.setText("Nickname");

        txtreligion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtreligion.setForeground(new java.awt.Color(51, 51, 51));
        txtreligion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtreligionFocusGained(evt);
            }
        });

        jLabel21.setText("Religion");

        jLabel22.setText("Office Contact No");

        jLabel23.setText("Mobile No");

        txtcontact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcontact.setForeground(new java.awt.Color(51, 51, 51));
        txtcontact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcontactFocusGained(evt);
            }
        });

        txtofficecontact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtofficecontact.setForeground(new java.awt.Color(51, 51, 51));
        txtofficecontact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtofficecontactFocusGained(evt);
            }
        });

        jLabel24.setText("Parent/Guardian");

        txtparentguardian.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtparentguardian.setForeground(new java.awt.Color(51, 51, 51));
        txtparentguardian.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtparentguardianFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10))
                        .addComponent(jLabel24)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnickname))
                    .addComponent(txtofficeaddress, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtaddress, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(420, 420, 420)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 89, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbgender, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtofficecontact, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(txtcontact)))
                    .addComponent(cmbcivilstatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcompanyname, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtoccupation, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtreligion)
                            .addComponent(txtparentguardian))
                        .addGap(497, 497, 497)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtnickname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(txtoccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(txtcompanyname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(txtofficeaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbgender, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbcivilstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtreligion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtparentguardian, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtofficecontact, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(cmdsave, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdexit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdsave)
                    .addComponent(cmdexit))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsaveActionPerformed
        if (txtname.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Please fill-up the required fields!");
        } else {
            Controller.setName(txtname.getText());
            Controller.setNickName(txtnickname.getText());
            Controller.setGenderID(genderid);
            Controller.setCivilStatusId(civilstatusid);
            Controller.setAddress(txtaddress.getText());
            Controller.setReligion(txtreligion.getText());
            Controller.setOfficeContactNo(txtofficecontact.getText());
            Controller.setOfficeAddress(txtofficeaddress.getText());
            Controller.setContactNo(txtcontact.getText());
            Controller.setParentGuardian(txtparentguardian.getText());
            Controller.setOccupation(txtoccupation.getText());
            Controller.setCompanyName(txtcompanyname.getText());

            DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String DateFormatted = DateFormat.format(txtdate.getDate());
            
            Controller.Update(DateFormatted);
            frmParent.PopulateData();
            this.dispose();
            JOptionPane.showMessageDialog(null, "Changes Saved Successfully");
        }
    }//GEN-LAST:event_cmdsaveActionPerformed

    private void cmdexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdexitActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdexitActionPerformed

    private void cmbcivilstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcivilstatusActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) cmbcivilstatus.getSelectedItem();
            civilstatusid = item.getId();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbcivilstatusActionPerformed

    private void txtaddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtaddressFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressFocusGained

    private void txtoccupationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtoccupationFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtoccupationFocusGained

    private void txtcompanynameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcompanynameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcompanynameFocusGained

    private void txtofficeaddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtofficeaddressFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtofficeaddressFocusGained

    private void cmbgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbgenderActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) cmbgender.getSelectedItem();
            genderid = item.getId();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbgenderActionPerformed

    private void txtnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnameFocusGained

    }//GEN-LAST:event_txtnameFocusGained

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

    private void txtnicknameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnicknameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnicknameFocusGained

    private void txtreligionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtreligionFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtreligionFocusGained

    private void txtcontactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcontactFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontactFocusGained

    private void txtofficecontactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtofficecontactFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtofficecontactFocusGained

    private void txtparentguardianFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtparentguardianFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtparentguardianFocusGained

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
            java.util.logging.Logger.getLogger(EditPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditPatient dialog = new EditPatient(frmParent, true);
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
    private javax.swing.JComboBox cmbcivilstatus;
    private javax.swing.JComboBox cmbgender;
    private javax.swing.JButton cmdexit;
    private javax.swing.JButton cmdsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtcompanyname;
    private javax.swing.JTextField txtcontact;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnickname;
    private javax.swing.JTextField txtoccupation;
    private javax.swing.JTextField txtofficeaddress;
    private javax.swing.JTextField txtofficecontact;
    private javax.swing.JTextField txtparentguardian;
    private javax.swing.JTextField txtreligion;
    // End of variables declaration//GEN-END:variables
}
