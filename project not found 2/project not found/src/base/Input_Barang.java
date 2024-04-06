/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package base;

import koneksi.Koneksi;
import Barcode.main;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Input_Barang extends javax.swing.JPanel {
    Koneksi koneksi= new Koneksi();
    private DefaultTableModel model;
    
  private void autoNumberBarang(String jenisBarang) {   
    try {
        Connection c = koneksi.getKoneksi();
        java.sql.Statement s = c.createStatement();
        
        // Query untuk mendapatkan kode barang terakhir berdasarkan jenis barang
        String sql = "SELECT * FROM `barang` WHERE jenis_barang = '" + jenisBarang + "' ORDER BY kode_barang DESC";
        ResultSet r = s.executeQuery(sql);
        
        if(r.next()) {
            String kodeBarang = r.getString("kode_barang");
            String kodeJenis = kodeBarang.substring(0, 2);
            String NoFaktur = kodeBarang.substring(2);
            String BR = "" + (Integer.parseInt(NoFaktur) + 1);
            String Nol = "";
        
            if (BR.length() == 1) {
                Nol = "00";
            } else if (BR.length() == 2) {
                Nol = "0";
            } else if (BR.length() == 3) {
                Nol = "";
            } else if (BR.length() == 4) {
                Nol = "";
            }
            tx_KodeBarang.setText(kodeJenis + Nol + BR);
        } else {
            // Jika tidak ada data barang dengan jenis yang dipilih, gunakan kode default
            if (jenisBarang.equals("Kaos")) {
                tx_KodeBarang.setText("KA001");
            } else if (jenisBarang.equals("Kemeja")) {
                tx_KodeBarang.setText("KE001");
            } else if (jenisBarang.equals("Celana")) {
                tx_KodeBarang.setText("CE001");
            } else if (jenisBarang.equals("Tas")) {
                tx_KodeBarang.setText("TA001");
            }
        }
        r.close();
        s.close();
    } catch(Exception e){
        System.out.println("autonumber error");
    }

}
    
    public void loadData(){
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.addRow(new Object[]{
        tx_KodeBarang.getText(),
        tx_NamaBarang.getText(),
        tx_JenisBarang.getSelectedItem(),
        tx_Ukuran.getSelectedItem(),
         txHarga.getText(),
         txHarga1.getText(),
        tx_Jumlah.getText(),
    });
}

public void kosong(){
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
    while (model.getRowCount()>0){
        model.removeRow(0);
    }
} 

public void clear() {
    tx_KodeBarang.setText("");
    tx_NamaBarang.setText("");
    tx_Jumlah.setText("");
    txHarga.setText("");
    txHarga1.setText("");
}
    
    public void loadDataBarang(){
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
    
    try{
        Connection c = koneksi.getKoneksi();
        java.sql.Statement s = c.createStatement();
        
        String sql = "SELECT * FROM barang";
        ResultSet r = s.executeQuery(sql);
        
        while(r.next()){
            Object[] obj = new Object[7];
            obj [0] = r.getString("kode_barang");
            obj [1] = r.getString("nama_barang");
            obj [2] = r.getString("jenis_barang");
            obj [3] = r.getString("ukuran");
            obj [4] = r.getString("harga_beli");
            obj [5] = r.getString("harga_jual");
            obj [6] = r.getString("jumlah");
            
            model.addRow(obj);
        }
        r.close();
        s.close();
    }catch(Exception e){
        e.printStackTrace();
    }
}


    /**
     * Creates new form Input_Barang
     */
        public Input_Barang() {
            initComponents();
            
            
            
        model = new DefaultTableModel();
        
        jTable1.setModel(model);
        //InputBarang
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jenis Barang");
        model.addColumn("Ukuran");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        model.addColumn("Jumlah");
        loadDataBarang();
        
        
    }
    
   
    
    
    
    
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        main_panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txHarga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tx_NamaBarang = new javax.swing.JTextField();
        tx_KodeBarang = new javax.swing.JTextField();
        tx_JenisBarang = new javax.swing.JComboBox<>();
        tx_Ukuran = new javax.swing.JComboBox<>();
        txHarga1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tx_Jumlah = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_Tambah = new javax.swing.JButton();
        btn_Barcode = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(520, 422));
        setLayout(new java.awt.CardLayout());

        main_panel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Kode Barang");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Nama Barang");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Jenis Barang");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Jumlah");

        txHarga.setBackground(new java.awt.Color(182, 69, 44));
        txHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txHargaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Ukuran");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Harga Beli");

        tx_NamaBarang.setBackground(new java.awt.Color(182, 69, 44));
        tx_NamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_NamaBarangActionPerformed(evt);
            }
        });

        tx_KodeBarang.setBackground(new java.awt.Color(182, 69, 44));

        tx_JenisBarang.setBackground(new java.awt.Color(182, 69, 44));
        tx_JenisBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kaos", "Kemeja", "Celana", "Tas" }));
        tx_JenisBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_JenisBarangActionPerformed(evt);
            }
        });

        tx_Ukuran.setBackground(new java.awt.Color(182, 69, 44));
        tx_Ukuran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M,", "L", "XL", "XXL", "XXXL", "-" }));

        txHarga1.setBackground(new java.awt.Color(182, 69, 44));
        txHarga1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txHarga1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Harga Jual");

        tx_Jumlah.setBackground(new java.awt.Color(182, 69, 44));
        tx_Jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_JumlahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tx_NamaBarang)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tx_KodeBarang))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tx_Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(tx_Ukuran, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_JenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(txHarga1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_KodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tx_Ukuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tx_Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_NamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tx_JenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txHarga1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Input Barang");

        jScrollPane3.setBorder(null);
        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(221, 197, 162));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Jenis Barang", "Ukuran", "Harga Beli", "Harga Jual", "Jumlah"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setOpaque(false);
        jTable1.setRowHeight(25);
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(jTable1);

        btn_Tambah.setBackground(new java.awt.Color(182, 69, 44));
        btn_Tambah.setText("Simpan");
        btn_Tambah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 197, 162), 3));
        btn_Tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TambahMouseClicked(evt);
            }
        });
        btn_Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TambahActionPerformed(evt);
            }
        });

        btn_Barcode.setBackground(new java.awt.Color(182, 69, 44));
        btn_Barcode.setText("Barcode");
        btn_Barcode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 197, 162), 3));
        btn_Barcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_BarcodeMouseClicked(evt);
            }
        });
        btn_Barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BarcodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout main_panelLayout = new javax.swing.GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(main_panelLayout.createSequentialGroup()
                .addGroup(main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(main_panelLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main_panelLayout.createSequentialGroup()
                        .addContainerGap(70, Short.MAX_VALUE)
                        .addGroup(main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(main_panelLayout.createSequentialGroup()
                                .addComponent(btn_Tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btn_Barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(69, 69, 69)))
                .addContainerGap())
        );
        main_panelLayout.setVerticalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        add(main_panel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1AncestorAdded

    private void btn_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TambahActionPerformed
        // TODO add your handling code here:
                DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
         
try {
            Connection c = koneksi.getKoneksi();
                int baris = jTable1.getRowCount();
                String kodeBarang= tx_KodeBarang.getText();
                double hargaBeli = Double.parseDouble(txHarga.getText());
                int jumlah = Integer.parseInt(tx_Jumlah.getText());
                String ukuran = (String) tx_Ukuran.getSelectedItem();
                Double hargaJual = Double.parseDouble(txHarga1.getText());
                String jenisBarang = (String) tx_JenisBarang.getSelectedItem();
                String namaBarang = tx_NamaBarang.getText();  
             String sql = "INSERT INTO barang (kode_barang, nama_barang, jenis_barang, ukuran, harga_beli, harga_jual, jumlah) VALUES (?, ?, ?, ?, ?, ?, ?)";
            java.sql.PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, kodeBarang); 
            p.setString(2, namaBarang); 
            p.setString(3, jenisBarang); // K
            p.setString(4, ukuran); // Kolom 4: Ukuran
            p.setDouble(5, hargaBeli); // Kolom 5: Harga Jual
            p.setDouble(6, hargaJual); // Kolom 6: Jenis barang
            p.setInt(7, jumlah); // Kolom 7: nama barang

                  p.executeUpdate();
                  p.close();
 
loadData();
clear();
JOptionPane.showMessageDialog(null, "Data Tersimpan");
    }catch (SQLException e) {
        System.out.println(e);
    }
    }//GEN-LAST:event_btn_TambahActionPerformed

    private void btn_BarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BarcodeActionPerformed
        // TODO add your handling code here:   
    String kodeBarang = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
    main barcodeFrame = new main(kodeBarang);
    barcodeFrame.setVisible(true);
    }//GEN-LAST:event_btn_BarcodeActionPerformed

    private void txHarga1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txHarga1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txHarga1ActionPerformed

    private void tx_JenisBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_JenisBarangActionPerformed
        // TODO add your handling code here:
        String jenisBarang = (String) tx_JenisBarang.getSelectedItem();
        autoNumberBarang(jenisBarang);
    }//GEN-LAST:event_tx_JenisBarangActionPerformed

    private void tx_NamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_NamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_NamaBarangActionPerformed

    private void txHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txHargaActionPerformed

    private void tx_JumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_JumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_JumlahActionPerformed

    private void btn_TambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TambahMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TambahMouseClicked

    private void btn_BarcodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BarcodeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_BarcodeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Barcode;
    private javax.swing.JButton btn_Tambah;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel main_panel;
    public static javax.swing.JTextField txHarga;
    public static javax.swing.JTextField txHarga1;
    private javax.swing.JComboBox<String> tx_JenisBarang;
    public static javax.swing.JTextField tx_Jumlah;
    public static javax.swing.JTextField tx_KodeBarang;
    public static javax.swing.JTextField tx_NamaBarang;
    private javax.swing.JComboBox<String> tx_Ukuran;
    // End of variables declaration//GEN-END:variables
}