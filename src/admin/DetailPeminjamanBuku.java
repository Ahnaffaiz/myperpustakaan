/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;


import dbconnection.MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ahnaffaiz
 */
public final class DetailPeminjamanBuku extends javax.swing.JFrame {
    
    public String id, judul, status;
    public int dipinjam;
    public DefaultTableModel tabModel;

    /**
     * Creates new form DetailPeminjamanBuku
     */
    public DetailPeminjamanBuku() {
        super("Detail Peminjaman Buku");
        initComponents();
        btnDikembalikan.setVisible(false);
    }
    
    public DetailPeminjamanBuku(String idBook, String judulBook, String dipinjamBook) {
        super("Detail Peminjaman Buku");
        initComponents();
        this.id = idBook;
        this.judul = judulBook;
        this.dipinjam = Integer.parseInt(dipinjamBook);
        System.out.println(this.dipinjam);
        tvJudul.setText(this.judul);
        setJudul();
        showDataPinjam();
        btnDikembalikan.setVisible(false);
    }
    
    public void setJudul(){
        Object[] title = {
            "ID Peminjaman","Peminjam","Kode Buku", "Tanggal Pinjam", "Tanggal dikembalikan", "status"  
        };
        tabModel = new DefaultTableModel(null, title);
        tblBukuPinjam.setModel(tabModel);
    }
    
    public void showDataPinjam(){
        MySQLConnection m = new MySQLConnection();
        Connection koneksi = m.conn;
        Object[] data;
        data = new Object[6];
        
        tabModel.getDataVector().removeAllElements();
        tabModel.fireTableDataChanged();
        
        String query = "SELECT db_peminjaman.id_peminjaman, db_users.name, db_buku.id_buku, db_peminjaman.tgl_awal, db_peminjaman.tgl_akhir, db_peminjaman.status FROM db_users, db_buku, db_peminjaman WHERE db_peminjaman.id_buku = '" + this.id +"' AND db_buku.id_buku = db_peminjaman.id_buku and db_users.rules='user' AND db_peminjaman.id_user = db_users.id_user";
        System.out.println(this.id);
        try {
            Statement statement = koneksi.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while(result.next()){
                data[0] = result.getString("id_peminjaman");
                data[1] = result.getString("name");
                data[2] = result.getString("id_buku");
                data[3] = result.getString("tgl_awal");
                data[4] = result.getString("tgl_akhir");
                int cek = Integer.parseInt(result.getString("status"));
                if(cek == 1){
                    data[5] = "Dikembalikan";
                } else {
                    data[5] = "Belum dikembalikan";
                }
                
                tabModel.addRow(data);
            }

        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        
    }
    
    public void updateStatus(String id){
        AdminController admin = new AdminController();
        admin.updateStatus(id);
        this.dipinjam -= 1;
        admin.updateStok(this.dipinjam, this.id);
        JOptionPane.showMessageDialog(null, "Ubah status Berhasil");
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tvJudul = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBukuPinjam = new javax.swing.JTable();
        btnDikembalikan = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        tvJudul.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        tvJudul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tvJudul.setText("Judul Buku");

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
        jScrollPane1.setViewportView(tblBukuPinjam);

        btnDikembalikan.setText("Tandai Dikembalikan");
        btnDikembalikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDikembalikanActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tvJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDikembalikan)
                        .addGap(18, 18, 18)
                        .addComponent(btnKembali))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tvJudul)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDikembalikan)
                    .addComponent(btnKembali))
                .addContainerGap(229, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        new AdminView().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnDikembalikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDikembalikanActionPerformed
        // TODO add your handling code here:
        String idBook = tblBukuPinjam.getValueAt(tblBukuPinjam.getSelectedRow(), 0).toString();
        updateStatus(idBook);
        showDataPinjam();
    }//GEN-LAST:event_btnDikembalikanActionPerformed

    private void tblBukuPinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBukuPinjamMouseClicked
        // TODO add your handling code here:
        if(tblBukuPinjam.getValueAt(tblBukuPinjam.getSelectedRow(), 5).toString().equals("Belum dikembalikan")){
            btnDikembalikan.setVisible(true);
        } else {
            btnDikembalikan.setVisible(false);
        }
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
            java.util.logging.Logger.getLogger(DetailPeminjamanBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DetailPeminjamanBuku().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDikembalikan;
    private javax.swing.JButton btnKembali;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBukuPinjam;
    private javax.swing.JLabel tvJudul;
    // End of variables declaration//GEN-END:variables
}
