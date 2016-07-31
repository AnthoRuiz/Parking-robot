/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.Color;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import views.MainView;

/**
 *
 * @author Jarvis
 */
public class CheckConnection implements Job{
    
    public void execute(JobExecutionContext context) throws JobExecutionException {
        MainView manMainView = new MainView();
        manMainView.textFieldTitle.setText("cosa");
        try {
            
            URL u = new URL("https://www.google.es/");
            HttpsURLConnection huc = (HttpsURLConnection)u.openConnection();
            huc.connect();
            
            System.out.println("si hay inter");
            
        }
        catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No Hay Internet", "Verificando", 2);
            System.out.println("no hay inter");
        }
    } 
    
    public String getConnectionStatus() {
    String conStatus = null;
    try {
        URL u = new URL("https://www.google.es/");
        HttpsURLConnection huc = (HttpsURLConnection)u.openConnection();
        huc.connect();
        conStatus = "Online";
    }
    catch (Exception e) {
        conStatus = "Offline";
    }
    return conStatus;
}

    public void check() {
        String status = this.getConnectionStatus();
        if (status.equals("Offline")) {
            //System.out.println("no hay inter");
            JOptionPane.showMessageDialog(null, "No Hay Internet", "Verificando", 2);
        } else {
            JOptionPane.showMessageDialog(null, "Si Hay Internet", "Verificando", 1);
            //System.out.println("si hay inter");
        }
    }
}
