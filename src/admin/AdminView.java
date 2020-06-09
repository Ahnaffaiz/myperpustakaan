/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import dbconnection.MySQLConnection;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login.HalLogin;

/**
 *
 * @author ahnaffaiz
 */
public final class AdminView extends javax.swing.JFrame {
    
    public String id, judul, sampul, jenis, pengarang, penerbit, tahun, stok, dipinjam, tersedia;
    public DefaultTableModel tabModel;
    

    /**
     * Creates new form View
     */
    public AdminView() {
        super("Aplikasi Perpustakaan");
        initComponents();
        setJudul();
        showData();
        btnUbah.setVisible(false);
        btnHapus.setVisible(false);
        btnDetail.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenu1 = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfKodeBuku = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfJudul = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbJenis = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tfPengarang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfPenerbit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfTahun = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfStok = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfDipinjam = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuku = new javax.swing.JTable();
        btnDetail = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("jRadioButtonMenuItem2");

        jMenu1.setText("jMenu1");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dashboard Admin");
        jLabel1.setMaximumSize(new java.awt.Dimension(1000, 600));
        jLabel1.setMinimumSize(new java.awt.Dimension(1000, 600));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Daftar Buku");

        jLabel3.setText("Kode");

        tfKodeBuku.setMinimumSize(new java.awt.Dimension(150, 21));
        tfKodeBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKodeBukuActionPerformed(evt);
            }
        });

        jLabel4.setText("Judul");

        jLabel5.setText("Jenis");

        cbJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Novel", "Ensiklopedi", "Biografi", "Ilmiah", "Astronomi", "Saintek", "Agama", "Panduan", "Soshum" }));

        jLabel6.setText("Pengarang");

        jLabel7.setText("Penerbit");

        jLabel8.setText("Tahun Terbit");

        jLabel9.setText("Stok");

        jLabel10.setText("Dipinjam");

        btnTambah.setText("Tambah");
        btnTambah.setMaximumSize(new java.awt.Dimension(150, 27));
        btnTambah.setMinimumSize(new java.awt.Dimension(150, 27));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.setPreferredSize(new java.awt.Dimension(150, 27));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tblBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBuku);

        btnDetail.setText("Detail");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKeluar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(90, 90, 90)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tfPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tfPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tfTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(96, 96, 96)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfStok, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfDipinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1)))
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfDipinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset)
                    .addComponent(btnDetail)
                    .addComponent(btnHapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnKeluar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfKodeBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKodeBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfKodeBukuActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        insert();
        showData();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        reset();
        btnTambah.setVisible(true);
        btnUbah.setVisible(false);
        btnDetail.setVisible(false);
        btnHapus.setVisible(false);
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBukuMouseClicked
        // TODO add your handling code here:
        tfKodeBuku.setText(tblBuku.getValueAt(tblBuku.getSelectedRow(), 0).toString());
        tfJudul.setText(tblBuku.getValueAt(tblBuku.getSelectedRow(), 1).toString());
        cbJenis.setSelectedItem(tblBuku.getValueAt(tblBuku.getSelectedRow(), 2).toString());
        tfPengarang.setText(tblBuku.getValueAt(tblBuku.getSelectedRow(), 3).toString());
        tfPenerbit.setText(tblBuku.getValueAt(tblBuku.getSelectedRow(), 4).toString());
        tfTahun.setText(tblBuku.getValueAt(tblBuku.getSelectedRow(), 5).toString());
        tfStok.setText(tblBuku.getValueAt(tblBuku.getSelectedRow(), 6).toString());
        tfDipinjam.setText(tblBuku.getValueAt(tblBuku.getSelectedRow(), 7).toString());
        
        
        btnTambah.setVisible(false);
        btnUbah.setVisible(true);
        btnHapus.setVisible(true);
        btnDetail.setVisible(true);
        
    }//GEN-LAST:event_tblBukuMouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        update();
        showData();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        tfKodeBuku.setText(tblBuku.getValueAt(tblBuku.getSelectedRow(), 0).toString());
        this.id = tfKodeBuku.getText();
        MySQLConnection m = new MySQLConnection();
        Connection koneksi = m.conn;
        try {
            int jawab;
            
            if((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION))==0){
                
                String query = "DELETE FROM `db_buku` WHERE `id_buku`=?";
                
                PreparedStatement statement = koneksi.prepareStatement(query);
                statement.setString(1, id);
                int rowInserted = statement.executeUpdate();
            
                if (rowInserted>0){
                    JOptionPane.showMessageDialog(null, "Hapus data Berhasil");
                } else {
                    
                }
                
                
            }
        }
        
        catch (HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Tidak dapat menghapus buku yang sedang dipinjam");
        }
        
        showData();
        
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new HalLogin().setVisible(true);
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        // TODO add your handling code here:
        String idBook = tfKodeBuku.getText();
        String judulBook = tfJudul.getText();
        String dipinjamBook = tfDipinjam.getText();
        new DetailPeminjamanBuku(idBook, judulBook, dipinjamBook).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDetailActionPerformed

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
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AdminView().setVisible(true);
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbJenis;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBuku;
    private javax.swing.JTextField tfDipinjam;
    private javax.swing.JTextField tfJudul;
    private javax.swing.JTextField tfKodeBuku;
    private javax.swing.JTextField tfPenerbit;
    private javax.swing.JTextField tfPengarang;
    private javax.swing.JTextField tfStok;
    private javax.swing.JTextField tfTahun;
    // End of variables declaration//GEN-END:variables

    public void setJudul(){
        Object[] title = {
            "kode","Judul", "Jenis", "Pengarang", "Penerbit", "Tahun Terbit", "Stok", "Dipinjam", "Tersedia"  
        };
        tabModel = new DefaultTableModel(null, title);
        tblBuku.setModel(tabModel);
    }
    
    public void insert(){
        this.id = tfKodeBuku.getText();
        this.judul = tfJudul.getText();
        this.jenis = (String) cbJenis.getSelectedItem();
        this.pengarang = tfPengarang.getText();
        this.penerbit = tfPenerbit.getText();
        this.tahun = tfTahun.getText();
        this.stok = tfStok.getText();
        this.dipinjam = tfDipinjam.getText();
        
        MySQLConnection koneksi = new MySQLConnection();
        AdminController admin = new AdminController();
        admin.insertBuku(koneksi, id, judul, sampul, jenis, pengarang, penerbit, tahun, stok, dipinjam);
        koneksi.close();
        
    }
    
    public void showData(){
        MySQLConnection m = new MySQLConnection();
        Connection koneksi = m.conn;
        Object[] data = new Object[9];
        Object[] date = new Object[3];
        
        tabModel.getDataVector().removeAllElements();
        tabModel.fireTableDataChanged();
        
        String query = "SELECT * FROM db_buku";
        
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
        
        reset();
    }
    
    
    public void reset(){
        tfKodeBuku.setText("");
        tfJudul.setText("");
        cbJenis.setSelectedItem("Novel");
        tfPengarang.setText("");
        tfPenerbit.setText("");
        tfTahun.setText("");
        tfStok.setText("");
        tfDipinjam.setText("");
    }
    
    public void update(){
        this.id = tfKodeBuku.getText();
        this.judul = tfJudul.getText();
        this.jenis = (String) cbJenis.getSelectedItem();
        this.pengarang = tfPengarang.getText();
        this.penerbit = tfPenerbit.getText();
        this.tahun = tfTahun.getText();
        this.stok = tfStok.getText();
        this.dipinjam = tfDipinjam.getText();
        
        MySQLConnection koneksi = new MySQLConnection();
        AdminController admin = new AdminController();
        admin.updateBuku(koneksi, id, judul, jenis, pengarang, penerbit, tahun, stok, dipinjam);
        koneksi.close();
        JOptionPane.showMessageDialog(null, "Ubah data Berhasil");
    }

}


