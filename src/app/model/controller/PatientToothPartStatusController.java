/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.controller;

import static app.config.DBConn.getConnection;
import app.global.helper.DefaultTableView;
import app.model.PatientToothPartStatus;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;

/**
 *
 * @author EngkoiZidac
 */
public class PatientToothPartStatusController extends PatientToothPartStatus {

    static Statement Stmt;

    DefaultTableView dtv = new DefaultTableView();

    public void PopulateTableData(JTable TableObject) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT  ptps.ToothPartId, CONCAT(Param, Image) as C FROM patient_tooth_part_status ptps "
                + "INNER JOIN tooth_status ts ON ptps.ToothStatusId=ts.ToothStatusId "
                + "INNER JOIN tooth_part tp ON ptps.ToothPartId=tp.ToothPartId "
                + "INNER JOIN tooth_part_color tpc ON tpc.ToothPartColorId=tp.ToothPartColorId "
                + "WHERE PatientId=" + this.getPatientId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                dtv.TableModel.addRow(new Object[]{rs.getInt("ToothPartId"), rs.getString("C")});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void RemoveAllPartStatus() {
        Connection Conn = getConnection();
        String createString;
        createString = "DELETE FROM patient_tooth_part_status WHERE ToothId=" + this.getToothId() + " AND PatientId=" + this.getPatientId();

        try {
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void AddAllToothPartStatus() {
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO patient_tooth_part_status (ToothPartId, ToothId, PatientId, ToothStatusId) "
                + "SELECT ToothPartId, ToothId," + this.getPatientId() + "," + this.getToothStatusId() + " FROM tooth_part WHERE ToothId=" + this.getToothId();

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

    public void AddToothPartStatus() {
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO patient_tooth_part_status (ToothPartId, ToothId, PatientId, ToothStatusId) "
                + "VALUES (" + this.getToothPartId() + "," + this.getToothId() + "," + this.getPatientId() + "," + this.getToothStatusId() + ")";

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

    public void UpdateAllPartStatus() {
        Connection conn = getConnection();
        String createString;
        createString = "UPDATE patient_tooth_part_status SET ToothStatusId=" + this.getToothStatusId() + " WHERE ToothId=" + this.getToothId() + " AND PatientId=" + this.getPatientId();
        System.out.println(createString);
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

    public void UpdatePerPartStatus() {
        Connection conn = getConnection();
        String createString;
        createString = "UPDATE patient_tooth_part_status SET ToothStatusId=" + this.getToothStatusId() + " WHERE ToothId=" + this.getToothId() + " AND PatientId=" + this.getPatientId() + " AND ToothPartId=" + this.getToothPartId();
        System.out.println(createString);
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

    public boolean IsToothPartSet() {
        boolean IsSet = false;

        Connection Conn = getConnection();

        String createString = "SELECT ToothPartId FROM patient_tooth_part_status  WHERE ToothId=" + this.getToothId() + " AND PatientId=" + this.getPatientId() + " AND ToothPartId=" + this.getToothPartId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            int cntr = 0;
            while (rs.next()) {
                cntr++;
            }

            if (cntr > 0) {
                IsSet = true;
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }

        return IsSet;
    }
}
