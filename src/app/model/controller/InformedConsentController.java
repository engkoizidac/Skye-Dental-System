/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.controller;

import static app.config.DBConn.getConnection;
import app.global.helper.DefaultComboBoxView;
import app.global.helper.DefaultTableView;
import app.model.InformedConsent;
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
public class InformedConsentController extends InformedConsent {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void Add(String nowdate) {
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO informed_consent (PatientId, DentistId, TransDate, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10) "
                + "VALUES (" + this.getPatientId() + ", " + this.getDentistId() + ", '" + nowdate + "', "
                + "" + this.getC1() + ", "
                + "" + this.getC2() + ", "
                + "" + this.getC3() + ", "
                + "" + this.getC4() + ", "
                + "" + this.getC5() + ", "
                + "" + this.getC6() + ", "
                + "" + this.getC7() + ", "
                + "" + this.getC8() + ", "
                + "" + this.getC9() + ", "
                + "" + this.getC10() + ")";

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
        createString = "UPDATE informed_consent SET "
                + "DentistId=" + this.getDentistId() + ", "
                + "C1=" + this.getC1() + ", "
                + "C2=" + this.getC2() + ", "
                + "C3=" + this.getC3() + ", "
                + "C4=" + this.getC4() + ", "
                + "C5=" + this.getC5() + ", "
                + "C6=" + this.getC6() + ", "
                + "C7=" + this.getC7() + ", "
                + "C8=" + this.getC8() + ", "
                + "C9=" + this.getC9() + ", "
                + "C10=" + this.getC10() + " "
                + "WHERE ISId=" + this.getISId();

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

    public void Remove() {
        Connection Conn = getConnection();
        String createString;
        createString = "DELETE FROM informed_consent WHERE ISId=" + this.getISId();

        try {
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void PopulateDataOnEdit() {
        Connection Conn = getConnection();
        String createString = "SELECT * FROM informed_consent WHERE ISId=" + this.getISId();
        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setDentistId(rs.getInt("DentistId"));
                this.setC1(rs.getInt("C1"));
                this.setC2(rs.getInt("C2"));
                this.setC3(rs.getInt("C3"));
                this.setC4(rs.getInt("C4"));
                this.setC5(rs.getInt("C5"));
                this.setC6(rs.getInt("C6"));
                this.setC7(rs.getInt("C7"));
                this.setC8(rs.getInt("C8"));
                this.setC9(rs.getInt("C9"));
                this.setC10(rs.getInt("C10"));
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void PopulateTableData(JTable TableObject, int Stat) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTableLarge();
        dtv.RenderTable();

        String createString = "SELECT * FROM informed_consent WHERE SignedFlag=" + Stat + "  ORDER BY TransDate";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

//            dtv.ColumnAlignRight(2);
//            dtv.ColumnCenter(3);
            while (rs.next()) {
                String lbl = "<html><table border=0 cellpadding=0 cellspacing=0>"
                        + "<tr><td><img src=" + getClass().getResource("/img/consent.png") + ">&nbsp</td><td>" + rs.getDate("TransDate") + "</td></th>";

                dtv.TableModel.addRow(new Object[]{rs.getInt("ISId"), lbl});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
}
