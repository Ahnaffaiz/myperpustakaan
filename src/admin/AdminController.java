/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import dbconnection.MySQLConnection;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ahnaffaiz
 */
public class AdminController {
    
    public void insertBuku(MySQLConnection m,
            String id,
            String judul, 
            String sampul, 
            String jenis, 
            String pengarang, 
            String penerbit,
            String tahun,
            String stok,
            String dipinjam) {
        
        //melakukan koneksi ke MySQL
        Connection koneksi = m.conn;
        
        String query = "INSERT INTO `db_buku`(`id_buku`, `judul`, `jenis`, `pengarang`, `penerbit`, `tahun`, `stok`, `dipinjam`) VALUES (?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement statement = koneksi.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, judul);
            statement.setString(3, jenis);
            statement.setString(4, pengarang);
            statement.setString(5, penerbit);
            statement.setString(6, tahun);
            statement.setString(7, stok);
            statement.setString(8, dipinjam);
            
            //menjalanakan query
            int rowInserted = statement.executeUpdate();
            
            if (rowInserted>0){
                JOptionPane.showMessageDialog(null, "Buku Berhasil Ditambahkan");
            }
        }
        
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Buku gagal Ditambahkan");
            System.out.println(ex);
        }
    }
    
    public void updateBuku(MySQLConnection m,
            String id,
            String judul,
            String jenis, 
            String pengarang, 
            String penerbit,
            String tahun,
            String stok,
            String dipinjam){
        
         //melakukan koneksi ke MySQL
        Connection koneksi = m.conn;
        
        String query = "UPDATE `db_buku` SET `id_buku`=?,`judul`=?,`jenis`=?,`pengarang`=?,`penerbit`=?,`tahun`=?,`stok`=?,`dipinjam`=? WHERE `id_buku`=?"; 
        
        try {
            PreparedStatement statement = koneksi.prepareStatement(query);
            
            // mapping nilai parameter dari query sql nya (sesuai urutan)
            statement.setString(1, id);
            statement.setString(2, judul);
            statement.setString(3, jenis);
            statement.setString(4, pengarang);
            statement.setString(5, penerbit);
            statement.setString(6, tahun);
            statement.setString(7, stok);
            statement.setString(8, dipinjam);
            statement.setString(9, id);
            
            
            //menjalanakan query
            int rowInserted = statement.executeUpdate();
            
            if (rowInserted>0){
                JOptionPane.showMessageDialog(null, "Update Data Buku Berhasil");
                System.out.println("update data buku berhasil");
            }
        }
        
        catch (Exception ex){
            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Update Data Buku gagal");
        }
        
    }
    
    public void updateStatus(String id){
        MySQLConnection m = new MySQLConnection();
        Connection koneksi = m.conn;
        
        String query = "UPDATE `db_peminjaman` SET `status`='1' WHERE db_peminjaman.id_peminjaman=" + id;
        
        try {
            Statement statement = koneksi.createStatement();
            statement.executeUpdate(query);
        }
        
        catch(java.sql.SQLException ex){
            System.out.println(ex);
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
        
        catch(java.sql.SQLException ex){
            System.out.println("Stok gagal diperbarui");
        }
    }
    
    
    
}
