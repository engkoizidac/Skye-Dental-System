package app.global;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PathFactory {

    static String path;

    public static String GetPicPath() {
        String filePath = System.getProperty("user.dir") + "\\config.properties";

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(filePath));
        } catch (IOException ex) {
            Logger.getLogger(PathFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        path = properties.getProperty("picpathconfig");
        return path;
    }
    


    public static String GetSigPath() {
        String filePath = System.getProperty("user.dir") + "\\config.properties";

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(filePath));
        } catch (IOException ex) {
            Logger.getLogger(PathFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        path = properties.getProperty("sigpathconfig");
        return path;
    }

    public static void main(String[] args) {
            
    }

}
