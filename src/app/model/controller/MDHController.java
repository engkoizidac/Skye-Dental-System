/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.controller;

import static app.config.DBConn.getConnection;
import app.global.helper.DefaultTableView;
import app.model.MedicalDentalHistory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;

public class MDHController extends MedicalDentalHistory {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();

    public static boolean chk;

    public void PopulateTableData(JTable TableObject, int id) {
        chk = false;
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT * FROM medical_dental_history WHERE CategoryId=" + id;

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

//            dtv.ColumnAlignRight(2);
//            dtv.ColumnCenter(3);
            while (rs.next()) {
                dtv.TableModel.addRow(new Object[]{rs.getInt("MDHId"), chk, rs.getString("Description")});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
    
     public void PopulateTableDataOnEdit(JTable TableObject, int id, int PatientId) {
        chk = false;
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT * FROM medical_dental_history WHERE CategoryId=" + id + " AND MDHId NOT IN (SELECT MDHId FROM patient_mdh WHERE PatientId="+PatientId+")";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

//            dtv.ColumnAlignRight(2);
//            dtv.ColumnCenter(3);
            while (rs.next()) {
                dtv.TableModel.addRow(new Object[]{rs.getInt("MDHId"), chk, rs.getString("Description")});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
}
