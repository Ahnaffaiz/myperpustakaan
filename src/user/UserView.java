/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import dbconnection.MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import login.HalLogin;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ahnaffaiz
 */
public final class UserView extends javax.swing.JFrame {
    public String idUser;
    public DefaultTableModel tabModel;
    public DefaultTableModel tabModel2;
    public DetailBuku db;
    public String id;
    public int denda=5000;
    
    
    /**
     * Creates new form UserView
     */
    public UserView() {
        super("Perpustakaan");
        initComponents();
        setJudul();
        setJudulTablePinjam();
        showBukuPinjam();
        
    }
    
    public UserView(String user) {
        super("Perpustakaan");
        initComponents();
        setJudul();
        this.idUser = user;
        setJudulTablePinjam();
        showBukuPinjam();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfCariBuku = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCariBuku = new javax.swing.JTable();
        btnLihatDetail = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBukuPinjam = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pinjam Buku");

        jLabel2.setText("Masukkan Judul Buku");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tblCariBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCariBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCariBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCariBuku);

        btnLihatDetail.setText("Lihat Detail");
        btnLihatDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatDetailActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("* Cari buku yang akan dipinjam");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Daftar Buku Dipinjam");

        tblBukuPinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBukuPinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBukuPinjamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBukuPinjam);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("* Pilih Judul Buku yang ingin anda pinjam kemudian Klik  Lihat Detail");

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKeluar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(tfCariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1)
                        .addComponent(btnLihatDetail)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLihatDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKeluar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        
        cariBuku(tfCariBuku.getText());
        
    }//GEN-LAST:event_btnCariActionPerformed

    private void tblCariBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCariBukuMouseClicked
        // TODO add your handling code here:
        
        
        
        
    }//GEN-LAST:event_tblCariBukuMouseClicked

    private void btnLihatDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatDetailActionPerformed
        // TODO add your handling code here:
        String idBook = tblCariBuku.getValueAt(tblCariBuku.getSelectedRow(), 0).toString();
        String judulBook = tblCariBuku.getValueAt(tblCariBuku.getSelectedRow(), 1).toString();
        String jenisBook = tblCariBuku.getValueAt(tblCariBuku.getSelectedRow(), 2).toString();
        String pengarangBook = tblCariBuku.getValueAt(tblCariBuku.getSelectedRow(), 3).toString();
        String penerbitBook = tblCariBuku.getValueAt(tblCariBuku.getSelectedRow(), 4).toString();
        String tahunBook = tblCariBuku.getValueAt(tblCariBuku.getSelectedRow(), 5).toString();
        String stokBook = tblCariBuku.getValueAt(tblCariBuku.getSelectedRow(), 6).toString();
        String dipinjamBook = tblCariBuku.getValueAt(tblCariBuku.getSelectedRow(), 7).toString();
        String tersediaBook = tblCariBuku.getValueAt(tblCariBuku.getSelectedRow(), 8).toString();
        
        new DetailBuku(idBook, judulBook, jenisBook, pengarangBook, penerbitBook, tahunBook, stokBook, dipinjamBook, tersediaBook, this.idUser).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLihatDetailActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new HalLogin().setVisible(true);
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void tblBukuPinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBukuPinjamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBukuPinjamMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UserView().setVisible(true);
        });
    }
    
    public void setJudul(){
        Object[] title = {
            "kode","Judul", "Jenis", "Pengarang", "Penerbit", "Tahun Terbit", "Stok", "Dipinjam", "Tersedia"  
        };
        tabModel = new DefaultTableModel(null, title);
        tblCariBuku.setModel(tabModel);
    }
    
    public void setJudulTablePinjam(){
        Object[] title = {
            "Judul Buku", "Tanggal Awal Pinjam", "Tanggal diKembalikan","Tanggal Awal", "Tanggal Akhir", "Tahun Terbit", "Denda"  
        };
        tabModel2 = new DefaultTableModel(null, title);
        tblBukuPinjam.setModel(tabModel2);
    }
    
    public void cariBuku(String cari){
        MySQLConnection m = new MySQLConnection();
        Connection koneksi = m.conn;
        Object[] data = new Object[9];
        Object[] date = new Object[3];
        
        tabModel.getDataVector().removeAllElements();
        tabModel.fireTableDataChanged();
        
        String query = "SELECT * FROM db_buku WHERE judul LIKE '%" + cari + "%'";
        
        try {
            Statement statement = koneksi.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while(result.next()){
                data[0] = result.getString("id_buku");
                data[1] = result.getString("judul");
                data[2] = result.getString("jenis");
                data[3] = result.getString("pengarang");
                data[4] = result.getString("penerbit");
                String str = result.getString("tahun");
                String[] arr = str.split("-",2);
                
                data[5] = arr[0];
                data[6] = result.getString("stok");
                data[7] = result.getString("dipinjam");
                data[8] = Integer.parseInt((String) data[6]) - Integer.parseInt((String) data[7]);
                
                tabModel.addRow(data);
            }
        } catch (NumberFormatException | SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void showBukuPinjam(){
        MySQLConnection m = new MySQLConnection();
        Connection koneksi = m.conn;
        Object[] data = new Object[7];
        Object[] date = new Object[3];
        
        tabModel2.getDataVector().removeAllElements();
        tabModel2.fireTableDataChanged();
        
        String query = "SELECT db_peminjaman.tgl_awal, db_peminjaman.tgl_akhir , db_buku.judul, db_buku.pengarang, db_buku.penerbit, db_buku.tahun FROM db_peminjaman, db_buku WHERE db_peminjaman.id_user='" + this.idUser + "'  AND db_peminjaman.id_buku=db_buku.id_buku";
        
        try {
            Statement statement = koneksi.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while(result.next()){
                data[0] = result.getString("judul");
                data[1] = result.getString("pengarang");
                data[2] = result.getString("penerbit");
                data[3] = result.getString("tgl_awal");
                data[4] = result.getString("tgl_akhir");
               
                String str = result.getString("tahun");
                String[] arr = str.split("-",3);
                
                data[5] = arr[0];
                
                String tglAwal = (String) data[3];
                String[] arr2 = tglAwal.split("-",3);
                String[] arr3 = arr2[2].split(" ",2);
                
                String tglAkhir = (String) data[4];
                String[] arr4 = tglAkhir.split("-",3);
                String[] arr5 = arr4[2].split(" ",2);
                
                
                int lamaPinjam = Integer.parseInt(arr5[0]) - Integer.parseInt(arr3[0]);
                int selisih = lamaPinjam - 7;
                if(selisih>0){
                    int dendaTotal = selisih*this.denda;
                    data[6]="Rp" + dendaTotal;
                } else {
                    data[6] = "Rp" + 0;
                }
                
                tabModel2.addRow(data);
            }
            
        } catch (NumberFormatException | SQLException ex){
            System.out.println(ex);
        }
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnLihatDetail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBukuPinjam;
    private javax.swing.JTable tblCariBuku;
    private javax.swing.JTextField tfCariBuku;
    // End of variables declaration//GEN-END:variables
}
