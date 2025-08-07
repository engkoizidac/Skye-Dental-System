/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.global;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.apache.commons.net.ftp.FTPFile;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

import com.jcraft.jsch.*;
import java.io.FileInputStream;

public class FTPFactory {

    private String ftphost;
    private int ftpport;
    private String user;
    private String pass;

    private void getConfigParameters() {
        String filePath = System.getProperty("user.dir") + "\\config.properties";
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(filePath));
        } catch (IOException ex) {
            Logger.getLogger(FTPFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        ftphost = properties.getProperty("ftphosts");
        String ftptemp = properties.getProperty("ftpport");
        ftpport = Integer.parseInt(ftptemp);
        user = "admin";
        pass = "admin";

    }

    public String GetFTPImagePath() {
        getConfigParameters();
        String path = "ftp://" + user + ":" + pass + "@" + ftphost + ":" + ftpport + "/img/";
        return path;
    }

    public String GetFTPPicPath() {
        getConfigParameters();
        String path = "ftp://" + user + ":" + pass + "@" + ftphost + ":" + ftpport + "/img/pic/";
        return path;
    }

    public String GetFTPSigPath() {
        getConfigParameters();
        String path = "ftp://" + user + ":" + pass + "@" + ftphost + ":" + ftpport + "/sig/";
        return path;
    }

    public void FTPViewImage(String urlstr, JLabel lbl) {
        try {
            URL url = new URL(urlstr);
            BufferedImage myImage;

            myImage = ImageIO.read(url);
            lbl.setIcon(new ImageIcon(myImage));
            lbl.revalidate();
        } catch (IOException ex) {
            //Logger.getLogger(FTPFactory.class.getName()).log(Level.SEVERE, null, ex);
            Icon ico1 = new javax.swing.ImageIcon(getClass().getResource("/img/nophoto.jpg"));
            lbl.setIcon(ico1);
            lbl.revalidate();
        }
    }

    public void FTPViewImage2(String urlstr, JLabel lbl) {
        try {
            URL url = new URL(urlstr);
            BufferedImage myImage;

            myImage = ImageIO.read(url);
            lbl.setIcon(new ImageIcon(myImage));
            lbl.revalidate();
        } catch (IOException ex) {
            //Logger.getLogger(FTPFactory.class.getName()).log(Level.SEVERE, null, ex);
            // Icon ico1 = new javax.swing.ImageIcon(getClass().getResource("/img/nophoto.jpg"));
            lbl.setText("No Signature Available");
            lbl.revalidate();
        }
    }

    public void ftpSaveFileGO(String local, String remote) throws IOException {
        getConfigParameters(); // assumes this initializes ftphost, ftpport, user, pass

        // Validate local file
        File localFile = new File(local);
        if (!localFile.exists() || !localFile.isFile()) {
            throw new FileNotFoundException("Local file does not exist or is not a file: " + local);
        }

        FTPClient ftpClient = new FTPClient();
        // Optional: timeouts
        ftpClient.setConnectTimeout(15_000); // 15 seconds
        ftpClient.setDefaultTimeout(30_000);
        ftpClient.setDataTimeout(30_000);

        try {
            ftpClient.connect(ftphost, ftpport);
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                throw new IOException("FTP server refused connection. Reply code: " + reply);
            }

            boolean loggedIn = ftpClient.login(user, pass);
            if (!loggedIn) {
                throw new IOException("FTP login failed. Server reply: " + ftpClient.getReplyString());
            }

            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // Upload using stream
            try (InputStream inputStream = new BufferedInputStream(new FileInputStream(localFile));
                    OutputStream outputStream = ftpClient.storeFileStream(remote)) {

                if (outputStream == null) {
                    throw new IOException("Could not open remote output stream. Reply: " + ftpClient.getReplyString());
                }

                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
            }

            // Must complete pending command
            boolean completed = ftpClient.completePendingCommand();
            if (!completed) {
                throw new IOException("Failed to complete FTP transaction. Reply: " + ftpClient.getReplyString());
            }

            // Optionally: verify existence/size on server if protocol allows
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.logout();
                } catch (IOException e) {
                    // log warning about logout failure
                }
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    // log warning about disconnect failure
                }
            }
        }
    }

    public void FTPSaveFile(String local, String remote) {

        getConfigParameters();
        System.out.println("local: " + local);
        System.out.println("remote: " + remote);
        System.out.println("host: " + ftphost);
        System.out.println("port: " + ftpport);
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftphost, ftpport);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
            File LocalFile = new File(local);
            String RemoteFile = remote;
            InputStream IStream = new FileInputStream(LocalFile);

            OutputStream outputStream = ftpClient.storeFileStream(RemoteFile);
            byte[] bytesIn = new byte[4096];
            int read = 0;

            while ((read = IStream.read(bytesIn)) != -1) {
                outputStream.write(bytesIn, 0, read);
            }

            IStream.close();
            outputStream.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.getMessage();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.getMessage();
            }
        }

    }

    public void SaveFile2() {
        try {
            getConfigParameters();
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(ftphost, ftpport);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // APPROACH #1: uploads first file using an InputStream
            File firstLocalFile = new File("D:/a.jpg");

            String firstRemoteFile = "/999.jpg";
            InputStream inputStream = new FileInputStream(firstLocalFile);

            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("The first file is uploaded successfully.");
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public void FTPDownloadFile(int Id) {
        getConfigParameters();
        //  System.out.println(GetFTPPicPath());
        FTPClient ftpClient = new FTPClient();

        try {

            ftpClient.connect(ftphost, ftpport);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // APPROACH #1: using retrieveFile(String, OutputStream)
            String remoteFile1 = "/img/" + Id + ".jpg";
            File downloadFile1 = new File("./preview/preview.jpg");
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();

            if (success) {
                System.out.println("File #1 has been downloaded successfully.");
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public String GetFTPPath() {
        getConfigParameters();
        String path = "ftp://" + user + ":" + pass + "@" + ftphost + ":" + ftpport + "/";
        return path;
    }

    public String GetFTPVersionPath() {
        getConfigParameters();
        String path = "ftp://" + user + ":" + pass + "@" + ftphost + ":" + ftpport + "/updates/memsys/version.properties";
        return path;
    }

    public void FTPDownload(int id) {
        getConfigParameters();
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftphost, ftpport);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory("ftp");
//FTPFile file = null;
            String remoteFile1 = "/ftp/" + id + ".pdf";
            File downloadFile1 = new File("./ftp/preview.pdf");
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void FTPUpdateLib() {
        getConfigParameters();
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftphost, ftpport);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory("updates/memsys/lib");
            FTPFile[] files = ftpClient.listFiles();
            for (FTPFile file : files) {
                System.out.println(file.getName());

                // APPROACH #1: using retrieveFile(String, OutputStream)
                //   SysUp x = new SysUp();
                //  x.insertlog(file.getName());
                String remoteFile1 = "/ftp/" + file.getName();
                File downloadFile1 = new File("./lib/" + file.getName());
                OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
                boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
                outputStream1.close();
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void SaveImageThroghFTP() {
        getConfigParameters();

        String localFilePath = "etc/temp/imgcrop.png";
        String remoteFilePath = "/img/44.png";

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, ftphost, ftpport); // Port 22 for SFTP
            session.setPassword(pass);
            session.setConfig("StrictHostKeyChecking", "no"); // For development, disable strict host key checking
            session.connect();

            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

            FileInputStream fis = new FileInputStream(localFilePath);
            channelSftp.put(fis, remoteFilePath);
            fis.close();

            System.out.println("File transferred successfully!");

            channelSftp.disconnect();
            session.disconnect();

        } catch (JSchException | java.io.IOException | SftpException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        FTPFactory x = new FTPFactory();
//        x.FTPUpdateLib();
//        x.FTPUpdate();
        FTPFactory x = new FTPFactory();
        x.SaveImageThroghFTP();
        //x.FTPDownloadFile(5);
        //    x.FTPSaveFile("etc/temp/imgcrop.png", "img/44.png");
//x.SaveFile2();

    }

}
