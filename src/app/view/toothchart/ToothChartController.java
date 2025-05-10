/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.toothchart;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EngkoiZidac
 */
public class ToothChartController {

    ImageIcon image;
    public static SetToothStatus frmSetToothPerPart;
    PatientToothStatusSetter PTSS = new PatientToothStatusSetter();
    int stat;

    public void InjectToothAnimationListener(JLabel lbl, int type, String code, int toothno, int toothid, int toothpartid, JTable tbl, JTable multi) {
        lbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent me) {
                ToothChart x = new ToothChart();
                //    x.sel("Tooth No. " + toothno, toothid, toothpartid);
                ToothChart.SelectToothPart("Tooth No. " + toothno, toothid, toothpartid);
            }

//            @Override
//            public void mouseExited(MouseEvent me) {
//                boolean IsSet = PTSS.IsSet(toothpartid, tbl);
//
//                if (IsSet == false) {
//                    if (stat == 0) {
//                        switch (type) {
//                            case 1:
//                                image = new ImageIcon(getClass().getResource("/img/toothcenterblank.png"));
//                                lbl.setIcon(image);
//                                break;
//                            case 2:
//                                image = new ImageIcon(getClass().getResource("/img/toothtopblank.png"));
//                                lbl.setIcon(image);
//                                break;
//                            case 3:
//                                image = new ImageIcon(getClass().getResource("/img/toothbottomblank.png"));
//                                lbl.setIcon(image);
//                                break;
//                            case 4:
//                                image = new ImageIcon(getClass().getResource("/img/toothrightblank.png"));
//                                lbl.setIcon(image);
//                                break;
//                            case 5:
//                                image = new ImageIcon(getClass().getResource("/img/toothleftblank.png"));
//                                lbl.setIcon(image);
//                                break;
//                            default:
//                                break;
//                        }
//                    }
//                } else {
//
//                }
//stat=0;
//            }
            @Override
            public void mousePressed(MouseEvent me) {
//                if (PatientId == 0) {
//JOptionPane.showMessageDialog(null, "Please select a patient record!");
//                } else {
                stat = 1;
                switch (type) {
                    case 1:
                        image = new ImageIcon(getClass().getResource("/img/toothcentermouseclick.png"));
                        lbl.setIcon(image);
                        break;
                    case 2:
                        image = new ImageIcon(getClass().getResource("/img/toothtopmouseclick.png"));
                        lbl.setIcon(image);
                        break;
                    case 3:
                        image = new ImageIcon(getClass().getResource("/img/toothbottommouseclick.png"));
                        lbl.setIcon(image);
                        break;
                    case 4:
                        image = new ImageIcon(getClass().getResource("/img/toothrightmouseclick.png"));
                        lbl.setIcon(image);
                        break;
                    case 5:
                        image = new ImageIcon(getClass().getResource("/img/toothleftmouseclick.png"));
                        lbl.setIcon(image);
                        break;
                    default:
                        break;
                }
                
                InsertRowForEdit(multi, toothid, toothpartid, tbl);
            }

        });

//        lbl.addMouseMotionListener(new MouseMotionAdapter() {
//            @Override
//            public void mouseMoved(MouseEvent me) {
//                boolean IsSet = PTSS.IsSet(toothpartid, tbl);
//
//                if (IsSet == false) {
//                    switch (type) {
//                        case 1:
//                            image = new ImageIcon(getClass().getResource("/img/toothcentermousemoved.png"));
//                            lbl.setIcon(image);
//                            break;
//                        case 2:
//                            image = new ImageIcon(getClass().getResource("/img/toothtopmousemoved.png"));
//                            lbl.setIcon(image);
//                            break;
//                        case 3:
//                            image = new ImageIcon(getClass().getResource("/img/toothbottommousemoved.png"));
//                            lbl.setIcon(image);
//                            break;
//                        case 4:
//                            image = new ImageIcon(getClass().getResource("/img/toothrightmousemoved.png"));
//                            lbl.setIcon(image);
//                            break;
//                        case 5:
//                            image = new ImageIcon(getClass().getResource("/img/toothleftmousemoved.png"));
//                            lbl.setIcon(image);
//                            break;
//                        default:
//                            break;
//                    }
//                }
//            }
//        });
//        lbl.addFocusListener(new FocusListener() {
//            @Override
//            public void focusLost(FocusEvent me) {
//             
//            }
//
//            @Override
//            public void focusGained(FocusEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
    }

    void InsertRowForEdit(JTable multi, int ToothId, int ToothPartId, JTable tbl) {
        boolean isSet = PTSS.IsSet(ToothPartId, tbl);
        
        DefaultTableModel model = (DefaultTableModel) multi.getModel();
        
        int action = 0;
        if(isSet==true){
            action =2;
        }else{
            action=1;
        }
        
        model.addRow(new Object[]{ToothId, ToothPartId, action});
    }

    public void RefreshValues(JLabel lbl, int type) {
        switch (type) {
            case 1:
                image = new ImageIcon(getClass().getResource("/img/toothcenterblank.png"));
                lbl.setIcon(image);
                break;
            case 2:
                image = new ImageIcon(getClass().getResource("/img/toothtopblank.png"));
                lbl.setIcon(image);
                break;
            case 3:
                image = new ImageIcon(getClass().getResource("/img/toothbottomblank.png"));
                lbl.setIcon(image);
                break;
            case 4:
                image = new ImageIcon(getClass().getResource("/img/toothrightblank.png"));
                lbl.setIcon(image);
                break;
            case 5:
                image = new ImageIcon(getClass().getResource("/img/toothleftblank.png"));
                lbl.setIcon(image);
                break;
            default:
                break;
        }
    }

    public void RefreshLabelValues(JLabel lbl) {
        lbl.setText("L");
    }
}
