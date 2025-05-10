/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.toothchart;

import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EngkoiZidac
 */
public class PatientToothStatusSetter {

    static Statement Stmt;
    static DefaultTableModel model;
    ImageIcon image;

    public void SetPatientToothStatus(int PatientId, JLabel lbl, int ToothId, JTable tbl) {
        //   boolean IsSet = IsStatusSet(PatientId, ToothId);
        model = (DefaultTableModel) tbl.getModel();

        int rc = 0;
        rc = model.getRowCount();
        int srow = 0;

        while (srow != rc) {
            String t = tbl.getValueAt(srow, 0).toString();
            String c = tbl.getValueAt(srow, 1).toString();
            //.out.println(t +" : "+ToothId);
            if (ToothId == Integer.parseInt(t)) {
                lbl.setText(c);

            }
            srow++;
        }
    }

    public void SetPatientToothPartColor(int PatientId, JLabel lbl, int ToothPartId, JTable tbl) {
        //   boolean IsSet = IsStatusSet(PatientId, ToothId);
        model = (DefaultTableModel) tbl.getModel();

        int rc = 0;
        rc = model.getRowCount();
        int srow = 0;

        while (srow != rc) {
            String tp = tbl.getValueAt(srow, 0).toString();
            String c = tbl.getValueAt(srow, 1).toString();
            //.out.println(t +" : "+ToothId);
            if (ToothPartId == Integer.parseInt(tp)) {
                image = new ImageIcon(getClass().getResource("/img/" + c));
                lbl.setIcon(image);
            }
            srow++;
        }
    }
    
    
    boolean IsSet(int ToothPartId, JTable tbl) {
        boolean IsSet =false;
        model = (DefaultTableModel) tbl.getModel();

        int rc = 0;
        rc = model.getRowCount();
        int srow = 0;

        int cntr =0;
        while (srow != rc) {
            String tp = tbl.getValueAt(srow, 0).toString();
            String c = tbl.getValueAt(srow, 1).toString();
            //.out.println(t +" : "+ToothId);
            if (ToothPartId == Integer.parseInt(tp)) {
                cntr=cntr+1;
            }
            srow++;
        }
        
        if(cntr>0){
            IsSet=true;
        }
        
        return IsSet;
    }
    
    boolean ToothIsSet(int ToothId, JTable tbl) {
        boolean IsSet =false;
        model = (DefaultTableModel) tbl.getModel();

        int rc = 0;
        rc = model.getRowCount();
        int srow = 0;

        int cntr =0;
        while (srow != rc) {
            String t = tbl.getValueAt(srow, 0).toString();
        
            //.out.println(t +" : "+ToothId);
            if (ToothId == Integer.parseInt(t)) {
                cntr=cntr+1;
                 // System.out.println(t);
            }
            srow++;
        }
        
        if(cntr>0){
            IsSet=true;
        }
        
        return IsSet;
    }

}
