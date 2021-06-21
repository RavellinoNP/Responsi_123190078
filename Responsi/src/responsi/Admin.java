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

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class Admin {
    
    String data[][] = new String[500][3];
    Connector connector = new Connector();
    
    JFrame window = new JFrame("Admin");
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    //membuat kolom dgn array tipe object;
    Object namaKolom[] = {"No","Username","Password"}; 
    
    public Admin(){
        window.setLayout(null);
        window.setSize(550,600);
        window.setDefaultCloseOperation(3);
        
        window.setVisible(true);
        
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    
         try{
            int jmlData = 0; //menampung jumlah data sebanyak jumlah data yang ada, defaultnya 0
            String query = "Select * from `admin`"; //proses pengambilan data
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); //result isinya tabel belum berupa string
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("No"); 
                data[jmlData][1] = resultSet.getString("Username");
                data[jmlData][2] = resultSet.getString("Password");
               jmlData++; 
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
         
         tabel = new JTable(data,namaKolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
         scrollPane = new JScrollPane(tabel);
         window.add(scrollPane);
         
         scrollPane.setBounds(20, 35, 500, 300);
         scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        }
}
