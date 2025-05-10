/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.controller;

import static app.config.DBConn.getConnection;
import app.global.helper.DefaultComboBoxView;
import app.global.helper.DefaultTableView;
import app.model.Patient;
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
public class PatientController extends Patient {

    static Statement Stmt;
    DefaultTableView dtv = new DefaultTableView();
    DefaultComboBoxView dcv = new DefaultComboBoxView();

    public void PopulateTableData(JTable TableObject, String parameter) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTablePatient();
        dtv.RenderTable();

        String createString = "SELECT p.PatientId, p.Name, "
                + "NickName, "
                + "g.Description,"
                + "cs.Description,"
                + "Address,"
                + "BirthDate,"
                + "YEAR(CURDATE())-YEAR(Birthdate) as Age, "
                + "Religion,"
                + "Occupation,"
                + "CompanyName,"
                + "OfficeAddress,"
                + "OfficeContactNo,"
                + "ParentGuardian,"
                + "TransDate,"
                + "p.GenderId,"
                + "p.CivilStatusId"
                + " FROM patient p INNER JOIN gender g ON p.GenderId=g.GenderId INNER JOIN civil_status cs ON p.CivilStatusId=cs.CivilStatusId WHERE name LIKE '%" + parameter + "%' ORDER BY Name";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

//            dtv.ColumnAlignRight(2);
            dtv.ColumnCenter(7);
            while (rs.next()) {
                String lbl = "";
                if (rs.getInt("GenderId") == 1) {
                    lbl = "<html><table border=0 cellpadding=0 cellspacing=0>"
                            + "<tr><td><img src=" + getClass().getResource("/img/malemedium.png") + ">&nbsp</td><td>" + rs.getString("Name") + "</td></th>";
                } else {
                    lbl = "<html><table border=0 cellpadding=0 cellspacing=0>"
                            + "<tr><td><img src=" + getClass().getResource("/img/femalemedium.png") + ">&nbsp</td><td>" + rs.getString("Name") + "</td></th>";
                }

                dtv.TableModel.addRow(new Object[]{rs.getInt("PatientId"),
                    lbl,
                    rs.getString("NickName"),
                    rs.getString("g.Description"),
                    rs.getString("cs.Description"),
                    rs.getString("Address"),
                    rs.getDate("BirthDate"),
                    rs.getString("Age"),
                    rs.getString("Religion"),
                    rs.getString("Occupation"),
                    rs.getString("CompanyName"),
                    rs.getString("OfficeAddress"),
                    rs.getString("OfficeContactNo"),
                    rs.getString("ParentGuardian"),
                    rs.getDate("TransDate"),
                });
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
    
    public void PopulateTableDataSearch(JTable TableObject, String parameter) {
        Connection Conn = getConnection();
        dtv.setTableObject(TableObject);
        dtv.InitializeTablePatient();
        dtv.RenderTable();

        String createString = "SELECT p.PatientId, p.Name, "
                + "NickName, "
                + "g.Description,"
                + "cs.Description,"
                + "Address,"
                + "BirthDate,"
                + "YEAR(CURDATE())-YEAR(Birthdate) as Age, "
                + "Religion,"
                + "Occupation,"
                + "CompanyName,"
                + "OfficeAddress,"
                + "OfficeContactNo,"
                + "ParentGuardian,"
                + "TransDate,"
                + "p.GenderId,"
                + "p.CivilStatusId"
                + " FROM patient p INNER JOIN gender g ON p.GenderId=g.GenderId INNER JOIN civil_status cs ON p.CivilStatusId=cs.CivilStatusId WHERE name LIKE '%" + parameter + "%' ORDER BY Name";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

//            dtv.ColumnAlignRight(2);
            dtv.ColumnCenter(7);
            while (rs.next()) {
                String lbl = "";
                if (rs.getInt("GenderId") == 1) {
                    lbl = "<html><table border=0 cellpadding=0 cellspacing=0>"
                            + "<tr><td><img src=" + getClass().getResource("/img/malemedium.png") + ">&nbsp</td><td>" + rs.getString("Name") + "</td></th>";
                } else {
                    lbl = "<html><table border=0 cellpadding=0 cellspacing=0>"
                            + "<tr><td><img src=" + getClass().getResource("/img/femalemedium.png") + ">&nbsp</td><td>" + rs.getString("Name") + "</td></th>";
                }

                dtv.TableModel.addRow(new Object[]{rs.getInt("PatientId"),
                    lbl,
                    rs.getString("NickName"),
                    rs.getString("g.Description"),
                    rs.getString("cs.Description"),
                    rs.getString("Address"),
                    rs.getDate("BirthDate"),
                    rs.getString("Religion"),
                    rs.getString("Occupation"),
                    rs.getString("CompanyName"),
                    rs.getString("OfficeAddress"),
                    rs.getString("OfficeContactNo"),
                    rs.getString("ParentGuardian"),
                    rs.getDate("TransDate"),
                    rs.getString("Name")
                    
                    
                });
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public int GetAge(int PatientId) {
        int PatientAge = 0;
        Connection Conn = getConnection();
        String createString = "SELECT YEAR(CURDATE())-YEAR(Birthdate) as Age FROM patient WHERE PatientId=" + PatientId;
        try {
            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                PatientAge = rs.getInt("Age");
            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
        return PatientAge;
    }

    public void Update(String bday) {
        Connection conn = getConnection();
        String createString;
        createString = "UPDATE patient "
                + "SET "
                + "Name='" + this.getName() + "', "
                + "NickName='" + this.getNickName() + "', "
                + "GenderId='" + this.getGenderID() + "', "
                + "CivilStatusId='" + this.getCivilStatusId() + "', "
                + "Address='" + this.getAddress() + "', "
                + "BirthDate='" + bday + "', "
                + "Religion='" + this.getReligion() + "', "
                + "Occupation='" + this.getOccupation() + "', "
                + "CompanyName='" + this.getCompanyName() + "', "
                + "OfficeAddress='" + this.getOfficeAddress() + "', "
                + "OfficeContactNo='" + this.getOfficeContactNo() + "', "
                + "ContactNo='" + this.getContactNo() + "', "
                 + "MedIntake='" + this.getMedIntake() + "', "
                + "ParentGuardian='" + this.getParentGuardian() + "' "
                + "WHERE PatientId=" + this.getPatientId();

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

    public void UpdateOAAndPE() {
        Connection conn = getConnection();
        String createString;
        createString = "UPDATE patient "
                + "SET "
                + "OtherAllergies='" + this.getOtherAllergies() + "', "
                + "PreviousExtraction='" + this.getPreviousExtraction() + "', "
                + "MedIntake='" + this.getMedIntake() + "' "
                + "WHERE PatientId=" + this.getPatientId();

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

    public int Add(String bday, String nowdate) {
        int MaxId = 0;
        Connection conn = getConnection();
        String createString;
        createString = "INSERT INTO patient (Name, NickName, GenderID, CivilStatusId, Address, BirthDate, Religion, OfficeContactNo, ContactNo, TransDate, ParentGuardian, OfficeAddress, Occupation, CompanyName, OtherAllergies, PreviousExtraction, MedIntake) "
                + "VALUES ('" + this.getName() + "', '" + this.getNickName() + "'," + this.getGenderID() + "," + this.getCivilStatusId() + ",'" + this.getAddress() + "','" + bday + "','" + this.getReligion() + "','" + this.getOfficeContactNo() + "','" + this.getContactNo() + "','" + nowdate + "','" + this.getParentGuardian() + "','" + this.getOfficeAddress() + "','" + this.getOccupation() + "','" + this.getCompanyName() + "','" + this.getOtherAllergies() + "','" + this.getPreviousExtraction() + "','" + this.getMedIntake() + "')";

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
        createString = "SELECT MAX(PatientId) FROM patient";

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

    public void PopulateDataOnEdit() {
        Connection Conn = getConnection();
        String createString = "SELECT * FROM patient WHERE PatientId=" + this.getPatientId();

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
                this.setName(rs.getString("Name"));
                this.setNickName(rs.getString("NickName"));
                this.setGenderID(rs.getInt("GenderId"));
                this.setCivilStatusId(rs.getInt("CivilStatusId"));
                this.setAddress(rs.getString("Address"));
                this.setBirthDate(rs.getDate("BirthDate"));
                this.setReligion(rs.getString("Religion"));
                this.setOccupation(rs.getString("Occupation"));
                this.setCompanyName(rs.getString("CompanyName"));
                this.setOfficeAddress(rs.getString("OfficeAddress"));
                this.setOfficeContactNo(rs.getString("OfficeContactNo"));
                this.setContactNo(rs.getString("ContactNo"));
                this.setParentGuardian(rs.getString("ParentGuardian"));
                this.setOtherAllergies(rs.getString("OtherAllergies"));
                this.setPreviousExtraction(rs.getString("PreviousExtraction"));
                 this.setMedIntake(rs.getString("MedIntake"));
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
        createString = "DELETE FROM patient WHERE PatientId=" + this.getPatientId();

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
