/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main.panel;

import main.frame.MainUI;
import main.utility.JDBCUtil;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author bryan
 */
public class PanelPenjualanBarang extends javax.swing.JPanel {

    private MainUI mainFrame;
    private Connection conn;
    private PreparedStatement stmnt;
    private int price, total, totalPrice, money, back, barangId, pengadaanBarangId, karyawanId, pelangganId, pengadaanBarangStock;
    private String brand, typenVariant, color, namaKaryawan, namaPelanggan;
    private Timestamp time_in, time_out;

    private final String GET_BARANG_AND_PENGADAAN_BARANG =
            "SELECT brg.brand, brg.type_and_variant, brg.color, brg.price_out, pngdn_brg.id AS id, pngdn_brg.stock, pngdn_brg.time_in, pngdn_brg.barang_id " +
            "FROM pengadaan_barang pngdn_brg " +
            "INNER JOIN barang brg " +
            "ON pngdn_brg.barang_id = brg.id " +
            "WHERE pngdn_brg.id = ?;";

    private final String GET_KARYAWAN_BY_ID =
            "SELECT * FROM karyawan WHERE id = ?;";

    private final String GET_PELANGGAN_BY_ID =
            "SELECT * FROM pelanggan WHERE id = ?;";

    /**
     * Creates new form PanelPenjualanBarang
     */
    public PanelPenjualanBarang(MainUI mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
    }

    public PanelPenjualanBarang(MainUI mainFrame, int id) {
        initComponents();
        this.mainFrame = mainFrame;
        tfId.setText(String.valueOf(id));
        btnCekActionPerformed(null);
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
        tfId = new javax.swing.JTextField();
        btnCek = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        tfJumlahBarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfUangPelanggan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfKembalian = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfIdKaryawan = new javax.swing.JTextField();
        btnCekKaryawan = new javax.swing.JButton();
        tfIdPelanggan = new javax.swing.JTextField();
        btnCekPelanggan = new javax.swing.JButton();
        btnBelumInpPelanggan = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(750, 300));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Penjualan Barang");

        jLabel2.setText("Kode barang :");

        tfId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfIdKeyTyped(evt);
            }
        });

        btnCek.setText("Set");
        btnCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekActionPerformed(evt);
            }
        });

        textArea1.setColumns(20);
        textArea1.setRows(5);
        jScrollPane1.setViewportView(textArea1);

        jLabel3.setText("Jumlah barang :");

        tfJumlahBarang.setEditable(false);
        tfJumlahBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfJumlahBarangKeyTyped(evt);
            }
        });

        jLabel4.setText("Uang pelanggan :");

        tfUangPelanggan.setEditable(false);
        tfUangPelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfUangPelangganKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfUangPelangganKeyTyped(evt);
            }
        });

        jLabel5.setText("Kembalian :");

        tfKembalian.setEditable(false);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel6.setText("Id karyawan :");

        jLabel7.setText("Id pelanggan :");

        tfIdKaryawan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfIdKaryawanKeyTyped(evt);
            }
        });

        btnCekKaryawan.setText("Set");
        btnCekKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekKaryawanActionPerformed(evt);
            }
        });

        tfIdPelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfIdPelangganKeyTyped(evt);
            }
        });

        btnCekPelanggan.setText("Set");
        btnCekPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekPelangganActionPerformed(evt);
            }
        });

        btnBelumInpPelanggan.setText("Belum input pelanggan?");
        btnBelumInpPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBelumInpPelangganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBelumInpPelanggan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfUangPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfIdKaryawan)
                            .addComponent(tfId)
                            .addComponent(tfIdPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCekKaryawan)
                            .addComponent(btnCek)
                            .addComponent(btnCekPelanggan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBelumInpPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCek, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIdKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCekKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIdPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCekPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUangPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // cek barang
    private void btnCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekActionPerformed
        if (tfId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Form kode barang harus diisi");
            return;
        }

        tfId.setEnabled(false);
        btnCek.setText("Cek");

        try {
            conn = JDBCUtil.getConnection();
            stmnt = conn.prepareStatement(GET_BARANG_AND_PENGADAAN_BARANG);
            stmnt.setInt(1, Integer.parseInt(tfId.getText()));
            ResultSet rs = stmnt.executeQuery();
            if (rs.next()) {
                barangId = rs.getInt("barang_id");
                pengadaanBarangId = rs.getInt("id");
                brand = rs.getString("brand");
                typenVariant = rs.getString("type_and_variant");
                color = rs.getString("color");
                price = rs.getInt("price_out");
                time_in = rs.getTimestamp("time_in");
                pengadaanBarangStock = rs.getInt("stock");

                String status = (pengadaanBarangStock < 1) ? "Barang dengan id " + pengadaanBarangId + "\n \t  tidak tersedia" : "Barang dengan id " + pengadaanBarangId + "\n \t  tersedia sebanyak "  + pengadaanBarangStock + " barang";
                String data = "\n Merek\t: " + brand +
                        "\n Tipe & varian\t: " + typenVariant +
                        "\n Warna\t: " + color +
                        "\n Harga jual\t: " + price +
                        "\n Status\t: " + status;

                textArea1.setText(data);
                tfJumlahBarang.setEditable(true);
                tfUangPelanggan.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan");
                tfId.setEnabled(true);
                btnCek.setText("Set");
            }

            rs.close(); stmnt.close(); conn.close();

        } catch (SQLException exc) {
            exc.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error");
        }
    }//GEN-LAST:event_btnCekActionPerformed

    // simpan
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (tfKembalian.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap tekan enter pada form uang pelanggan");
            return;
        }

        if (barangId == 0 || pengadaanBarangId == 0 || karyawanId == 0 || pelangganId == 0) {
            JOptionPane.showMessageDialog(this, "Harap cek barang terlebih dulu");
            return;
        }

        if (pengadaanBarangStock < total) {
            JOptionPane.showMessageDialog(this, "Barang dengan id " + pengadaanBarangId  + " tidak tersedia");
            return;
        }

        int isContinue = JOptionPane.showConfirmDialog(this, "Merek\t: " + brand + "\nTipe dan varian\t: " + typenVariant + "\nKaryawan\t: " + namaKaryawan +  "\nPelanggan\t: " + namaPelanggan,
                "Cek lagi", JOptionPane.YES_NO_OPTION);

        if (isContinue != 0) {
            return;
        }

        System.out.println("Start sync");

        CompletableFuture<Integer> futurePengadaanBarang = CompletableFuture.supplyAsync(() -> {
            try {
                conn = JDBCUtil.getConnection();
                stmnt = conn.prepareStatement("UPDATE pengadaan_barang SET stock = stock - ? WHERE id = ?;");
                stmnt.setInt(1, total);
                stmnt.setInt(2, pengadaanBarangId);
                int affected = stmnt.executeUpdate();
                stmnt.close(); conn.close();
                return affected;
            } catch(SQLException exc) {
                exc.printStackTrace();
            }
            return null;
        });

        CompletableFuture<Integer> futureBarang = CompletableFuture.supplyAsync(() -> {
            try {
                conn = JDBCUtil.getConnection();
                stmnt = conn.prepareStatement("UPDATE barang SET stock = stock - ? WHERE id = ?;");
                stmnt.setInt(1, total);
                stmnt.setInt(2, barangId);
                int affected = stmnt.executeUpdate();
                stmnt.close(); conn.close();
                return affected;
            } catch(SQLException exc) {
                exc.printStackTrace();
            }
            return null;
        });

        System.out.println("End sync");

        total = Integer.parseInt(tfJumlahBarang.getText());
        totalPrice = total * price;
        money = Integer.parseInt(tfUangPelanggan.getText());
        back = money - totalPrice;

        try {
            conn = JDBCUtil.getConnection();
            stmnt = conn.prepareStatement("INSERT INTO penjualan_barang (brand, type_and_variant, color, price, quantity, total_price, customer_money, change_money, time_in, " +
                    "time_out, karyawan_name, pelanggan_name, pengadaan_barang_id, karyawan_id, pelanggan_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

            time_out = new Timestamp(System.currentTimeMillis());
            time_out.setHours(time_out.getHours() - 7);

            stmnt.setString(1, brand);
            stmnt.setString(2, typenVariant);
            stmnt.setString(3, color);
            stmnt.setInt(4, price);
            stmnt.setInt(5, total);
            stmnt.setInt(6, totalPrice);
            stmnt.setInt(7, money);
            stmnt.setInt(8, back);
            stmnt.setTimestamp(9, time_in);
            stmnt.setTimestamp(10, time_out);
            stmnt.setString(11, namaKaryawan);
            stmnt.setString(12, namaPelanggan);
            stmnt.setInt(13, pengadaanBarangId);
            stmnt.setInt(14, karyawanId);
            stmnt.setInt(15, pelangganId);
            int affected = stmnt.executeUpdate();
            int pengadaanBarangAffected = futurePengadaanBarang.get();
            int barangAffected = futureBarang.get();
            System.out.println("Result async1: " + pengadaanBarangAffected);
            System.out.println("Result async2: " + barangAffected);

            if (affected < 0) {
                JOptionPane.showMessageDialog(this, "Data penjualan tidak ter-insert");
            }

            if (pengadaanBarangAffected < 0) {
                JOptionPane.showMessageDialog(this, "Data pengadaan tidak ter-update");
            }

            if (barangAffected < 0) {
                JOptionPane.showMessageDialog(this, "Data produk tidak ter-update");
            }

            stmnt.close(); conn.close();

        } catch (SQLException | InterruptedException | ExecutionException exc) {
            exc.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error");
            return;
        }

//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Popup().setVisible(true);
//            }
//        });
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tfUangPelangganKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUangPelangganKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_tfUangPelangganKeyTyped

    // form uang pelanggan enter generate kembalian
    private void tfUangPelangganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUangPelangganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (tfJumlahBarang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Form jumlah barang harus diisi");
                return;
            }
            int money = Integer.parseInt(tfUangPelanggan.getText());
            int back =  money - (price * Integer.parseInt(tfJumlahBarang.getText()));
            if (back >= 0) {
                tfKembalian.setText(String.valueOf(back));
            } else {
                JOptionPane.showMessageDialog(this, "Uang kurang");
                return;
            }
        }
    }//GEN-LAST:event_tfUangPelangganKeyPressed

    // reset
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        tfId.setText(""); tfId.setEnabled(true);
        tfIdPelanggan.setText(""); tfIdPelanggan.setEnabled(true);
        tfIdKaryawan.setText(""); tfIdKaryawan.setEnabled(true);
        btnCek.setText("Set"); btnCekKaryawan.setText("Set"); btnCekPelanggan.setText("Set");
        tfJumlahBarang.setText(""); tfUangPelanggan.setText(""); tfKembalian.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    // cek karyawan
    private void btnCekKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekKaryawanActionPerformed
        if (tfIdKaryawan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Form id karyawan harus diisi");
            return;
        }

        tfIdKaryawan.setEnabled(false);
        btnCekKaryawan.setText("Cek");

        try {
            conn = JDBCUtil.getConnection();
            stmnt = conn.prepareStatement(GET_KARYAWAN_BY_ID);
            stmnt.setInt(1, Integer.parseInt(tfIdKaryawan.getText()));
            ResultSet rs = stmnt.executeQuery();
            if (rs.next()) {
                karyawanId = rs.getInt("id");
                namaKaryawan = rs.getString("nama");

                String data = "\n Nama\t: " +  namaKaryawan +
                        "\n Jabatan\t: " + rs.getString("jabatan") +
                        "\n Alamat\t: " + rs.getString("alamat") +
                        "\n No. Telepon\t: " + rs.getString("no_telepon");

                textArea1.setText(data);
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan");
                tfIdKaryawan.setEnabled(true);
                btnCekKaryawan.setText("Set");
            }

            rs.close(); stmnt.close(); conn.close();

        } catch (SQLException exc) {
            exc.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error");
        }
    }//GEN-LAST:event_btnCekKaryawanActionPerformed

    // cek pelanggan
    private void btnCekPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekPelangganActionPerformed
        if (tfIdPelanggan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Form id pelanggan harus diisi");
            return;
        }

        tfIdPelanggan.setEnabled(false);
        btnCekPelanggan.setText("Cek");

        try {
            conn = JDBCUtil.getConnection();
            stmnt = conn.prepareStatement(GET_PELANGGAN_BY_ID);
            stmnt.setInt(1, Integer.parseInt(tfIdPelanggan.getText()));
            ResultSet rs = stmnt.executeQuery();
            if (rs.next()) {
                pelangganId = rs.getInt("id");
                namaPelanggan = rs.getString("nama");

                String data = "\n Nama\t: " +  namaPelanggan +
                        "\n Alamat\t: " + rs.getString("alamat") +
                        "\n No. Telepon\t: " + rs.getString("no_telepon");

                textArea1.setText(data);
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan");
                tfIdPelanggan.setEnabled(true);
                btnCekPelanggan.setText("Set");
            }

            rs.close(); stmnt.close(); conn.close();

        } catch (SQLException exc) {
            exc.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error");
        }
    }//GEN-LAST:event_btnCekPelangganActionPerformed

    private void tfIdKaryawanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIdKaryawanKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_tfIdKaryawanKeyTyped

    private void tfIdPelangganKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIdPelangganKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_tfIdPelangganKeyTyped

    private void tfJumlahBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfJumlahBarangKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_tfJumlahBarangKeyTyped

    private void tfIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIdKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_tfIdKeyTyped

    private void btnBelumInpPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBelumInpPelangganActionPerformed
        mainFrame.setPanel(new PanelPelanggan());
    }//GEN-LAST:event_btnBelumInpPelangganActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBelumInpPelanggan;
    private javax.swing.JButton btnCek;
    private javax.swing.JButton btnCekKaryawan;
    private javax.swing.JButton btnCekPelanggan;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea1;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdKaryawan;
    private javax.swing.JTextField tfIdPelanggan;
    private javax.swing.JTextField tfJumlahBarang;
    private javax.swing.JTextField tfKembalian;
    private javax.swing.JTextField tfUangPelanggan;
    // End of variables declaration//GEN-END:variables
}
