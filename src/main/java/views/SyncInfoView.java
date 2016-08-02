/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package views;

import VO.DataBase;
import VO.Parking;
import VO.Tarifa;
import VO.TipoVehiculo;
import controllers.CopyFileDB;
import controllers.CopyFileMyDB;
import controllers.MainController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class SyncInfoView
        extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JTextField textNameDB;
    private JTextField textUserDB;
    private JLabel lblUserDB;
    private JLabel lblPass;
    private JPanel buttonPane;
    private JButton okButton;
    private JButton cancelButton;
    private JPasswordField passDB;
    private MainController mainController = new MainController();
    
    public SyncInfoView(Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();
        this.setTitle("Configuraci\u00f3n de Base de Datos");
        this.setResizable(false);
        this.setBounds(100, 100, 777, 485);
        this.setSize(720, 500);
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
    }
    
    private void initComponents() {
        this.getContentPane().setLayout(new BorderLayout());
        this.contentPanel.setBackground(new Color(176, 224, 230));
        this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.getContentPane().add((Component)this.contentPanel, "Center");
        this.contentPanel.setLayout(null);
        JLabel lblNameDB = new JLabel("Nombre Base Datos");
        lblNameDB.setBackground(new Color(32, 178, 170));
        lblNameDB.setBounds(46, 56, 176, 32);
        lblNameDB.setHorizontalAlignment(0);
        lblNameDB.setFont(new Font("Arial Black", 0, 14));
        this.contentPanel.add(lblNameDB);
        this.textNameDB = new JTextField();
        this.textNameDB.setBounds(265, 57, 192, 32);
        this.textNameDB.setFont(new Font("Arial Black", 0, 13));
        this.textNameDB.setHorizontalAlignment(0);
        this.contentPanel.add(this.textNameDB);
        this.textNameDB.setColumns(10);
        this.lblUserDB = new JLabel("Usuario Base Datos");
        this.lblUserDB.setBounds(46, 137, 176, 32);
        this.lblUserDB.setHorizontalAlignment(0);
        this.lblUserDB.setFont(new Font("Arial Black", 0, 14));
        this.contentPanel.add(this.lblUserDB);
        this.textUserDB = new JTextField();
        this.textUserDB.setBounds(265, 137, 192, 32);
        this.textUserDB.setHorizontalAlignment(0);
        this.textUserDB.setFont(new Font("Arial Black", 0, 13));
        this.textUserDB.setColumns(10);
        this.contentPanel.add(this.textUserDB);
        this.lblPass = new JLabel("Password Base Datos");
        this.lblPass.setBounds(46, 219, 176, 32);
        this.lblPass.setHorizontalAlignment(0);
        this.lblPass.setFont(new Font("Arial Black", 0, 14));
        this.contentPanel.add(this.lblPass);
        this.passDB = new JPasswordField();
        this.passDB.setHorizontalAlignment(0);
        this.passDB.setFont(new Font("Arial Black", 0, 13));
        this.passDB.setBounds(265, 220, 192, 32);
        this.contentPanel.add(this.passDB);
        this.buttonPane = new JPanel();
        this.buttonPane.setLayout(new FlowLayout(2));
        this.getContentPane().add((Component)this.buttonPane, "South");
        this.okButton = new JButton("OK");
        this.okButton.setActionCommand("OK");
        this.buttonPane.add(this.okButton);
        this.getRootPane().setDefaultButton(this.okButton);
        this.okButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                SyncInfoView.this.okButtonActionPerformed(evt);
            }
        });
        this.cancelButton = new JButton("Cancel");
        this.cancelButton.setActionCommand("Cancel");
        this.buttonPane.add(this.cancelButton);
        this.cancelButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                SyncInfoView.this.cancelButtonActionPerformed(evt);
            }
        });
    }
    
    protected void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }
    
    protected void okButtonActionPerformed(ActionEvent evt) {
        this.addConfigDataBase();
    }
    
    private void addConfigDataBase() {
        Parking parking = new Parking();
        ArrayList<TipoVehiculo> tipoVehiculoList = new ArrayList<TipoVehiculo>();
        Tarifa tarifa = new Tarifa();
        
        ArrayList<Parking> parkingCloudList = new ArrayList<Parking>();
        CopyFileDB copyFileDB = new CopyFileDB();
        CopyFileMyDB copyFileMyDB = new CopyFileMyDB();
        int cloudParkingIndex;
        DataBase dataBase = new DataBase();
        Connection connection = null;
        dataBase.setNameDataBase(this.textNameDB.getText().trim());
        dataBase.setPass(this.passDB.getText().trim());
        dataBase.setUser(this.textUserDB.getText().trim());
        connection = this.mainController.addConfigDataBase(dataBase);
        if (this.validateFields(this.textNameDB.getText().trim(), this.textUserDB.getText().trim())) {
            if (connection != null) {
                this.clearConfig();
                this.dispose();
                parking = copyFileDB.getDataParking(connection);
                tipoVehiculoList = copyFileDB.getDataTypeVehicle(connection);
                tarifa = copyFileDB.getTarifa(connection);
                
                parkingCloudList = copyFileMyDB.getDataParking();
                cloudParkingIndex = this.mainController.checkEqueals(parking, parkingCloudList);
                
                
                
                //System.out.println(parkingCloudList.toString());
                //System.out.println(tipoVehiculoList.toString());
                JOptionPane.showMessageDialog(null, "Configuracion Exitosa!");
            } else {
                JOptionPane.showMessageDialog(null, "Configuracion Fallida!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Configuracion Fallida!");
        }
    }
    
    public boolean validateFields(String name, String user) {
        boolean validateName = false;
        boolean validateUser = false;
        if (name != null && !name.equals("")) {
            validateName = true;
        }
        if (user != null && !user.equals("")) {
            validateUser = true;
        }
        if (validateName && validateUser) {
            return true;
        }
        return false;
    }
    
    private void clearConfig() {
        this.textNameDB.setText("");
        this.passDB.setText("");
        this.textUserDB.setText("");
    }
    
}