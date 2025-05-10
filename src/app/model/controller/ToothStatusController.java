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
import app.model.ToothStatus;
import static app.model.controller.GenderController.Stmt;
import static app.view.patient.NewPatient.chk;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import static org.eclipse.persistence.sessions.remote.corba.sun.TransporterHelper.id;

/**
 *
 * @author EngkoiZidac
 */
public class ToothStatusController extends ToothStatus {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();
    public void PopulateTableData(JTable TableObject) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTable();
        dtv.RenderTable();

        String createString = "SELECT * FROM tooth_status ORDER BY Description";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

//            dtv.ColumnAlignRight(2);
//            dtv.ColumnCenter(3);
            while (rs.next()) {
          
               String  lbl = "<html><table border=0 cellpadding=0 cellspacing=0>"
                        + "<tr><td><img src=" + getClass().getResource("/img/"+rs.getString("Image")) + ">&nbsp</td><td>" + rs.getString("Color") + "</td></th>";
                
                dtv.TableModel.addRow(new Object[]{rs.getInt("ToothStatusId"), rs.getString("Code"), rs.getString("Description"), lbl});
            }

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
        createString = "SELECT * FROM tooth_status ORDER BY Description";

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                 String  lbl = "<html><table border=0 cellpadding=0 cellspacing=0>"
                        + "<tr><td><img src=" + getClass().getResource("/img/"+rs.getString("Image")) + ">&nbsp</td><td>" + rs.getString("Description")+" <b>[" +rs.getString("Code")+"]</b>"+ "</td></th>";
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("ToothStatusId"), lbl));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
