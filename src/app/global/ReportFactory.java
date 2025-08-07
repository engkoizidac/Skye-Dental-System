package app.global;

import static app.config.DBConn.getConnection;
import java.awt.BorderLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;

import net.sf.jasperreports.engine.JRException;
import static net.sf.jasperreports.engine.JasperCompileManager.compileReport;
import static net.sf.jasperreports.engine.JasperFillManager.fillReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

public class ReportFactory {

    public void LoadReportBoot() {
        try {
            JasperReport jasperReport;
            JasperPrint jPrint;

            //parameters
            HashMap parameters = new HashMap();

            jasperReport = compileReport("rpt/ReportBoot.jrxml");

            jPrint = fillReport(jasperReport, parameters, getConnection());
        } catch (JRException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void LoadReportInformedConsent(int id, String docSigPath, String patientSigPath, JPanel y) {
        try {
            JasperReport jasperReport;
            JasperPrint jPrint;

            //parameters
            HashMap parameters = new HashMap();
            parameters.put("id", id);
            parameters.put("docsigpath", docSigPath);
            parameters.put("patientsigpath", patientSigPath);
            
            jasperReport = compileReport("rpt/ReportInformedConsent.jrxml");

            jPrint = fillReport(jasperReport, parameters, getConnection());

            // JasperViewer Viewer = new JasperViewer(jPrint, false);
            JRViewer x = new JRViewer(jPrint);
            y.setLayout(new BorderLayout());
            y.add(x);

            //   JasperExportManager.exportReportToPdfFile(jPrint, "./salesupdate.pdf");
//            //  JasperExportManager.exportReportToPdf(jPrint, "C:\\report.pdf");
//            Viewer.setTitle("Informed Consent");
//            Viewer.setExtendedState(Viewer.getExtendedState() | MAXIMIZED_BOTH);
//            Viewer.setVisible(true);
        } catch (JRException e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public static void rptBoot() throws FileNotFoundException, IOException {
        try {
            JasperReport jasperReport;

            JasperPrint jPrint;

            //parameters
            HashMap parameters = new HashMap();

            jasperReport = compileReport("rpt/rptboot.jrxml");

            jPrint = fillReport(jasperReport, parameters, getConnection());

            JasperViewer Viewer = new JasperViewer(jPrint, false);
            Viewer.setExtendedState(Viewer.getExtendedState() | MAXIMIZED_BOTH);
        } catch (JRException e) {
            showMessageDialog(null, e.getMessage());
            return;
        }
    }

    public static void LaborSummary(String from, String to, String caption) {
        try {
            JasperReport jasperReport;
            JasperPrint jPrint;

            //parameters
            HashMap parameters = new HashMap();
            parameters.put("from", from);
            parameters.put("to", to);
            parameters.put("caption", caption);

            jasperReport = compileReport("rpt/LaborPayroll/Summary.jrxml");

            jPrint = fillReport(jasperReport, parameters, getConnection());

            JasperViewer Viewer = new JasperViewer(jPrint, false);
            //JasperExportManager.exportReportToPdf(jPrint);
            Viewer.setTitle("Labor Payroll Summary");
            Viewer.setExtendedState(Viewer.getExtendedState() | MAXIMIZED_BOTH);
            Viewer.setVisible(true);
        } catch (JRException e) {
            showMessageDialog(null, e.getMessage());
        }

    }

    public static void DailyCollectionSummary(String dte) {
        try {
            JasperReport jasperReport;
            JasperPrint jPrint;

            //parameters
            HashMap parameters = new HashMap();
            parameters.put("date", dte);
            parameters.put("caption", dte);

            jasperReport = compileReport("rpt/DailyCollectionReport/Summary.jrxml");

            jPrint = fillReport(jasperReport, parameters, getConnection());

            JasperViewer Viewer = new JasperViewer(jPrint, false);
            //JasperExportManager.exportReportToPdf(jPrint);
            Viewer.setTitle("Labor Payroll Summary");
            Viewer.setExtendedState(Viewer.getExtendedState() | MAXIMIZED_BOTH);
            Viewer.setVisible(true);
        } catch (JRException e) {
            showMessageDialog(null, e.getMessage());
        }

    }

    public static void LaborDetailedSummary(String from, String to, String caption) {
        try {
            JasperReport jasperReport;
            JasperPrint jPrint;

            //parameters
            HashMap parameters = new HashMap();
            parameters.put("from", from);
            parameters.put("to", to);
            parameters.put("caption", caption);

            jasperReport = compileReport("rpt/LaborPayrollDetails/SummaryDetails.jrxml");

            jPrint = fillReport(jasperReport, parameters, getConnection());

            JasperViewer Viewer = new JasperViewer(jPrint, false);
            //JasperExportManager.exportReportToPdf(jPrint);
            Viewer.setTitle("Labor Payroll Summary");
            Viewer.setExtendedState(Viewer.getExtendedState() | MAXIMIZED_BOTH);
            Viewer.setVisible(true);
        } catch (JRException e) {
            showMessageDialog(null, e.getMessage());
        }

    }

}
