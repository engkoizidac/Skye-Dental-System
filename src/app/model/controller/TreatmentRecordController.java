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
import app.model.TreatmentRecord;

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
public class TreatmentRecordController extends TreatmentRecord {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateTableData(JTable TableObject, String parameter) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTablePatient();
        dtv.RenderTable();

        String createString = "SELECT tr.TRId, ToothNos, TProcedure, d.Name, AmountCharged, AmountCharged, tr.TransDate, TreatmentDate, SUM(AmountPaid) as TotalPaid,  AmountCharged-SUM(AmountPaid) as Balance, c.Name, Note, BloodPressure "
                + "FROM treatment_record tr "
                + "INNER JOIN dentist d ON tr.DentistId= d.DentistId "
                + "INNER JOIN clinic c ON tr.ClinicId=c.ClinicId "
                + "INNER JOIN payment p ON tr.TRId=p.TRId "
                + "WHERE PatientId=" + this.getPatientId() + " AND TProcedure LIKE '%" + parameter + "%' GROUP BY tr.TRId ORDER BY tr.TRId DESC ";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            dtv.ColumnAlignRight(5);
            dtv.ColumnAlignRight(6);
            dtv.ColumnAlignRight(7);
//            dtv.ColumnCenter(3);
            while (rs.next()) {
                String lbl = "<html><table border=0 cellpadding=0 cellspacing=0>"
                        + "<tr><td><img src=" + getClass().getResource("/img/tr.png") + ">&nbsp</td><td>" + rs.getDate("TreatmentDate") + "</td></th>";

                dtv.TableModel.addRow(new Object[]{rs.getInt("TRId"), lbl, rs.getString("ToothNos"), rs.getString("TProcedure"), rs.getString("d.Name"), FunctionFactory.amountFormat(rs.getDouble("AmountCharged")), FunctionFactory.amountFormat(rs.getDouble("TotalPaid")), FunctionFactory.amountFormat(rs.getDouble("Balance")), rs.getDate("TransDate"), rs.getString("c.Name"), rs.getString("Note"), rs.getString("BloodPressure")});
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public int Add(String TreatmentDate, String TransDate) {
        int MaxId = 0;
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO treatment_record (TreatmentDate, TransDate, ToothNos, TProcedure, DentistId, AmountCharged, PatientId, ClinicId, Note, BloodPressure) "
                + "VALUES ('" + TreatmentDate + "', '" + TransDate + "', '" + this.getToothNos() + "', '" + this.getTProcedure() + "', " + this.getDentistId() + ", '" + this.getAmountCharged() + "', '" + this.getPatientId() + "', '" + this.getClinicId() + "', '" + this.getNote() + "', '" + this.getBloodPressure() + "')";

        try {
            Connection Conn = getConnection();
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
        MaxId = GetInsertedId();
        return MaxId;
    }

    public int GetInsertedId() {
        int Id = 0;

        Connection conn = getConnection();
        String createString;
        createString = "SELECT MAX(TRId) FROM treatment_record";

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                Id = rs.getInt(1);
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return Id;
    }

    public void Update(String TreatmentDate) {
        Connection conn = getConnection();
        String createString;
        createString = "UPDATE treatment_record SET "
                + "TreatmentDate='" + TreatmentDate + "', "
                + "ToothNos='" + this.getToothNos() + "', "
                + "TProcedure= '" + this.getTProcedure() + "', "
                + "DentistId=" + this.getDentistId() + ", "
                + "Note='" + this.getNote() + "', "
                + "BloodPressure='" + this.getBloodPressure() + "', "
                + "AmountCharged='" + this.getAmountCharged() + "' "
                + "WHERE TRId=" + this.getTRId();

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
        String createString = "SELECT * FROM treatment_record WHERE TRId=" + this.getTRId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setTreatmentDate(rs.getDate("TreatmentDate"));
                this.setToothNos(rs.getString("ToothNos"));
                this.setTProcedure(rs.getString("TProcedure"));
                this.setDentistId(rs.getInt("DentistId"));
                this.setClinicId(rs.getInt("ClinicId"));
                this.setAmountCharged(rs.getDouble("AmountCharged"));
                this.setNote(rs.getString("Note"));
                this.setBloodPressure(rs.getString("BloodPressure"));
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
        createString = "DELETE FROM treatment_record WHERE TRId=" + this.getTRId();

        try {
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(createString);
            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }

        PaymentController PayController = new PaymentController();
        PayController.setTRId(this.getTRId());
        PayController.RemoveAllPaymentFromTR();
    }

    public String GetTotalBalance() {
        String Total = "";
        Connection Conn = getConnection();

        String createString = "SELECT   SUM(AmountCharged)-SUM(AmountPaid) as Balance "
                + "FROM treatment_record tr "
                + "INNER JOIN payment p ON tr.TRId=p.TRId "
                + "WHERE PatientId=" + this.getPatientId();
        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                Total = FunctionFactory.amountFormat2(String.valueOf(rs.getDouble("Balance")));
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }

        return Total;
    }
}
