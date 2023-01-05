/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.panel;

import main.utility.JDBCUtil;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lutfi Subekti
 */
public class Karyawan_UI extends javax.swing.JPanel {
    private void kosong(){
        txt_nama.setText(null);
        cb_jabatan.setSelectedItem(this);
        txt_alamat.setText(null);
        txt_email.setText(null);
        txt_telephone.setText(null);
        buttonGroup1.clearSelection();
        
    }
    
    
    private void TampilData(){
        DefaultTableModel model = (DefaultTableModel) tabelKaryawan.getModel();
//        model.addColumn("NO ID.");
//        model.addColumn("Nama Karyawan");
//        model.addColumn("Jabatan");
//        model.addColumn("Jenis Kelamin");
//        model.addColumn("Alamat");
//        model.addColumn("No Telephone");
//        model.addColumn("E-mail");
        String cariitem = txt_cari.getText();
        
      
        try{
            String sql = "SELECT * FROM karyawan";
            Connection conn = JDBCUtil.getConnection();
            java.sql.PreparedStatement stm = conn.prepareStatement(sql);
            java.sql.ResultSet res = stm.executeQuery();
            model.setRowCount(0);
            while(res.next()){
            model.addRow(new Object[]{res.getInt("id"),res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
            }

            tabelKaryawan.setModel((TableModel) model);
        }catch(SQLException e){
            System.out.println("Error : "+ e.getMessage());
        }
    }

    /**
     * Creates new form Karyawan_UI
     */
    public Karyawan_UI() {
       initComponents();
       TampilData();
       kosong();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelKaryawan = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        btn_hapus = new javax.swing.JButton();
        txt_nama = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        btn_ubah = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        cari = new javax.swing.JButton();
        txt_telephone = new javax.swing.JTextField();
        btn_batal = new javax.swing.JButton();
        txt_cari = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        lb_kelamin = new javax.swing.JLabel();
        btn_laki = new javax.swing.JRadioButton();
        btn_perempuan = new javax.swing.JRadioButton();
        cb_jabatan = new javax.swing.JComboBox<>();
        btn_tambahdata = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("DATA KARYAWAN");

        jLabel7.setText("E-mail");

        jLabel5.setText("Jabatan");

        tabelKaryawan.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Karyawan", "Nama Karyawan", "Jabatan", "Jenis Kelamin", "Alamat", "No Telephone", "E-mail"
            }
        ));
        tabelKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKaryawanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelKaryawan);

        jLabel4.setText("Alamat");

        jLabel3.setText("Nama Karyawan");

        jLabel6.setText("No Telephone");

        txt_alamat.setColumns(20);
        txt_alamat.setRows(5);
        jScrollPane3.setViewportView(txt_alamat);

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_ubah.setText("Ubah");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        cari.setText("Cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                txt_cariKeyPressed(evt);
            }
        });

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        lb_kelamin.setText("Jenis Kelamin");

        buttonGroup1.add(btn_laki);
        btn_laki.setText("Laki-laki");

        buttonGroup1.add(btn_perempuan);
        btn_perempuan.setText("Perempuan");

        cb_jabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT Engineer", "HRD", "Staff" }));

        btn_tambahdata.setText("Tambah Data");
        btn_tambahdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahdataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(lb_kelamin)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_telephone, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_laki)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_perempuan))
                            .addComponent(cb_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_batal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_keluar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_tambahdata))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cari))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_kelamin)
                    .addComponent(btn_laki)
                    .addComponent(btn_perempuan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cari))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_hapus)
                            .addComponent(btn_ubah)
                            .addComponent(btn_simpan)
                            .addComponent(btn_batal)
                            .addComponent(btn_keluar)
                            .addComponent(btn_tambahdata)))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        TampilData();
        
    }//GEN-LAST:event_cariActionPerformed

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here
            TampilData();
        
    }//GEN-LAST:event_txt_cariActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        String jenis = null;
                if(btn_laki.isSelected()){
                    jenis = "Laki-Laki";
                }else if (btn_perempuan.isSelected()){
                    jenis = "Perempuan";
                }
        try{
            String sql = "INSERT INTO karyawan (nama,jabatan,alamat,no_telepon,jenis_kelamin,email) VALUES (?,?,?,?,?,?);";
            Connection conn = (Connection)JDBCUtil.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,txt_nama.getText());
            pstm.setString(2, (String) cb_jabatan.getSelectedItem());
            pstm.setString(3,txt_alamat.getText());
            pstm.setString(4, txt_telephone.getText());
            pstm.setString(5,txt_email.getText());
            pstm.setString(6, jenis);
            pstm.execute();
            TampilData();
            kosong();
            JOptionPane.showMessageDialog(this,"Proses Simpan Data Berhasil..");
            txt_nama.requestFocus();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void btn_tambahdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahdataActionPerformed
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_btn_tambahdataActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        String jenis = null;
                if(btn_laki.isSelected()){
                    jenis = "Laki-Laki";
                }else if (btn_perempuan.isSelected()){
                    jenis = "Perempuan";
                }
        try{
            String sql = "UPDATE karyawan SET id=?,nama=?,jabatan=?,alamat=?,no_telepon=?,jenis_kelamin=?,email=?'";
            Connection conn = (Connection)JDBCUtil.getConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,txt_nama.getText());
            pstm.setString(2, (String) cb_jabatan.getSelectedItem());
            pstm.setString(3,txt_alamat.getText());
            pstm.setString(4, txt_telephone.getText());
            pstm.setString(5,txt_email.getText());
            pstm.setString(6, jenis);
            pstm.execute();
            JOptionPane.showMessageDialog(this,"Edit Data Berhasil..");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        TampilData();
        kosong();

    }//GEN-LAST:event_btn_ubahActionPerformed

    private void tabelKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKaryawanMouseClicked
        // TODO add your handling code here:
        int baris = tabelKaryawan.rowAtPoint(evt.getPoint());
        
        String nama = tabelKaryawan.getValueAt(baris, 1).toString();
        txt_nama.setText(nama);
        
        String jabatan = tabelKaryawan.getValueAt(baris, 2).toString();
        cb_jabatan.setSelectedItem(jabatan);
        
        String alamat = tabelKaryawan.getValueAt(baris, 3).toString();
        txt_alamat.setText(alamat);
        
        String tlp = tabelKaryawan.getValueAt(baris, 4).toString();
        txt_telephone.setText(tlp);
        
        String email = tabelKaryawan.getValueAt(baris, 5).toString();
        txt_email.setText(email);
        
        if(btn_laki.isSelected()){
            btn_laki.setSelected(true);
        }else{
            btn_perempuan.setSelected(true);
        }
       
    }//GEN-LAST:event_tabelKaryawanMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Hapus", "Konfirmasi Dialog ",JOptionPane.YES_NO_OPTION);
        if(ok == 0){
            try{
          String sql = "DELETE FROM karyawan WHERE Id='";
          Connection conn = (Connection )JDBCUtil.getConnection();
          java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
          
          pstm.execute();
          JOptionPane.showMessageDialog(this,"Hapus Data Berhasil..");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        TampilData();
         kosong();
        }
        
       
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void txt_cariKeyPressed(KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            TampilData();
        }
    }//GEN-LAST:event_txt_cariKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JRadioButton btn_laki;
    private javax.swing.JRadioButton btn_perempuan;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambahdata;
    private javax.swing.JButton btn_ubah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cari;
    private javax.swing.JComboBox<String> cb_jabatan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_kelamin;
    private javax.swing.JTable tabelKaryawan;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_telephone;
    // End of variables declaration//GEN-END:variables
}
