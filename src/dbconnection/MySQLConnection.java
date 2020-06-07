/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ahnaffaiz
 */
public class MySQLConnection {
    // atribut untuk keperluan koneksi ke mysql
    public String dbHost;
    public String dbName;
    public String dbUser;
    public String dbPass;
    public Connection conn;
    
    public MySQLConnection(){
        // setting nilai atribut koneksi
        this.dbHost = "localhost";
        this.dbName = "db_perpustakaan";
        this.dbUser = "root";
        this.dbPass = "";
        
        try {
            // membuat url string connection ke mysql 
            String dbURL = "jdbc:mysql://"+ this.dbHost +":3306/" + this.dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            this.conn = DriverManager.getConnection(dbURL, this.dbUser, this.dbPass);
            // jika konek
            if (this.conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            // jika gagal konek
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    
        // method untuk menutup koneksi mysql
    public void close(){
        try {
            // tutup koneksi
            this.conn.close();
        } catch (SQLException ex) {
            System.out.println("Penutupan koneksi gagal");
        }
    }
}
