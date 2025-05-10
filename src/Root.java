
import app.global.ReportFactory;
import app.view.user.Login;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.UIManager;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EngkoiZidac
 */
public class Root {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               try {
            setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            for (UIManager.LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        Login frame = new Login();
        frame.setVisible(true);
        
        ReportFactory Factory = new ReportFactory();
        Factory.LoadReportBoot();
        
        
        
       // LocalDateTime myObj = LocalDateTime.now();
       // System.out.println(myObj);
    }
    
}
