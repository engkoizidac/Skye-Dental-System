/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.controller;

import static app.config.DBConn.getConnection;
import app.global.helper.DefaultComboBoxView;
import app.global.helper.DefaultTableView;
import app.model.TreatmentRecordLog;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Administrator
 */
public class TreatmentRecordLogController extends TreatmentRecordLog {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void  Add(String TreatmentDate, String TransDate, int MaxID) {

        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO treatment_record_log (TreatmentDate, TransDate, ToothNos, TProcedure, DentistId, AmountCharged, PatientId, ClinicId, Note, BloodPressure, TRId) "
                + "VALUES ('" + TreatmentDate + "', '" + TransDate + "', '" + this.getToothNos() + "', '" + this.getTProcedure() + "', " + this.getDentistId() + ", '" + this.getAmountCharged() + "', '" + this.getPatientId() + "', '" + this.getClinicId() + "', '" + this.getNote() + "', '" + this.getBloodPressure() + "',"+MaxID+")";

        try {
            Connection Conn = getConnection();
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }

 
    }

}
