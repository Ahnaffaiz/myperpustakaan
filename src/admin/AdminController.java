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
        
        String query = "INSERT INTO `db_buku`(`id_buku`, `judul`, `sampul`, `jenis`, `pengarang`, `penerbit`, `tahun`, `stok`, `dipinjam`) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement statement = koneksi.prepareStatement(query);
            
            // mapping nilai parameter dari query sql nya (sesuai urutan)
            statement.setString(1, id);
            statement.setString(2, judul);
            statement.setString(3, sampul);
            statement.setString(4, jenis);
            statement.setString(5, pengarang);
            statement.setString(6, penerbit);
            statement.setString(7, tahun);
            statement.setString(8, stok);
            statement.setString(9, dipinjam);
            
            
            //menjalanakan query
            int rowInserted = statement.executeUpdate();
            
            if (rowInserted>0){
                JOptionPane.showMessageDialog(null, "Data Buku Berhasil Ditambahkan");
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan");
            }
        }
        
        catch (SQLException ex){
            System.out.println("error " + ex);
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
                System.out.println("update data buku berhasil");
            }
        }
        
        catch (SQLException ex){
            System.out.println("error " + ex);
        }
        
    }
    
    
    
}
