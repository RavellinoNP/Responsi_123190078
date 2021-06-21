
package responsi;

import java.sql.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */

public class AdminLogin extends JFrame{
    public String username, password;
    
    Connector connector = new Connector();    
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("Admin");
   
    JLabel lusername = new JLabel("Username ");
        JTextField tfusername = new JTextField();
    JLabel lpass = new JLabel("Password");
        JTextField tfpass = new JTextField();
  
    JButton btnCancel = new JButton("Cancel");
    JButton btnLoginPanel = new JButton("Login");
    
public AdminLogin() {
        window.setLayout(null);
        window.setSize(550,200);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);


       // setDefaultCloseOperation(EXIT_ON_CLOSE);

//ADD COMPONENT
        window.add(lusername);
        window.add(tfusername);
        window.add(lpass);
        window.add(tfpass);
        window.add(btnCancel);
        window.add(btnLoginPanel);



//LABEL
        lusername.setBounds(5, 35, 120, 20);
        lpass.setBounds(5, 60, 120, 20);
        
//TEXTFIELD
        tfusername.setBounds(110, 35, 120, 20);
        tfpass.setBounds(110, 60, 120, 20);
        

//BUTTON PANEL
        btnCancel.setBounds(250, 35, 90, 20);
        btnLoginPanel.setBounds(250,60,90,20);

        
        btnLoginPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   try {
            String query = "SELECT * FROM admin WHERE username='"+tfusername.getText()+"' && password='"+tfpass.getText()+"'";
            
            connector.statement = connector.koneksi.createStatement();
            new Admin();

            System.out.println("Login Berhasil");
            JOptionPane.showMessageDialog(null,"Login Berhasil !!");
           
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
            }
        });
         
        btnCancel.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent arg0) { 
                
                 tfusername.setText("");
                 tfpass.setText("");
             }
        });
}
}

        
      
 