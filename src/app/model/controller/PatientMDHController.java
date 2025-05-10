/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.controller;

import app.model.PatientMdh;
import static app.config.DBConn.getConnection;
import app.global.helper.DefaultTableView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EngkoiZidac
 */
public class PatientMDHController extends PatientMdh {

    static DefaultTableModel model;
    private static String ValuesParam;
    static Statement Stmt;
     DefaultTableView dtv = new DefaultTableView();

    public int GetSelectedCount(JTable tbl) {
        int rc = tbl.getRowCount();
        int row = 0;
        int counter = 0;
        while (row != rc) {
            String isSel = tbl.getValueAt(row, 1).toString();
            boolean is = Boolean.parseBoolean(isSel);

            if (is == true) {
                counter++;
            }
            row++;
        }
        return counter;
    }
    
    
    String ParamValues(JTable tbl) {
        String values = "";
        int rc = tbl.getRowCount();
        int row = 0;
        int counter = 0;
        while (row != rc) {
            String mdhId = tbl.getValueAt(row, 0).toString();
            String isSel = tbl.getValueAt(row, 1).toString();
            boolean is = Boolean.parseBoolean(isSel);

            if (is == true) {
                if (counter == 0) {
                    values = "(" + Integer.parseInt(mdhId) + "," + this.getPatientId() + ")";
                } else if (counter > 0) {
                    values = values + ",(" + Integer.parseInt(mdhId) + "," + this.getPatientId() + ")";
                }
                counter++;
            }
            row++;
        }
        return values;
    }

    public void Add(JTable tbl) {
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO patient_mdh (MDHId, PatientId) VALUES " + ParamValues(tbl);
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


    public void PopulateMDH(JTable TableObject, int PatientId) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTableMDH();
        dtv.RenderTableNoID();

        String createString = "SELECT * FROM mdh_category";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                String lbl= "<html><table border=0 cellpadding=0 cellspacing=0>"
                        + "<tr><td><img src=" + getClass().getResource("/img/mdhinfo.png") + ">&nbsp</td><td><b><i>" + rs.getString("Description") + "</i></b></td></th>";
                dtv.TableModel.addRow(new Object[]{lbl});
                PopulateMDHCHild(TableObject, PatientId, rs.getInt("CategoryId"));
                
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
        
     public void PopulateMDHCHild(JTable TableObject, int PatientId, int CategoryId) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTableMDHChild();
        dtv.RenderTableNoID();

        String createString = "SELECT * FROM patient_mdh pm INNER JOIN medical_dental_history mdh ON pm.MDHId=mdh.MDHId WHERE PatientId=" + PatientId + " AND mdh.CategoryId="+CategoryId+" ORDER BY PatientMDHId DESC";

//System.out.println(createString);
        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                String lbl= "<html><table border=0 cellpadding=0 cellspacing=0>"
                        + "<tr><td><img src=" + getClass().getResource("/img/flagredtmini.png") + ">&nbsp</td><td>" + rs.getString("Description") + "</td></th>";
                dtv.TableModel.addRow(new Object[]{"",lbl});
            //    System.out.println( rs.getString("Description"));
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
}
