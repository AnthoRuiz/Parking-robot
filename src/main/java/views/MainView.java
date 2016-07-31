/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.CheckConnection;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import views.SyncInfoView;

public class MainView
extends JFrame
implements ActionListener {
    private JPanel contentPane;
    public  JTextField textFieldTitle;
    public  JButton btnConnection;
    private JButton btnSync;
    private CheckConnection checkConnection = new CheckConnection();

    private void initComponents() {
        this.contentPane = new JPanel();
        this.contentPane.setBackground(new Color(176, 224, 230));
        this.contentPane.setBorder(null);
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        this.textFieldTitle = new JTextField();
        this.textFieldTitle.setEditable(false);
        this.textFieldTitle.setBackground(new Color(32, 178, 170));
        this.textFieldTitle.setForeground(new Color(0, 0, 0));
        this.textFieldTitle.setFont(new Font("Arial Black", 1, 20));
        this.textFieldTitle.setHorizontalAlignment(0);
        this.textFieldTitle.setText("SINCRONIZAR INFORMACI\u00d3N");
        this.textFieldTitle.setBounds(216, 28, 445, 53);
        this.contentPane.add(this.textFieldTitle);
        this.textFieldTitle.setColumns(10);
        this.btnConnection = new JButton("Verificar Conexi\u00f3n");
        this.btnConnection.setFont(new Font("Arial Black", 0, 15));
        this.btnConnection.setForeground(new Color(25, 25, 112));
        //this.btnConnection.setBackground(Color.red);
        this.btnConnection.setBounds(502, 199, 199, 53);
        this.contentPane.add(this.btnConnection);
        this.btnConnection.addActionListener(this);
        this.btnSync = new JButton("Sincronizar Informaci\u00f3n");
        this.btnSync.setForeground(new Color(25, 25, 112));
        this.btnSync.setFont(new Font("Arial Black", 0, 15));
        //this.btnSync.setBackground(new Color(240, 248, 255));
        this.btnSync.setBounds(142, 199, 238, 53);
        this.contentPane.add(this.btnSync);
        this.btnSync.addActionListener(this);
    }

    public MainView() {
        this.initComponents();
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 893, 546);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnConnection) {
            this.checkConnection.check();
        } else if (e.getSource() == this.btnSync) {
            this.openSyncInfo();
        }
    }

    private void openSyncInfo() {
        SyncInfoView syncInfoView = new SyncInfoView(this, this.isValid());
        syncInfoView.setVisible(true);
    }
}
