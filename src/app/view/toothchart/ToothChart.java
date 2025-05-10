/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.toothchart;

import app.view.patient.attachment.Attachment;
import static app.config.DBConn.getConnection;
import app.global.ReportFactory;
import app.global.helper.ComboBoxItem;
import app.global.helper.DefaultTableView;
import app.model.controller.PatientController;
import app.model.controller.PatientToothPartStatusController;
import app.model.controller.PatientToothStatusController;
import app.model.controller.ToothStatusController;
import app.view.informedConsent.InformedConcent;
import app.view.patient.PatientMDH;
import app.view.signature.SignatureClient;
import static app.view.toothchart.PatientToothStatusSetter.Stmt;
import app.view.treatmentrecord.TreatmentRecord;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EngkoiZidac
 */
public final class ToothChart extends javax.swing.JInternalFrame {

    ToothChartController TC = new ToothChartController();
    PatientToothStatusSetter PTSS = new PatientToothStatusSetter();
    public static Legend frmLegend;
    public static SelectPatient frmSelectPatient;
    public static InformedConcent frmInformedConcent;
    public static Attachment frmAttachment;
    public static SetToothStatus frmSetToothPerPart;
    public static int PatientId, ToothId, ToothPartId;
    public static String lbl, nymtxtc;
    PatientToothStatusController PTSC = new PatientToothStatusController();
    PatientToothPartStatusController PTPSC = new PatientToothPartStatusController();
    ToothStatusController TSController = new ToothStatusController();

    DefaultTableView dtv = new DefaultTableView();

    PatientController PatientController = new PatientController();
    public static PatientMDH frmPatientMDH;
    public static TreatmentRecord frmTR;
    public static SignatureClient frmSigCli;

    public static int ToothStatusId;

    public ToothChart() {

        initComponents();
        String lbl = "<html><table border=0 cellpadding=0 cellspacing=0>"
                + "<tr>&nbsp<td><img src=" + getClass().getResource("/img/malefemalemedium.png") + ">&nbsp</td><td>No Patient Selected</td></th>";
        lblpatient.setText(lbl);
        setAdultTab();
        setChildTab();
        InjectToothAnimationListener();
         tbltoothlabel.setVisible(false);
        jPanel7.setVisible(false);
        //   jButton4.setVisible(false);
        TSController.PopulateComboBoxData(cmbstatus);
//
//        cmdsave.setEnabled(false);
//        cmdrefresh.setEnabled(false);
//        cmbstatus.setEnabled(false);
    }

//            if (PatientId == 0) {
//            JOptionPane.showMessageDialog(null, "Please select patient record!");
//        } else {
//            ShowFrmSetToothPerPart();
//        }
    public void ShowFrmTR() {
        frmTR = new TreatmentRecord(this, true);
        frmTR.setVisible(true);
    }

    public void ShowFrmInformedConcent() {
        frmInformedConcent = new InformedConcent(this, true);
        frmInformedConcent.setVisible(true);
    }

    public void ShowFrmSigCli() {
        frmSigCli = new SignatureClient(this, true);
        frmSigCli.setVisible(true);
    }

    void ClearTableSelections() {
        DefaultTableModel model = (DefaultTableModel) tblmulti.getModel();
        model.setNumRows(0);
    }

    public void ShowFrmPatientMDH() {
        frmPatientMDH = new PatientMDH(this, true);
        frmPatientMDH.setVisible(true);
    }

    public void ShowFrmAttachment() {
        frmAttachment = new Attachment(this, true);
        frmAttachment.setVisible(true);
    }

    public void PopulateData() {
        PTSC.setPatientId(PatientId);
        PTSC.PopulateTableData(tbltoothlabel);
    }

    public void PopulateDataColor() {
        PTPSC.setPatientId(PatientId);
        PTPSC.PopulateTableData(tbltoothpartcolor);
    }

    public void RefreshPatientToothStatus() {
        PopulateData();
        PopulateDataColor();
        SetValueAndColors();
    }

    public void AddRow() {
        DefaultTableModel model = (DefaultTableModel) tbltoothpartcolor.getModel();
        model.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});
    }

    void RefreshValues() {
        TC.RefreshLabelValues(t11);
        TC.RefreshLabelValues(t12);
        TC.RefreshLabelValues(t13);
        TC.RefreshLabelValues(t14);
        TC.RefreshLabelValues(t15);
        TC.RefreshLabelValues(t16);
        TC.RefreshLabelValues(t17);
        TC.RefreshLabelValues(t18);
        TC.RefreshLabelValues(t21);
        TC.RefreshLabelValues(t22);
        TC.RefreshLabelValues(t23);
        TC.RefreshLabelValues(t24);
        TC.RefreshLabelValues(t25);
        TC.RefreshLabelValues(t26);
        TC.RefreshLabelValues(t27);
        TC.RefreshLabelValues(t28);

        TC.RefreshLabelValues(t31);
        TC.RefreshLabelValues(t32);
        TC.RefreshLabelValues(t33);
        TC.RefreshLabelValues(t34);
        TC.RefreshLabelValues(t35);
        TC.RefreshLabelValues(t36);
        TC.RefreshLabelValues(t37);
        TC.RefreshLabelValues(t38);
        TC.RefreshLabelValues(t41);
        TC.RefreshLabelValues(t42);
        TC.RefreshLabelValues(t43);
        TC.RefreshLabelValues(t44);
        TC.RefreshLabelValues(t45);
        TC.RefreshLabelValues(t46);
        TC.RefreshLabelValues(t47);
        TC.RefreshLabelValues(t48);

        TC.RefreshLabelValues(t51);
        TC.RefreshLabelValues(t52);
        TC.RefreshLabelValues(t53);
        TC.RefreshLabelValues(t54);
        TC.RefreshLabelValues(t55);

        TC.RefreshLabelValues(t61);
        TC.RefreshLabelValues(t62);
        TC.RefreshLabelValues(t63);
        TC.RefreshLabelValues(t64);
        TC.RefreshLabelValues(t65);

        TC.RefreshLabelValues(t71);
        TC.RefreshLabelValues(t72);
        TC.RefreshLabelValues(t73);
        TC.RefreshLabelValues(t74);
        TC.RefreshLabelValues(t75);

        TC.RefreshLabelValues(t81);
        TC.RefreshLabelValues(t82);
        TC.RefreshLabelValues(t83);
        TC.RefreshLabelValues(t84);
        TC.RefreshLabelValues(t85);

        TC.RefreshValues(t201, 1);
        TC.RefreshValues(t202, 2);
        TC.RefreshValues(t203, 3);
        TC.RefreshValues(t204, 4);
        TC.RefreshValues(t205, 5);
        TC.RefreshValues(t206, 1);
        TC.RefreshValues(t207, 2);
        TC.RefreshValues(t208, 3);
        TC.RefreshValues(t209, 4);
        TC.RefreshValues(t210, 5);
        TC.RefreshValues(t211, 1);
        TC.RefreshValues(t212, 2);
        TC.RefreshValues(t213, 3);
        TC.RefreshValues(t214, 4);
        TC.RefreshValues(t215, 5);
        TC.RefreshValues(t216, 1);
        TC.RefreshValues(t217, 2);
        TC.RefreshValues(t218, 3);
        TC.RefreshValues(t219, 4);
        TC.RefreshValues(t220, 5);
        TC.RefreshValues(t221, 1);
        TC.RefreshValues(t222, 2);
        TC.RefreshValues(t223, 3);
        TC.RefreshValues(t224, 4);
        TC.RefreshValues(t225, 5);
        TC.RefreshValues(t226, 1);
        TC.RefreshValues(t227, 2);
        TC.RefreshValues(t228, 3);
        TC.RefreshValues(t229, 4);
        TC.RefreshValues(t230, 5);
        TC.RefreshValues(t231, 1);
        TC.RefreshValues(t232, 2);
        TC.RefreshValues(t233, 3);
        TC.RefreshValues(t234, 4);
        TC.RefreshValues(t235, 5);
        TC.RefreshValues(t236, 1);
        TC.RefreshValues(t237, 2);
        TC.RefreshValues(t238, 3);
        TC.RefreshValues(t239, 4);
        TC.RefreshValues(t240, 5);

        TC.RefreshValues(t241, 1);
        TC.RefreshValues(t242, 2);
        TC.RefreshValues(t243, 3);
        TC.RefreshValues(t244, 4);
        TC.RefreshValues(t245, 5);
        TC.RefreshValues(t246, 1);
        TC.RefreshValues(t247, 2);
        TC.RefreshValues(t248, 3);
        TC.RefreshValues(t249, 4);
        TC.RefreshValues(t250, 5);
        TC.RefreshValues(t251, 1);
        TC.RefreshValues(t252, 2);
        TC.RefreshValues(t253, 3);
        TC.RefreshValues(t254, 4);
        TC.RefreshValues(t255, 5);
        TC.RefreshValues(t256, 1);
        TC.RefreshValues(t257, 2);
        TC.RefreshValues(t258, 3);
        TC.RefreshValues(t259, 4);
        TC.RefreshValues(t260, 5);
        TC.RefreshValues(t261, 1);
        TC.RefreshValues(t262, 2);
        TC.RefreshValues(t263, 3);
        TC.RefreshValues(t264, 4);
        TC.RefreshValues(t265, 5);
        TC.RefreshValues(t266, 1);
        TC.RefreshValues(t267, 2);
        TC.RefreshValues(t268, 3);
        TC.RefreshValues(t269, 4);
        TC.RefreshValues(t270, 5);
        TC.RefreshValues(t271, 1);
        TC.RefreshValues(t272, 2);
        TC.RefreshValues(t273, 3);
        TC.RefreshValues(t274, 4);
        TC.RefreshValues(t275, 5);
        TC.RefreshValues(t276, 1);
        TC.RefreshValues(t277, 2);
        TC.RefreshValues(t278, 3);
        TC.RefreshValues(t279, 4);
        TC.RefreshValues(t280, 5);

        TC.RefreshValues(t281, 1);
        TC.RefreshValues(t282, 2);
        TC.RefreshValues(t283, 3);
        TC.RefreshValues(t284, 4);
        TC.RefreshValues(t285, 5);
        TC.RefreshValues(t286, 1);
        TC.RefreshValues(t287, 2);
        TC.RefreshValues(t288, 3);
        TC.RefreshValues(t289, 4);
        TC.RefreshValues(t290, 5);
        TC.RefreshValues(t291, 1);
        TC.RefreshValues(t292, 2);
        TC.RefreshValues(t293, 3);
        TC.RefreshValues(t294, 4);
        TC.RefreshValues(t295, 5);
        TC.RefreshValues(t296, 1);
        TC.RefreshValues(t297, 2);
        TC.RefreshValues(t298, 3);
        TC.RefreshValues(t299, 4);
        TC.RefreshValues(t300, 5);
        TC.RefreshValues(t301, 1);
        TC.RefreshValues(t302, 2);
        TC.RefreshValues(t303, 3);
        TC.RefreshValues(t304, 4);
        TC.RefreshValues(t305, 5);
        TC.RefreshValues(t306, 1);
        TC.RefreshValues(t307, 2);
        TC.RefreshValues(t308, 3);
        TC.RefreshValues(t309, 4);
        TC.RefreshValues(t310, 5);
        TC.RefreshValues(t311, 1);
        TC.RefreshValues(t312, 2);
        TC.RefreshValues(t313, 3);
        TC.RefreshValues(t314, 4);
        TC.RefreshValues(t315, 5);
        TC.RefreshValues(t316, 1);
        TC.RefreshValues(t317, 2);
        TC.RefreshValues(t318, 3);
        TC.RefreshValues(t319, 4);
        TC.RefreshValues(t320, 5);

        TC.RefreshValues(t321, 1);
        TC.RefreshValues(t322, 2);
        TC.RefreshValues(t323, 3);
        TC.RefreshValues(t324, 4);
        TC.RefreshValues(t325, 5);
        TC.RefreshValues(t326, 1);
        TC.RefreshValues(t327, 2);
        TC.RefreshValues(t328, 3);
        TC.RefreshValues(t329, 4);
        TC.RefreshValues(t330, 5);
        TC.RefreshValues(t331, 1);
        TC.RefreshValues(t332, 2);
        TC.RefreshValues(t333, 3);
        TC.RefreshValues(t334, 4);
        TC.RefreshValues(t335, 5);
        TC.RefreshValues(t336, 1);
        TC.RefreshValues(t337, 2);
        TC.RefreshValues(t338, 3);
        TC.RefreshValues(t339, 4);
        TC.RefreshValues(t340, 5);
        TC.RefreshValues(t341, 1);
        TC.RefreshValues(t342, 2);
        TC.RefreshValues(t343, 3);
        TC.RefreshValues(t344, 4);
        TC.RefreshValues(t345, 5);
        TC.RefreshValues(t346, 1);
        TC.RefreshValues(t347, 2);
        TC.RefreshValues(t348, 3);
        TC.RefreshValues(t349, 4);
        TC.RefreshValues(t350, 5);
        TC.RefreshValues(t351, 1);
        TC.RefreshValues(t352, 2);
        TC.RefreshValues(t353, 3);
        TC.RefreshValues(t354, 4);
        TC.RefreshValues(t355, 5);
        TC.RefreshValues(t356, 1);
        TC.RefreshValues(t357, 2);
        TC.RefreshValues(t358, 3);
        TC.RefreshValues(t359, 4);
        TC.RefreshValues(t360, 5);

        TC.RefreshValues(t361, 1);
        TC.RefreshValues(t362, 2);
        TC.RefreshValues(t363, 3);
        TC.RefreshValues(t364, 4);
        TC.RefreshValues(t365, 5);
        TC.RefreshValues(t366, 1);
        TC.RefreshValues(t367, 2);
        TC.RefreshValues(t368, 3);
        TC.RefreshValues(t369, 4);
        TC.RefreshValues(t370, 5);
        TC.RefreshValues(t371, 1);
        TC.RefreshValues(t372, 2);
        TC.RefreshValues(t373, 3);
        TC.RefreshValues(t374, 4);
        TC.RefreshValues(t375, 5);
        TC.RefreshValues(t376, 1);
        TC.RefreshValues(t377, 2);
        TC.RefreshValues(t378, 3);
        TC.RefreshValues(t379, 4);
        TC.RefreshValues(t380, 5);
        TC.RefreshValues(t381, 1);
        TC.RefreshValues(t382, 2);
        TC.RefreshValues(t383, 3);
        TC.RefreshValues(t384, 4);
        TC.RefreshValues(t385, 5);

        TC.RefreshValues(t386, 1);
        TC.RefreshValues(t387, 2);
        TC.RefreshValues(t388, 3);
        TC.RefreshValues(t389, 4);
        TC.RefreshValues(t390, 5);
        TC.RefreshValues(t391, 1);
        TC.RefreshValues(t392, 2);
        TC.RefreshValues(t393, 3);
        TC.RefreshValues(t394, 4);
        TC.RefreshValues(t395, 5);
        TC.RefreshValues(t396, 1);
        TC.RefreshValues(t397, 2);
        TC.RefreshValues(t398, 3);
        TC.RefreshValues(t399, 4);
        TC.RefreshValues(t400, 5);
        TC.RefreshValues(t401, 1);
        TC.RefreshValues(t402, 2);
        TC.RefreshValues(t403, 3);
        TC.RefreshValues(t404, 4);
        TC.RefreshValues(t405, 5);
        TC.RefreshValues(t406, 1);
        TC.RefreshValues(t407, 2);
        TC.RefreshValues(t408, 3);
        TC.RefreshValues(t409, 4);
        TC.RefreshValues(t410, 5);

        TC.RefreshValues(t411, 1);
        TC.RefreshValues(t412, 2);
        TC.RefreshValues(t413, 3);
        TC.RefreshValues(t414, 4);
        TC.RefreshValues(t415, 5);
        TC.RefreshValues(t416, 1);
        TC.RefreshValues(t417, 2);
        TC.RefreshValues(t418, 3);
        TC.RefreshValues(t419, 4);
        TC.RefreshValues(t420, 5);
        TC.RefreshValues(t421, 1);
        TC.RefreshValues(t422, 2);
        TC.RefreshValues(t423, 3);
        TC.RefreshValues(t424, 4);
        TC.RefreshValues(t425, 5);
        TC.RefreshValues(t426, 1);
        TC.RefreshValues(t427, 2);
        TC.RefreshValues(t428, 3);
        TC.RefreshValues(t429, 4);
        TC.RefreshValues(t430, 5);
        TC.RefreshValues(t431, 1);
        TC.RefreshValues(t432, 2);
        TC.RefreshValues(t433, 3);
        TC.RefreshValues(t434, 4);
        TC.RefreshValues(t435, 5);

        TC.RefreshValues(t436, 1);
        TC.RefreshValues(t437, 2);
        TC.RefreshValues(t438, 3);
        TC.RefreshValues(t439, 4);
        TC.RefreshValues(t440, 5);
        TC.RefreshValues(t441, 1);
        TC.RefreshValues(t442, 2);
        TC.RefreshValues(t443, 3);
        TC.RefreshValues(t444, 4);
        TC.RefreshValues(t445, 5);
        TC.RefreshValues(t446, 1);
        TC.RefreshValues(t447, 2);
        TC.RefreshValues(t448, 3);
        TC.RefreshValues(t449, 4);
        TC.RefreshValues(t450, 5);
        TC.RefreshValues(t451, 1);
        TC.RefreshValues(t452, 2);
        TC.RefreshValues(t453, 3);
        TC.RefreshValues(t454, 4);
        TC.RefreshValues(t455, 5);
        TC.RefreshValues(t456, 1);
        TC.RefreshValues(t457, 2);
        TC.RefreshValues(t458, 3);
        TC.RefreshValues(t459, 4);
        TC.RefreshValues(t460, 5);

    }

    void RefreshColorValuesOnly() {
        TC.RefreshValues(t201, 1);
        TC.RefreshValues(t202, 2);
        TC.RefreshValues(t203, 3);
        TC.RefreshValues(t204, 4);
        TC.RefreshValues(t205, 5);
        TC.RefreshValues(t206, 1);
        TC.RefreshValues(t207, 2);
        TC.RefreshValues(t208, 3);
        TC.RefreshValues(t209, 4);
        TC.RefreshValues(t210, 5);
        TC.RefreshValues(t211, 1);
        TC.RefreshValues(t212, 2);
        TC.RefreshValues(t213, 3);
        TC.RefreshValues(t214, 4);
        TC.RefreshValues(t215, 5);
        TC.RefreshValues(t216, 1);
        TC.RefreshValues(t217, 2);
        TC.RefreshValues(t218, 3);
        TC.RefreshValues(t219, 4);
        TC.RefreshValues(t220, 5);
        TC.RefreshValues(t221, 1);
        TC.RefreshValues(t222, 2);
        TC.RefreshValues(t223, 3);
        TC.RefreshValues(t224, 4);
        TC.RefreshValues(t225, 5);
        TC.RefreshValues(t226, 1);
        TC.RefreshValues(t227, 2);
        TC.RefreshValues(t228, 3);
        TC.RefreshValues(t229, 4);
        TC.RefreshValues(t230, 5);
        TC.RefreshValues(t231, 1);
        TC.RefreshValues(t232, 2);
        TC.RefreshValues(t233, 3);
        TC.RefreshValues(t234, 4);
        TC.RefreshValues(t235, 5);
        TC.RefreshValues(t236, 1);
        TC.RefreshValues(t237, 2);
        TC.RefreshValues(t238, 3);
        TC.RefreshValues(t239, 4);
        TC.RefreshValues(t240, 5);

        TC.RefreshValues(t241, 1);
        TC.RefreshValues(t242, 2);
        TC.RefreshValues(t243, 3);
        TC.RefreshValues(t244, 4);
        TC.RefreshValues(t245, 5);
        TC.RefreshValues(t246, 1);
        TC.RefreshValues(t247, 2);
        TC.RefreshValues(t248, 3);
        TC.RefreshValues(t249, 4);
        TC.RefreshValues(t250, 5);
        TC.RefreshValues(t251, 1);
        TC.RefreshValues(t252, 2);
        TC.RefreshValues(t253, 3);
        TC.RefreshValues(t254, 4);
        TC.RefreshValues(t255, 5);
        TC.RefreshValues(t256, 1);
        TC.RefreshValues(t257, 2);
        TC.RefreshValues(t258, 3);
        TC.RefreshValues(t259, 4);
        TC.RefreshValues(t260, 5);
        TC.RefreshValues(t261, 1);
        TC.RefreshValues(t262, 2);
        TC.RefreshValues(t263, 3);
        TC.RefreshValues(t264, 4);
        TC.RefreshValues(t265, 5);
        TC.RefreshValues(t266, 1);
        TC.RefreshValues(t267, 2);
        TC.RefreshValues(t268, 3);
        TC.RefreshValues(t269, 4);
        TC.RefreshValues(t270, 5);
        TC.RefreshValues(t271, 1);
        TC.RefreshValues(t272, 2);
        TC.RefreshValues(t273, 3);
        TC.RefreshValues(t274, 4);
        TC.RefreshValues(t275, 5);
        TC.RefreshValues(t276, 1);
        TC.RefreshValues(t277, 2);
        TC.RefreshValues(t278, 3);
        TC.RefreshValues(t279, 4);
        TC.RefreshValues(t280, 5);

        TC.RefreshValues(t281, 1);
        TC.RefreshValues(t282, 2);
        TC.RefreshValues(t283, 3);
        TC.RefreshValues(t284, 4);
        TC.RefreshValues(t285, 5);
        TC.RefreshValues(t286, 1);
        TC.RefreshValues(t287, 2);
        TC.RefreshValues(t288, 3);
        TC.RefreshValues(t289, 4);
        TC.RefreshValues(t290, 5);
        TC.RefreshValues(t291, 1);
        TC.RefreshValues(t292, 2);
        TC.RefreshValues(t293, 3);
        TC.RefreshValues(t294, 4);
        TC.RefreshValues(t295, 5);
        TC.RefreshValues(t296, 1);
        TC.RefreshValues(t297, 2);
        TC.RefreshValues(t298, 3);
        TC.RefreshValues(t299, 4);
        TC.RefreshValues(t300, 5);
        TC.RefreshValues(t301, 1);
        TC.RefreshValues(t302, 2);
        TC.RefreshValues(t303, 3);
        TC.RefreshValues(t304, 4);
        TC.RefreshValues(t305, 5);
        TC.RefreshValues(t306, 1);
        TC.RefreshValues(t307, 2);
        TC.RefreshValues(t308, 3);
        TC.RefreshValues(t309, 4);
        TC.RefreshValues(t310, 5);
        TC.RefreshValues(t311, 1);
        TC.RefreshValues(t312, 2);
        TC.RefreshValues(t313, 3);
        TC.RefreshValues(t314, 4);
        TC.RefreshValues(t315, 5);
        TC.RefreshValues(t316, 1);
        TC.RefreshValues(t317, 2);
        TC.RefreshValues(t318, 3);
        TC.RefreshValues(t319, 4);
        TC.RefreshValues(t320, 5);

        TC.RefreshValues(t321, 1);
        TC.RefreshValues(t322, 2);
        TC.RefreshValues(t323, 3);
        TC.RefreshValues(t324, 4);
        TC.RefreshValues(t325, 5);
        TC.RefreshValues(t326, 1);
        TC.RefreshValues(t327, 2);
        TC.RefreshValues(t328, 3);
        TC.RefreshValues(t329, 4);
        TC.RefreshValues(t330, 5);
        TC.RefreshValues(t331, 1);
        TC.RefreshValues(t332, 2);
        TC.RefreshValues(t333, 3);
        TC.RefreshValues(t334, 4);
        TC.RefreshValues(t335, 5);
        TC.RefreshValues(t336, 1);
        TC.RefreshValues(t337, 2);
        TC.RefreshValues(t338, 3);
        TC.RefreshValues(t339, 4);
        TC.RefreshValues(t340, 5);
        TC.RefreshValues(t341, 1);
        TC.RefreshValues(t342, 2);
        TC.RefreshValues(t343, 3);
        TC.RefreshValues(t344, 4);
        TC.RefreshValues(t345, 5);
        TC.RefreshValues(t346, 1);
        TC.RefreshValues(t347, 2);
        TC.RefreshValues(t348, 3);
        TC.RefreshValues(t349, 4);
        TC.RefreshValues(t350, 5);
        TC.RefreshValues(t351, 1);
        TC.RefreshValues(t352, 2);
        TC.RefreshValues(t353, 3);
        TC.RefreshValues(t354, 4);
        TC.RefreshValues(t355, 5);
        TC.RefreshValues(t356, 1);
        TC.RefreshValues(t357, 2);
        TC.RefreshValues(t358, 3);
        TC.RefreshValues(t359, 4);
        TC.RefreshValues(t360, 5);

        TC.RefreshValues(t361, 1);
        TC.RefreshValues(t362, 2);
        TC.RefreshValues(t363, 3);
        TC.RefreshValues(t364, 4);
        TC.RefreshValues(t365, 5);
        TC.RefreshValues(t366, 1);
        TC.RefreshValues(t367, 2);
        TC.RefreshValues(t368, 3);
        TC.RefreshValues(t369, 4);
        TC.RefreshValues(t370, 5);
        TC.RefreshValues(t371, 1);
        TC.RefreshValues(t372, 2);
        TC.RefreshValues(t373, 3);
        TC.RefreshValues(t374, 4);
        TC.RefreshValues(t375, 5);
        TC.RefreshValues(t376, 1);
        TC.RefreshValues(t377, 2);
        TC.RefreshValues(t378, 3);
        TC.RefreshValues(t379, 4);
        TC.RefreshValues(t380, 5);
        TC.RefreshValues(t381, 1);
        TC.RefreshValues(t382, 2);
        TC.RefreshValues(t383, 3);
        TC.RefreshValues(t384, 4);
        TC.RefreshValues(t385, 5);

        TC.RefreshValues(t386, 1);
        TC.RefreshValues(t387, 2);
        TC.RefreshValues(t388, 3);
        TC.RefreshValues(t389, 4);
        TC.RefreshValues(t390, 5);
        TC.RefreshValues(t391, 1);
        TC.RefreshValues(t392, 2);
        TC.RefreshValues(t393, 3);
        TC.RefreshValues(t394, 4);
        TC.RefreshValues(t395, 5);
        TC.RefreshValues(t396, 1);
        TC.RefreshValues(t397, 2);
        TC.RefreshValues(t398, 3);
        TC.RefreshValues(t399, 4);
        TC.RefreshValues(t400, 5);
        TC.RefreshValues(t401, 1);
        TC.RefreshValues(t402, 2);
        TC.RefreshValues(t403, 3);
        TC.RefreshValues(t404, 4);
        TC.RefreshValues(t405, 5);
        TC.RefreshValues(t406, 1);
        TC.RefreshValues(t407, 2);
        TC.RefreshValues(t408, 3);
        TC.RefreshValues(t409, 4);
        TC.RefreshValues(t410, 5);

        TC.RefreshValues(t411, 1);
        TC.RefreshValues(t412, 2);
        TC.RefreshValues(t413, 3);
        TC.RefreshValues(t414, 4);
        TC.RefreshValues(t415, 5);
        TC.RefreshValues(t416, 1);
        TC.RefreshValues(t417, 2);
        TC.RefreshValues(t418, 3);
        TC.RefreshValues(t419, 4);
        TC.RefreshValues(t420, 5);
        TC.RefreshValues(t421, 1);
        TC.RefreshValues(t422, 2);
        TC.RefreshValues(t423, 3);
        TC.RefreshValues(t424, 4);
        TC.RefreshValues(t425, 5);
        TC.RefreshValues(t426, 1);
        TC.RefreshValues(t427, 2);
        TC.RefreshValues(t428, 3);
        TC.RefreshValues(t429, 4);
        TC.RefreshValues(t430, 5);
        TC.RefreshValues(t431, 1);
        TC.RefreshValues(t432, 2);
        TC.RefreshValues(t433, 3);
        TC.RefreshValues(t434, 4);
        TC.RefreshValues(t435, 5);

        TC.RefreshValues(t436, 1);
        TC.RefreshValues(t437, 2);
        TC.RefreshValues(t438, 3);
        TC.RefreshValues(t439, 4);
        TC.RefreshValues(t440, 5);
        TC.RefreshValues(t441, 1);
        TC.RefreshValues(t442, 2);
        TC.RefreshValues(t443, 3);
        TC.RefreshValues(t444, 4);
        TC.RefreshValues(t445, 5);
        TC.RefreshValues(t446, 1);
        TC.RefreshValues(t447, 2);
        TC.RefreshValues(t448, 3);
        TC.RefreshValues(t449, 4);
        TC.RefreshValues(t450, 5);
        TC.RefreshValues(t451, 1);
        TC.RefreshValues(t452, 2);
        TC.RefreshValues(t453, 3);
        TC.RefreshValues(t454, 4);
        TC.RefreshValues(t455, 5);
        TC.RefreshValues(t456, 1);
        TC.RefreshValues(t457, 2);
        TC.RefreshValues(t458, 3);
        TC.RefreshValues(t459, 4);
        TC.RefreshValues(t460, 5);

    }

    void SetValueAndColors() {
        PTSS.SetPatientToothStatus(PatientId, t11, 1, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t12, 2, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t13, 3, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t14, 4, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t15, 5, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t16, 6, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t17, 7, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t18, 8, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t21, 9, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t22, 10, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t23, 11, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t24, 12, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t25, 13, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t26, 14, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t27, 15, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t28, 16, tbltoothlabel);

        PTSS.SetPatientToothStatus(PatientId, t31, 17, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t32, 18, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t33, 19, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t34, 20, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t35, 21, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t36, 22, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t37, 23, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t38, 24, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t41, 25, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t42, 26, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t43, 27, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t44, 28, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t45, 29, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t46, 30, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t47, 31, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t48, 32, tbltoothlabel);

        PTSS.SetPatientToothStatus(PatientId, t51, 33, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t52, 34, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t53, 35, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t54, 36, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t55, 37, tbltoothlabel);

        PTSS.SetPatientToothStatus(PatientId, t61, 38, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t62, 39, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t63, 40, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t64, 41, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t65, 42, tbltoothlabel);

        PTSS.SetPatientToothStatus(PatientId, t71, 43, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t72, 44, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t73, 45, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t74, 46, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t75, 47, tbltoothlabel);

        PTSS.SetPatientToothStatus(PatientId, t81, 48, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t82, 49, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t83, 50, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t84, 51, tbltoothlabel);
        PTSS.SetPatientToothStatus(PatientId, t85, 52, tbltoothlabel);

        PTSS.SetPatientToothPartColor(PatientId, t201, 36, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t202, 37, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t203, 38, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t204, 39, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t205, 40, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t206, 31, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t207, 32, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t208, 33, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t209, 34, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t210, 35, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t211, 26, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t212, 27, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t213, 28, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t214, 29, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t215, 30, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t216, 21, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t217, 22, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t218, 23, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t219, 24, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t220, 25, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t221, 16, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t222, 17, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t223, 18, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t224, 19, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t225, 20, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t226, 11, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t227, 12, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t228, 13, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t229, 14, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t230, 15, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t231, 6, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t232, 7, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t233, 8, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t234, 9, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t235, 10, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t236, 1, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t237, 2, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t238, 3, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t239, 4, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t240, 5, tbltoothpartcolor);

        PTSS.SetPatientToothPartColor(PatientId, t241, 41, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t242, 42, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t243, 43, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t244, 44, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t245, 45, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t246, 46, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t247, 47, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t248, 48, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t249, 49, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t250, 50, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t251, 51, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t252, 52, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t253, 53, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t254, 54, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t255, 55, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t256, 56, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t257, 57, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t258, 58, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t259, 59, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t260, 60, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t261, 61, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t262, 62, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t263, 63, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t264, 64, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t265, 65, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t266, 66, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t267, 67, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t268, 68, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t269, 69, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t270, 70, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t271, 71, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t272, 72, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t273, 73, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t274, 74, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t275, 75, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t276, 76, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t277, 77, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t278, 78, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t279, 79, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t280, 80, tbltoothpartcolor);

        PTSS.SetPatientToothPartColor(PatientId, t281, 160, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t282, 159, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t283, 158, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t284, 157, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t285, 156, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t286, 155, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t287, 154, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t288, 153, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t289, 152, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t290, 151, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t291, 150, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t292, 149, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t293, 148, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t294, 147, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t295, 146, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t296, 145, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t297, 144, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t298, 143, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t299, 142, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t300, 141, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t301, 140, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t302, 139, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t303, 138, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t304, 137, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t305, 136, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t306, 135, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t307, 134, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t308, 133, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t309, 132, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t310, 131, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t311, 130, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t312, 129, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t313, 128, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t314, 127, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t315, 126, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t316, 125, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t317, 124, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t318, 123, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t319, 122, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t320, 121, tbltoothpartcolor);

        PTSS.SetPatientToothPartColor(PatientId, t321, 81, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t322, 82, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t323, 83, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t324, 84, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t325, 85, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t326, 86, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t327, 87, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t328, 88, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t329, 89, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t330, 90, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t331, 91, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t332, 92, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t333, 93, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t334, 94, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t335, 95, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t336, 96, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t337, 97, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t338, 98, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t339, 99, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t340, 100, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t341, 101, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t342, 102, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t343, 103, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t344, 104, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t345, 105, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t346, 106, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t347, 107, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t348, 108, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t349, 109, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t350, 110, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t351, 111, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t352, 112, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t353, 113, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t354, 114, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t355, 115, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t356, 116, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t357, 117, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t358, 118, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t359, 119, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t360, 120, tbltoothpartcolor);

        PTSS.SetPatientToothPartColor(PatientId, t361, 185, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t362, 184, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t363, 183, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t364, 182, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t365, 181, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t366, 180, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t367, 179, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t368, 178, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t369, 177, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t370, 176, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t371, 175, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t372, 174, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t373, 173, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t374, 172, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t375, 171, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t376, 170, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t377, 169, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t378, 168, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t379, 167, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t380, 166, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t381, 165, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t382, 164, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t383, 163, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t384, 162, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t385, 161, tbltoothpartcolor);

        PTSS.SetPatientToothPartColor(PatientId, t386, 186, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t387, 187, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t388, 188, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t389, 189, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t390, 190, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t391, 191, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t392, 192, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t393, 193, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t394, 194, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t395, 195, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t396, 196, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t397, 197, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t398, 198, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t399, 199, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t400, 200, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t401, 201, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t402, 202, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t403, 203, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t404, 204, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t405, 205, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t406, 206, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t407, 207, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t408, 208, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t409, 209, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t410, 210, tbltoothpartcolor);

        PTSS.SetPatientToothPartColor(PatientId, t411, 260, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t412, 259, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t413, 258, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t414, 257, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t415, 256, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t416, 255, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t417, 254, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t418, 253, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t419, 252, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t420, 251, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t421, 250, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t422, 249, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t423, 248, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t424, 247, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t425, 246, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t426, 245, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t427, 244, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t428, 243, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t429, 242, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t430, 241, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t431, 240, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t432, 239, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t433, 238, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t434, 237, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t435, 236, tbltoothpartcolor);

        PTSS.SetPatientToothPartColor(PatientId, t436, 211, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t437, 212, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t438, 213, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t439, 214, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t440, 215, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t441, 216, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t442, 217, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t443, 218, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t444, 219, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t445, 220, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t446, 221, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t447, 222, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t448, 223, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t449, 224, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t450, 225, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t451, 226, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t452, 227, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t453, 228, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t454, 229, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t455, 230, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t456, 231, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t457, 232, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t458, 233, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t459, 234, tbltoothpartcolor);
        PTSS.SetPatientToothPartColor(PatientId, t460, 235, tbltoothpartcolor);

    }

    public void ShowFrmSetToothPerPart() {

        SetToothStatus.lbl = lbl;
        SetToothStatus.PatientId = PatientId;
        SetToothStatus.ToothId = ToothId;
        SetToothStatus.ToothPartId = ToothPartId;
        frmSetToothPerPart = new SetToothStatus(this, true);
        frmSetToothPerPart.setVisible(true);

    }

    public static void SelectToothPart(String lbls, int ToothIds, int ToothPartIds) {

        lbl = lbls;
        ToothId = ToothIds;
        ToothPartId = ToothPartIds;

    }

    public void SetPatientToothStatus(int PatientId) {
        Connection Conn = getConnection();
        String createString = "SELECT * FROM pa";

        try {

            Stmt = Conn.createStatement();
            ResultSet rs = Stmt.executeQuery(createString);

            while (rs.next()) {

            }

            Stmt.close();
            Conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void ShowFrmSelectPatient() {
        frmSelectPatient = new SelectPatient(this, true);
        frmSelectPatient.setVisible(true);
    }

    public void ShowFrmLegend() {
        frmLegend = new Legend(this, true);
        frmLegend.setVisible(true);
    }

    public void SetDataOnSelectPatient(int Id, String Nym, String Gender, String nymtxt) {
        lblpatient.setText("");
        PatientId = Id;
//        System.out.println(PatientId);
        lblpatient.setText(Nym);
        nymtxtc = nymtxt;

        RefreshValues();
        PopulateData();
        PopulateDataColor();
        SetValueAndColors();
        lbla.setText("Age: " + PatientController.GetAge(PatientId));
    }

    void InjectToothAnimationListener() {
//                TC.InjectToothAnimationListener(t201, 1, "t201", 18, 8, 36, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t202, 2, "t202", 18, 8, 37, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t203, 3, "t203", 18, 8, 38, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t204, 4, "t204", 18, 8, 39, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t205, 5, "t205", 18, 8, 40, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t206, 1, "t206", 17, 7, 31, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t207, 2, "t207", 17, 7, 32, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t208, 3, "t208", 17, 7, 33, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t209, 4, "t209", 17, 7, 34, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t210, 5, "t210", 17, 7, 35, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t211, 1, "t211", 16, 6, 26, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t212, 2, "t212", 16, 6, 27, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t213, 3, "t213", 16, 6, 28, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t214, 4, "t214", 16, 6, 29, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t215, 5, "t215", 16, 6, 30, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t216, 1, "t216", 15, 5, 21, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t217, 2, "t217", 15, 5, 22, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t218, 3, "t218", 15, 5, 23, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t219, 4, "t219", 15, 5, 24, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t220, 5, "t220", 15, 5, 25, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t221, 1, "t221", 14, 4, 16, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t222, 2, "t222", 14, 4, 17, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t223, 3, "t223", 14, 4, 18, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t224, 4, "t224", 14, 4, 19, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t225, 5, "t225", 14, 4, 20, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t226, 1, "t226", 13, 3, 11, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t227, 2, "t227", 13, 3, 12, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t228, 3, "t228", 13, 3, 13, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t229, 4, "t229", 13, 3, 14, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t230, 5, "t230", 13, 3, 15, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t231, 1, "t231", 12, 2, 6, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t232, 2, "t232", 12, 2, 7, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t233, 3, "t233", 12, 2, 8, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t234, 4, "t234", 12, 2, 9, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t235, 5, "t235", 12, 2, 10, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t236, 1, "t236", 11, 1, 1, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t237, 2, "t237", 11, 1, 2, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t238, 3, "t238", 11, 1, 3, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t239, 4, "t239", 11, 1, 4, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t240, 5, "t240", 11, 1, 5, tbltoothpartcolor, PatientId);
//
//        TC.InjectToothAnimationListener(t241, 1, "t241", 21, 9, 41, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t242, 2, "t242", 21, 9, 42, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t243, 3, "t243", 21, 9, 43, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t244, 4, "t244", 21, 9, 44, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t245, 5, "t245", 21, 9, 45, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t246, 1, "t246", 22, 10, 46, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t247, 2, "t247", 22, 10, 47, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t248, 3, "t248", 22, 10, 48, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t249, 4, "t249", 22, 10, 49, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t250, 5, "t250", 22, 10, 50, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t251, 1, "t251", 23, 11, 51, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t252, 2, "t252", 23, 11, 52, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t253, 3, "t253", 23, 11, 53, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t254, 4, "t254", 23, 11, 54, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t255, 5, "t255", 23, 11, 55, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t256, 1, "t256", 24, 12, 56, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t257, 2, "t257", 24, 12, 57, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t258, 3, "t258", 24, 12, 58, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t259, 4, "t259", 24, 12, 59, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t260, 5, "t260", 24, 12, 60, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t261, 1, "t261", 25, 13, 61, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t262, 2, "t262", 25, 13, 62, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t263, 3, "t263", 25, 13, 63, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t264, 4, "t264", 25, 13, 64, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t265, 5, "t265", 25, 13, 65, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t266, 1, "t266", 26, 14, 66, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t267, 2, "t267", 26, 14, 67, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t268, 3, "t268", 26, 14, 68, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t269, 4, "t269", 26, 14, 69, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t270, 5, "t270", 26, 14, 70, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t271, 1, "t271", 27, 15, 71, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t272, 2, "t272", 27, 15, 72, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t273, 3, "t273", 27, 15, 73, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t274, 4, "t274", 27, 15, 74, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t275, 5, "t275", 27, 15, 75, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t276, 1, "t276", 28, 16, 76, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t277, 2, "t277", 28, 16, 77, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t278, 3, "t278", 28, 16, 78, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t279, 4, "t279", 28, 16, 79, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t280, 5, "t270", 28, 16, 80, tbltoothpartcolor, PatientId);
//
//        TC.InjectToothAnimationListener(t281, 1, "t281", 48, 32, 160, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t282, 2, "t282", 48, 32, 159, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t283, 3, "t283", 48, 32, 158, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t284, 4, "t284", 48, 32, 157, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t285, 5, "t285", 48, 32, 156, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t286, 1, "t286", 47, 31, 155, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t287, 2, "t287", 47, 31, 154, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t288, 3, "t288", 47, 31, 153, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t289, 4, "t289", 47, 31, 152, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t290, 5, "t290", 47, 31, 151, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t291, 1, "t291", 46, 30, 150, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t292, 2, "t292", 46, 30, 149, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t293, 3, "t293", 46, 30, 148, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t294, 4, "t294", 46, 30, 147, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t295, 5, "t295", 46, 30, 146, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t296, 1, "t296", 45, 29, 145, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t297, 2, "t297", 45, 29, 144, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t298, 3, "t298", 45, 29, 143, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t299, 4, "t299", 45, 29, 142, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t300, 5, "t300", 45, 29, 141, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t301, 1, "t301", 44, 28, 140, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t302, 2, "t302", 44, 28, 139, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t303, 3, "t303", 44, 28, 138, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t304, 4, "t304", 44, 28, 137, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t305, 5, "t305", 44, 28, 136, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t306, 1, "t306", 43, 27, 135, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t307, 2, "t307", 43, 27, 134, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t308, 3, "t308", 43, 27, 133, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t309, 4, "t309", 43, 27, 132, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t310, 5, "t310", 43, 27, 131, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t311, 1, "t311", 42, 26, 130, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t312, 2, "t312", 42, 26, 129, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t313, 3, "t313", 42, 26, 128, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t314, 4, "t314", 42, 26, 127, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t315, 5, "t315", 42, 26, 126, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t316, 1, "t316", 41, 25, 125, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t317, 2, "t317", 41, 25, 124, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t318, 3, "t318", 41, 25, 123, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t319, 4, "t319", 41, 25, 122, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t320, 5, "t320", 41, 25, 121, tbltoothpartcolor, PatientId);
//
//        TC.InjectToothAnimationListener(t321, 1, "t321", 31, 17, 81, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t322, 2, "t322", 31, 17, 82, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t323, 3, "t323", 31, 17, 83, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t324, 4, "t324", 31, 17, 84, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t325, 5, "t325", 31, 17, 85, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t326, 1, "t326", 32, 18, 86, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t327, 2, "t327", 32, 18, 87, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t328, 3, "t328", 32, 18, 88, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t329, 4, "t329", 32, 18, 89, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t330, 5, "t330", 32, 18, 90, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t331, 1, "t331", 33, 19, 91, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t332, 2, "t332", 33, 19, 92, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t333, 3, "t333", 33, 19, 93, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t334, 4, "t334", 33, 19, 94, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t335, 5, "t335", 33, 19, 95, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t336, 1, "t336", 34, 20, 96, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t337, 2, "t337", 34, 20, 97, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t338, 3, "t338", 34, 20, 98, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t339, 4, "t339", 34, 20, 99, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t340, 5, "t340", 34, 20, 100, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t341, 1, "t341", 35, 21, 101, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t342, 2, "t342", 35, 21, 102, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t343, 3, "t343", 35, 21, 103, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t344, 4, "t344", 35, 21, 104, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t345, 5, "t345", 35, 21, 105, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t346, 1, "t346", 36, 22, 106, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t347, 2, "t347", 36, 22, 107, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t348, 3, "t348", 36, 22, 108, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t349, 4, "t349", 36, 22, 109, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t350, 5, "t350", 36, 22, 110, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t351, 1, "t351", 37, 23, 111, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t352, 2, "t352", 37, 23, 112, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t353, 3, "t353", 37, 23, 113, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t354, 4, "t354", 37, 23, 114, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t355, 5, "t355", 37, 23, 115, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t356, 1, "t356", 38, 24, 116, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t357, 2, "t357", 38, 24, 117, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t358, 3, "t358", 38, 24, 118, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t359, 4, "t359", 38, 24, 119, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t360, 5, "t360", 38, 24, 120, tbltoothpartcolor, PatientId);
//
//        TC.InjectToothAnimationListener(t361, 1, "t361", 55, 37, 185, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t362, 2, "t362", 55, 37, 184, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t363, 3, "t363", 55, 37, 183, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t364, 4, "t364", 55, 37, 182, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t365, 5, "t365", 55, 37, 181, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t366, 1, "t366", 54, 36, 180, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t367, 2, "t367", 54, 36, 179, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t368, 3, "t368", 54, 36, 178, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t369, 4, "t369", 54, 36, 177, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t370, 5, "t370", 54, 36, 176, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t371, 1, "t371", 53, 35, 175, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t372, 2, "t372", 53, 35, 174, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t373, 3, "t373", 53, 35, 173, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t374, 4, "t374", 53, 35, 172, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t375, 5, "t375", 53, 35, 171, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t376, 1, "t376", 52, 34, 170, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t377, 2, "t377", 52, 34, 169, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t378, 3, "t378", 52, 34, 168, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t379, 4, "t379", 52, 34, 167, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t380, 5, "t380", 52, 34, 166, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t381, 1, "t381", 51, 33, 165, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t382, 2, "t382", 51, 33, 164, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t383, 3, "t383", 51, 33, 163, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t384, 4, "t384", 51, 33, 162, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t385, 5, "t385", 51, 33, 161, tbltoothpartcolor, PatientId);
//
//        TC.InjectToothAnimationListener(t386, 1, "t386", 61, 38, 186, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t387, 2, "t387", 61, 38, 187, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t388, 3, "t388", 61, 38, 188, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t389, 4, "t389", 61, 38, 189, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t390, 5, "t390", 61, 38, 190, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t391, 1, "t391", 62, 39, 191, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t392, 2, "t392", 62, 39, 192, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t393, 3, "t393", 62, 39, 193, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t394, 4, "t394", 62, 39, 194, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t395, 5, "t395", 62, 39, 195, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t396, 1, "t396", 63, 40, 196, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t397, 2, "t397", 63, 40, 197, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t398, 3, "t398", 63, 40, 198, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t399, 4, "t399", 63, 40, 199, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t400, 5, "t400", 63, 40, 200, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t401, 1, "t401", 64, 41, 201, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t402, 2, "t402", 64, 41, 202, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t403, 3, "t403", 64, 41, 203, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t404, 4, "t405", 64, 41, 204, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t405, 5, "t405", 64, 41, 205, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t406, 1, "t406", 65, 42, 206, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t407, 2, "t407", 65, 42, 207, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t408, 3, "t408", 65, 42, 208, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t409, 4, "t409", 65, 42, 209, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t410, 5, "t410", 65, 42, 210, tbltoothpartcolor, PatientId);
//
//        TC.InjectToothAnimationListener(t411, 1, "t411", 85, 52, 260, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t412, 2, "t412", 85, 52, 259, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t413, 3, "t413", 85, 52, 258, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t414, 4, "t414", 85, 52, 257, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t415, 5, "t415", 85, 52, 256, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t416, 1, "t416", 84, 51, 255, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t417, 2, "t417", 84, 51, 254, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t418, 3, "t418", 84, 51, 253, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t419, 4, "t419", 84, 51, 252, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t420, 5, "t420", 84, 51, 251, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t421, 1, "t421", 83, 50, 250, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t422, 2, "t422", 83, 50, 249, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t423, 3, "t423", 83, 50, 248, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t424, 4, "t425", 83, 50, 247, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t425, 5, "t425", 83, 50, 246, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t426, 1, "t426", 82, 49, 245, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t427, 2, "t427", 82, 49, 244, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t428, 3, "t428", 82, 49, 243, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t429, 4, "t429", 82, 49, 242, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t430, 5, "t430", 82, 49, 241, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t431, 1, "t431", 81, 48, 240, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t432, 2, "t432", 81, 48, 239, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t433, 3, "t433", 81, 48, 238, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t434, 4, "t435", 81, 48, 237, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t435, 5, "t435", 81, 48, 236, tbltoothpartcolor, PatientId);
//
//        TC.InjectToothAnimationListener(t436, 1, "t436", 71, 43, 211, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t437, 2, "t437", 71, 43, 212, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t438, 3, "t438", 71, 43, 213, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t439, 4, "t439", 71, 43, 214, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t440, 5, "t440", 71, 43, 215, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t441, 1, "t441", 72, 44, 216, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t442, 2, "t442", 72, 44, 217, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t443, 3, "t443", 72, 44, 218, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t444, 4, "t445", 72, 44, 219, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t445, 5, "t445", 72, 44, 220, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t446, 1, "t446", 73, 45, 221, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t447, 2, "t447", 73, 45, 222, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t448, 3, "t448", 73, 45, 223, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t449, 4, "t449", 73, 45, 224, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t450, 5, "t450", 73, 45, 225, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t451, 1, "t451", 74, 46, 226, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t452, 2, "t452", 74, 46, 227, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t453, 3, "t453", 74, 46, 228, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t454, 4, "t455", 74, 46, 229, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t455, 5, "t455", 74, 46, 230, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t456, 1, "t456", 75, 47, 231, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t457, 2, "t457", 75, 47, 232, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t458, 3, "t458", 75, 47, 233, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t459, 4, "t459", 75, 47, 234, tbltoothpartcolor, PatientId);
//        TC.InjectToothAnimationListener(t460, 5, "t460", 75, 47, 235, tbltoothpartcolor, PatientId);

//        TC.InjectToothAnimationListener(t201, 1, "t201", 18, 8, 36, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t202, 2, "t202", 18, 8, 37, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t203, 3, "t203", 18, 8, 38, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t204, 4, "t204", 18, 8, 39, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t205, 5, "t205", 18, 8, 40, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t206, 1, "t206", 17, 7, 31, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t207, 2, "t207", 17, 7, 32, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t208, 3, "t208", 17, 7, 33, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t209, 4, "t209", 17, 7, 34, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t210, 5, "t210", 17, 7, 35, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t211, 1, "t211", 16, 6, 26, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t212, 2, "t212", 16, 6, 27, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t213, 3, "t213", 16, 6, 28, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t214, 4, "t214", 16, 6, 29, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t215, 5, "t215", 16, 6, 30, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t216, 1, "t216", 15, 5, 21, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t217, 2, "t217", 15, 5, 22, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t218, 3, "t218", 15, 5, 23, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t219, 4, "t219", 15, 5, 24, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t220, 5, "t220", 15, 5, 25, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t221, 1, "t221", 14, 4, 16, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t222, 2, "t222", 14, 4, 17, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t223, 3, "t223", 14, 4, 18, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t224, 4, "t224", 14, 4, 19, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t225, 5, "t225", 14, 4, 20, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t226, 1, "t226", 13, 3, 11, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t227, 2, "t227", 13, 3, 12, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t228, 3, "t228", 13, 3, 13, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t229, 4, "t229", 13, 3, 14, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t230, 5, "t230", 13, 3, 15, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t231, 1, "t231", 12, 2, 6, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t232, 2, "t232", 12, 2, 7, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t233, 3, "t233", 12, 2, 8, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t234, 4, "t234", 12, 2, 9, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t235, 5, "t235", 12, 2, 10, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t236, 1, "t236", 11, 1, 1, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t237, 2, "t237", 11, 1, 2, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t238, 3, "t238", 11, 1, 3, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t239, 4, "t239", 11, 1, 4, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t240, 5, "t240", 11, 1, 5, tbltoothpartcolor);
//
//        TC.InjectToothAnimationListener(t241, 1, "t241", 21, 9, 41, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t242, 2, "t242", 21, 9, 42, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t243, 3, "t243", 21, 9, 43, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t244, 4, "t244", 21, 9, 44, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t245, 5, "t245", 21, 9, 45, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t246, 1, "t246", 22, 10, 46, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t247, 2, "t247", 22, 10, 47, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t248, 3, "t248", 22, 10, 48, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t249, 4, "t249", 22, 10, 49, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t250, 5, "t250", 22, 10, 50, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t251, 1, "t251", 23, 11, 51, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t252, 2, "t252", 23, 11, 52, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t253, 3, "t253", 23, 11, 53, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t254, 4, "t254", 23, 11, 54, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t255, 5, "t255", 23, 11, 55, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t256, 1, "t256", 24, 12, 56, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t257, 2, "t257", 24, 12, 57, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t258, 3, "t258", 24, 12, 58, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t259, 4, "t259", 24, 12, 59, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t260, 5, "t260", 24, 12, 60, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t261, 1, "t261", 25, 13, 61, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t262, 2, "t262", 25, 13, 62, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t263, 3, "t263", 25, 13, 63, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t264, 4, "t264", 25, 13, 64, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t265, 5, "t265", 25, 13, 65, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t266, 1, "t266", 26, 14, 66, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t267, 2, "t267", 26, 14, 67, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t268, 3, "t268", 26, 14, 68, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t269, 4, "t269", 26, 14, 69, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t270, 5, "t270", 26, 14, 70, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t271, 1, "t271", 27, 15, 71, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t272, 2, "t272", 27, 15, 72, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t273, 3, "t273", 27, 15, 73, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t274, 4, "t274", 27, 15, 74, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t275, 5, "t275", 27, 15, 75, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t276, 1, "t276", 28, 16, 76, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t277, 2, "t277", 28, 16, 77, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t278, 3, "t278", 28, 16, 78, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t279, 4, "t279", 28, 16, 79, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t280, 5, "t270", 28, 16, 80, tbltoothpartcolor);
//
//        TC.InjectToothAnimationListener(t281, 1, "t281", 48, 32, 160, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t282, 2, "t282", 48, 32, 159, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t283, 3, "t283", 48, 32, 158, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t284, 4, "t284", 48, 32, 157, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t285, 5, "t285", 48, 32, 156, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t286, 1, "t286", 47, 31, 155, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t287, 2, "t287", 47, 31, 154, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t288, 3, "t288", 47, 31, 153, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t289, 4, "t289", 47, 31, 152, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t290, 5, "t290", 47, 31, 151, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t291, 1, "t291", 46, 30, 150, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t292, 2, "t292", 46, 30, 149, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t293, 3, "t293", 46, 30, 148, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t294, 4, "t294", 46, 30, 147, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t295, 5, "t295", 46, 30, 146, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t296, 1, "t296", 45, 29, 145, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t297, 2, "t297", 45, 29, 144, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t298, 3, "t298", 45, 29, 143, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t299, 4, "t299", 45, 29, 142, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t300, 5, "t300", 45, 29, 141, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t301, 1, "t301", 44, 28, 140, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t302, 2, "t302", 44, 28, 139, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t303, 3, "t303", 44, 28, 138, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t304, 4, "t304", 44, 28, 137, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t305, 5, "t305", 44, 28, 136, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t306, 1, "t306", 43, 27, 135, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t307, 2, "t307", 43, 27, 134, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t308, 3, "t308", 43, 27, 133, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t309, 4, "t309", 43, 27, 132, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t310, 5, "t310", 43, 27, 131, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t311, 1, "t311", 42, 26, 130, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t312, 2, "t312", 42, 26, 129, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t313, 3, "t313", 42, 26, 128, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t314, 4, "t314", 42, 26, 127, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t315, 5, "t315", 42, 26, 126, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t316, 1, "t316", 41, 25, 125, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t317, 2, "t317", 41, 25, 124, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t318, 3, "t318", 41, 25, 123, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t319, 4, "t319", 41, 25, 122, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t320, 5, "t320", 41, 25, 121, tbltoothpartcolor);
//
//        TC.InjectToothAnimationListener(t321, 1, "t321", 31, 17, 81, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t322, 2, "t322", 31, 17, 82, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t323, 3, "t323", 31, 17, 83, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t324, 4, "t324", 31, 17, 84, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t325, 5, "t325", 31, 17, 85, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t326, 1, "t326", 32, 18, 86, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t327, 2, "t327", 32, 18, 87, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t328, 3, "t328", 32, 18, 88, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t329, 4, "t329", 32, 18, 89, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t330, 5, "t330", 32, 18, 90, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t331, 1, "t331", 33, 19, 91, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t332, 2, "t332", 33, 19, 92, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t333, 3, "t333", 33, 19, 93, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t334, 4, "t334", 33, 19, 94, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t335, 5, "t335", 33, 19, 95, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t336, 1, "t336", 34, 20, 96, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t337, 2, "t337", 34, 20, 97, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t338, 3, "t338", 34, 20, 98, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t339, 4, "t339", 34, 20, 99, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t340, 5, "t340", 34, 20, 100, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t341, 1, "t341", 35, 21, 101, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t342, 2, "t342", 35, 21, 102, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t343, 3, "t343", 35, 21, 103, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t344, 4, "t344", 35, 21, 104, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t345, 5, "t345", 35, 21, 105, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t346, 1, "t346", 36, 22, 106, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t347, 2, "t347", 36, 22, 107, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t348, 3, "t348", 36, 22, 108, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t349, 4, "t349", 36, 22, 109, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t350, 5, "t350", 36, 22, 110, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t351, 1, "t351", 37, 23, 111, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t352, 2, "t352", 37, 23, 112, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t353, 3, "t353", 37, 23, 113, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t354, 4, "t354", 37, 23, 114, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t355, 5, "t355", 37, 23, 115, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t356, 1, "t356", 38, 24, 116, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t357, 2, "t357", 38, 24, 117, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t358, 3, "t358", 38, 24, 118, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t359, 4, "t359", 38, 24, 119, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t360, 5, "t360", 38, 24, 120, tbltoothpartcolor);
//
//        TC.InjectToothAnimationListener(t361, 1, "t361", 55, 37, 185, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t362, 2, "t362", 55, 37, 184, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t363, 3, "t363", 55, 37, 183, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t364, 4, "t364", 55, 37, 182, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t365, 5, "t365", 55, 37, 181, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t366, 1, "t366", 54, 36, 180, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t367, 2, "t367", 54, 36, 179, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t368, 3, "t368", 54, 36, 178, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t369, 4, "t369", 54, 36, 177, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t370, 5, "t370", 54, 36, 176, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t371, 1, "t371", 53, 35, 175, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t372, 2, "t372", 53, 35, 174, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t373, 3, "t373", 53, 35, 173, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t374, 4, "t374", 53, 35, 172, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t375, 5, "t375", 53, 35, 171, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t376, 1, "t376", 52, 34, 170, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t377, 2, "t377", 52, 34, 169, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t378, 3, "t378", 52, 34, 168, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t379, 4, "t379", 52, 34, 167, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t380, 5, "t380", 52, 34, 166, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t381, 1, "t381", 51, 33, 165, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t382, 2, "t382", 51, 33, 164, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t383, 3, "t383", 51, 33, 163, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t384, 4, "t384", 51, 33, 162, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t385, 5, "t385", 51, 33, 161, tbltoothpartcolor);
//
//        TC.InjectToothAnimationListener(t386, 1, "t386", 61, 38, 186, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t387, 2, "t387", 61, 38, 187, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t388, 3, "t388", 61, 38, 188, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t389, 4, "t389", 61, 38, 189, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t390, 5, "t390", 61, 38, 190, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t391, 1, "t391", 62, 39, 191, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t392, 2, "t392", 62, 39, 192, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t393, 3, "t393", 62, 39, 193, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t394, 4, "t394", 62, 39, 194, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t395, 5, "t395", 62, 39, 195, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t396, 1, "t396", 63, 40, 196, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t397, 2, "t397", 63, 40, 197, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t398, 3, "t398", 63, 40, 198, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t399, 4, "t399", 63, 40, 199, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t400, 5, "t400", 63, 40, 200, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t401, 1, "t401", 64, 41, 201, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t402, 2, "t402", 64, 41, 202, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t403, 3, "t403", 64, 41, 203, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t404, 4, "t405", 64, 41, 204, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t405, 5, "t405", 64, 41, 205, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t406, 1, "t406", 65, 42, 206, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t407, 2, "t407", 65, 42, 207, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t408, 3, "t408", 65, 42, 208, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t409, 4, "t409", 65, 42, 209, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t410, 5, "t410", 65, 42, 210, tbltoothpartcolor);
//
//        TC.InjectToothAnimationListener(t411, 1, "t411", 85, 52, 260, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t412, 2, "t412", 85, 52, 259, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t413, 3, "t413", 85, 52, 258, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t414, 4, "t414", 85, 52, 257, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t415, 5, "t415", 85, 52, 256, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t416, 1, "t416", 84, 51, 255, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t417, 2, "t417", 84, 51, 254, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t418, 3, "t418", 84, 51, 253, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t419, 4, "t419", 84, 51, 252, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t420, 5, "t420", 84, 51, 251, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t421, 1, "t421", 83, 50, 250, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t422, 2, "t422", 83, 50, 249, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t423, 3, "t423", 83, 50, 248, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t424, 4, "t425", 83, 50, 247, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t425, 5, "t425", 83, 50, 246, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t426, 1, "t426", 82, 49, 245, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t427, 2, "t427", 82, 49, 244, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t428, 3, "t428", 82, 49, 243, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t429, 4, "t429", 82, 49, 242, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t430, 5, "t430", 82, 49, 241, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t431, 1, "t431", 81, 48, 240, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t432, 2, "t432", 81, 48, 239, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t433, 3, "t433", 81, 48, 238, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t434, 4, "t435", 81, 48, 237, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t435, 5, "t435", 81, 48, 236, tbltoothpartcolor);
//
//        TC.InjectToothAnimationListener(t436, 1, "t436", 71, 43, 211, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t437, 2, "t437", 71, 43, 212, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t438, 3, "t438", 71, 43, 213, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t439, 4, "t439", 71, 43, 214, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t440, 5, "t440", 71, 43, 215, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t441, 1, "t441", 72, 44, 216, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t442, 2, "t442", 72, 44, 217, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t443, 3, "t443", 72, 44, 218, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t444, 4, "t445", 72, 44, 219, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t445, 5, "t445", 72, 44, 220, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t446, 1, "t446", 73, 45, 221, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t447, 2, "t447", 73, 45, 222, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t448, 3, "t448", 73, 45, 223, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t449, 4, "t449", 73, 45, 224, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t450, 5, "t450", 73, 45, 225, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t451, 1, "t451", 74, 46, 226, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t452, 2, "t452", 74, 46, 227, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t453, 3, "t453", 74, 46, 228, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t454, 4, "t455", 74, 46, 229, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t455, 5, "t455", 74, 46, 230, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t456, 1, "t456", 75, 47, 231, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t457, 2, "t457", 75, 47, 232, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t458, 3, "t458", 75, 47, 233, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t459, 4, "t459", 75, 47, 234, tbltoothpartcolor);
//        TC.InjectToothAnimationListener(t460, 5, "t460", 75, 47, 235, tbltoothpartcolor);
        TC.InjectToothAnimationListener(t201, 1, "t201", 18, 8, 36, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t202, 2, "t202", 18, 8, 37, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t203, 3, "t203", 18, 8, 38, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t204, 4, "t204", 18, 8, 39, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t205, 5, "t205", 18, 8, 40, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t206, 1, "t206", 17, 7, 31, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t207, 2, "t207", 17, 7, 32, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t208, 3, "t208", 17, 7, 33, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t209, 4, "t209", 17, 7, 34, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t210, 5, "t210", 17, 7, 35, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t211, 1, "t211", 16, 6, 26, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t212, 2, "t212", 16, 6, 27, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t213, 3, "t213", 16, 6, 28, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t214, 4, "t214", 16, 6, 29, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t215, 5, "t215", 16, 6, 30, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t216, 1, "t216", 15, 5, 21, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t217, 2, "t217", 15, 5, 22, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t218, 3, "t218", 15, 5, 23, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t219, 4, "t219", 15, 5, 24, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t220, 5, "t220", 15, 5, 25, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t221, 1, "t221", 14, 4, 16, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t222, 2, "t222", 14, 4, 17, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t223, 3, "t223", 14, 4, 18, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t224, 4, "t224", 14, 4, 19, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t225, 5, "t225", 14, 4, 20, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t226, 1, "t226", 13, 3, 11, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t227, 2, "t227", 13, 3, 12, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t228, 3, "t228", 13, 3, 13, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t229, 4, "t229", 13, 3, 14, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t230, 5, "t230", 13, 3, 15, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t231, 1, "t231", 12, 2, 6, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t232, 2, "t232", 12, 2, 7, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t233, 3, "t233", 12, 2, 8, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t234, 4, "t234", 12, 2, 9, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t235, 5, "t235", 12, 2, 10, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t236, 1, "t236", 11, 1, 1, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t237, 2, "t237", 11, 1, 2, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t238, 3, "t238", 11, 1, 3, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t239, 4, "t239", 11, 1, 4, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t240, 5, "t240", 11, 1, 5, tbltoothpartcolor, tblmulti);

        TC.InjectToothAnimationListener(t241, 1, "t241", 21, 9, 41, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t242, 2, "t242", 21, 9, 42, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t243, 3, "t243", 21, 9, 43, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t244, 4, "t244", 21, 9, 44, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t245, 5, "t245", 21, 9, 45, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t246, 1, "t246", 22, 10, 46, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t247, 2, "t247", 22, 10, 47, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t248, 3, "t248", 22, 10, 48, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t249, 4, "t249", 22, 10, 49, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t250, 5, "t250", 22, 10, 50, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t251, 1, "t251", 23, 11, 51, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t252, 2, "t252", 23, 11, 52, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t253, 3, "t253", 23, 11, 53, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t254, 4, "t254", 23, 11, 54, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t255, 5, "t255", 23, 11, 55, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t256, 1, "t256", 24, 12, 56, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t257, 2, "t257", 24, 12, 57, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t258, 3, "t258", 24, 12, 58, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t259, 4, "t259", 24, 12, 59, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t260, 5, "t260", 24, 12, 60, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t261, 1, "t261", 25, 13, 61, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t262, 2, "t262", 25, 13, 62, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t263, 3, "t263", 25, 13, 63, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t264, 4, "t264", 25, 13, 64, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t265, 5, "t265", 25, 13, 65, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t266, 1, "t266", 26, 14, 66, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t267, 2, "t267", 26, 14, 67, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t268, 3, "t268", 26, 14, 68, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t269, 4, "t269", 26, 14, 69, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t270, 5, "t270", 26, 14, 70, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t271, 1, "t271", 27, 15, 71, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t272, 2, "t272", 27, 15, 72, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t273, 3, "t273", 27, 15, 73, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t274, 4, "t274", 27, 15, 74, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t275, 5, "t275", 27, 15, 75, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t276, 1, "t276", 28, 16, 76, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t277, 2, "t277", 28, 16, 77, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t278, 3, "t278", 28, 16, 78, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t279, 4, "t279", 28, 16, 79, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t280, 5, "t270", 28, 16, 80, tbltoothpartcolor, tblmulti);

        TC.InjectToothAnimationListener(t281, 1, "t281", 48, 32, 160, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t282, 2, "t282", 48, 32, 159, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t283, 3, "t283", 48, 32, 158, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t284, 4, "t284", 48, 32, 157, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t285, 5, "t285", 48, 32, 156, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t286, 1, "t286", 47, 31, 155, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t287, 2, "t287", 47, 31, 154, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t288, 3, "t288", 47, 31, 153, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t289, 4, "t289", 47, 31, 152, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t290, 5, "t290", 47, 31, 151, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t291, 1, "t291", 46, 30, 150, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t292, 2, "t292", 46, 30, 149, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t293, 3, "t293", 46, 30, 148, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t294, 4, "t294", 46, 30, 147, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t295, 5, "t295", 46, 30, 146, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t296, 1, "t296", 45, 29, 145, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t297, 2, "t297", 45, 29, 144, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t298, 3, "t298", 45, 29, 143, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t299, 4, "t299", 45, 29, 142, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t300, 5, "t300", 45, 29, 141, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t301, 1, "t301", 44, 28, 140, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t302, 2, "t302", 44, 28, 139, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t303, 3, "t303", 44, 28, 138, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t304, 4, "t304", 44, 28, 137, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t305, 5, "t305", 44, 28, 136, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t306, 1, "t306", 43, 27, 135, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t307, 2, "t307", 43, 27, 134, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t308, 3, "t308", 43, 27, 133, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t309, 4, "t309", 43, 27, 132, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t310, 5, "t310", 43, 27, 131, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t311, 1, "t311", 42, 26, 130, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t312, 2, "t312", 42, 26, 129, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t313, 3, "t313", 42, 26, 128, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t314, 4, "t314", 42, 26, 127, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t315, 5, "t315", 42, 26, 126, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t316, 1, "t316", 41, 25, 125, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t317, 2, "t317", 41, 25, 124, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t318, 3, "t318", 41, 25, 123, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t319, 4, "t319", 41, 25, 122, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t320, 5, "t320", 41, 25, 121, tbltoothpartcolor, tblmulti);

        TC.InjectToothAnimationListener(t321, 1, "t321", 31, 17, 81, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t322, 2, "t322", 31, 17, 82, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t323, 3, "t323", 31, 17, 83, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t324, 4, "t324", 31, 17, 84, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t325, 5, "t325", 31, 17, 85, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t326, 1, "t326", 32, 18, 86, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t327, 2, "t327", 32, 18, 87, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t328, 3, "t328", 32, 18, 88, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t329, 4, "t329", 32, 18, 89, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t330, 5, "t330", 32, 18, 90, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t331, 1, "t331", 33, 19, 91, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t332, 2, "t332", 33, 19, 92, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t333, 3, "t333", 33, 19, 93, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t334, 4, "t334", 33, 19, 94, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t335, 5, "t335", 33, 19, 95, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t336, 1, "t336", 34, 20, 96, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t337, 2, "t337", 34, 20, 97, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t338, 3, "t338", 34, 20, 98, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t339, 4, "t339", 34, 20, 99, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t340, 5, "t340", 34, 20, 100, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t341, 1, "t341", 35, 21, 101, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t342, 2, "t342", 35, 21, 102, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t343, 3, "t343", 35, 21, 103, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t344, 4, "t344", 35, 21, 104, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t345, 5, "t345", 35, 21, 105, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t346, 1, "t346", 36, 22, 106, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t347, 2, "t347", 36, 22, 107, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t348, 3, "t348", 36, 22, 108, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t349, 4, "t349", 36, 22, 109, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t350, 5, "t350", 36, 22, 110, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t351, 1, "t351", 37, 23, 111, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t352, 2, "t352", 37, 23, 112, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t353, 3, "t353", 37, 23, 113, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t354, 4, "t354", 37, 23, 114, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t355, 5, "t355", 37, 23, 115, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t356, 1, "t356", 38, 24, 116, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t357, 2, "t357", 38, 24, 117, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t358, 3, "t358", 38, 24, 118, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t359, 4, "t359", 38, 24, 119, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t360, 5, "t360", 38, 24, 120, tbltoothpartcolor, tblmulti);

        TC.InjectToothAnimationListener(t361, 1, "t361", 55, 37, 185, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t362, 2, "t362", 55, 37, 184, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t363, 3, "t363", 55, 37, 183, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t364, 4, "t364", 55, 37, 182, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t365, 5, "t365", 55, 37, 181, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t366, 1, "t366", 54, 36, 180, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t367, 2, "t367", 54, 36, 179, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t368, 3, "t368", 54, 36, 178, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t369, 4, "t369", 54, 36, 177, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t370, 5, "t370", 54, 36, 176, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t371, 1, "t371", 53, 35, 175, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t372, 2, "t372", 53, 35, 174, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t373, 3, "t373", 53, 35, 173, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t374, 4, "t374", 53, 35, 172, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t375, 5, "t375", 53, 35, 171, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t376, 1, "t376", 52, 34, 170, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t377, 2, "t377", 52, 34, 169, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t378, 3, "t378", 52, 34, 168, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t379, 4, "t379", 52, 34, 167, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t380, 5, "t380", 52, 34, 166, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t381, 1, "t381", 51, 33, 165, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t382, 2, "t382", 51, 33, 164, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t383, 3, "t383", 51, 33, 163, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t384, 4, "t384", 51, 33, 162, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t385, 5, "t385", 51, 33, 161, tbltoothpartcolor, tblmulti);

        TC.InjectToothAnimationListener(t386, 1, "t386", 61, 38, 186, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t387, 2, "t387", 61, 38, 187, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t388, 3, "t388", 61, 38, 188, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t389, 4, "t389", 61, 38, 189, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t390, 5, "t390", 61, 38, 190, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t391, 1, "t391", 62, 39, 191, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t392, 2, "t392", 62, 39, 192, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t393, 3, "t393", 62, 39, 193, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t394, 4, "t394", 62, 39, 194, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t395, 5, "t395", 62, 39, 195, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t396, 1, "t396", 63, 40, 196, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t397, 2, "t397", 63, 40, 197, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t398, 3, "t398", 63, 40, 198, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t399, 4, "t399", 63, 40, 199, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t400, 5, "t400", 63, 40, 200, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t401, 1, "t401", 64, 41, 201, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t402, 2, "t402", 64, 41, 202, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t403, 3, "t403", 64, 41, 203, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t404, 4, "t405", 64, 41, 204, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t405, 5, "t405", 64, 41, 205, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t406, 1, "t406", 65, 42, 206, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t407, 2, "t407", 65, 42, 207, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t408, 3, "t408", 65, 42, 208, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t409, 4, "t409", 65, 42, 209, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t410, 5, "t410", 65, 42, 210, tbltoothpartcolor, tblmulti);

        TC.InjectToothAnimationListener(t411, 1, "t411", 85, 52, 260, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t412, 2, "t412", 85, 52, 259, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t413, 3, "t413", 85, 52, 258, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t414, 4, "t414", 85, 52, 257, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t415, 5, "t415", 85, 52, 256, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t416, 1, "t416", 84, 51, 255, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t417, 2, "t417", 84, 51, 254, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t418, 3, "t418", 84, 51, 253, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t419, 4, "t419", 84, 51, 252, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t420, 5, "t420", 84, 51, 251, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t421, 1, "t421", 83, 50, 250, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t422, 2, "t422", 83, 50, 249, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t423, 3, "t423", 83, 50, 248, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t424, 4, "t425", 83, 50, 247, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t425, 5, "t425", 83, 50, 246, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t426, 1, "t426", 82, 49, 245, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t427, 2, "t427", 82, 49, 244, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t428, 3, "t428", 82, 49, 243, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t429, 4, "t429", 82, 49, 242, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t430, 5, "t430", 82, 49, 241, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t431, 1, "t431", 81, 48, 240, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t432, 2, "t432", 81, 48, 239, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t433, 3, "t433", 81, 48, 238, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t434, 4, "t435", 81, 48, 237, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t435, 5, "t435", 81, 48, 236, tbltoothpartcolor, tblmulti);

        TC.InjectToothAnimationListener(t436, 1, "t436", 71, 43, 211, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t437, 2, "t437", 71, 43, 212, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t438, 3, "t438", 71, 43, 213, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t439, 4, "t439", 71, 43, 214, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t440, 5, "t440", 71, 43, 215, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t441, 1, "t441", 72, 44, 216, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t442, 2, "t442", 72, 44, 217, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t443, 3, "t443", 72, 44, 218, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t444, 4, "t445", 72, 44, 219, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t445, 5, "t445", 72, 44, 220, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t446, 1, "t446", 73, 45, 221, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t447, 2, "t447", 73, 45, 222, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t448, 3, "t448", 73, 45, 223, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t449, 4, "t449", 73, 45, 224, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t450, 5, "t450", 73, 45, 225, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t451, 1, "t451", 74, 46, 226, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t452, 2, "t452", 74, 46, 227, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t453, 3, "t453", 74, 46, 228, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t454, 4, "t455", 74, 46, 229, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t455, 5, "t455", 74, 46, 230, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t456, 1, "t456", 75, 47, 231, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t457, 2, "t457", 75, 47, 232, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t458, 3, "t458", 75, 47, 233, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t459, 4, "t459", 75, 47, 234, tbltoothpartcolor, tblmulti);
        TC.InjectToothAnimationListener(t460, 5, "t460", 75, 47, 235, tbltoothpartcolor, tblmulti);

    }

    void setAdultTab() {
        JLabel lbl = new JLabel("<html><table border=0 cellpadding=0 cellspacing=0><tr><td><img src=" + getClass().getResource("/img/adult.png") + ">&nbsp</td><td>Adult<font></td></th>");
        lbl.setIconTextGap(5);
        //   ptab.setTabComponentAt(0, lbl);
    }

    void setChildTab() {
        JLabel lbl = new JLabel("<html><table border=0 cellpadding=0 cellspacing=0><tr><td><img src=" + getClass().getResource("/img/child.png") + ">&nbsp</td><td>Child<font></td></th>");
        lbl.setIconTextGap(5);
        //   ptab.setTabComponentAt(1, lbl);
    }

//    void setTopTeethTab() {
//        JLabel lbl = new JLabel("<html><table border=0 cellpadding=0 cellspacing=0><tr><td><img src=" + getClass().getResource("/img/topteeth.png") + ">&nbsp</td><td>Teeth 11-28<font></td></th>");
//        lbl.setIconTextGap(5);
//        ttab.setTabComponentAt(0, lbl);
//    }
//
//    void setTopBottomTeethTab() {
//        JLabel lbl = new JLabel("<html><table border=0 cellpadding=0 cellspacing=0><tr><td><img src=" + getClass().getResource("/img/bottomteeth.png") + ">&nbsp</td><td>Teeth 31-48<font></td></th>");
//        lbl.setIconTextGap(5);
//        ttab.setTabComponentAt(1, lbl);
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        panel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        t201 = new javax.swing.JLabel();
        t202 = new javax.swing.JLabel();
        t203 = new javax.swing.JLabel();
        t204 = new javax.swing.JLabel();
        t205 = new javax.swing.JLabel();
        t18 = new javax.swing.JLabel();
        t17 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        t206 = new javax.swing.JLabel();
        t207 = new javax.swing.JLabel();
        t208 = new javax.swing.JLabel();
        t209 = new javax.swing.JLabel();
        t210 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        t16 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        t211 = new javax.swing.JLabel();
        t212 = new javax.swing.JLabel();
        t213 = new javax.swing.JLabel();
        t214 = new javax.swing.JLabel();
        t215 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        t15 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        t216 = new javax.swing.JLabel();
        t217 = new javax.swing.JLabel();
        t218 = new javax.swing.JLabel();
        t219 = new javax.swing.JLabel();
        t220 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        t221 = new javax.swing.JLabel();
        t222 = new javax.swing.JLabel();
        t223 = new javax.swing.JLabel();
        t224 = new javax.swing.JLabel();
        t225 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        t14 = new javax.swing.JLabel();
        t13 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        t226 = new javax.swing.JLabel();
        t227 = new javax.swing.JLabel();
        t228 = new javax.swing.JLabel();
        t229 = new javax.swing.JLabel();
        t230 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        t231 = new javax.swing.JLabel();
        t232 = new javax.swing.JLabel();
        t233 = new javax.swing.JLabel();
        t234 = new javax.swing.JLabel();
        t235 = new javax.swing.JLabel();
        t12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        t236 = new javax.swing.JLabel();
        t237 = new javax.swing.JLabel();
        t238 = new javax.swing.JLabel();
        t239 = new javax.swing.JLabel();
        t240 = new javax.swing.JLabel();
        t11 = new javax.swing.JLabel();
        t21 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        t241 = new javax.swing.JLabel();
        t242 = new javax.swing.JLabel();
        t243 = new javax.swing.JLabel();
        t244 = new javax.swing.JLabel();
        t245 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        t22 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        t246 = new javax.swing.JLabel();
        t247 = new javax.swing.JLabel();
        t248 = new javax.swing.JLabel();
        t249 = new javax.swing.JLabel();
        t250 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        t23 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        t251 = new javax.swing.JLabel();
        t252 = new javax.swing.JLabel();
        t253 = new javax.swing.JLabel();
        t254 = new javax.swing.JLabel();
        t255 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        t24 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        t256 = new javax.swing.JLabel();
        t257 = new javax.swing.JLabel();
        t258 = new javax.swing.JLabel();
        t259 = new javax.swing.JLabel();
        t260 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        t25 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        t261 = new javax.swing.JLabel();
        t262 = new javax.swing.JLabel();
        t263 = new javax.swing.JLabel();
        t264 = new javax.swing.JLabel();
        t265 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        t26 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        t266 = new javax.swing.JLabel();
        t267 = new javax.swing.JLabel();
        t268 = new javax.swing.JLabel();
        t269 = new javax.swing.JLabel();
        t270 = new javax.swing.JLabel();
        t27 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        t271 = new javax.swing.JLabel();
        t272 = new javax.swing.JLabel();
        t273 = new javax.swing.JLabel();
        t274 = new javax.swing.JLabel();
        t275 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        t28 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        t276 = new javax.swing.JLabel();
        t277 = new javax.swing.JLabel();
        t278 = new javax.swing.JLabel();
        t279 = new javax.swing.JLabel();
        t280 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        t281 = new javax.swing.JLabel();
        t282 = new javax.swing.JLabel();
        t283 = new javax.swing.JLabel();
        t284 = new javax.swing.JLabel();
        t285 = new javax.swing.JLabel();
        t48 = new javax.swing.JLabel();
        t47 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        t286 = new javax.swing.JLabel();
        t287 = new javax.swing.JLabel();
        t288 = new javax.swing.JLabel();
        t289 = new javax.swing.JLabel();
        t290 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        t46 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        t291 = new javax.swing.JLabel();
        t292 = new javax.swing.JLabel();
        t293 = new javax.swing.JLabel();
        t294 = new javax.swing.JLabel();
        t295 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        t45 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        t296 = new javax.swing.JLabel();
        t297 = new javax.swing.JLabel();
        t298 = new javax.swing.JLabel();
        t299 = new javax.swing.JLabel();
        t300 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        t301 = new javax.swing.JLabel();
        t302 = new javax.swing.JLabel();
        t303 = new javax.swing.JLabel();
        t304 = new javax.swing.JLabel();
        t305 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        t44 = new javax.swing.JLabel();
        t43 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        t306 = new javax.swing.JLabel();
        t307 = new javax.swing.JLabel();
        t308 = new javax.swing.JLabel();
        t309 = new javax.swing.JLabel();
        t310 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        t311 = new javax.swing.JLabel();
        t312 = new javax.swing.JLabel();
        t313 = new javax.swing.JLabel();
        t314 = new javax.swing.JLabel();
        t315 = new javax.swing.JLabel();
        t42 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        t316 = new javax.swing.JLabel();
        t317 = new javax.swing.JLabel();
        t318 = new javax.swing.JLabel();
        t319 = new javax.swing.JLabel();
        t320 = new javax.swing.JLabel();
        t41 = new javax.swing.JLabel();
        t31 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        t321 = new javax.swing.JLabel();
        t322 = new javax.swing.JLabel();
        t323 = new javax.swing.JLabel();
        t324 = new javax.swing.JLabel();
        t325 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        t32 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        t326 = new javax.swing.JLabel();
        t327 = new javax.swing.JLabel();
        t328 = new javax.swing.JLabel();
        t329 = new javax.swing.JLabel();
        t330 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        t33 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        t331 = new javax.swing.JLabel();
        t332 = new javax.swing.JLabel();
        t333 = new javax.swing.JLabel();
        t334 = new javax.swing.JLabel();
        t335 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        t34 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        t336 = new javax.swing.JLabel();
        t337 = new javax.swing.JLabel();
        t338 = new javax.swing.JLabel();
        t339 = new javax.swing.JLabel();
        t340 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        t35 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        t341 = new javax.swing.JLabel();
        t342 = new javax.swing.JLabel();
        t343 = new javax.swing.JLabel();
        t344 = new javax.swing.JLabel();
        t345 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        t36 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        t346 = new javax.swing.JLabel();
        t347 = new javax.swing.JLabel();
        t348 = new javax.swing.JLabel();
        t349 = new javax.swing.JLabel();
        t350 = new javax.swing.JLabel();
        t37 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        t351 = new javax.swing.JLabel();
        t352 = new javax.swing.JLabel();
        t353 = new javax.swing.JLabel();
        t354 = new javax.swing.JLabel();
        t355 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        t38 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        t356 = new javax.swing.JLabel();
        t357 = new javax.swing.JLabel();
        t358 = new javax.swing.JLabel();
        t359 = new javax.swing.JLabel();
        t360 = new javax.swing.JLabel();
        t55 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        t361 = new javax.swing.JLabel();
        t362 = new javax.swing.JLabel();
        t363 = new javax.swing.JLabel();
        t364 = new javax.swing.JLabel();
        t365 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        t366 = new javax.swing.JLabel();
        t367 = new javax.swing.JLabel();
        t368 = new javax.swing.JLabel();
        t369 = new javax.swing.JLabel();
        t370 = new javax.swing.JLabel();
        t54 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        t53 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        t371 = new javax.swing.JLabel();
        t372 = new javax.swing.JLabel();
        t373 = new javax.swing.JLabel();
        t374 = new javax.swing.JLabel();
        t375 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        t376 = new javax.swing.JLabel();
        t377 = new javax.swing.JLabel();
        t378 = new javax.swing.JLabel();
        t379 = new javax.swing.JLabel();
        t380 = new javax.swing.JLabel();
        t52 = new javax.swing.JLabel();
        t51 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        t381 = new javax.swing.JLabel();
        t382 = new javax.swing.JLabel();
        t383 = new javax.swing.JLabel();
        t384 = new javax.swing.JLabel();
        t385 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        t61 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        t386 = new javax.swing.JLabel();
        t387 = new javax.swing.JLabel();
        t388 = new javax.swing.JLabel();
        t389 = new javax.swing.JLabel();
        t390 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        t62 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        t391 = new javax.swing.JLabel();
        t392 = new javax.swing.JLabel();
        t393 = new javax.swing.JLabel();
        t394 = new javax.swing.JLabel();
        t395 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        t63 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        t396 = new javax.swing.JLabel();
        t397 = new javax.swing.JLabel();
        t398 = new javax.swing.JLabel();
        t399 = new javax.swing.JLabel();
        t400 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        t64 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        t401 = new javax.swing.JLabel();
        t402 = new javax.swing.JLabel();
        t403 = new javax.swing.JLabel();
        t404 = new javax.swing.JLabel();
        t405 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        t65 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        t406 = new javax.swing.JLabel();
        t407 = new javax.swing.JLabel();
        t408 = new javax.swing.JLabel();
        t409 = new javax.swing.JLabel();
        t410 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        t85 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        t411 = new javax.swing.JLabel();
        t412 = new javax.swing.JLabel();
        t413 = new javax.swing.JLabel();
        t414 = new javax.swing.JLabel();
        t415 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        t84 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        t416 = new javax.swing.JLabel();
        t417 = new javax.swing.JLabel();
        t418 = new javax.swing.JLabel();
        t419 = new javax.swing.JLabel();
        t420 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        t421 = new javax.swing.JLabel();
        t422 = new javax.swing.JLabel();
        t423 = new javax.swing.JLabel();
        t424 = new javax.swing.JLabel();
        t425 = new javax.swing.JLabel();
        t83 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        t426 = new javax.swing.JLabel();
        t427 = new javax.swing.JLabel();
        t428 = new javax.swing.JLabel();
        t429 = new javax.swing.JLabel();
        t430 = new javax.swing.JLabel();
        t82 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        t431 = new javax.swing.JLabel();
        t432 = new javax.swing.JLabel();
        t433 = new javax.swing.JLabel();
        t434 = new javax.swing.JLabel();
        t435 = new javax.swing.JLabel();
        t81 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        t71 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        t436 = new javax.swing.JLabel();
        t437 = new javax.swing.JLabel();
        t438 = new javax.swing.JLabel();
        t439 = new javax.swing.JLabel();
        t440 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        t72 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        t441 = new javax.swing.JLabel();
        t442 = new javax.swing.JLabel();
        t443 = new javax.swing.JLabel();
        t444 = new javax.swing.JLabel();
        t445 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        t73 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        t446 = new javax.swing.JLabel();
        t447 = new javax.swing.JLabel();
        t448 = new javax.swing.JLabel();
        t449 = new javax.swing.JLabel();
        t450 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        t74 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        t451 = new javax.swing.JLabel();
        t452 = new javax.swing.JLabel();
        t453 = new javax.swing.JLabel();
        t454 = new javax.swing.JLabel();
        t455 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        t75 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        t456 = new javax.swing.JLabel();
        t457 = new javax.swing.JLabel();
        t458 = new javax.swing.JLabel();
        t459 = new javax.swing.JLabel();
        t460 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbla = new javax.swing.JLabel();
        lblpatient = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        tbl2 = new javax.swing.JScrollPane();
        tblmulti = new javax.swing.JTable();
        tbl1 = new javax.swing.JScrollPane();
        tbltoothpartcolor = new javax.swing.JTable();
        tbl = new javax.swing.JScrollPane();
        tbltoothlabel = new javax.swing.JTable();
        cmdrefresh = new javax.swing.JButton();
        cmdsave = new javax.swing.JButton();
        cmbstatus = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Patient Tooth Chart");

        panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelMouseMoved(evt);
            }
        });
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelMouseReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("18");

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t201.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t201.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t201.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t201MouseReleased(evt);
            }
        });
        jPanel8.add(t201, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t202.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t202.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t202.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t202MouseReleased(evt);
            }
        });
        jPanel8.add(t202, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t203.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t203.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t203.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t203MouseReleased(evt);
            }
        });
        jPanel8.add(t203, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t204.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t204.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t204.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t204MouseReleased(evt);
            }
        });
        jPanel8.add(t204, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t205.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t205.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t205.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t205MouseMoved(evt);
            }
        });
        t205.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t205FocusLost(evt);
            }
        });
        t205.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t205MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t205MouseReleased(evt);
            }
        });
        jPanel8.add(t205, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        t18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t18.setForeground(new java.awt.Color(153, 0, 153));
        t18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t18.setText("L");

        t17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t17.setForeground(new java.awt.Color(153, 0, 153));
        t17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t17.setText("L");

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t206.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t206.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t206.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t206MouseReleased(evt);
            }
        });
        jPanel9.add(t206, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t207.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t207.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t207.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t207MouseReleased(evt);
            }
        });
        jPanel9.add(t207, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t208.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t208.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t208.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t208MouseReleased(evt);
            }
        });
        jPanel9.add(t208, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t209.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t209.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t209.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t209MouseReleased(evt);
            }
        });
        jPanel9.add(t209, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t210.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t210.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t210.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t210MouseMoved(evt);
            }
        });
        t210.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t210FocusLost(evt);
            }
        });
        t210.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t210MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t210MouseReleased(evt);
            }
        });
        jPanel9.add(t210, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("17");

        t16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t16.setForeground(new java.awt.Color(153, 0, 153));
        t16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t16.setText("L");

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t211.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t211.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t211.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t211MouseReleased(evt);
            }
        });
        jPanel10.add(t211, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t212.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t212.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t212.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t212MouseReleased(evt);
            }
        });
        jPanel10.add(t212, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t213.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t213.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t213MouseReleased(evt);
            }
        });
        jPanel10.add(t213, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t214.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t214.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t214.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t214MouseReleased(evt);
            }
        });
        jPanel10.add(t214, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t215.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t215.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t215.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t215MouseMoved(evt);
            }
        });
        t215.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t215FocusLost(evt);
            }
        });
        t215.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t215MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t215MouseReleased(evt);
            }
        });
        jPanel10.add(t215, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("16");

        t15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t15.setForeground(new java.awt.Color(153, 0, 153));
        t15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t15.setText("L");

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t216.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t216.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t216.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t216MouseReleased(evt);
            }
        });
        jPanel11.add(t216, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t217.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t217.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t217.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t217MouseReleased(evt);
            }
        });
        jPanel11.add(t217, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t218.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t218.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t218.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t218MouseReleased(evt);
            }
        });
        jPanel11.add(t218, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t219.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t219.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t219.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t219MouseReleased(evt);
            }
        });
        jPanel11.add(t219, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t220.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t220.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t220.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t220MouseMoved(evt);
            }
        });
        t220.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t220FocusLost(evt);
            }
        });
        t220.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t220MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t220MouseReleased(evt);
            }
        });
        jPanel11.add(t220, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("15");

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t221.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t221.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t221.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t221MouseReleased(evt);
            }
        });
        jPanel12.add(t221, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t222.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t222.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t222MouseReleased(evt);
            }
        });
        jPanel12.add(t222, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t223.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t223.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t223MouseReleased(evt);
            }
        });
        jPanel12.add(t223, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t224.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t224.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t224MouseReleased(evt);
            }
        });
        jPanel12.add(t224, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t225.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t225.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t225.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t225MouseMoved(evt);
            }
        });
        t225.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t225FocusLost(evt);
            }
        });
        t225.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t225MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t225MouseReleased(evt);
            }
        });
        jPanel12.add(t225, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("14");

        t14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t14.setForeground(new java.awt.Color(153, 0, 153));
        t14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t14.setText("L");

        t13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t13.setForeground(new java.awt.Color(153, 0, 153));
        t13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t13.setText("L");

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t226.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t226.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t226.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t226MouseReleased(evt);
            }
        });
        jPanel13.add(t226, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t227.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t227.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t227.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t227MouseReleased(evt);
            }
        });
        jPanel13.add(t227, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t228.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t228.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t228.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t228MouseReleased(evt);
            }
        });
        jPanel13.add(t228, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t229.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t229.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t229.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t229MouseReleased(evt);
            }
        });
        jPanel13.add(t229, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t230.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t230.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t230.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t230MouseMoved(evt);
            }
        });
        t230.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t230FocusLost(evt);
            }
        });
        t230.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t230MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t230MouseReleased(evt);
            }
        });
        jPanel13.add(t230, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("13");

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t231.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t231.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t231.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t231MouseReleased(evt);
            }
        });
        jPanel14.add(t231, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t232.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t232.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t232.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t232MouseReleased(evt);
            }
        });
        jPanel14.add(t232, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t233.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t233.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t233.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t233MouseReleased(evt);
            }
        });
        jPanel14.add(t233, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t234.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t234MouseReleased(evt);
            }
        });
        jPanel14.add(t234, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t235.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t235MouseMoved(evt);
            }
        });
        t235.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t235FocusLost(evt);
            }
        });
        t235.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t235MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t235MouseReleased(evt);
            }
        });
        jPanel14.add(t235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        t12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t12.setForeground(new java.awt.Color(153, 0, 153));
        t12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t12.setText("L");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("12");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("11");

        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t236.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t236.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t236.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t236MouseReleased(evt);
            }
        });
        jPanel15.add(t236, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t237.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t237.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t237.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t237MouseReleased(evt);
            }
        });
        jPanel15.add(t237, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t238.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t238.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t238.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t238MouseReleased(evt);
            }
        });
        jPanel15.add(t238, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t239.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t239.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t239.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t239MouseReleased(evt);
            }
        });
        jPanel15.add(t239, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t240.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t240.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t240.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t240MouseMoved(evt);
            }
        });
        t240.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t240FocusLost(evt);
            }
        });
        t240.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t240MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t240MouseReleased(evt);
            }
        });
        jPanel15.add(t240, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        t11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t11.setForeground(new java.awt.Color(153, 0, 153));
        t11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t11.setText("L");

        t21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t21.setForeground(new java.awt.Color(153, 0, 153));
        t21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t21.setText("L");

        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t241.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t241.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t241.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t241MouseReleased(evt);
            }
        });
        jPanel16.add(t241, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t242.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t242.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t242.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t242MouseReleased(evt);
            }
        });
        jPanel16.add(t242, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t243.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t243.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t243.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t243MouseReleased(evt);
            }
        });
        jPanel16.add(t243, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t244.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t244.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t244.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t244MouseReleased(evt);
            }
        });
        jPanel16.add(t244, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t245.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t245.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t245.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t245MouseMoved(evt);
            }
        });
        t245.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t245FocusLost(evt);
            }
        });
        t245.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t245MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t245MouseReleased(evt);
            }
        });
        jPanel16.add(t245, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("21");

        t22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t22.setForeground(new java.awt.Color(153, 0, 153));
        t22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t22.setText("L");

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t246.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t246.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t246.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t246MouseReleased(evt);
            }
        });
        jPanel17.add(t246, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t247.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t247.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t247.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t247MouseReleased(evt);
            }
        });
        jPanel17.add(t247, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t248.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t248.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t248.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t248MouseReleased(evt);
            }
        });
        jPanel17.add(t248, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t249.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t249.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t249.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t249MouseReleased(evt);
            }
        });
        jPanel17.add(t249, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t250.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t250.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t250.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t250MouseMoved(evt);
            }
        });
        t250.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t250FocusLost(evt);
            }
        });
        t250.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t250MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t250MouseReleased(evt);
            }
        });
        jPanel17.add(t250, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("22");

        t23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t23.setForeground(new java.awt.Color(153, 0, 153));
        t23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t23.setText("L");

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t251.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t251.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t251.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t251MouseReleased(evt);
            }
        });
        jPanel18.add(t251, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t252.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t252.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t252.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t252MouseReleased(evt);
            }
        });
        jPanel18.add(t252, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t253.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t253.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t253.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t253MouseReleased(evt);
            }
        });
        jPanel18.add(t253, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t254.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t254.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t254.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t254MouseReleased(evt);
            }
        });
        jPanel18.add(t254, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t255.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t255.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t255.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t255MouseMoved(evt);
            }
        });
        t255.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t255FocusLost(evt);
            }
        });
        t255.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t255MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t255MouseReleased(evt);
            }
        });
        jPanel18.add(t255, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("23");

        t24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t24.setForeground(new java.awt.Color(153, 0, 153));
        t24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t24.setText("L");

        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t256.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t256.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t256.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t256MouseReleased(evt);
            }
        });
        jPanel19.add(t256, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t257.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t257.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t257.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t257MouseReleased(evt);
            }
        });
        jPanel19.add(t257, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t258.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t258.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t258.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t258MouseReleased(evt);
            }
        });
        jPanel19.add(t258, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t259.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t259.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t259.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t259MouseReleased(evt);
            }
        });
        jPanel19.add(t259, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t260.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t260.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t260.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t260MouseMoved(evt);
            }
        });
        t260.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t260FocusLost(evt);
            }
        });
        t260.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t260MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t260MouseReleased(evt);
            }
        });
        jPanel19.add(t260, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("24");

        t25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t25.setForeground(new java.awt.Color(153, 0, 153));
        t25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t25.setText("L");

        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t261.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t261.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t261.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t261MouseReleased(evt);
            }
        });
        jPanel20.add(t261, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t262.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t262.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t262.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t262MouseReleased(evt);
            }
        });
        jPanel20.add(t262, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t263.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t263.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t263.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t263MouseReleased(evt);
            }
        });
        jPanel20.add(t263, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t264.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t264.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t264.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t264MouseReleased(evt);
            }
        });
        jPanel20.add(t264, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t265.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t265.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t265.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t265MouseMoved(evt);
            }
        });
        t265.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t265FocusLost(evt);
            }
        });
        t265.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t265MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t265MouseReleased(evt);
            }
        });
        jPanel20.add(t265, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("25");

        t26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t26.setForeground(new java.awt.Color(153, 0, 153));
        t26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t26.setText("L");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("26");

        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t266.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t266.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t266.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t266MouseReleased(evt);
            }
        });
        jPanel21.add(t266, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t267.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t267.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t267.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t267MouseReleased(evt);
            }
        });
        jPanel21.add(t267, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t268.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t268.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t268.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t268MouseReleased(evt);
            }
        });
        jPanel21.add(t268, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t269.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t269.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t269.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t269MouseReleased(evt);
            }
        });
        jPanel21.add(t269, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t270.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t270.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t270.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t270MouseMoved(evt);
            }
        });
        t270.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t270FocusLost(evt);
            }
        });
        t270.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t270MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t270MouseReleased(evt);
            }
        });
        jPanel21.add(t270, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        t27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t27.setForeground(new java.awt.Color(153, 0, 153));
        t27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t27.setText("L");

        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t271.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t271.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t271.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t271MouseReleased(evt);
            }
        });
        jPanel22.add(t271, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t272.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t272.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t272.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t272MouseReleased(evt);
            }
        });
        jPanel22.add(t272, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t273.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t273.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t273.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t273MouseReleased(evt);
            }
        });
        jPanel22.add(t273, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t274.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t274.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t274.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t274MouseReleased(evt);
            }
        });
        jPanel22.add(t274, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t275.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t275.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t275.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t275MouseMoved(evt);
            }
        });
        t275.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t275FocusLost(evt);
            }
        });
        t275.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t275MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t275MouseReleased(evt);
            }
        });
        jPanel22.add(t275, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("27");

        t28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t28.setForeground(new java.awt.Color(153, 0, 153));
        t28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t28.setText("L");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("28");

        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t276.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t276.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t276.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t276MouseReleased(evt);
            }
        });
        jPanel23.add(t276, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t277.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t277.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t277.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t277MouseReleased(evt);
            }
        });
        jPanel23.add(t277, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t278.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t278.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t278.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t278MouseReleased(evt);
            }
        });
        jPanel23.add(t278, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t279.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t279.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t279.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t279MouseReleased(evt);
            }
        });
        jPanel23.add(t279, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t280.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t280.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t280.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t280MouseMoved(evt);
            }
        });
        t280.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t280FocusLost(evt);
            }
        });
        t280.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t280MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t280MouseReleased(evt);
            }
        });
        jPanel23.add(t280, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("48");

        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t281.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t281.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t281.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t281MouseReleased(evt);
            }
        });
        jPanel24.add(t281, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t282.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t282.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t282.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t282MouseReleased(evt);
            }
        });
        jPanel24.add(t282, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t283.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t283.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t283.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t283MouseReleased(evt);
            }
        });
        jPanel24.add(t283, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t284.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t284.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t284.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t284MouseReleased(evt);
            }
        });
        jPanel24.add(t284, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t285.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t285.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t285.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t285MouseMoved(evt);
            }
        });
        t285.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t285FocusLost(evt);
            }
        });
        t285.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t285MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t285MouseReleased(evt);
            }
        });
        jPanel24.add(t285, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        t48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t48.setForeground(new java.awt.Color(153, 0, 153));
        t48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t48.setText("L");

        t47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t47.setForeground(new java.awt.Color(153, 0, 153));
        t47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t47.setText("L");

        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t286.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t286.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t286.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t286MouseReleased(evt);
            }
        });
        jPanel25.add(t286, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t287.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t287.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t287.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t287MouseReleased(evt);
            }
        });
        jPanel25.add(t287, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t288.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t288.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t288.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t288MouseReleased(evt);
            }
        });
        jPanel25.add(t288, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t289.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t289.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t289.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t289MouseReleased(evt);
            }
        });
        jPanel25.add(t289, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t290.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t290.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t290.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t290MouseMoved(evt);
            }
        });
        t290.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t290FocusLost(evt);
            }
        });
        t290.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t290MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t290MouseReleased(evt);
            }
        });
        jPanel25.add(t290, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("47");

        t46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t46.setForeground(new java.awt.Color(153, 0, 153));
        t46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t46.setText("L");

        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t291.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t291.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t291.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t291MouseReleased(evt);
            }
        });
        jPanel26.add(t291, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t292.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t292.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t292.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t292MouseReleased(evt);
            }
        });
        jPanel26.add(t292, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t293.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t293.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t293.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t293MouseReleased(evt);
            }
        });
        jPanel26.add(t293, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t294.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t294.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t294.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t294MouseReleased(evt);
            }
        });
        jPanel26.add(t294, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t295.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t295.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t295.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t295MouseMoved(evt);
            }
        });
        t295.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t295FocusLost(evt);
            }
        });
        t295.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t295MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t295MouseReleased(evt);
            }
        });
        jPanel26.add(t295, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("46");

        t45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t45.setForeground(new java.awt.Color(153, 0, 153));
        t45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t45.setText("L");

        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t296.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t296.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t296.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t296MouseReleased(evt);
            }
        });
        jPanel27.add(t296, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t297.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t297.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t297.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t297MouseReleased(evt);
            }
        });
        jPanel27.add(t297, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t298.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t298.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t298.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t298MouseReleased(evt);
            }
        });
        jPanel27.add(t298, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t299.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t299.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t299.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t299MouseReleased(evt);
            }
        });
        jPanel27.add(t299, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t300.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t300.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t300.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t300MouseMoved(evt);
            }
        });
        t300.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t300FocusLost(evt);
            }
        });
        t300.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t300MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t300MouseReleased(evt);
            }
        });
        jPanel27.add(t300, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("45");

        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t301.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t301.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t301.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t301MouseReleased(evt);
            }
        });
        jPanel28.add(t301, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t302.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t302.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t302.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t302MouseReleased(evt);
            }
        });
        jPanel28.add(t302, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t303.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t303.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t303.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t303MouseReleased(evt);
            }
        });
        jPanel28.add(t303, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t304.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t304.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t304.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t304MouseReleased(evt);
            }
        });
        jPanel28.add(t304, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t305.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t305.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t305.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t305MouseMoved(evt);
            }
        });
        t305.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t305FocusLost(evt);
            }
        });
        t305.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t305MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t305MouseReleased(evt);
            }
        });
        jPanel28.add(t305, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("44");

        t44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t44.setForeground(new java.awt.Color(153, 0, 153));
        t44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t44.setText("L");

        t43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t43.setForeground(new java.awt.Color(153, 0, 153));
        t43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t43.setText("L");

        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t306.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t306.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t306.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t306MouseReleased(evt);
            }
        });
        jPanel29.add(t306, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t307.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t307.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t307MouseReleased(evt);
            }
        });
        jPanel29.add(t307, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t308.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t308.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t308.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t308MouseReleased(evt);
            }
        });
        jPanel29.add(t308, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t309.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t309.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t309.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t309MouseReleased(evt);
            }
        });
        jPanel29.add(t309, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t310.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t310.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t310.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t310MouseMoved(evt);
            }
        });
        t310.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t310FocusLost(evt);
            }
        });
        t310.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t310MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t310MouseReleased(evt);
            }
        });
        jPanel29.add(t310, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("43");

        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t311.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t311.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t311.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t311MouseReleased(evt);
            }
        });
        jPanel30.add(t311, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t312.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t312.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t312.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t312MouseReleased(evt);
            }
        });
        jPanel30.add(t312, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t313.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t313.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t313.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t313MouseReleased(evt);
            }
        });
        jPanel30.add(t313, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t314.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t314.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t314.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t314MouseReleased(evt);
            }
        });
        jPanel30.add(t314, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t315.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t315.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t315.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t315MouseMoved(evt);
            }
        });
        t315.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t315FocusLost(evt);
            }
        });
        t315.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t315MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t315MouseReleased(evt);
            }
        });
        jPanel30.add(t315, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        t42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t42.setForeground(new java.awt.Color(153, 0, 153));
        t42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t42.setText("L");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("42");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("41");

        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t316.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t316.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t316.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t316MouseReleased(evt);
            }
        });
        jPanel31.add(t316, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t317.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t317.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t317.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t317MouseReleased(evt);
            }
        });
        jPanel31.add(t317, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t318.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t318.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t318MouseReleased(evt);
            }
        });
        jPanel31.add(t318, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t319.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t319.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t319.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t319MouseReleased(evt);
            }
        });
        jPanel31.add(t319, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t320.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t320.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t320.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t320MouseMoved(evt);
            }
        });
        t320.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t320FocusLost(evt);
            }
        });
        t320.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t320MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t320MouseReleased(evt);
            }
        });
        jPanel31.add(t320, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        t41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t41.setForeground(new java.awt.Color(153, 0, 153));
        t41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t41.setText("L");

        t31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t31.setForeground(new java.awt.Color(153, 0, 153));
        t31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t31.setText("L");

        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t321.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t321.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t321.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t321MouseReleased(evt);
            }
        });
        jPanel32.add(t321, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t322.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t322.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t322.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t322MouseReleased(evt);
            }
        });
        jPanel32.add(t322, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t323.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t323.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t323.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t323MouseReleased(evt);
            }
        });
        jPanel32.add(t323, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t324.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t324.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t324.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t324MouseReleased(evt);
            }
        });
        jPanel32.add(t324, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t325.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t325.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t325.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t325MouseMoved(evt);
            }
        });
        t325.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t325FocusLost(evt);
            }
        });
        t325.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t325MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t325MouseReleased(evt);
            }
        });
        jPanel32.add(t325, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("31");

        t32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t32.setForeground(new java.awt.Color(153, 0, 153));
        t32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t32.setText("L");

        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t326.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t326.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t326.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t326MouseReleased(evt);
            }
        });
        jPanel33.add(t326, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t327.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t327.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t327.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t327MouseReleased(evt);
            }
        });
        jPanel33.add(t327, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t328.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t328.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t328.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t328MouseReleased(evt);
            }
        });
        jPanel33.add(t328, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t329.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t329.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t329.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t329MouseReleased(evt);
            }
        });
        jPanel33.add(t329, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t330.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t330.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t330.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t330MouseMoved(evt);
            }
        });
        t330.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t330FocusLost(evt);
            }
        });
        t330.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t330MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t330MouseReleased(evt);
            }
        });
        jPanel33.add(t330, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("32");

        t33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t33.setForeground(new java.awt.Color(153, 0, 153));
        t33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t33.setText("L");

        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t331.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t331.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t331.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t331MouseReleased(evt);
            }
        });
        jPanel34.add(t331, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t332.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t332.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t332.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t332MouseReleased(evt);
            }
        });
        jPanel34.add(t332, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t333.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t333.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t333.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t333MouseReleased(evt);
            }
        });
        jPanel34.add(t333, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t334.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t334.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t334.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t334MouseReleased(evt);
            }
        });
        jPanel34.add(t334, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t335.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t335.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t335.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t335MouseMoved(evt);
            }
        });
        t335.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t335FocusLost(evt);
            }
        });
        t335.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t335MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t335MouseReleased(evt);
            }
        });
        jPanel34.add(t335, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("33");

        t34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t34.setForeground(new java.awt.Color(153, 0, 153));
        t34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t34.setText("L");

        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t336.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t336.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t336.setAlignmentX(0.5F);
        t336.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t336MouseReleased(evt);
            }
        });
        jPanel35.add(t336, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t337.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t337.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t337.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t337MouseReleased(evt);
            }
        });
        jPanel35.add(t337, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t338.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t338.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t338.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t338MouseReleased(evt);
            }
        });
        jPanel35.add(t338, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t339.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t339.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t339.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t339MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t339MouseReleased(evt);
            }
        });
        jPanel35.add(t339, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t340.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t340.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t340.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t340MouseMoved(evt);
            }
        });
        t340.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t340FocusLost(evt);
            }
        });
        t340.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t340MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t340MouseReleased(evt);
            }
        });
        jPanel35.add(t340, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("34");

        t35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t35.setForeground(new java.awt.Color(153, 0, 153));
        t35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t35.setText("L");

        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t341.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t341.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t341.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t341MouseReleased(evt);
            }
        });
        jPanel36.add(t341, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t342.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t342.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t342.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t342MouseReleased(evt);
            }
        });
        jPanel36.add(t342, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t343.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t343.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t343.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t343MouseReleased(evt);
            }
        });
        jPanel36.add(t343, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t344.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t344.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t344.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t344MouseReleased(evt);
            }
        });
        jPanel36.add(t344, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t345.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t345.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t345.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t345MouseMoved(evt);
            }
        });
        t345.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t345FocusLost(evt);
            }
        });
        t345.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t345MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t345MouseReleased(evt);
            }
        });
        jPanel36.add(t345, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("35");

        t36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t36.setForeground(new java.awt.Color(153, 0, 153));
        t36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t36.setText("L");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("36");

        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t346.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t346.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t346.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t346MouseReleased(evt);
            }
        });
        jPanel37.add(t346, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t347.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t347.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t347.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t347MouseReleased(evt);
            }
        });
        jPanel37.add(t347, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t348.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t348.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t348.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t348MouseReleased(evt);
            }
        });
        jPanel37.add(t348, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t349.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t349.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t349.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t349MouseReleased(evt);
            }
        });
        jPanel37.add(t349, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t350.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t350.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t350.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t350MouseMoved(evt);
            }
        });
        t350.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t350FocusLost(evt);
            }
        });
        t350.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t350MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t350MouseReleased(evt);
            }
        });
        jPanel37.add(t350, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        t37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t37.setForeground(new java.awt.Color(153, 0, 153));
        t37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t37.setText("L");

        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t351.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t351.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t351.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t351MouseReleased(evt);
            }
        });
        jPanel38.add(t351, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t352.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t352.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t352.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t352MouseReleased(evt);
            }
        });
        jPanel38.add(t352, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t353.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t353.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t353.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t353MouseReleased(evt);
            }
        });
        jPanel38.add(t353, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t354.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t354.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t354.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t354MouseReleased(evt);
            }
        });
        jPanel38.add(t354, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t355.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t355.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t355.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t355MouseMoved(evt);
            }
        });
        t355.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t355FocusLost(evt);
            }
        });
        t355.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t355MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t355MouseReleased(evt);
            }
        });
        jPanel38.add(t355, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("37");

        t38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t38.setForeground(new java.awt.Color(153, 0, 153));
        t38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t38.setText("L");

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("38");

        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t356.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t356.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t356.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t356MouseReleased(evt);
            }
        });
        jPanel39.add(t356, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t357.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t357.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t357.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t357MouseReleased(evt);
            }
        });
        jPanel39.add(t357, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t358.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t358.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t358.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t358MouseReleased(evt);
            }
        });
        jPanel39.add(t358, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t359.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t359.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t359.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t359MouseReleased(evt);
            }
        });
        jPanel39.add(t359, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t360.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t360.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t360.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t360MouseMoved(evt);
            }
        });
        t360.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t360FocusLost(evt);
            }
        });
        t360.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t360MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t360MouseReleased(evt);
            }
        });
        jPanel39.add(t360, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        t55.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t55.setForeground(new java.awt.Color(153, 0, 153));
        t55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t55.setText("L");

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 0, 102));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("55");

        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t361.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t361.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t361.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t361MouseReleased(evt);
            }
        });
        jPanel40.add(t361, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t362.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t362.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t362.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t362MouseReleased(evt);
            }
        });
        jPanel40.add(t362, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t363.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t363.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t363.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t363MouseReleased(evt);
            }
        });
        jPanel40.add(t363, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t364.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t364.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t364.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t364MouseReleased(evt);
            }
        });
        jPanel40.add(t364, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t365.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t365.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t365.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t365MouseMoved(evt);
            }
        });
        t365.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t365FocusLost(evt);
            }
        });
        t365.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t365MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t365MouseReleased(evt);
            }
        });
        jPanel40.add(t365, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setAlignmentX(0.9F);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t366.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t366.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t366.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t366MouseReleased(evt);
            }
        });
        jPanel41.add(t366, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t367.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t367.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t367.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t367MouseReleased(evt);
            }
        });
        jPanel41.add(t367, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t368.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t368.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t368.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t368MouseReleased(evt);
            }
        });
        jPanel41.add(t368, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t369.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t369.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t369.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t369MouseReleased(evt);
            }
        });
        jPanel41.add(t369, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t370.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t370.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t370.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t370MouseMoved(evt);
            }
        });
        t370.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t370FocusLost(evt);
            }
        });
        t370.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t370MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t370MouseReleased(evt);
            }
        });
        jPanel41.add(t370, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        t54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t54.setForeground(new java.awt.Color(153, 0, 153));
        t54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t54.setText("L");

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 0, 102));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("54");

        t53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t53.setForeground(new java.awt.Color(153, 0, 153));
        t53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t53.setText("L");

        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t371.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t371.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t371.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t371MouseReleased(evt);
            }
        });
        jPanel42.add(t371, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t372.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t372.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t372.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t372MouseReleased(evt);
            }
        });
        jPanel42.add(t372, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t373.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t373.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t373.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t373MouseReleased(evt);
            }
        });
        jPanel42.add(t373, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t374.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t374.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t374.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t374MouseReleased(evt);
            }
        });
        jPanel42.add(t374, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t375.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t375.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t375.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t375MouseMoved(evt);
            }
        });
        t375.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t375FocusLost(evt);
            }
        });
        t375.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t375MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t375MouseReleased(evt);
            }
        });
        jPanel42.add(t375, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 0, 102));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("53");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 0, 102));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("52");

        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t376.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t376.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t376.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t376MouseReleased(evt);
            }
        });
        jPanel43.add(t376, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t377.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t377.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t377.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t377MouseReleased(evt);
            }
        });
        jPanel43.add(t377, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t378.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t378.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t378.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t378MouseReleased(evt);
            }
        });
        jPanel43.add(t378, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t379.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t379.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t379.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t379MouseReleased(evt);
            }
        });
        jPanel43.add(t379, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t380.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t380.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t380.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t380MouseMoved(evt);
            }
        });
        t380.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t380FocusLost(evt);
            }
        });
        t380.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t380MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t380MouseReleased(evt);
            }
        });
        jPanel43.add(t380, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        t52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t52.setForeground(new java.awt.Color(153, 0, 153));
        t52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t52.setText("L");

        t51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t51.setForeground(new java.awt.Color(153, 0, 153));
        t51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t51.setText("L");

        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t381.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t381.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t381.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t381MouseReleased(evt);
            }
        });
        jPanel44.add(t381, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t382.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t382.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t382.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t382MouseReleased(evt);
            }
        });
        jPanel44.add(t382, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t383.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t383.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t383.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t383MouseReleased(evt);
            }
        });
        jPanel44.add(t383, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t384.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t384.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t384.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t384MouseReleased(evt);
            }
        });
        jPanel44.add(t384, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t385.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t385.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t385.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t385MouseMoved(evt);
            }
        });
        t385.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t385FocusLost(evt);
            }
        });
        t385.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t385MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t385MouseReleased(evt);
            }
        });
        jPanel44.add(t385, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 0, 102));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("51");

        t61.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t61.setForeground(new java.awt.Color(153, 0, 153));
        t61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t61.setText("L");

        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t386.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t386.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t386.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t386MouseReleased(evt);
            }
        });
        jPanel45.add(t386, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t387.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t387.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t387.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t387MouseReleased(evt);
            }
        });
        jPanel45.add(t387, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t388.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t388.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t388.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t388MouseReleased(evt);
            }
        });
        jPanel45.add(t388, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t389.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t389.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t389.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t389MouseReleased(evt);
            }
        });
        jPanel45.add(t389, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t390.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t390.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t390.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t390MouseMoved(evt);
            }
        });
        t390.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t390FocusLost(evt);
            }
        });
        t390.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t390MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t390MouseReleased(evt);
            }
        });
        jPanel45.add(t390, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 0, 102));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("61");

        t62.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t62.setForeground(new java.awt.Color(153, 0, 153));
        t62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t62.setText("L");

        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t391.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t391.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t391.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t391MouseReleased(evt);
            }
        });
        jPanel46.add(t391, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t392.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t392.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t392.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t392MouseReleased(evt);
            }
        });
        jPanel46.add(t392, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t393.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t393.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t393.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t393MouseReleased(evt);
            }
        });
        jPanel46.add(t393, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t394.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t394.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t394.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t394MouseReleased(evt);
            }
        });
        jPanel46.add(t394, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t395.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t395.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t395.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t395MouseMoved(evt);
            }
        });
        t395.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t395FocusLost(evt);
            }
        });
        t395.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t395MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t395MouseReleased(evt);
            }
        });
        jPanel46.add(t395, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 0, 102));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("62");

        t63.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t63.setForeground(new java.awt.Color(153, 0, 153));
        t63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t63.setText("L");

        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t396.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t396.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t396.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t396MouseReleased(evt);
            }
        });
        jPanel47.add(t396, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t397.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t397.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t397.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t397MouseReleased(evt);
            }
        });
        jPanel47.add(t397, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t398.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t398.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t398.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t398MouseReleased(evt);
            }
        });
        jPanel47.add(t398, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t399.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t399.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t399.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t399MouseReleased(evt);
            }
        });
        jPanel47.add(t399, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t400.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t400.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t400.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t400MouseMoved(evt);
            }
        });
        t400.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t400FocusLost(evt);
            }
        });
        t400.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t400MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t400MouseReleased(evt);
            }
        });
        jPanel47.add(t400, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 0, 102));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("63");

        t64.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t64.setForeground(new java.awt.Color(153, 0, 153));
        t64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t64.setText("L");

        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t401.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t401.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t401.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t401MouseReleased(evt);
            }
        });
        jPanel48.add(t401, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t402.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t402.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t402.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t402MouseReleased(evt);
            }
        });
        jPanel48.add(t402, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t403.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t403.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t403.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t403MouseReleased(evt);
            }
        });
        jPanel48.add(t403, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t404.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t404.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t404.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t404MouseReleased(evt);
            }
        });
        jPanel48.add(t404, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t405.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t405.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t405.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t405MouseMoved(evt);
            }
        });
        t405.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t405FocusLost(evt);
            }
        });
        t405.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t405MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t405MouseReleased(evt);
            }
        });
        jPanel48.add(t405, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 0, 102));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("64");

        t65.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t65.setForeground(new java.awt.Color(153, 0, 153));
        t65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t65.setText("L");

        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t406.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t406.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t406.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t406MouseReleased(evt);
            }
        });
        jPanel49.add(t406, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t407.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t407.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t407.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t407MouseReleased(evt);
            }
        });
        jPanel49.add(t407, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t408.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t408.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t408.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t408MouseReleased(evt);
            }
        });
        jPanel49.add(t408, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t409.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t409.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t409.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t409MouseReleased(evt);
            }
        });
        jPanel49.add(t409, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t410.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t410.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t410.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t410MouseMoved(evt);
            }
        });
        t410.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t410FocusLost(evt);
            }
        });
        t410.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t410MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t410MouseReleased(evt);
            }
        });
        jPanel49.add(t410, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 0, 102));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("65");

        t85.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t85.setForeground(new java.awt.Color(153, 0, 153));
        t85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t85.setText("L");

        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t411.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t411.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t411.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t411MouseReleased(evt);
            }
        });
        jPanel50.add(t411, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t412.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t412.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t412.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t412MouseReleased(evt);
            }
        });
        jPanel50.add(t412, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t413.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t413.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t413.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t413MouseReleased(evt);
            }
        });
        jPanel50.add(t413, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t414.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t414.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t414.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t414MouseReleased(evt);
            }
        });
        jPanel50.add(t414, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t415.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t415.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t415.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t415MouseMoved(evt);
            }
        });
        t415.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t415FocusLost(evt);
            }
        });
        t415.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t415MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t415MouseReleased(evt);
            }
        });
        jPanel50.add(t415, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 0, 102));
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("85");

        t84.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t84.setForeground(new java.awt.Color(153, 0, 153));
        t84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t84.setText("L");

        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t416.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t416.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t416.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t416MouseReleased(evt);
            }
        });
        jPanel51.add(t416, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t417.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t417.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t417.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t417MouseReleased(evt);
            }
        });
        jPanel51.add(t417, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t418.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t418.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t418.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t418MouseReleased(evt);
            }
        });
        jPanel51.add(t418, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t419.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t419.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t419.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t419MouseReleased(evt);
            }
        });
        jPanel51.add(t419, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t420.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t420.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t420.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t420MouseMoved(evt);
            }
        });
        t420.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t420FocusLost(evt);
            }
        });
        t420.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t420MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t420MouseReleased(evt);
            }
        });
        jPanel51.add(t420, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 0, 102));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("84");

        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t421.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t421.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t421.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t421MouseReleased(evt);
            }
        });
        jPanel52.add(t421, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t422.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t422.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t422.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t422MouseReleased(evt);
            }
        });
        jPanel52.add(t422, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t423.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t423.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t423.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t423MouseReleased(evt);
            }
        });
        jPanel52.add(t423, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t424.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t424.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t424.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t424MouseReleased(evt);
            }
        });
        jPanel52.add(t424, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t425.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t425.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t425.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t425MouseMoved(evt);
            }
        });
        t425.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t425FocusLost(evt);
            }
        });
        t425.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t425MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t425MouseReleased(evt);
            }
        });
        jPanel52.add(t425, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        t83.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t83.setForeground(new java.awt.Color(153, 0, 153));
        t83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t83.setText("L");

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 0, 102));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("83");

        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t426.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t426.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t426.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t426MouseReleased(evt);
            }
        });
        jPanel53.add(t426, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t427.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t427.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t427.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t427MouseReleased(evt);
            }
        });
        jPanel53.add(t427, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t428.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t428.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t428.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t428MouseReleased(evt);
            }
        });
        jPanel53.add(t428, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t429.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t429.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t429.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t429MouseReleased(evt);
            }
        });
        jPanel53.add(t429, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t430.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t430.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t430.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t430MouseMoved(evt);
            }
        });
        t430.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t430FocusLost(evt);
            }
        });
        t430.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t430MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t430MouseReleased(evt);
            }
        });
        jPanel53.add(t430, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        t82.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t82.setForeground(new java.awt.Color(153, 0, 153));
        t82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t82.setText("L");

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 0, 102));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("82");

        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t431.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t431.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t431.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t431MouseReleased(evt);
            }
        });
        jPanel54.add(t431, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t432.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t432.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t432.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t432MouseReleased(evt);
            }
        });
        jPanel54.add(t432, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t433.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t433.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t433.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t433MouseReleased(evt);
            }
        });
        jPanel54.add(t433, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t434.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t434.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t434.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t434MouseReleased(evt);
            }
        });
        jPanel54.add(t434, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t435.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t435.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t435.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t435MouseMoved(evt);
            }
        });
        t435.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t435FocusLost(evt);
            }
        });
        t435.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t435MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t435MouseReleased(evt);
            }
        });
        jPanel54.add(t435, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        t81.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t81.setForeground(new java.awt.Color(153, 0, 153));
        t81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t81.setText("L");

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 0, 102));
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("81");

        t71.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t71.setForeground(new java.awt.Color(153, 0, 153));
        t71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t71.setText("L");

        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t436.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t436.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t436.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t436MouseReleased(evt);
            }
        });
        jPanel55.add(t436, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t437.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t437.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t437.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t437MouseReleased(evt);
            }
        });
        jPanel55.add(t437, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t438.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t438.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t438.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t438MouseReleased(evt);
            }
        });
        jPanel55.add(t438, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t439.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t439.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t439.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t439MouseReleased(evt);
            }
        });
        jPanel55.add(t439, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t440.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t440.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t440.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t440MouseMoved(evt);
            }
        });
        t440.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t440FocusLost(evt);
            }
        });
        t440.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t440MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t440MouseReleased(evt);
            }
        });
        jPanel55.add(t440, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 0, 102));
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setText("71");

        t72.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t72.setForeground(new java.awt.Color(153, 0, 153));
        t72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t72.setText("L");

        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t441.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t441.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t441.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t441MouseReleased(evt);
            }
        });
        jPanel56.add(t441, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t442.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t442.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t442.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t442MouseReleased(evt);
            }
        });
        jPanel56.add(t442, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t443.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t443.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t443.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t443MouseReleased(evt);
            }
        });
        jPanel56.add(t443, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t444.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t444.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t444.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t444MouseReleased(evt);
            }
        });
        jPanel56.add(t444, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t445.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t445.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t445.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t445MouseMoved(evt);
            }
        });
        t445.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t445FocusLost(evt);
            }
        });
        t445.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t445MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t445MouseReleased(evt);
            }
        });
        jPanel56.add(t445, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 0, 102));
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("72");

        t73.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t73.setForeground(new java.awt.Color(153, 0, 153));
        t73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t73.setText("L");

        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t446.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t446.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t446.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t446MouseReleased(evt);
            }
        });
        jPanel57.add(t446, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t447.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t447.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t447.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t447MouseReleased(evt);
            }
        });
        jPanel57.add(t447, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t448.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t448.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t448.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t448MouseReleased(evt);
            }
        });
        jPanel57.add(t448, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t449.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t449.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t449.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t449MouseReleased(evt);
            }
        });
        jPanel57.add(t449, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t450.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t450.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t450.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t450MouseMoved(evt);
            }
        });
        t450.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t450FocusLost(evt);
            }
        });
        t450.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t450MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t450MouseReleased(evt);
            }
        });
        jPanel57.add(t450, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 0, 102));
        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel106.setText("73");

        t74.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t74.setForeground(new java.awt.Color(153, 0, 153));
        t74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t74.setText("L");

        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t451.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t451.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t451.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t451MouseReleased(evt);
            }
        });
        jPanel58.add(t451, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t452.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t452.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t452.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t452MouseReleased(evt);
            }
        });
        jPanel58.add(t452, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t453.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t453.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t453.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t453MouseReleased(evt);
            }
        });
        jPanel58.add(t453, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t454.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t454.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t454.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t454MouseReleased(evt);
            }
        });
        jPanel58.add(t454, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t455.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t455.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t455.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t455MouseMoved(evt);
            }
        });
        t455.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t455FocusLost(evt);
            }
        });
        t455.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t455MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t455MouseReleased(evt);
            }
        });
        jPanel58.add(t455, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 0, 102));
        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setText("74");

        t75.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t75.setForeground(new java.awt.Color(153, 0, 153));
        t75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t75.setText("L");

        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t456.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t456.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothcenterblank.png"))); // NOI18N
        t456.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t456MouseReleased(evt);
            }
        });
        jPanel59.add(t456, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 36, 40));

        t457.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t457.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothtopblank.png"))); // NOI18N
        t457.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t457MouseReleased(evt);
            }
        });
        jPanel59.add(t457, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 50, 22));

        t458.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t458.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothbottomblank.png"))); // NOI18N
        t458.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t458MouseReleased(evt);
            }
        });
        jPanel59.add(t458, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 50, 22));

        t459.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t459.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothrightblank.png"))); // NOI18N
        t459.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t459MouseReleased(evt);
            }
        });
        jPanel59.add(t459, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 12, 22, 50));

        t460.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t460.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/toothleftblank.png"))); // NOI18N
        t460.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                t460MouseMoved(evt);
            }
        });
        t460.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t460FocusLost(evt);
            }
        });
        t460.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t460MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t460MouseReleased(evt);
            }
        });
        jPanel59.add(t460, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 22, 50));

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 0, 102));
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("75");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/topteeth.png"))); // NOI18N
        jLabel1.setText("Upper");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bottomteeth.png"))); // NOI18N
        jLabel2.setText("Lower");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/payperiod.png"))); // NOI18N

        lbla.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbla.setForeground(new java.awt.Color(0, 102, 255));
        lbla.setText("AGE:0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbla, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbla, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(t28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(t71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(t31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(t32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(t33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(t34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(t35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(t36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(t37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(t38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(t72, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel56, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel104, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(t73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(t74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(t75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(jLabel74)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(t54))
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(jLabel76)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(t53))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                .addComponent(jLabel77)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(t52)))
                                        .addGroup(panelLayout.createSequentialGroup()
                                            .addComponent(jLabel80)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t51))
                                        .addGroup(panelLayout.createSequentialGroup()
                                            .addComponent(jLabel82)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t61))
                                        .addGroup(panelLayout.createSequentialGroup()
                                            .addComponent(jLabel84)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t62))
                                        .addGroup(panelLayout.createSequentialGroup()
                                            .addComponent(jLabel86)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t63))
                                        .addGroup(panelLayout.createSequentialGroup()
                                            .addComponent(jLabel88)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t64))
                                        .addGroup(panelLayout.createSequentialGroup()
                                            .addComponent(jLabel90)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t65)))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel72)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t55))))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(t11))
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(t12))
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(t13))
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t14))
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t15))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t16))
                                        .addGroup(panelLayout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t17))
                                        .addGroup(panelLayout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t18)))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t28))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t27))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t26))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t25))
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addComponent(jLabel30)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(t24))
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t23))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t22))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t21)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel70)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t38))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t37))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel66)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t36))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t35))
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addComponent(jLabel62)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(t34))
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel60)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t33))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel58)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t32))
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                            .addComponent(jLabel56)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t31))
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                .addComponent(jLabel53)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(t41))
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(jLabel52)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(t42))
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(jLabel50)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(t43))
                                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                                    .addComponent(jLabel47)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(t44))
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                        .addComponent(jLabel46)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(t45))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                        .addComponent(jLabel44)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(t46))
                                                    .addGroup(panelLayout.createSequentialGroup()
                                                        .addComponent(jLabel42)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(t47))
                                                    .addGroup(panelLayout.createSequentialGroup()
                                                        .addComponent(jLabel39)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(t48)))))))))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel92)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel94)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(t84)
                                            .addComponent(t85)))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel96)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t83))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel98)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t82))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel100)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t81))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel102)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t71))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel104)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t72))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel106)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t73))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel108)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t74))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel110)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t75)))
                                .addGap(0, 85, Short.MAX_VALUE))))))
        );

        t55.getAccessibleContext().setAccessibleName("t55");
        t53.getAccessibleContext().setAccessibleName("t56");

        lblpatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/searchmedium.png"))); // NOI18N
        jButton1.setMnemonic('S');
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblmulti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ToothId", "ToothPartId", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl2.setViewportView(tblmulti);

        tbltoothpartcolor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ToothPartId", "Status", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl1.setViewportView(tbltoothpartcolor);

        tbltoothlabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ToothId", "Status", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.setViewportView(tbltoothlabel);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(tbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbl, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(tbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        cmdrefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refreshmedium.png"))); // NOI18N
        cmdrefresh.setMnemonic('R');
        cmdrefresh.setText("Refresh");
        cmdrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdrefreshActionPerformed(evt);
            }
        });

        cmdsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/savemedium.png"))); // NOI18N
        cmdsave.setMnemonic('S');
        cmdsave.setText("Save");
        cmdsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsaveActionPerformed(evt);
            }
        });

        cmbstatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbstatusActionPerformed(evt);
            }
        });

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/segment.png"))); // NOI18N
        jMenu1.setMnemonic('F');
        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tr.png"))); // NOI18N
        jMenuItem1.setMnemonic('T');
        jMenuItem1.setText("Treatment Record");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/patient.png"))); // NOI18N
        jMenuItem2.setMnemonic('M');
        jMenuItem2.setText("Medical Dental History");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/legend.png"))); // NOI18N
        jMenuItem3.setMnemonic('L');
        jMenuItem3.setText("Legend");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/attach.png"))); // NOI18N
        jMenuItem5.setText("Attachment");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/signature.png"))); // NOI18N
        jMenuItem4.setText("Informed Consent");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblpatient, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdrefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdsave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblpatient, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdsave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblpatient.getAccessibleContext().setAccessibleDescription("35");
        jButton1.getAccessibleContext().setAccessibleDescription("35");
        jPanel7.getAccessibleContext().setAccessibleDescription("35");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t360MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t360MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t360MouseReleased

    private void t360MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t360MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t360MouseExited

    private void t360FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t360FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t360FocusLost

    private void t360MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t360MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t360MouseMoved

    private void t359MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t359MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t359MouseReleased

    private void t358MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t358MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t358MouseReleased

    private void t357MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t357MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t357MouseReleased

    private void t356MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t356MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t356MouseReleased

    private void t355MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t355MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t355MouseReleased

    private void t355MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t355MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t355MouseExited

    private void t355FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t355FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t355FocusLost

    private void t355MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t355MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t355MouseMoved

    private void t354MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t354MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t354MouseReleased

    private void t353MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t353MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t353MouseReleased

    private void t352MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t352MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t352MouseReleased

    private void t351MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t351MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t351MouseReleased

    private void t350MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t350MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t350MouseReleased

    private void t350MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t350MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t350MouseExited

    private void t350FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t350FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t350FocusLost

    private void t350MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t350MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t350MouseMoved

    private void t349MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t349MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t349MouseReleased

    private void t348MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t348MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t348MouseReleased

    private void t347MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t347MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t347MouseReleased

    private void t346MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t346MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t346MouseReleased

    private void t345MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t345MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t345MouseReleased

    private void t345MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t345MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t345MouseExited

    private void t345FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t345FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t345FocusLost

    private void t345MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t345MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t345MouseMoved

    private void t344MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t344MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t344MouseReleased

    private void t343MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t343MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t343MouseReleased

    private void t342MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t342MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t342MouseReleased

    private void t341MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t341MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t341MouseReleased

    private void t340MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t340MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t340MouseReleased

    private void t340MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t340MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t340MouseExited

    private void t340FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t340FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t340FocusLost

    private void t340MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t340MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t340MouseMoved

    private void t339MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t339MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t339MouseReleased

    private void t338MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t338MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t338MouseReleased

    private void t337MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t337MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t337MouseReleased

    private void t336MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t336MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t336MouseReleased

    private void t335MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t335MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t335MouseReleased

    private void t335MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t335MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t335MouseExited

    private void t335FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t335FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t335FocusLost

    private void t335MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t335MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t335MouseMoved

    private void t334MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t334MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t334MouseReleased

    private void t333MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t333MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t333MouseReleased

    private void t332MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t332MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t332MouseReleased

    private void t331MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t331MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t331MouseReleased

    private void t330MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t330MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t330MouseReleased

    private void t330MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t330MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t330MouseExited

    private void t330FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t330FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t330FocusLost

    private void t330MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t330MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t330MouseMoved

    private void t329MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t329MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t329MouseReleased

    private void t328MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t328MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t328MouseReleased

    private void t327MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t327MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t327MouseReleased

    private void t326MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t326MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t326MouseReleased

    private void t325MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t325MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t325MouseReleased

    private void t325MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t325MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t325MouseExited

    private void t325FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t325FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t325FocusLost

    private void t325MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t325MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t325MouseMoved

    private void t324MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t324MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t324MouseReleased

    private void t323MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t323MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t323MouseReleased

    private void t322MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t322MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t322MouseReleased

    private void t321MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t321MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t321MouseReleased

    private void t320MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t320MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t320MouseReleased

    private void t320MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t320MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t320MouseExited

    private void t320FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t320FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t320FocusLost

    private void t320MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t320MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t320MouseMoved

    private void t319MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t319MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t319MouseReleased

    private void t318MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t318MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t318MouseReleased

    private void t317MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t317MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t317MouseReleased

    private void t316MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t316MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t316MouseReleased

    private void t315MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t315MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t315MouseReleased

    private void t315MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t315MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t315MouseExited

    private void t315FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t315FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t315FocusLost

    private void t315MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t315MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t315MouseMoved

    private void t314MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t314MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t314MouseReleased

    private void t313MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t313MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t313MouseReleased

    private void t312MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t312MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t312MouseReleased

    private void t311MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t311MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t311MouseReleased

    private void t310MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t310MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t310MouseReleased

    private void t310MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t310MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t310MouseExited

    private void t310FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t310FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t310FocusLost

    private void t310MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t310MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t310MouseMoved

    private void t309MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t309MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t309MouseReleased

    private void t308MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t308MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t308MouseReleased

    private void t307MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t307MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t307MouseReleased

    private void t306MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t306MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t306MouseReleased

    private void t305MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t305MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t305MouseReleased

    private void t305MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t305MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t305MouseExited

    private void t305FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t305FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t305FocusLost

    private void t305MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t305MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t305MouseMoved

    private void t304MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t304MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t304MouseReleased

    private void t303MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t303MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t303MouseReleased

    private void t302MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t302MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t302MouseReleased

    private void t301MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t301MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t301MouseReleased

    private void t300MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t300MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t300MouseReleased

    private void t300MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t300MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t300MouseExited

    private void t300FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t300FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t300FocusLost

    private void t300MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t300MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t300MouseMoved

    private void t299MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t299MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t299MouseReleased

    private void t298MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t298MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t298MouseReleased

    private void t297MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t297MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t297MouseReleased

    private void t296MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t296MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t296MouseReleased

    private void t295MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t295MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t295MouseReleased

    private void t295MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t295MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t295MouseExited

    private void t295FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t295FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t295FocusLost

    private void t295MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t295MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t295MouseMoved

    private void t294MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t294MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t294MouseReleased

    private void t293MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t293MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t293MouseReleased

    private void t292MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t292MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t292MouseReleased

    private void t291MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t291MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t291MouseReleased

    private void t290MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t290MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t290MouseReleased

    private void t290MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t290MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t290MouseExited

    private void t290FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t290FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t290FocusLost

    private void t290MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t290MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t290MouseMoved

    private void t289MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t289MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t289MouseReleased

    private void t288MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t288MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t288MouseReleased

    private void t287MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t287MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t287MouseReleased

    private void t286MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t286MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t286MouseReleased

    private void t285MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t285MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t285MouseReleased

    private void t285MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t285MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t285MouseExited

    private void t285FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t285FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t285FocusLost

    private void t285MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t285MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t285MouseMoved

    private void t284MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t284MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t284MouseReleased

    private void t283MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t283MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t283MouseReleased

    private void t282MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t282MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t282MouseReleased

    private void t281MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t281MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t281MouseReleased

    private void t280MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t280MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t280MouseReleased

    private void t280MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t280MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t280MouseExited

    private void t280FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t280FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t280FocusLost

    private void t280MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t280MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t280MouseMoved

    private void t279MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t279MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t279MouseReleased

    private void t278MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t278MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t278MouseReleased

    private void t277MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t277MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t277MouseReleased

    private void t276MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t276MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t276MouseReleased

    private void t275MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t275MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t275MouseReleased

    private void t275MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t275MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t275MouseExited

    private void t275FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t275FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t275FocusLost

    private void t275MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t275MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t275MouseMoved

    private void t274MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t274MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t274MouseReleased

    private void t273MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t273MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t273MouseReleased

    private void t272MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t272MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t272MouseReleased

    private void t271MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t271MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t271MouseReleased

    private void t270MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t270MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t270MouseReleased

    private void t270MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t270MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t270MouseExited

    private void t270FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t270FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t270FocusLost

    private void t270MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t270MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t270MouseMoved

    private void t269MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t269MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t269MouseReleased

    private void t268MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t268MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t268MouseReleased

    private void t267MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t267MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t267MouseReleased

    private void t266MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t266MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t266MouseReleased

    private void t265MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t265MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t265MouseReleased

    private void t265MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t265MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t265MouseExited

    private void t265FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t265FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t265FocusLost

    private void t265MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t265MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t265MouseMoved

    private void t264MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t264MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t264MouseReleased

    private void t263MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t263MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t263MouseReleased

    private void t262MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t262MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t262MouseReleased

    private void t261MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t261MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t261MouseReleased

    private void t260MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t260MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t260MouseReleased

    private void t260MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t260MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t260MouseExited

    private void t260FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t260FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t260FocusLost

    private void t260MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t260MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t260MouseMoved

    private void t259MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t259MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t259MouseReleased

    private void t258MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t258MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t258MouseReleased

    private void t257MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t257MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t257MouseReleased

    private void t256MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t256MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t256MouseReleased

    private void t255MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t255MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t255MouseReleased

    private void t255MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t255MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t255MouseExited

    private void t255FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t255FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t255FocusLost

    private void t255MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t255MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t255MouseMoved

    private void t254MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t254MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t254MouseReleased

    private void t253MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t253MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t253MouseReleased

    private void t252MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t252MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t252MouseReleased

    private void t251MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t251MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t251MouseReleased

    private void t250MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t250MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t250MouseReleased

    private void t250MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t250MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t250MouseExited

    private void t250FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t250FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t250FocusLost

    private void t250MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t250MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t250MouseMoved

    private void t249MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t249MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t249MouseReleased

    private void t248MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t248MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t248MouseReleased

    private void t247MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t247MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t247MouseReleased

    private void t246MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t246MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t246MouseReleased

    private void t245MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t245MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t245MouseReleased

    private void t245MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t245MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t245MouseExited

    private void t245FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t245FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t245FocusLost

    private void t245MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t245MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t245MouseMoved

    private void t244MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t244MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t244MouseReleased

    private void t243MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t243MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t243MouseReleased

    private void t242MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t242MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t242MouseReleased

    private void t241MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t241MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t241MouseReleased

    private void t240MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t240MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t240MouseReleased

    private void t240MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t240MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t240MouseExited

    private void t240FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t240FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t240FocusLost

    private void t240MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t240MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t240MouseMoved

    private void t239MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t239MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t239MouseReleased

    private void t238MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t238MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t238MouseReleased

    private void t237MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t237MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t237MouseReleased

    private void t236MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t236MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t236MouseReleased

    private void t235MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t235MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t235MouseReleased

    private void t235MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t235MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t235MouseExited

    private void t235FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t235FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t235FocusLost

    private void t235MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t235MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t235MouseMoved

    private void t234MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t234MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t234MouseReleased

    private void t233MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t233MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t233MouseReleased

    private void t232MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t232MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t232MouseReleased

    private void t231MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t231MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t231MouseReleased

    private void t230MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t230MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t230MouseReleased

    private void t230MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t230MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t230MouseExited

    private void t230FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t230FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t230FocusLost

    private void t230MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t230MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t230MouseMoved

    private void t229MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t229MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t229MouseReleased

    private void t228MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t228MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t228MouseReleased

    private void t227MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t227MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t227MouseReleased

    private void t226MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t226MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t226MouseReleased

    private void t225MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t225MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t225MouseReleased

    private void t225MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t225MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t225MouseExited

    private void t225FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t225FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t225FocusLost

    private void t225MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t225MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t225MouseMoved

    private void t224MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t224MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t224MouseReleased

    private void t223MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t223MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t223MouseReleased

    private void t222MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t222MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t222MouseReleased

    private void t221MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t221MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t221MouseReleased

    private void t220MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t220MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t220MouseReleased

    private void t220MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t220MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t220MouseExited

    private void t220FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t220FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t220FocusLost

    private void t220MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t220MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t220MouseMoved

    private void t219MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t219MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t219MouseReleased

    private void t218MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t218MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t218MouseReleased

    private void t217MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t217MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t217MouseReleased

    private void t216MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t216MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t216MouseReleased

    private void t215MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t215MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t215MouseReleased

    private void t215MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t215MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t215MouseExited

    private void t215FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t215FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t215FocusLost

    private void t215MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t215MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t215MouseMoved

    private void t214MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t214MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t214MouseReleased

    private void t213MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t213MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t213MouseReleased

    private void t212MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t212MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t212MouseReleased

    private void t211MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t211MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t211MouseReleased

    private void t210MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t210MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t210MouseReleased

    private void t210MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t210MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t210MouseExited

    private void t210FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t210FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t210FocusLost

    private void t210MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t210MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t210MouseMoved

    private void t209MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t209MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t209MouseReleased

    private void t208MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t208MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t208MouseReleased

    private void t207MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t207MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t207MouseReleased

    private void t206MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t206MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t206MouseReleased

    private void t205MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t205MouseReleased
        // showMessageDialog(this,"topleft");
    }//GEN-LAST:event_t205MouseReleased

    private void t205MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t205MouseExited
        //       ImageIcon  image = new ImageIcon(getClass().getResource("/img/toothtopleftblank.png"));
        //                        t201.setIcon(image);
    }//GEN-LAST:event_t205MouseExited

    private void t205FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t205FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t205FocusLost

    private void t205MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t205MouseMoved
        //      ImageIcon  image = new ImageIcon(getClass().getResource("/img/toothtopleftmousemoved.png"));
        //                        t201.setIcon(image);
    }//GEN-LAST:event_t205MouseMoved

    private void t204MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t204MouseReleased
        // showMessageDialog(this,"bottomright");
    }//GEN-LAST:event_t204MouseReleased

    private void t203MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t203MouseReleased
        //showMessageDialog(this,"bottomleft");
    }//GEN-LAST:event_t203MouseReleased

    private void t202MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t202MouseReleased
        //showMessageDialog(this,"topright");
    }//GEN-LAST:event_t202MouseReleased

    private void t201MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t201MouseReleased
        //  showMessageDialog(this,"center");
    }//GEN-LAST:event_t201MouseReleased

    private void t361MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t361MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t361MouseReleased

    private void t362MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t362MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t362MouseReleased

    private void t363MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t363MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t363MouseReleased

    private void t364MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t364MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t364MouseReleased

    private void t365MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t365MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t365MouseMoved

    private void t365FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t365FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t365FocusLost

    private void t365MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t365MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t365MouseExited

    private void t365MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t365MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t365MouseReleased

    private void t366MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t366MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t366MouseReleased

    private void t367MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t367MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t367MouseReleased

    private void t368MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t368MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t368MouseReleased

    private void t369MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t369MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t369MouseReleased

    private void t370MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t370MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t370MouseMoved

    private void t370FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t370FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t370FocusLost

    private void t370MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t370MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t370MouseExited

    private void t370MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t370MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t370MouseReleased

    private void t371MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t371MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t371MouseReleased

    private void t372MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t372MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t372MouseReleased

    private void t373MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t373MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t373MouseReleased

    private void t374MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t374MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t374MouseReleased

    private void t375MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t375MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t375MouseMoved

    private void t375FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t375FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t375FocusLost

    private void t375MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t375MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t375MouseExited

    private void t375MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t375MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t375MouseReleased

    private void t376MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t376MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t376MouseReleased

    private void t377MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t377MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t377MouseReleased

    private void t378MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t378MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t378MouseReleased

    private void t379MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t379MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t379MouseReleased

    private void t380MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t380MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t380MouseMoved

    private void t380FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t380FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t380FocusLost

    private void t380MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t380MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t380MouseExited

    private void t380MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t380MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t380MouseReleased

    private void t381MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t381MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t381MouseReleased

    private void t382MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t382MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t382MouseReleased

    private void t383MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t383MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t383MouseReleased

    private void t384MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t384MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t384MouseReleased

    private void t385MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t385MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t385MouseMoved

    private void t385FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t385FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t385FocusLost

    private void t385MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t385MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t385MouseExited

    private void t385MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t385MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t385MouseReleased

    private void t386MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t386MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t386MouseReleased

    private void t387MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t387MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t387MouseReleased

    private void t388MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t388MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t388MouseReleased

    private void t389MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t389MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t389MouseReleased

    private void t390MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t390MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t390MouseMoved

    private void t390FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t390FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t390FocusLost

    private void t390MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t390MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t390MouseExited

    private void t390MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t390MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t390MouseReleased

    private void t391MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t391MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t391MouseReleased

    private void t392MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t392MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t392MouseReleased

    private void t393MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t393MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t393MouseReleased

    private void t394MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t394MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t394MouseReleased

    private void t395MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t395MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t395MouseMoved

    private void t395FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t395FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t395FocusLost

    private void t395MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t395MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t395MouseExited

    private void t395MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t395MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t395MouseReleased

    private void t396MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t396MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t396MouseReleased

    private void t397MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t397MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t397MouseReleased

    private void t398MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t398MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t398MouseReleased

    private void t399MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t399MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t399MouseReleased

    private void t400MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t400MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t400MouseMoved

    private void t400FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t400FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t400FocusLost

    private void t400MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t400MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t400MouseExited

    private void t400MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t400MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t400MouseReleased

    private void t401MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t401MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t401MouseReleased

    private void t402MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t402MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t402MouseReleased

    private void t403MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t403MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t403MouseReleased

    private void t404MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t404MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t404MouseReleased

    private void t405MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t405MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t405MouseMoved

    private void t405FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t405FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t405FocusLost

    private void t405MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t405MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t405MouseExited

    private void t405MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t405MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t405MouseReleased

    private void t406MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t406MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t406MouseReleased

    private void t407MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t407MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t407MouseReleased

    private void t408MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t408MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t408MouseReleased

    private void t409MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t409MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t409MouseReleased

    private void t410MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t410MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t410MouseMoved

    private void t410FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t410FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t410FocusLost

    private void t410MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t410MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t410MouseExited

    private void t410MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t410MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t410MouseReleased

    private void t411MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t411MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t411MouseReleased

    private void t412MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t412MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t412MouseReleased

    private void t413MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t413MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t413MouseReleased

    private void t414MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t414MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t414MouseReleased

    private void t415MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t415MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t415MouseMoved

    private void t415FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t415FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t415FocusLost

    private void t415MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t415MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t415MouseExited

    private void t415MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t415MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t415MouseReleased

    private void t416MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t416MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t416MouseReleased

    private void t417MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t417MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t417MouseReleased

    private void t418MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t418MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t418MouseReleased

    private void t419MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t419MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t419MouseReleased

    private void t420MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t420MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t420MouseMoved

    private void t420FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t420FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t420FocusLost

    private void t420MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t420MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t420MouseExited

    private void t420MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t420MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t420MouseReleased

    private void t421MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t421MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t421MouseReleased

    private void t422MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t422MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t422MouseReleased

    private void t423MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t423MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t423MouseReleased

    private void t424MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t424MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t424MouseReleased

    private void t425MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t425MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t425MouseMoved

    private void t425FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t425FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t425FocusLost

    private void t425MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t425MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t425MouseExited

    private void t425MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t425MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t425MouseReleased

    private void t426MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t426MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t426MouseReleased

    private void t427MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t427MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t427MouseReleased

    private void t428MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t428MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t428MouseReleased

    private void t429MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t429MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t429MouseReleased

    private void t430MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t430MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t430MouseMoved

    private void t430FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t430FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t430FocusLost

    private void t430MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t430MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t430MouseExited

    private void t430MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t430MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t430MouseReleased

    private void t431MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t431MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t431MouseReleased

    private void t432MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t432MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t432MouseReleased

    private void t433MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t433MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t433MouseReleased

    private void t434MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t434MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t434MouseReleased

    private void t435MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t435MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t435MouseMoved

    private void t435FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t435FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t435FocusLost

    private void t435MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t435MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t435MouseExited

    private void t435MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t435MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t435MouseReleased

    private void t436MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t436MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t436MouseReleased

    private void t437MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t437MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t437MouseReleased

    private void t438MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t438MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t438MouseReleased

    private void t439MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t439MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t439MouseReleased

    private void t440MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t440MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t440MouseMoved

    private void t440FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t440FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t440FocusLost

    private void t440MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t440MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t440MouseExited

    private void t440MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t440MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t440MouseReleased

    private void t441MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t441MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t441MouseReleased

    private void t442MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t442MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t442MouseReleased

    private void t443MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t443MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t443MouseReleased

    private void t444MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t444MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t444MouseReleased

    private void t445MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t445MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t445MouseMoved

    private void t445FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t445FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t445FocusLost

    private void t445MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t445MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t445MouseExited

    private void t445MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t445MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t445MouseReleased

    private void t446MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t446MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t446MouseReleased

    private void t447MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t447MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t447MouseReleased

    private void t448MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t448MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t448MouseReleased

    private void t449MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t449MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t449MouseReleased

    private void t450MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t450MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t450MouseMoved

    private void t450FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t450FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t450FocusLost

    private void t450MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t450MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t450MouseExited

    private void t450MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t450MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t450MouseReleased

    private void t451MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t451MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t451MouseReleased

    private void t452MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t452MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t452MouseReleased

    private void t453MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t453MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t453MouseReleased

    private void t454MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t454MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t454MouseReleased

    private void t455MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t455MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t455MouseMoved

    private void t455FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t455FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t455FocusLost

    private void t455MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t455MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t455MouseExited

    private void t455MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t455MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t455MouseReleased

    private void t456MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t456MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t456MouseReleased

    private void t457MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t457MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t457MouseReleased

    private void t458MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t458MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t458MouseReleased

    private void t459MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t459MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t459MouseReleased

    private void t460MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t460MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_t460MouseMoved

    private void t460FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t460FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t460FocusLost

    private void t460MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t460MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_t460MouseExited

    private void t460MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t460MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t460MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ShowFrmSelectPatient();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void panelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseMoved
        // SetValueAndColors();
//    RefreshColorValuesOnly();
    }//GEN-LAST:event_panelMouseMoved

    private void cmbstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbstatusActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) cmbstatus.getSelectedItem();
            ToothStatusId = item.getId();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbstatusActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (PatientId == 0) {
            JOptionPane.showMessageDialog(this, "Please select a patient record!");
        } else {
            TreatmentRecord.PatientId = PatientId;
            TreatmentRecord.nym = lblpatient.getText();
            ShowFrmTR();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (PatientId == 0) {
            JOptionPane.showMessageDialog(this, "Please select a patient record!");
        } else {
            PatientMDH.PatientId = PatientId;
            // EditPatient.nym=nym;
            ShowFrmPatientMDH();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ShowFrmLegend();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void cmdsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsaveActionPerformed
        if (PatientId == 0) {
            JOptionPane.showMessageDialog(null, "Please select patient record!");
        } else {
            //ShowFrmSetToothPerPart();

            DefaultTableModel modelx = (DefaultTableModel) tblmulti.getModel();

            String AddParam = "";
            String AddQueryStart = "INSERT INTO patient_tooth_part_status (PatientId, ToothPartId, ToothId, ToothStatusId)  VALUES ";

            String AddToothParam = "";
            String AddToothQueryStart = "INSERT INTO patient_tooth_status (PatientId, ToothId, ToothStatusId)  VALUES ";

            String UpdateParam = "";
            String UpdateQueryStart = "UPDATE patient_tooth_part_status SET ";
//            String UpdateQueryEnd=" WHERE PatientId="+PatientId +;

            int rc = 0;
            rc = modelx.getRowCount();
            int srow = 0;
            int notSetCntr = 0;
            int setCntr = 0;
            while (srow != rc) {
                String t = tblmulti.getValueAt(srow, 0).toString();
                String tp = tblmulti.getValueAt(srow, 1).toString();
                String a = tblmulti.getValueAt(srow, 2).toString();
                // AddFirstRow="("+t+","+tp+","+ToothStatusId+")";

                boolean isSet = PTSS.ToothIsSet(Integer.parseInt(t), tbltoothlabel);

                if (Integer.parseInt(a) == 1) {

                    if (srow == 0) {
                        AddParam = AddParam + "(" + PatientId + "," + tp + "," + t + "," + ToothStatusId + ")";
                        if (isSet == false) {
                            if (notSetCntr == 0) {
                                AddToothParam = AddToothParam + "(" + PatientId + "," + t + "," + ToothStatusId + ")";
                            } else {
                                AddToothParam = AddToothParam + ", (" + PatientId + "," + t + "," + ToothStatusId + ")";
                            }

                            notSetCntr++;
                        }
                        setCntr++;
                    } else {
                        AddParam = AddParam + ", (" + PatientId + "," + tp + "," + t + "," + ToothStatusId + ")";
                        if (isSet == false) {
                            if (notSetCntr == 0) {
                                AddToothParam = AddToothParam + "(" + PatientId + "," + t + "," + ToothStatusId + ")";
                            } else {
                                AddToothParam = AddToothParam + ", (" + PatientId + "," + t + "," + ToothStatusId + ")";
                            }
                            notSetCntr++;

                        }
                        setCntr++;
                    }
                } else if (Integer.parseInt(a) == 2) {
                    AddUpdateToothPart("UPDATE patient_tooth_part_status SET ToothStatusId=" + ToothStatusId + " WHERE PatientId=" + PatientId + " AND ToothPartId=" + tp);

                    AddUpdateTooth("UPDATE patient_tooth_status SET ToothStatusId=" + ToothStatusId + " WHERE PatientId=" + PatientId + " AND ToothId=" + t);

                }

                srow++;
            }
//            System.out.println(AddQueryStart + AddParam);
//
//            if (notSetCntr > 0) {
//                System.out.println(AddToothQueryStart + AddToothParam);
//            }

            if (setCntr > 0) {
                AddUpdateToothPart(AddQueryStart + AddParam);
            }
            if (notSetCntr > 0) {
                AddUpdateTooth(AddToothQueryStart + AddToothParam);
            }

            ClearTableSelections();
            RefreshValues();
            PopulateData();
            PopulateDataColor();
            SetValueAndColors();

            JOptionPane.showMessageDialog(null, "Tooth Status Successfully Updated!");

        }
    }//GEN-LAST:event_cmdsaveActionPerformed

    public void AddUpdateTooth(String Query) {
        Connection conn = getConnection();

        try {
            Connection Conn = getConnection();
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(Query);
            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void AddUpdateToothPart(String Query) {
        Connection conn = getConnection();

        try {
            Connection Conn = getConnection();
            Stmt = Conn.createStatement();
            Stmt.executeUpdate(Query);
            Stmt.close();
            conn.close();

        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    boolean ToothIsSet(int ToothId) {
        boolean IsSet = false;
        DefaultTableModel modely = (DefaultTableModel) tbltoothlabel.getModel();

        int rc = 0;
        rc = modely.getRowCount();
        int srow = 0;

        int cntr = 0;
        while (srow != rc) {
            String t = tbltoothlabel.getValueAt(srow, 0).toString();

            //.out.println(t +" : "+ToothId);
            if (ToothId == Integer.parseInt(t)) {
                cntr = cntr + 1;
                //System.out.println(t);
            }
            srow++;
        }

        if (cntr > 0) {
            IsSet = true;
        }

        return IsSet;
    }


    private void panelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseReleased
        ClearTableSelections();
        RefreshValues();
        SetValueAndColors();
    }//GEN-LAST:event_panelMouseReleased

    private void cmdrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdrefreshActionPerformed
        ClearTableSelections();
        RefreshValues();
        SetValueAndColors();
    }//GEN-LAST:event_cmdrefreshActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if (PatientId == 0) {
            JOptionPane.showMessageDialog(this, "Please select a patient record!");
        } else {
            Attachment.PatientId = PatientId;
            ShowFrmAttachment();
        }

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (PatientId == 0) {
            JOptionPane.showMessageDialog(null, "Please select patient record!");
        } else {
ShowFrmInformedConcent();
//            ReportFactory Factory = new ReportFactory();
////            Factory.LoadReportInformedConsent(nymtxtc);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void t339MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t339MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_t339MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbstatus;
    private javax.swing.JButton cmdrefresh;
    private javax.swing.JButton cmdsave;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbla;
    private javax.swing.JLabel lblpatient;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel t11;
    private javax.swing.JLabel t12;
    private javax.swing.JLabel t13;
    private javax.swing.JLabel t14;
    private javax.swing.JLabel t15;
    private javax.swing.JLabel t16;
    private javax.swing.JLabel t17;
    private javax.swing.JLabel t18;
    private javax.swing.JLabel t201;
    private javax.swing.JLabel t202;
    private javax.swing.JLabel t203;
    private javax.swing.JLabel t204;
    private javax.swing.JLabel t205;
    private javax.swing.JLabel t206;
    private javax.swing.JLabel t207;
    private javax.swing.JLabel t208;
    private javax.swing.JLabel t209;
    private javax.swing.JLabel t21;
    private javax.swing.JLabel t210;
    private javax.swing.JLabel t211;
    private javax.swing.JLabel t212;
    private javax.swing.JLabel t213;
    private javax.swing.JLabel t214;
    private javax.swing.JLabel t215;
    private javax.swing.JLabel t216;
    private javax.swing.JLabel t217;
    private javax.swing.JLabel t218;
    private javax.swing.JLabel t219;
    private javax.swing.JLabel t22;
    private javax.swing.JLabel t220;
    private javax.swing.JLabel t221;
    private javax.swing.JLabel t222;
    private javax.swing.JLabel t223;
    private javax.swing.JLabel t224;
    private javax.swing.JLabel t225;
    private javax.swing.JLabel t226;
    private javax.swing.JLabel t227;
    private javax.swing.JLabel t228;
    private javax.swing.JLabel t229;
    private javax.swing.JLabel t23;
    private javax.swing.JLabel t230;
    private javax.swing.JLabel t231;
    private javax.swing.JLabel t232;
    private javax.swing.JLabel t233;
    private javax.swing.JLabel t234;
    private javax.swing.JLabel t235;
    private javax.swing.JLabel t236;
    private javax.swing.JLabel t237;
    private javax.swing.JLabel t238;
    private javax.swing.JLabel t239;
    private javax.swing.JLabel t24;
    private javax.swing.JLabel t240;
    private javax.swing.JLabel t241;
    private javax.swing.JLabel t242;
    private javax.swing.JLabel t243;
    private javax.swing.JLabel t244;
    private javax.swing.JLabel t245;
    private javax.swing.JLabel t246;
    private javax.swing.JLabel t247;
    private javax.swing.JLabel t248;
    private javax.swing.JLabel t249;
    private javax.swing.JLabel t25;
    private javax.swing.JLabel t250;
    private javax.swing.JLabel t251;
    private javax.swing.JLabel t252;
    private javax.swing.JLabel t253;
    private javax.swing.JLabel t254;
    private javax.swing.JLabel t255;
    private javax.swing.JLabel t256;
    private javax.swing.JLabel t257;
    private javax.swing.JLabel t258;
    private javax.swing.JLabel t259;
    private javax.swing.JLabel t26;
    private javax.swing.JLabel t260;
    private javax.swing.JLabel t261;
    private javax.swing.JLabel t262;
    private javax.swing.JLabel t263;
    private javax.swing.JLabel t264;
    private javax.swing.JLabel t265;
    private javax.swing.JLabel t266;
    private javax.swing.JLabel t267;
    private javax.swing.JLabel t268;
    private javax.swing.JLabel t269;
    private javax.swing.JLabel t27;
    private javax.swing.JLabel t270;
    private javax.swing.JLabel t271;
    private javax.swing.JLabel t272;
    private javax.swing.JLabel t273;
    private javax.swing.JLabel t274;
    private javax.swing.JLabel t275;
    private javax.swing.JLabel t276;
    private javax.swing.JLabel t277;
    private javax.swing.JLabel t278;
    private javax.swing.JLabel t279;
    private javax.swing.JLabel t28;
    private javax.swing.JLabel t280;
    private javax.swing.JLabel t281;
    private javax.swing.JLabel t282;
    private javax.swing.JLabel t283;
    private javax.swing.JLabel t284;
    private javax.swing.JLabel t285;
    private javax.swing.JLabel t286;
    private javax.swing.JLabel t287;
    private javax.swing.JLabel t288;
    private javax.swing.JLabel t289;
    private javax.swing.JLabel t290;
    private javax.swing.JLabel t291;
    private javax.swing.JLabel t292;
    private javax.swing.JLabel t293;
    private javax.swing.JLabel t294;
    private javax.swing.JLabel t295;
    private javax.swing.JLabel t296;
    private javax.swing.JLabel t297;
    private javax.swing.JLabel t298;
    private javax.swing.JLabel t299;
    private javax.swing.JLabel t300;
    private javax.swing.JLabel t301;
    private javax.swing.JLabel t302;
    private javax.swing.JLabel t303;
    private javax.swing.JLabel t304;
    private javax.swing.JLabel t305;
    private javax.swing.JLabel t306;
    private javax.swing.JLabel t307;
    private javax.swing.JLabel t308;
    private javax.swing.JLabel t309;
    private javax.swing.JLabel t31;
    private javax.swing.JLabel t310;
    private javax.swing.JLabel t311;
    private javax.swing.JLabel t312;
    private javax.swing.JLabel t313;
    private javax.swing.JLabel t314;
    private javax.swing.JLabel t315;
    private javax.swing.JLabel t316;
    private javax.swing.JLabel t317;
    private javax.swing.JLabel t318;
    private javax.swing.JLabel t319;
    private javax.swing.JLabel t32;
    private javax.swing.JLabel t320;
    private javax.swing.JLabel t321;
    private javax.swing.JLabel t322;
    private javax.swing.JLabel t323;
    private javax.swing.JLabel t324;
    private javax.swing.JLabel t325;
    private javax.swing.JLabel t326;
    private javax.swing.JLabel t327;
    private javax.swing.JLabel t328;
    private javax.swing.JLabel t329;
    private javax.swing.JLabel t33;
    private javax.swing.JLabel t330;
    private javax.swing.JLabel t331;
    private javax.swing.JLabel t332;
    private javax.swing.JLabel t333;
    private javax.swing.JLabel t334;
    private javax.swing.JLabel t335;
    private javax.swing.JLabel t336;
    private javax.swing.JLabel t337;
    private javax.swing.JLabel t338;
    private javax.swing.JLabel t339;
    private javax.swing.JLabel t34;
    private javax.swing.JLabel t340;
    private javax.swing.JLabel t341;
    private javax.swing.JLabel t342;
    private javax.swing.JLabel t343;
    private javax.swing.JLabel t344;
    private javax.swing.JLabel t345;
    private javax.swing.JLabel t346;
    private javax.swing.JLabel t347;
    private javax.swing.JLabel t348;
    private javax.swing.JLabel t349;
    private javax.swing.JLabel t35;
    private javax.swing.JLabel t350;
    private javax.swing.JLabel t351;
    private javax.swing.JLabel t352;
    private javax.swing.JLabel t353;
    private javax.swing.JLabel t354;
    private javax.swing.JLabel t355;
    private javax.swing.JLabel t356;
    private javax.swing.JLabel t357;
    private javax.swing.JLabel t358;
    private javax.swing.JLabel t359;
    private javax.swing.JLabel t36;
    private javax.swing.JLabel t360;
    private javax.swing.JLabel t361;
    private javax.swing.JLabel t362;
    private javax.swing.JLabel t363;
    private javax.swing.JLabel t364;
    private javax.swing.JLabel t365;
    private javax.swing.JLabel t366;
    private javax.swing.JLabel t367;
    private javax.swing.JLabel t368;
    private javax.swing.JLabel t369;
    private javax.swing.JLabel t37;
    private javax.swing.JLabel t370;
    private javax.swing.JLabel t371;
    private javax.swing.JLabel t372;
    private javax.swing.JLabel t373;
    private javax.swing.JLabel t374;
    private javax.swing.JLabel t375;
    private javax.swing.JLabel t376;
    private javax.swing.JLabel t377;
    private javax.swing.JLabel t378;
    private javax.swing.JLabel t379;
    private javax.swing.JLabel t38;
    private javax.swing.JLabel t380;
    private javax.swing.JLabel t381;
    private javax.swing.JLabel t382;
    private javax.swing.JLabel t383;
    private javax.swing.JLabel t384;
    private javax.swing.JLabel t385;
    private javax.swing.JLabel t386;
    private javax.swing.JLabel t387;
    private javax.swing.JLabel t388;
    private javax.swing.JLabel t389;
    private javax.swing.JLabel t390;
    private javax.swing.JLabel t391;
    private javax.swing.JLabel t392;
    private javax.swing.JLabel t393;
    private javax.swing.JLabel t394;
    private javax.swing.JLabel t395;
    private javax.swing.JLabel t396;
    private javax.swing.JLabel t397;
    private javax.swing.JLabel t398;
    private javax.swing.JLabel t399;
    private javax.swing.JLabel t400;
    private javax.swing.JLabel t401;
    private javax.swing.JLabel t402;
    private javax.swing.JLabel t403;
    private javax.swing.JLabel t404;
    private javax.swing.JLabel t405;
    private javax.swing.JLabel t406;
    private javax.swing.JLabel t407;
    private javax.swing.JLabel t408;
    private javax.swing.JLabel t409;
    private javax.swing.JLabel t41;
    private javax.swing.JLabel t410;
    private javax.swing.JLabel t411;
    private javax.swing.JLabel t412;
    private javax.swing.JLabel t413;
    private javax.swing.JLabel t414;
    private javax.swing.JLabel t415;
    private javax.swing.JLabel t416;
    private javax.swing.JLabel t417;
    private javax.swing.JLabel t418;
    private javax.swing.JLabel t419;
    private javax.swing.JLabel t42;
    private javax.swing.JLabel t420;
    private javax.swing.JLabel t421;
    private javax.swing.JLabel t422;
    private javax.swing.JLabel t423;
    private javax.swing.JLabel t424;
    private javax.swing.JLabel t425;
    private javax.swing.JLabel t426;
    private javax.swing.JLabel t427;
    private javax.swing.JLabel t428;
    private javax.swing.JLabel t429;
    private javax.swing.JLabel t43;
    private javax.swing.JLabel t430;
    private javax.swing.JLabel t431;
    private javax.swing.JLabel t432;
    private javax.swing.JLabel t433;
    private javax.swing.JLabel t434;
    private javax.swing.JLabel t435;
    private javax.swing.JLabel t436;
    private javax.swing.JLabel t437;
    private javax.swing.JLabel t438;
    private javax.swing.JLabel t439;
    private javax.swing.JLabel t44;
    private javax.swing.JLabel t440;
    private javax.swing.JLabel t441;
    private javax.swing.JLabel t442;
    private javax.swing.JLabel t443;
    private javax.swing.JLabel t444;
    private javax.swing.JLabel t445;
    private javax.swing.JLabel t446;
    private javax.swing.JLabel t447;
    private javax.swing.JLabel t448;
    private javax.swing.JLabel t449;
    private javax.swing.JLabel t45;
    private javax.swing.JLabel t450;
    private javax.swing.JLabel t451;
    private javax.swing.JLabel t452;
    private javax.swing.JLabel t453;
    private javax.swing.JLabel t454;
    private javax.swing.JLabel t455;
    private javax.swing.JLabel t456;
    private javax.swing.JLabel t457;
    private javax.swing.JLabel t458;
    private javax.swing.JLabel t459;
    private javax.swing.JLabel t46;
    private javax.swing.JLabel t460;
    private javax.swing.JLabel t47;
    private javax.swing.JLabel t48;
    private javax.swing.JLabel t51;
    private javax.swing.JLabel t52;
    private javax.swing.JLabel t53;
    private javax.swing.JLabel t54;
    private javax.swing.JLabel t55;
    private javax.swing.JLabel t61;
    private javax.swing.JLabel t62;
    private javax.swing.JLabel t63;
    private javax.swing.JLabel t64;
    private javax.swing.JLabel t65;
    private javax.swing.JLabel t71;
    private javax.swing.JLabel t72;
    private javax.swing.JLabel t73;
    private javax.swing.JLabel t74;
    private javax.swing.JLabel t75;
    private javax.swing.JLabel t81;
    private javax.swing.JLabel t82;
    private javax.swing.JLabel t83;
    private javax.swing.JLabel t84;
    private javax.swing.JLabel t85;
    private javax.swing.JScrollPane tbl;
    private javax.swing.JScrollPane tbl1;
    private javax.swing.JScrollPane tbl2;
    private javax.swing.JTable tblmulti;
    private javax.swing.JTable tbltoothlabel;
    private javax.swing.JTable tbltoothpartcolor;
    // End of variables declaration//GEN-END:variables

}
