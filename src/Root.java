
import app.global.ReportFactory;
import app.view.user.Login;
import javax.swing.UIManager;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;

public class Root {
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
    }
    
}
