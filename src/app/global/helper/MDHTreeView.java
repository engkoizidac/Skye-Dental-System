/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.global.helper;

import static app.config.DBConn.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author EngkoiZidac
 */
public class MDHTreeView {

    static Statement Stmt;

    DefaultTreeModel model;
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Medical and Dental History");

    public void PopulateTreeView(JTree tree, int PatientId) {
        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM mdh_category ORDER BY CategoryId DESC";

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            model = new DefaultTreeModel(root);
            tree.setModel(model);

    
            while (rs.next()) {
                DefaultMutableTreeNode CategoryNode = new DefaultMutableTreeNode(rs.getString("Description"));

              root.add(CategoryNode);
               // CategoryNode.add(sss);
                PopulateTreeViewChild(PatientId, rs.getInt("CategotyId"));
    
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void PopulateTreeViewChild(int PatientId, int CategoryId) {
        Connection conn = getConnection();
        String createString;
        createString = "SELECT * FROM patient_mdh pm INNER JOIN medical_dental_history mdh ON pm.MDHId=mdh.MDHId WHERE PatientId=" + PatientId + " AND mdh.CategoryId="+CategoryId+" ORDER BY PatientMDHId DESC";

        try {
            Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {
//                DefaultMutableTreeNode ChildNode = new DefaultMutableTreeNode(rs.getString("mdh.Description"));
//                ParentNode.add(ChildNode);
System.out.println(rs.getString("mdh.Description"));
            }

            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    
      public static void main(String[] args) {
         MDHTreeView x = new MDHTreeView ();
          x.PopulateTreeViewChild(6, 1);
      }
}
