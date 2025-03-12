/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package databasemenu.stok;

import databasemenu.menu;anjaiii
import hai.Konektor;
import hai.NewJFrame;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class beli extends javax.swing.JFrame {

     Connection conn;
    PreparedStatement pst;
    public ResultSet rs;
    Color homecliked;
    
    public beli() {
    initComponents();
         conn = Konektor.getConnection();
         setLocationRelativeTo(null); 
        tampil();
        id();
        PJ();

         homecliked = new Color (1, 125, 67);
            
            tr1.setVisible(false);
            tr2.setVisible(false);
            lp1.setVisible(false);
            lp2.setVisible(false);
    }
    public void tampil() {
    try {
       
        pst = conn.prepareStatement("SELECT id_transaksi, tanggal_transaksi, jumlah, id_barang,"
                + "merk_barang,harga, id_penjual FROM transaksi_pembelian");
        rs = pst.executeQuery();
        ResultSetMetaData rss = rs.getMetaData();
        int j = rss.getColumnCount();
        
        DefaultTableModel df = (DefaultTableModel) tabelb.getModel();
        df.setRowCount(0);
        
        while (rs.next()) {
            Vector<String> v2 = new Vector<>();
            for (int a = 1; a <= j; a++) {
                v2.add(rs.getString(a)); 
            }
            df.addRow(v2);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(Konektor.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    } finally {

        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (SQLException e) {
            Logger.getLogger(Konektor.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    }
    
     public void id() {
    try {
        String query = "SELECT id_barang, merk_barang, harga_beli FROM barang";
        pst = conn.prepareStatement(query);
        rs = pst.executeQuery();
        t_idb.removeAllItems(); // Hapus semua item yang ada di combobox
        while (rs.next()) {
            String id_barang = rs.getString("id_barang"); 
            String merk_barang = rs.getString("merk_barang");
            String harga_beli = rs.getString("harga_beli");
            String combined = id_barang + " - "+ merk_barang+" - "+ harga_beli;
            t_idb.addItem(combined);
        }
    } catch (SQLException ex) {
        Logger.getLogger(jual.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (SQLException e) {
            Logger.getLogger(jual.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
     private String getSelectedIdTransaksi() {
    int selectedRow = tabelb.getSelectedRow(); 
    if (selectedRow != -1) { 
        return tabelb.getValueAt(selectedRow, 0).toString(); 
    } else {
        JOptionPane.showMessageDialog(this, "Silakan pilih transaksi dari tabel!", "Pesan", JOptionPane.WARNING_MESSAGE);
        return null; 
    }
}
        private void PJ() {
        try {
            // Membuat query
            String query = "SELECT DISTINCT id_penjual FROM penjual";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            t_idp.removeAllItems();

            while (rs.next()) {
               String id_penjual = rs.getString("id_penjual"); 
               
               t_idp.addItem(id_penjual);
            }
        } catch (SQLException ex) {
            Logger.getLogger(jual.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException e) {
                Logger.getLogger(jual.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
        public void openStokBaru() { 
            
        } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        mstok = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        tr = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        tr2 = new javax.swing.JButton();
        tr1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lp = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        lp2 = new javax.swing.JButton();
        lp1 = new javax.swing.JButton();
        t_jumlah = new javax.swing.JTextField();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        Tambah = new javax.swing.JButton();
        neo = new javax.swing.JButton();
        tgl = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelb = new javax.swing.JTable();
        t_idb = new javax.swing.JComboBox<>();
        t_idp = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);

        home.setOpaque(false);
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeMousePressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/s/icons8-home-50.png"))); // NOI18N
        home.add(jLabel2);

        jPanel3.setOpaque(false);
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        mstok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/s/Desain tanpa judul 2.png"))); // NOI18N
        jPanel3.add(mstok);

        jPanel4.setOpaque(false);

        tr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/s/Desain tanpa judul (1) 1 (1).png"))); // NOI18N
        tr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                trMousePressed(evt);
            }
        });
        tr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trActionPerformed(evt);
            }
        });

        jPanel9.setOpaque(false);

        tr2.setText("Transaksi pembalian");
        tr2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tr2ActionPerformed(evt);
            }
        });

        tr1.setText("Transaksi penjualan");
        tr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tr1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tr2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tr1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(tr1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tr2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(tr)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tr)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setOpaque(false);

        jPanel6.setOpaque(false);

        lp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/s/Desain tanpa judul (2) 1 (2).png"))); // NOI18N
        lp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lpMouseClicked(evt);
            }
        });
        lp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lpActionPerformed(evt);
            }
        });
        jPanel6.add(lp);

        jPanel8.setOpaque(false);

        lp2.setText("Laporan pengeluaran");
        lp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lp2ActionPerformed(evt);
            }
        });

        lp1.setText("Laporan pendapatan");
        lp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lp1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lp2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lp1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 340, 560));

        t_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_jumlahActionPerformed(evt);
            }
        });
        getContentPane().add(t_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 540, -1));

        ubah.setBackground(new java.awt.Color(49, 187, 61));
        ubah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ubah.setText("Ubah");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        getContentPane().add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 110, 40));

        hapus.setBackground(new java.awt.Color(49, 187, 61));
        hapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 110, 40));

        Tambah.setBackground(new java.awt.Color(49, 187, 61));
        Tambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Tambah.setText("Tambah");
        Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahActionPerformed(evt);
            }
        });
        getContentPane().add(Tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 350, 110, 40));

        neo.setText("Barang baru");
        neo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neoActionPerformed(evt);
            }
        });
        getContentPane().add(neo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 270, -1));

        tgl.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 540, -1));

        tabelb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Transaksi", "Tanggal Transaksi", "Jumlah", "ID Barang", "Merk barang", "Harga satuan", "ID penjual"
            }
        ));
        tabelb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelb);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 1100, 250));

        t_idb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_idbActionPerformed(evt);
            }
        });
        getContentPane().add(t_idb, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 260, -1));

        t_idp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        t_idp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_idpActionPerformed(evt);
            }
        });
        getContentPane().add(t_idp, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 540, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 81));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/s/icons8-logout-26.png"))); // NOI18N
        jLabel6.setText("keluar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 90, 80));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/s/menu (33).jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1310, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
try {
    String id_transaksi = getSelectedIdTransaksi();
    if (id_transaksi == null) {
        return;
    }
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String tanggal = sdf.format(tgl.getDate());
    int jumlah = Integer.parseInt(t_jumlah.getText());
    String selectedItem = t_idb.getSelectedItem().toString();    
    String[] itemParts = selectedItem.split(" - "); 
    String id_barang = itemParts[0]; 
    String merk_barang = itemParts[1]; 
    int harga_satuan = Integer.parseInt(itemParts[2]); 
    String id_penjual = t_idp.getSelectedItem().toString();
    
    // Menyusun pesan konfirmasi
    String message = String.format("Apakah Anda yakin ingin mengubah data transaksi ini?\n\n"
            + "ID Transaksi: %s\n"
            + "Tanggal: %s\n"
            + "Jumlah: %d\n"
            + "ID Barang: %s\n"
            + "Merk Barang: %s\n"
            + "Harga Satuan: %d\n"
            + "ID Penjual: %s",
            id_transaksi, tanggal, jumlah, id_barang, merk_barang, harga_satuan, id_penjual);

    // Konfirmasi sebelum melakukan update
    int confirm = JOptionPane.showConfirmDialog(this, message, "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return; // Batalkan operasi jika pengguna memilih tidak
    }

    String sql = "UPDATE transaksi_pembelian SET tanggal_transaksi = ?, jumlah = ?, "
            + "id_barang = ?, merk_barang = ?, harga = ?, id_penjual = ? WHERE id_transaksi = ?";
    PreparedStatement pst = conn.prepareStatement(sql);    
    pst.setString(1, tanggal);         
    pst.setInt(2, jumlah);  
    pst.setString(3, id_barang);       
    pst.setString(4, merk_barang);      
    pst.setInt(5, harga_satuan);       
    pst.setString(6, id_penjual);      
    pst.setString(7, id_transaksi);    
    
    int k = pst.executeUpdate(); 
    if (k == 1) {
        JOptionPane.showMessageDialog(this, "Berhasil diubah!");
        tgl.setDate(null); 
        t_jumlah.setText("");
        t_idb.setSelectedItem(null);
        t_idp.setSelectedItem(null);
        id(); 
        PJ();
        tampil();
    } else {
        JOptionPane.showMessageDialog(rootPane, "Gagal diubah!", "Pesan", JOptionPane.ERROR_MESSAGE);
    }
} catch (SQLException ex) {
    Logger.getLogger(Konektor.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(rootPane, "Database error: " + ex.getMessage(), "Pesan", JOptionPane.ERROR_MESSAGE);
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(rootPane, "Input tidak valid!", "Pesan", JOptionPane.ERROR_MESSAGE);
} catch (ArrayIndexOutOfBoundsException ex) {
    JOptionPane.showMessageDialog(rootPane, "Data tidak lengkap!", "Pesan", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
                                      
   try {
    String id_transaksi = getSelectedIdTransaksi();
    if (id_transaksi == null) {
        return;
    }

    // Menyusun pesan konfirmasi
    String message = String.format("Apakah Anda yakin ingin menghapus transaksi ini?\n\n"
            + "ID Transaksi: %s", id_transaksi);

    // Konfirmasi sebelum melakukan penghapusan
    int confirm = JOptionPane.showConfirmDialog(this, message, "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return; // Batalkan operasi jika pengguna memilih tidak
    }

    String deleteBarangQuery = "DELETE FROM transaksi_pembelian WHERE id_transaksi = ?";
    try (PreparedStatement deleteBarangStmt = conn.prepareStatement(deleteBarangQuery)) {
        deleteBarangStmt.setString(1, id_transaksi);
        int k = deleteBarangStmt.executeUpdate();

        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Transaksi berhasil dihapus!");
            tgl.setDate(null); 
            t_jumlah.setText("");
            t_idb.setSelectedItem(null);
            t_idp.setSelectedItem(null);
            tampil(); 
            id();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menghapus transaksi. ID tidak ditemukan.");
        }
    }
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
}
    }//GEN-LAST:event_hapusActionPerformed

    private void tabelbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbMouseClicked
   int row = tabelb.getSelectedRow();  

if (row != -1) { 
    String id_transaksi = tabelb.getValueAt(row, 0).toString(); 
    String tanggal = tabelb.getValueAt(row, 1).toString(); 
    String jumlah = tabelb.getValueAt(row, 2).toString();
    String id_barang = tabelb.getValueAt(row, 3).toString();
    String merk_barang = tabelb.getValueAt(row, 4).toString();
    String harga_satuan = tabelb.getValueAt(row, 5).toString();
    String id_pembeli = tabelb.getValueAt(row, 6).toString();
   
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date tggl = null;
    
    try {
        tggl = sdf.parse(tanggal);
    } catch (ParseException ex) {
        Logger.getLogger(jual.class.getName()).log(Level.SEVERE, null, ex);
    }
    tgl.setDate(tggl); 
    t_jumlah.setText(jumlah); 
    t_idp.setSelectedItem(id_pembeli); 

    String combinedItem = id_barang + " - " + merk_barang + " - " + harga_satuan;

    boolean itemFound = false;
    for (int i = 0; i < t_idb.getItemCount(); i++) {
        if (t_idb.getItemAt(i).equals(combinedItem)) {
            t_idb.setSelectedIndex(i); 
            itemFound = true; 
            break;
        }
    }

    if (!itemFound) {
        t_idb.addItem(combinedItem); 
        t_idb.setSelectedItem(combinedItem); 
    }
}
    }//GEN-LAST:event_tabelbMouseClicked

    private void TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahActionPerformed
                                      
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = sdf.format(tgl.getDate());
        int jumlah = Integer.parseInt(t_jumlah.getText());
        String selectedItem = t_idb.getSelectedItem().toString();      
        String[] itemParts = selectedItem.split(" - "); 
        String id_barang = itemParts[0]; 
        String merk_barang = itemParts[1]; 
        int harga_satuan = Integer.parseInt(itemParts[2]);      
        String id_pembeli = t_idp.getSelectedItem().toString();
        String sql = "INSERT INTO transaksi_pembelian (tanggal_transaksi, jumlah, id_barang,"
                + " merk_barang, harga, id_penjual) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, tanggal);
            pst.setInt(2, jumlah);
            pst.setString(3, id_barang);
            pst.setString(4, merk_barang); 
            pst.setInt(5, harga_satuan);
            pst.setString(6, id_pembeli);

            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Berhasil ditambahkan!");
                tgl.setDate(null); 
                t_jumlah.setText("");
                t_idb.setSelectedItem(null);
                t_idp.setSelectedItem(null);
                tampil();
                id();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal ditambahkan!");
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(Konektor.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Input tidak valid! Pastikan jumlah dan harga adalah angka.");
    } catch (ArrayIndexOutOfBoundsException ex) {
        JOptionPane.showMessageDialog(this, "Data tidak lengkap! Pastikan item terpilih dari daftar.");
    }

    }//GEN-LAST:event_TambahActionPerformed

    private void t_idbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_idbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_idbActionPerformed

    private void t_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_jumlahActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        jPanel2.setBackground(homecliked);
        new NewJFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel2MousePressed

    private void homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMousePressed
        // TODO add your handling code here:
        
        new menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMousePressed

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        // TODO add your handling code here:
       
        new stok().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel3MousePressed

    private void trMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trMouseClicked
        // TODO add your handling code here:
        if (tr.isSelected()) {
            tr1.setVisible(true);
            tr2.setVisible(true);
        } else {
            tr1.setVisible(false);
            tr2.setVisible(false);
        }
    }//GEN-LAST:event_trMouseClicked

    private void trMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_trMousePressed

    private void trActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trActionPerformed

    private void tr2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tr2ActionPerformed
        // TODO add your handling code here:
        new beli().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tr2ActionPerformed

    private void tr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tr1ActionPerformed
        // TODO add your handling code here:
        new jual().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tr1ActionPerformed

    private void lpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lpMouseClicked
        // TODO add your handling code here:
        if (lp.isSelected()) {
            lp1.setVisible(true);
            lp2.setVisible(true);
        } else {
            lp1.setVisible(false);
            lp2.setVisible(false);
        }

    }//GEN-LAST:event_lpMouseClicked

    private void lpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lpActionPerformed

    private void lp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lp2ActionPerformed
        // TODO add your handling code here:
        new lpb().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lp2ActionPerformed

    private void lp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lp1ActionPerformed
        // TODO add your handling code here:
        new lpj().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lp1ActionPerformed

    private void t_idpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_idpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_idpActionPerformed

    private void neoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neoActionPerformed
        // TODO add your handling code here:
        stokbaru sb = new stokbaru(this);
            sb.setVisible(true); 
    }//GEN-LAST:event_neoActionPerformed

    /**
     * @param args the command line arguments
     */
     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                beli mainFrame = new beli(); // Buat instance JFrame utama
                mainFrame.setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Tambah;
    private javax.swing.JButton hapus;
    private javax.swing.JPanel home;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox lp;
    private javax.swing.JButton lp1;
    private javax.swing.JButton lp2;
    private javax.swing.JLabel mstok;
    private javax.swing.JButton neo;
    private javax.swing.JComboBox<String> t_idb;
    private javax.swing.JComboBox<String> t_idp;
    private javax.swing.JTextField t_jumlah;
    private javax.swing.JTable tabelb;
    private com.toedter.calendar.JDateChooser tgl;
    private javax.swing.JCheckBox tr;
    private javax.swing.JButton tr1;
    private javax.swing.JButton tr2;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
