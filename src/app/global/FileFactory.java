/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.global;

import java.io.*;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EngkoiZidac
 */
public class FileFactory {

    private String SigPathDoc;
    private String SigPathPatient;
    private static String SigSource;
    private String FileName;

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    public String getSigPathDoc() {
        GetPathConfig();
        return SigPathDoc;
    }

    public void setSigPathDoc(String SigPathDoc) {
        this.SigPathDoc = SigPathDoc;
    }

    public String getSigPathPatient() {
        return SigPathPatient;
    }

    public void setSigPathPatient(String SigPathPatient) {
        this.SigPathPatient = SigPathPatient;
    }
    
    void GetPathConfig() {
        String filePath = System.getProperty("user.dir") + "\\config.properties";
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(filePath));
        } catch (IOException ex) {
            Logger.getLogger(FTPFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        SigPathDoc = properties.getProperty("sig.path.doc");
        SigPathPatient = properties.getProperty("sig.path.patient");
        SigSource = properties.getProperty("sig.source.file");

//        ftphost = properties.getProperty("ftphosts");
//        String ftptemp = properties.getProperty("ftpport");
//        ftpport = Integer.parseInt(ftptemp);
//        user = "admin";
//        pass = "admin";
    }

    public void SaveSignatureDoc() {
        GetPathConfig();
        Path source = Paths.get(SigSource);
        Path target = Paths.get(SigPathDoc + FileName);

        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(FileFactory.class.getName()).log(Level.SEVERE,
                    "Error copying file", ex);
            throw new RuntimeException("File copy failed", ex);
        }
    }

    public void SaveSignatureInformedConsent() {
        GetPathConfig();
        Path source = Paths.get(SigSource);
        Path target = Paths.get(SigPathPatient + FileName);

        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(FileFactory.class.getName()).log(Level.SEVERE,
                    "Error copying file", ex);
            throw new RuntimeException("File copy failed", ex);
        }
    }

    public void GetSigImage(JLabel label) {
        GetPathConfig();
        Path imagePath = Paths.get(SigPathDoc + FileName);

        // Validate image file existence
        if (!Files.exists(imagePath)) {
            Logger.getLogger(FileFactory.class.getName()).log(Level.SEVERE,
                    "Image file does not exist: " + imagePath.toAbsolutePath());
            label.setText("No Signature Image Saved!");
            return;
        }

        try {
            // Load image and create ImageIcon
            ImageIcon imageIcon = new ImageIcon(imagePath.toString());

            // Check if image loaded successfully
            if (imageIcon.getIconWidth() == -1) {
                Logger.getLogger(FileFactory.class.getName()).log(Level.WARNING,
                        "Failed to load image: " + imagePath.toAbsolutePath());
                label.setText("Error: Failed to load image");
                return;
            }

            // Optional: Scale image to fit JLabel (adjust dimensions as needed)
            Image scaledImage = imageIcon.getImage().getScaledInstance(
                    label.getWidth() > 0 ? label.getWidth() : 300,
                    label.getHeight() > 0 ? label.getHeight() : 300,
                    Image.SCALE_SMOOTH
            );
            imageIcon = new ImageIcon(scaledImage);

            // Set image to JLabel
            label.setIcon(imageIcon);
            label.setText(null); // Clear any previous text

        } catch (Exception ex) {
            Logger.getLogger(FileFactory.class.getName()).log(Level.SEVERE,
                    "Error loading image: " + imagePath.toAbsolutePath(), ex);
            label.setText("Error: Unable to display image");
        }
    }

    public static void main(String[] args) {
    }
}
