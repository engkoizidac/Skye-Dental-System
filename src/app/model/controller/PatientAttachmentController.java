/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.controller;

import static app.config.DBConn.getConnection;
import app.global.helper.DefaultComboBoxView;
import app.global.helper.DefaultTableView;
import app.model.PatientAttachment;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Administrator
 */
public class PatientAttachmentController extends PatientAttachment {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateTableData(JTable TableObject) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTableLarge();
        dtv.RenderTable();

        String createString = "SELECT * FROM patient_attachment WHERE PatientId=" + this.getPatientId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

//            dtv.ColumnAlignRight(2);
//            dtv.ColumnCenter(3);
//            TableObject.getColumn("Open").setCellRenderer(new ButtonRenderer(1));
//            TableObject.getColumn("Open").setCellEditor(new ButtonEditor(new JCheckBox(), 1));
            while (rs.next()) {

                String lbl = "<html><table border=0 cellpadding=0 cellspacing=0>"
                        + "<tr><td><img src=" + getClass().getResource("/img/attachment.png") + ">&nbsp</td><td>" + rs.getString("TransDate") + "</td></th>";

                dtv.TableModel.addRow(new Object[]{rs.getInt("AttachmentId"), lbl, rs.getString("AttachDescription")});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public int Add(String TransDate) {
        int MaxID = 0;

        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO patient_attachment (TransDate, AttachDescription, PatientId) "
                + "VALUES ('" + TransDate + "', '" + this.getAttachDescription() + "', '" + this.getPatientId() + "')";

        try {
            Connection Conn = getConnection();
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }

        MaxID = GetMaxArchiveID();
        return MaxID;
    }

    public void Remove() {
        Connection Conn = getConnection();
        String createString;
        createString = "DELETE FROM patient_attachment WHERE AttachmentId=" + this.getAttachmentId();

        try {
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    int GetMaxArchiveID() {
        int MaxID = 0;

        Connection conn = getConnection();
        String createString;
        createString = "SELECT MAX(AttachmentId) FROM patient_attachment";

        //int rc = 0;
        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                MaxID = rs.getInt(1);
            }

            Stmt.close();
            conn.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        return MaxID;
    }

}//end class
