/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

/**
 *
 * @author LENOVO
 */

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TampilanAwal extends JFrame{
    
    Connector connector = new Connector();
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("Login");
    
    JLabel lLogin = new JLabel("Login");
    JButton btnAdmin = new JButton("Admin");
    JButton btnUser = new JButton("User");
    
    ButtonGroup group = new ButtonGroup();
    
public TampilanAwal(){ 
        window.setLayout(null);
        window.setSize(500,200);
        
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
       // setDefaultCloseOperation(EXIT_ON_CLOSE);

//ADD COMPONENT
        window.add(lLogin);
        window.add(btnAdmin);
        window.add(btnUser);



//LABEL
        lLogin.setBounds(200,0,220,50);
        
//TEXTFIELD

//BUTTON PANEL
        btnAdmin.setBounds(150,75,75,40);
        btnUser.setBounds(250,75,75,40);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JButton btnAdmin1 = btnAdmin;
        JButton btnUser1 = btnUser;
                
    btnAdmin.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent arg0) { 
             
                 new AdminLogin();
                 dispose();
             }
        });
    btnUser.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent arg0) { 
                
                 new UserLogin();
                 dispose();
             }
        });
    }
}