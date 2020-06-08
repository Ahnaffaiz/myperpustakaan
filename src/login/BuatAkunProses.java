/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import dbconnection.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Andika
 */
public class BuatAkunProses {
    
    
    public void CreateAkun(MySQLConnection m,
            String username,
            String password,
            String alamat,
            String ttl,
            String tLahir,
            String rules){
        
        Connection koneksi = m.conn;
        String query = "INSERT INTO `db_users`(`name`, `password`, `alamat`, `ttl`, `tempat_lahir`, `rules`) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement statement = koneksi.prepareStatement(query);
            
            // mapping nilai parameter dari query sql nya (sesuai urutan)
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, alamat);
            statement.setString(4, ttl);
            statement.setString(5, tLahir);
            statement.setString(6, rules);
            
            
            //menjalanakan query
            int rowInserted = statement.executeUpdate();
            
            if (rowInserted>0){
                System.out.println("input data user berhasil");
            }
        }
        
        catch (SQLException ex){
            System.out.println("error " + ex);
        }
    }
}
