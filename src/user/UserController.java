/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import dbconnection.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

/**
 *
 * @author ahnaffaiz
 */
public class UserController {
    public void insertPinjamBuku(MySQLConnection m,
            String idUser, String idBuku) {
        
        //date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        LocalDateTime akhir = LocalDateTime.now().plusDays(7);
        
        //melakukan koneksi ke MySQL
        Connection koneksi = m.conn;
        
        String query = "INSERT INTO `db_peminjaman`(`id_user`, `id_buku`, `tgl_awal`, `tgl_akhir`,`status`) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement statement = koneksi.prepareStatement(query);
            
            // mapping nilai parameter dari query sql nya (sesuai urutan)
            statement.setString(1, idUser);
            statement.setString(2, idBuku);
            statement.setString(3, dtf.format(now));
            statement.setString(4, dtf.format(akhir));
            statement.setString(5, "0");
            
            //menjalanakan query
            int rowInserted = statement.executeUpdate();
            
            if (rowInserted>0){
                JOptionPane.showMessageDialog(null, "Buku Berhasil Dipinjam");
            } else {
                JOptionPane.showMessageDialog(null, "Buku Gagal Dipinjam");
            }
        }
        
        catch (SQLException ex){
            System.out.println("error " + ex);
        }
    }
    
    public void updateStok(int dipinjam, String id){
        MySQLConnection m = new MySQLConnection();
        Connection koneksi = m.conn;
        
        String query = "UPDATE `db_buku` SET `dipinjam`=" + dipinjam + " WHERE `id_buku`='" + id + "'";
        
        try {
            Statement statement = koneksi.createStatement();
            statement.executeUpdate(query);
        }
        
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Gagal mengubah status");
        }
    }
}
