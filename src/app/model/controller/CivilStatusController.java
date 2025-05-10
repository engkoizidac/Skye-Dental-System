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
import app.model.CivilStatus;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author EngkoiZidac
 */
public class CivilStatusController extends CivilStatus {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateComboBoxData(JComboBox ComboBoxObject, int Id) {
        dcv.setComboBoxObject(ComboBoxObject);
        dcv.InitializeComboBox();
        ComboBoxObject.addItem("SELECT");
        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM civil_status";

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("CivilStatusId"), rs.getString("Description")));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    
        public void PopulateComboBoxDataOnEdit(JComboBox ComboBoxObject, int Id, int CurrentCivilStatusId, String Desc) {
        dcv.setComboBoxObject(ComboBoxObject);
        //dcv.InitializeComboBox();
        ComboBoxObject.addItem(new ComboBoxItem(CurrentCivilStatusId, Desc));
        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM civil_status WHERE CivilStatusId<>" + CurrentCivilStatusId;

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                ComboBoxObject.addItem(new ComboBoxItem(rs.getInt("CivilStatusId"), rs.getString("Description")));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    
     public void PopulateDataOnEdit() {
        Connection Conn = getConnection();
        String createString = "SELECT * FROM civil_status WHERE CivilStatusId=" + this.getCivilStatusId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setDescription(rs.getString("Description"));

            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
}
