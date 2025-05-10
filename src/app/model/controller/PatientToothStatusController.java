/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.controller;

import static app.config.DBConn.getConnection;
import app.global.helper.DefaultTableView;
import app.model.PatientToothStatus;
import static app.view.patient.NewPatient.chk;
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
public class PatientToothStatusController extends PatientToothStatus {

    static Statement Stmt;

    DefaultTableView dtv = new DefaultTableView();

    public void PopulateTableData(JTable TableObject) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT * FROM patient_tooth_status pts INNER JOIN tooth_status ts ON pts.ToothStatusId=ts.ToothStatusId WHERE PatientId=" + this.getPatientId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                dtv.TableModel.addRow(new Object[]{rs.getInt("ToothId"), rs.getString("Code")});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public boolean IsStatusSet() {
        boolean IsSet = false;

        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM patient_tooth_status WHERE ToothId=" + this.getToothId() + " AND PatientId=" + this.getPatientId();

        int rc = 0;
        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                rc++;
            }

            Stmt.close();
            conn.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        if (rc > 0) {
            IsSet = true;
        }
        return IsSet;
    }

    public void Add() {
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO patient_tooth_status (PatientId, ToothId, ToothStatusId) VALUES (" + this.getPatientId() + "," + this.getToothId() + "," + this.getToothStatusId() + ")";

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

    public void Update() {
        Connection conn = getConnection();
        String createString;
        createString = "UPDATE patient_tooth_status SET ToothStatusId=" + this.getToothStatusId() + " WHERE ToothId=" + this.getToothId() + " AND PatientId=" + this.getPatientId();
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
}
