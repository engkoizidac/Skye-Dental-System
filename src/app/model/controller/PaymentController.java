/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.controller;

import static app.config.DBConn.getConnection;
import app.global.FunctionFactory;
import app.global.helper.DefaultComboBoxView;
import app.global.helper.DefaultTableView;
import app.model.Payment;
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
public class PaymentController extends Payment {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateTableData(JTable TableObject) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTablePatient();
        dtv.RenderTable();

        String createString = "SELECT * FROM payment WHERE TRId=" + this.getTRId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            dtv.ColumnAlignRight(4);
//            dtv.ColumnCenter(3);
            while (rs.next()) {
                String lbl = "<html><table border=0 cellpadding=0 cellspacing=0>"
                        + "<tr><td><img src=" + getClass().getResource("/img/pay3.png") + ">&nbsp</td><td>" + rs.getDate("TransDate") + "</td></th>";

                dtv.TableModel.addRow(new Object[]{rs.getInt("PaymentId"), lbl, rs.getString("ORNo"), rs.getString("Particular"), FunctionFactory.amountFormat(rs.getDouble("AmountPaid"))});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void Add(String TransDate) {
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO payment (TransDate, ORNo, AmountPaid, TRId, Particular) "
                + "VALUES ('" + TransDate + "', '" + this.getORNo() + "', '" + this.getAmountPaid() + "', " + this.getTRId() + ", '" + this.getParticular() + "')";

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

    public void Update(String TransDate) {
        Connection conn = getConnection();
        String createString;
        createString = "UPDATE payment SET "
                + "TransDate='" + TransDate + "', "
                + "ORNo='" + this.getORNo() + "', "
                + "AmountPaid= '" + this.getAmountPaid() + "', "
                + "Particular='" + this.getParticular() + "' "
                + "WHERE PaymentId=" + this.getPaymentId();

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
        String createString = "SELECT * FROM payment WHERE PaymentId=" + this.getPaymentId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setORNo(rs.getString("ORNo"));
                this.setParticular(rs.getString("Particular"));
                this.setTransDate(rs.getDate("TransDate"));
                this.setAmountPaid(rs.getDouble("AmountPaid"));
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
        createString = "DELETE FROM payment WHERE PaymentId=" + this.getPaymentId();

        try {
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void RemoveAllPaymentFromTR() {
        Connection Conn = getConnection();
        String createString;
        createString = "DELETE FROM payment WHERE TRId=" + this.getTRId();

        try {
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
}
