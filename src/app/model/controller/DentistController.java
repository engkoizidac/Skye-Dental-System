/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.controller;

import static app.config.DBConn.getConnection;
import app.global.helper.ComboBoxItem;
import app.global.helper.DefaultComboBoxView;
import app.global.helper.DefaultTableView;
import app.model.Dentist;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;

/**
 *
 * @author EngkoiZidac
 */
public class DentistController extends Dentist {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateTableData(JTable TableObject, String parameter) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTableLarge();
        dtv.RenderTable();

        String createString = "SELECT * FROM dentist WHERE Name LIKE '%" + parameter + "%'";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

//            dtv.ColumnAlignRight(2);
//            dtv.ColumnCenter(3);
            while (rs.next()) {
                String lbl = "<html><table border=0 cellpadding=0 cellspacing=0>"
                        + "<tr><td><img src=" + getClass().getResource("/img/doctor.png") + ">&nbsp</td><td>" + rs.getString("Name") + "</td></th>";

                dtv.TableModel.addRow(new Object[]{rs.getInt("DentistId"), lbl, rs.getString("Address"), rs.getString("ContactNo"), rs.getString("EmailAddress")});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void Add() {
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO dentist (Name, Address, ContactNo, EmailAddress) "
                + "VALUES ('" + this.getName() + "', '" + this.getAddress() + "', '" + this.getContactNo() + "', '" + this.getEmailAddress() + "')";

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
        createString = "UPDATE dentist SET "
                + "Name='" + this.getName() + "', "
                + "Address='" + this.getAddress() + "', "
                + "ContactNo= '" + this.getContactNo() + "', "
                + "EmailAddress='" + this.getEmailAddress() + "' "
                + "WHERE DentistId=" + this.getDentistId();

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

    public void PopulateDataOnEdit() {
        Connection Conn = getConnection();
        String createString = "SELECT * FROM dentist WHERE DentistId=" + this.getDentistId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setName(rs.getString("Name"));
                this.setAddress(rs.getString("Address"));
                this.setContactNo(rs.getString("ContactNo"));
                this.setEmailAddress(rs.getString("EmailAddress"));
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void Remove() {
        Connection Conn = getConnection();
        String createString;
        createString = "DELETE FROM dentist WHERE DentistId=" + this.getDentistId();

        try {
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void PopulateComboBoxData(JComboBox ComboBoxObject) {
        dcv.setComboBoxObject(ComboBoxObject);
        dcv.InitializeComboBox();
        ComboBoxObject.addItem("SELECT");
        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM Dentist ORDER BY Name";

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("DentistId"), rs.getString("Name")));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    
     public void PopulateComboBoxDataOnEdit(JComboBox ComboBoxObject, int CurrentDentistId, String Desc) {
        dcv.setComboBoxObject(ComboBoxObject);
        //dcv.InitializeComboBox();
        ComboBoxObject.addItem(new ComboBoxItem(CurrentDentistId, Desc));
        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM dentist WHERE DentistId<>" + CurrentDentistId;

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("DentistId"), rs.getString("Name")));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

}
