/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quanlysach;

/**
 *
 * @author Asus
 */
public class Panel_anylist extends javax.swing.JPanel {

    /**
     * Creates new form Panel_anylist
     */
    public Panel_anylist() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnl_ThongKeDoanhThu = new javax.swing.JPanel();
        pnl_TimKiem = new javax.swing.JPanel();
        lb_LoaiThoiGian = new javax.swing.JLabel();
        cb_LoaiThoiGian = new javax.swing.JComboBox<>();
        lb_NgayBatDau = new javax.swing.JLabel();
        choice1 = new java.awt.Choice();
        lb_NgayBatDau1 = new javax.swing.JLabel();
        choice2 = new java.awt.Choice();
        jButton1 = new javax.swing.JButton();
        pnl_ThongKe = new javax.swing.JPanel();
        pnl_TongTien = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        pnl_DoanhThu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        pnl_LoiNhuan = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        pnl_TongSoHoaDon = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnl_ThongKeSanPhamBanChay = new javax.swing.JPanel();
        pnl_TimKiem1 = new javax.swing.JPanel();
        lb_LoaiThoiGian1 = new javax.swing.JLabel();
        cb_LoaiThoiGian1 = new javax.swing.JComboBox<>();
        lb_NgayBatDau2 = new javax.swing.JLabel();
        choice3 = new java.awt.Choice();
        lb_NgayBatDau3 = new javax.swing.JLabel();
        choice4 = new java.awt.Choice();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        pnl_ThongKeDoanhThu.setPreferredSize(new java.awt.Dimension(1600, 265));

        pnl_TimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnl_TimKiem.setPreferredSize(new java.awt.Dimension(1350, 135));
        pnl_TimKiem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_LoaiThoiGian.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_LoaiThoiGian.setText("Loại thời gian:");
        pnl_TimKiem.add(lb_LoaiThoiGian, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 31, 100, 31));

        cb_LoaiThoiGian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Báo cáo theo giờ", "Báo cáo theo ngày", "Báo cáo theo năm" }));
        cb_LoaiThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_LoaiThoiGianActionPerformed(evt);
            }
        });
        pnl_TimKiem.add(cb_LoaiThoiGian, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 36, -1, -1));

        lb_NgayBatDau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_NgayBatDau.setText("Ngày bắt đầu:");
        pnl_TimKiem.add(lb_NgayBatDau, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 100, 31));
        pnl_TimKiem.add(choice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, 150, 31));

        lb_NgayBatDau1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_NgayBatDau1.setText("Ngày kết thúc:");
        pnl_TimKiem.add(lb_NgayBatDau1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1322, 30, 110, 31));
        pnl_TimKiem.add(choice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 21, 150, 50));

        jButton1.setBackground(new java.awt.Color(51, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Tìm Kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnl_TimKiem.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 970, -1));

        pnl_ThongKe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnl_ThongKe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_TongTien.setBackground(new java.awt.Color(255, 255, 102));
        pnl_TongTien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tổng tiền");
        pnl_TongTien.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jScrollPane2.setViewportView(jTextPane1);

        pnl_TongTien.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 83, 240, 30));

        pnl_ThongKe.add(pnl_TongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 294, 139));

        pnl_DoanhThu.setBackground(new java.awt.Color(255, 255, 102));
        pnl_DoanhThu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Doanh thu");
        pnl_DoanhThu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jScrollPane3.setViewportView(jTextPane2);

        pnl_DoanhThu.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 83, 220, 30));

        pnl_ThongKe.add(pnl_DoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 294, 139));

        pnl_LoiNhuan.setBackground(new java.awt.Color(255, 255, 102));
        pnl_LoiNhuan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Lợi nhuận");
        pnl_LoiNhuan.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jScrollPane5.setViewportView(jTextPane4);

        pnl_LoiNhuan.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 83, 220, 30));

        pnl_ThongKe.add(pnl_LoiNhuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 10, 294, 139));

        pnl_TongSoHoaDon.setBackground(new java.awt.Color(255, 255, 102));
        pnl_TongSoHoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tổng số hóa đơn");
        pnl_TongSoHoaDon.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jScrollPane4.setViewportView(jTextPane3);

        pnl_TongSoHoaDon.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 85, 230, 30));

        pnl_ThongKe.add(pnl_TongSoHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 294, 139));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Ngày tạo", "Thuế VAT (10%)", "Tiền vốn", "Doanh thu", "Lợi nhuận"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 6, 1640, 580));

        javax.swing.GroupLayout pnl_ThongKeDoanhThuLayout = new javax.swing.GroupLayout(pnl_ThongKeDoanhThu);
        pnl_ThongKeDoanhThu.setLayout(pnl_ThongKeDoanhThuLayout);
        pnl_ThongKeDoanhThuLayout.setHorizontalGroup(
            pnl_ThongKeDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ThongKeDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ThongKeDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnl_ThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_TimKiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1764, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_ThongKeDoanhThuLayout.setVerticalGroup(
            pnl_ThongKeDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ThongKeDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê doanh thu", pnl_ThongKeDoanhThu);

        pnl_TimKiem1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnl_TimKiem1.setPreferredSize(new java.awt.Dimension(1350, 135));
        pnl_TimKiem1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_LoaiThoiGian1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_LoaiThoiGian1.setText("Loại thời gian:");
        pnl_TimKiem1.add(lb_LoaiThoiGian1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 31, 100, 31));

        cb_LoaiThoiGian1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Báo cáo theo giờ", "Báo cáo theo ngày", "Báo cáo theo năm" }));
        cb_LoaiThoiGian1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_LoaiThoiGian1ActionPerformed(evt);
            }
        });
        pnl_TimKiem1.add(cb_LoaiThoiGian1, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 36, -1, -1));

        lb_NgayBatDau2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_NgayBatDau2.setText("Ngày bắt đầu:");
        pnl_TimKiem1.add(lb_NgayBatDau2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 100, 31));
        pnl_TimKiem1.add(choice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, 150, 31));

        lb_NgayBatDau3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_NgayBatDau3.setText("Ngày kết thúc:");
        pnl_TimKiem1.add(lb_NgayBatDau3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1322, 30, 110, 31));
        pnl_TimKiem1.add(choice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 21, 150, 50));

        jButton2.setBackground(new java.awt.Color(51, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Tìm Kiếm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnl_TimKiem1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 970, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Bảng thống kê sản phẩm bán chạy ");

        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Sản phẩm", "Đã bán", "Đơn giá", "Tổng doanh thu"
            }
        ));
        jScrollPane6.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(731, 731, 731))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_ThongKeSanPhamBanChayLayout = new javax.swing.GroupLayout(pnl_ThongKeSanPhamBanChay);
        pnl_ThongKeSanPhamBanChay.setLayout(pnl_ThongKeSanPhamBanChayLayout);
        pnl_ThongKeSanPhamBanChayLayout.setHorizontalGroup(
            pnl_ThongKeSanPhamBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ThongKeSanPhamBanChayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ThongKeSanPhamBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_TimKiem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnl_ThongKeSanPhamBanChayLayout.setVerticalGroup(
            pnl_ThongKeSanPhamBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ThongKeSanPhamBanChayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_TimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê sản phẩm bán chạy", pnl_ThongKeSanPhamBanChay);

        jLabel4.setText("Thống kê theo nhân viên");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel4)
                .addContainerGap(1323, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel4)
                .addContainerGap(725, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê nhân viên", jPanel3);

        jLabel5.setText("Thống kê theo ca làm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel5)
                .addContainerGap(1281, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel5)
                .addContainerGap(731, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê theo ca làm", jPanel4);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_LoaiThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_LoaiThoiGianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_LoaiThoiGianActionPerformed

    private void cb_LoaiThoiGian1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_LoaiThoiGian1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_LoaiThoiGian1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_LoaiThoiGian;
    private javax.swing.JComboBox<String> cb_LoaiThoiGian1;
    private java.awt.Choice choice1;
    private java.awt.Choice choice2;
    private java.awt.Choice choice3;
    private java.awt.Choice choice4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JLabel lb_LoaiThoiGian;
    private javax.swing.JLabel lb_LoaiThoiGian1;
    private javax.swing.JLabel lb_NgayBatDau;
    private javax.swing.JLabel lb_NgayBatDau1;
    private javax.swing.JLabel lb_NgayBatDau2;
    private javax.swing.JLabel lb_NgayBatDau3;
    private javax.swing.JPanel pnl_DoanhThu;
    private javax.swing.JPanel pnl_LoiNhuan;
    private javax.swing.JPanel pnl_ThongKe;
    private javax.swing.JPanel pnl_ThongKeDoanhThu;
    private javax.swing.JPanel pnl_ThongKeSanPhamBanChay;
    private javax.swing.JPanel pnl_TimKiem;
    private javax.swing.JPanel pnl_TimKiem1;
    private javax.swing.JPanel pnl_TongSoHoaDon;
    private javax.swing.JPanel pnl_TongTien;
    // End of variables declaration//GEN-END:variables
}
