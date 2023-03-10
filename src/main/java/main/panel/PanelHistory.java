package main.panel;

import main.frame.MainUI;
import main.utility.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelHistory extends javax.swing.JPanel {

    /**
     * Creates new form panelKaryawan
     */
    private MainUI mainFrame;
    DefaultTableModel dataModel;
    public String id = "";

    public PanelHistory(MainUI mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        updateTable(id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLihatIdPelanggan = new javax.swing.JButton();

        labelId.setText("ID Pelanggan");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Pelanggan", "Barang yang dibeli", "Warna", "Jumlah Beli", "Harga", "Uang", "Kembalian", "Waktu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
        }

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
        jLabel1.setText("History Pelanggan");

        btnLihatIdPelanggan.setText("Lihat id pelanggan?");
        btnLihatIdPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatIdPelangganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSubmit)
                                .addGap(27, 27, 27)
                                .addComponent(btnReset))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelId)
                                .addGap(49, 49, 49)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLihatIdPelanggan))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel1)))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLihatIdPelanggan))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnReset))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clear() {
        txtId.setText(null);

    }

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        String id = txtId.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi id");
            return;
        }

        updateTable(id);
        btnResetActionPerformed(evt);
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtId.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnLihatIdPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatIdPelangganActionPerformed
        mainFrame.setPanel(new PanelPelanggan());
    }//GEN-LAST:event_btnLihatIdPelangganActionPerformed

    public void updateTable(String id) {
        try {
            dataModel = (DefaultTableModel) jTable1.getModel();
            dataModel.setRowCount(0);
            if (!id.equals("")) {

                String sql = "SELECT p.id, p.nama, pb.brand, pb.type_and_variant, pb.color, pb.quantity, pb.total_price, pb.customer_money, pb.change_money, pb.time_out "
                        + "FROM pelanggan p "
                        + "INNER JOIN penjualan_barang pb "
                        + "ON pb.pelanggan_id = p.id "
                        + "WHERE p.id = ?";
                PreparedStatement stat = JDBCUtil.getConnection().prepareStatement(sql);
                stat.setInt(1, Integer.parseInt(id));
                ResultSet res = stat.executeQuery();
                while (res.next()) {
                    dataModel.addRow(new Object[]{res.getInt("id"), res.getString("nama"), res.getString("brand") + " " + res.getString("type_and_variant"), res.getString("color"), res.getString("quantity"), res.getString("total_price"), res.getString("customer_money"), res.getString("change_money"), res.getString("time_out")});

                }
                res.close();
                stat.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelHistory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLihatIdPelanggan;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelId;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
