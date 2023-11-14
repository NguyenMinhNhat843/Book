/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.SanPham;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class Panel_bill extends javax.swing.JPanel {
    private HoaDon_DAO hd_dao = new HoaDon_DAO();
    private CardLayout _this_card;
    private JPanel _this_pnl_card_parent;
    private String _this_maNV;
    private ChiTietHoaDon_DAO cthd_dao = new ChiTietHoaDon_DAO();
    private KhachHang_DAO kh_dao = new KhachHang_DAO();
    /**
     * Creates new form Panel_bill
     */
    public Panel_bill(CardLayout card_main, JPanel pnl_card_parent, String maNV) {
        initComponents();
        
        _this_card = card_main;
        _this_pnl_card_parent = pnl_card_parent;
        _this_maNV = maNV;
        
        LoadDuLieuLenTable();
    }
    
    public void LoadDuLieuLenTable() {
        ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
        dsHD = hd_dao.getAllHD();
        
        DefaultTableModel model_dsHD = (DefaultTableModel) table_DSHD.getModel();
        
        for(HoaDon hd : dsHD) {
            Object[] obj = {hd.getMaHD(), hd.getNv().getTenNV(), hd.getKh(), hd.getNgayTao(), hd.getTongTien()};
            
            model_dsHD.addRow(obj);
        }
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
        pnl_HoaDon = new javax.swing.JPanel();
        pnl_top = new javax.swing.JPanel();
        pnl_HD_info = new javax.swing.JPanel();
        pnl_MaHD = new javax.swing.JPanel();
        lbl_MaHD = new javax.swing.JLabel();
        txt_MaHD = new javax.swing.JTextField();
        pnl_NgayTao = new javax.swing.JPanel();
        lbl_NgayTao = new javax.swing.JLabel();
        date_NgayTao = new com.toedter.calendar.JDateChooser();
        pnl_NhanVien = new javax.swing.JPanel();
        lbl_NhanVien = new javax.swing.JLabel();
        txt_NhanVien = new javax.swing.JTextField();
        pnl_KhachHang = new javax.swing.JPanel();
        lbl_KhachHang = new javax.swing.JLabel();
        txt_KhachHang = new javax.swing.JTextField();
        pnl_HD_TimKiem = new javax.swing.JPanel();
        btn_TimKiem = new javax.swing.JButton();
        txt_TimKiem = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        pnl_center = new javax.swing.JPanel();
        pnl_BoLoc = new javax.swing.JPanel();
        pnl_LocTheoNgay_wrap = new javax.swing.JPanel();
        pnl_LocTheoNgay = new javax.swing.JPanel();
        pnl_LocTheoNgay_title = new javax.swing.JPanel();
        lbl_LocTheoNgay_title = new javax.swing.JLabel();
        pnl_Date_LocTheoNgay = new javax.swing.JPanel();
        date_LocTheoNgay = new com.toedter.calendar.JDateChooser();
        pnl_LocTheoKH_wrap = new javax.swing.JPanel();
        pnl_LocTheoKH = new javax.swing.JPanel();
        pnl_LocTheoKH_title = new javax.swing.JPanel();
        lbl_LocTheoKH_title = new javax.swing.JLabel();
        pnl_txt_LocTheoKH = new javax.swing.JPanel();
        txt_LocTheoKH = new javax.swing.JTextField();
        pnl_LocTheoNV_wrap = new javax.swing.JPanel();
        pnl_LocTheoNV = new javax.swing.JPanel();
        pnl_LocTheoNV_title = new javax.swing.JPanel();
        lbl_LocTheoNgay_title2 = new javax.swing.JLabel();
        pnl_txt_LocTheoNV = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        pnl_Tabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_DSHD = new javax.swing.JTable();
        pnl_XuatHoaDon = new javax.swing.JPanel();
        btn_InHD = new javax.swing.JButton();
        btn_XemChiTiet = new javax.swing.JButton();
        pnl_DoiTra = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(1280, 362));
        setPreferredSize(new java.awt.Dimension(476, 450));
        setLayout(new java.awt.BorderLayout());

        pnl_HoaDon.setLayout(new java.awt.BorderLayout());

        pnl_top.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Hóa Đơn"));
        pnl_top.setPreferredSize(new java.awt.Dimension(10, 220));
        pnl_top.setLayout(new java.awt.BorderLayout());

        pnl_HD_info.setPreferredSize(new java.awt.Dimension(10, 100));
        pnl_HD_info.setLayout(new java.awt.GridLayout(2, 4));

        lbl_MaHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_MaHD.setText("Mã HD:");
        lbl_MaHD.setPreferredSize(new java.awt.Dimension(120, 25));
        pnl_MaHD.add(lbl_MaHD);

        txt_MaHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_MaHD.setPreferredSize(new java.awt.Dimension(500, 40));
        pnl_MaHD.add(txt_MaHD);

        pnl_HD_info.add(pnl_MaHD);

        lbl_NgayTao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_NgayTao.setText("Ngày Tạo:");
        lbl_NgayTao.setPreferredSize(new java.awt.Dimension(120, 25));
        pnl_NgayTao.add(lbl_NgayTao);

        date_NgayTao.setPreferredSize(new java.awt.Dimension(500, 40));
        pnl_NgayTao.add(date_NgayTao);

        pnl_HD_info.add(pnl_NgayTao);

        lbl_NhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_NhanVien.setText("Nhân Viên: ");
        lbl_NhanVien.setPreferredSize(new java.awt.Dimension(120, 25));
        pnl_NhanVien.add(lbl_NhanVien);

        txt_NhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_NhanVien.setPreferredSize(new java.awt.Dimension(500, 40));
        pnl_NhanVien.add(txt_NhanVien);

        pnl_HD_info.add(pnl_NhanVien);

        lbl_KhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_KhachHang.setText("Khách Hàng:");
        lbl_KhachHang.setPreferredSize(new java.awt.Dimension(120, 25));
        pnl_KhachHang.add(lbl_KhachHang);

        txt_KhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_KhachHang.setPreferredSize(new java.awt.Dimension(500, 40));
        pnl_KhachHang.add(txt_KhachHang);

        pnl_HD_info.add(pnl_KhachHang);

        pnl_top.add(pnl_HD_info, java.awt.BorderLayout.NORTH);

        pnl_HD_TimKiem.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        pnl_HD_TimKiem.setPreferredSize(new java.awt.Dimension(10, 70));
        pnl_HD_TimKiem.setLayout(new java.awt.BorderLayout());

        btn_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_TimKiem.setText("Tìm kiếm");
        pnl_HD_TimKiem.add(btn_TimKiem, java.awt.BorderLayout.WEST);

        txt_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pnl_HD_TimKiem.add(txt_TimKiem, java.awt.BorderLayout.CENTER);

        pnl_top.add(pnl_HD_TimKiem, java.awt.BorderLayout.CENTER);
        pnl_top.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pnl_HoaDon.add(pnl_top, java.awt.BorderLayout.NORTH);

        pnl_center.setLayout(new java.awt.BorderLayout());

        pnl_BoLoc.setPreferredSize(new java.awt.Dimension(10, 150));
        pnl_BoLoc.setLayout(new java.awt.GridLayout(1, 3));

        pnl_LocTheoNgay_wrap.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnl_LocTheoNgay_wrap.setLayout(new java.awt.BorderLayout());

        pnl_LocTheoNgay.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 10, 30));
        pnl_LocTheoNgay.setLayout(new java.awt.GridLayout(2, 1));

        pnl_LocTheoNgay_title.setLayout(new java.awt.BorderLayout());

        lbl_LocTheoNgay_title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_LocTheoNgay_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_LocTheoNgay_title.setText("Lọc theo ngày");
        pnl_LocTheoNgay_title.add(lbl_LocTheoNgay_title, java.awt.BorderLayout.CENTER);

        pnl_LocTheoNgay.add(pnl_LocTheoNgay_title);

        pnl_Date_LocTheoNgay.setLayout(new java.awt.BorderLayout());
        pnl_Date_LocTheoNgay.add(date_LocTheoNgay, java.awt.BorderLayout.CENTER);

        pnl_LocTheoNgay.add(pnl_Date_LocTheoNgay);

        pnl_LocTheoNgay_wrap.add(pnl_LocTheoNgay, java.awt.BorderLayout.CENTER);

        pnl_BoLoc.add(pnl_LocTheoNgay_wrap);

        pnl_LocTheoKH_wrap.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnl_LocTheoKH_wrap.setLayout(new java.awt.BorderLayout());

        pnl_LocTheoKH.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 10, 30));
        pnl_LocTheoKH.setLayout(new java.awt.GridLayout(2, 1));

        pnl_LocTheoKH_title.setLayout(new java.awt.BorderLayout());

        lbl_LocTheoKH_title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_LocTheoKH_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_LocTheoKH_title.setText("Lọc theo Khách hàng");
        pnl_LocTheoKH_title.add(lbl_LocTheoKH_title, java.awt.BorderLayout.CENTER);

        pnl_LocTheoKH.add(pnl_LocTheoKH_title);

        pnl_txt_LocTheoKH.setLayout(new java.awt.BorderLayout());

        txt_LocTheoKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pnl_txt_LocTheoKH.add(txt_LocTheoKH, java.awt.BorderLayout.CENTER);

        pnl_LocTheoKH.add(pnl_txt_LocTheoKH);

        pnl_LocTheoKH_wrap.add(pnl_LocTheoKH, java.awt.BorderLayout.CENTER);

        pnl_BoLoc.add(pnl_LocTheoKH_wrap);

        pnl_LocTheoNV_wrap.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnl_LocTheoNV_wrap.setLayout(new java.awt.BorderLayout());

        pnl_LocTheoNV.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 10, 30));
        pnl_LocTheoNV.setLayout(new java.awt.GridLayout(2, 1));

        pnl_LocTheoNV_title.setLayout(new java.awt.BorderLayout());

        lbl_LocTheoNgay_title2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_LocTheoNgay_title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_LocTheoNgay_title2.setText("Lọc theo Nhân viên");
        pnl_LocTheoNV_title.add(lbl_LocTheoNgay_title2, java.awt.BorderLayout.CENTER);

        pnl_LocTheoNV.add(pnl_LocTheoNV_title);

        pnl_txt_LocTheoNV.setLayout(new java.awt.BorderLayout());

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pnl_txt_LocTheoNV.add(jTextField1, java.awt.BorderLayout.CENTER);

        pnl_LocTheoNV.add(pnl_txt_LocTheoNV);

        pnl_LocTheoNV_wrap.add(pnl_LocTheoNV, java.awt.BorderLayout.CENTER);

        pnl_BoLoc.add(pnl_LocTheoNV_wrap);

        pnl_center.add(pnl_BoLoc, java.awt.BorderLayout.NORTH);

        pnl_Tabel.setLayout(new java.awt.BorderLayout());

        table_DSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Nhân Viên", "Khách Hàng", "Ngày Tạo Hóa Đơn", "Tổng tiền"
            }
        ));
        table_DSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_DSHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_DSHD);

        pnl_Tabel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnl_center.add(pnl_Tabel, java.awt.BorderLayout.CENTER);

        pnl_XuatHoaDon.setPreferredSize(new java.awt.Dimension(10, 70));

        btn_InHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_InHD.setText("Xuất Hóa Đơn");
        btn_InHD.setPreferredSize(new java.awt.Dimension(600, 50));
        btn_InHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InHDActionPerformed(evt);
            }
        });
        pnl_XuatHoaDon.add(btn_InHD);

        btn_XemChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_XemChiTiet.setText("Xem ChiTieets");
        btn_XemChiTiet.setPreferredSize(new java.awt.Dimension(600, 50));
        btn_XemChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XemChiTietMouseClicked(evt);
            }
        });
        pnl_XuatHoaDon.add(btn_XemChiTiet);

        pnl_center.add(pnl_XuatHoaDon, java.awt.BorderLayout.PAGE_END);

        pnl_HoaDon.add(pnl_center, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Hóa đơn", pnl_HoaDon);
        jTabbedPane1.addTab("Hóa đơn đổi trả", pnl_DoiTra);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void table_DSHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_DSHDMouseClicked
        // TODO add your handling code here:
        
        int r = table_DSHD.getSelectedRow();

        if(r >= 0) {
            txt_MaHD.setText(table_DSHD.getValueAt(r, 0).toString());

            txt_NhanVien.setText(table_DSHD.getValueAt(r, 1) == null ? "" 
                                                : table_DSHD.getValueAt(r, 1).toString());
            txt_KhachHang.setText(table_DSHD.getValueAt(r, 2) == null ? ""
                                                : table_DSHD.getValueAt(r, 2).toString());


            try {
                SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");

                Date date = dtf.parse(table_DSHD.getValueAt(r, 3).toString().substring(0, 10));
                date_NgayTao.setDate(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_table_DSHDMouseClicked

    private void btn_InHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_InHDActionPerformed

    private void btn_XemChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XemChiTietMouseClicked
        // TODO add your handling code here:
        int r = table_DSHD.getSelectedRow();

        if(r >= 0) {
            ArrayList<ChiTietHoaDon> dsCTHD = cthd_dao.getDSSP_TheoMaHD(table_DSHD.getValueAt(r, 0).toString());
            HoaDon hd = hd_dao.getHD_TheoMa(table_DSHD.getValueAt(r, 0).toString());
            new DiaLog_DSSP_HD(hd, dsCTHD).setVisible(true);
        }

    }//GEN-LAST:event_btn_XemChiTietMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_InHD;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_XemChiTiet;
    private com.toedter.calendar.JDateChooser date_LocTheoNgay;
    private com.toedter.calendar.JDateChooser date_NgayTao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_KhachHang;
    private javax.swing.JLabel lbl_LocTheoKH_title;
    private javax.swing.JLabel lbl_LocTheoNgay_title;
    private javax.swing.JLabel lbl_LocTheoNgay_title2;
    private javax.swing.JLabel lbl_MaHD;
    private javax.swing.JLabel lbl_NgayTao;
    private javax.swing.JLabel lbl_NhanVien;
    private javax.swing.JPanel pnl_BoLoc;
    private javax.swing.JPanel pnl_Date_LocTheoNgay;
    private javax.swing.JPanel pnl_DoiTra;
    private javax.swing.JPanel pnl_HD_TimKiem;
    private javax.swing.JPanel pnl_HD_info;
    private javax.swing.JPanel pnl_HoaDon;
    private javax.swing.JPanel pnl_KhachHang;
    private javax.swing.JPanel pnl_LocTheoKH;
    private javax.swing.JPanel pnl_LocTheoKH_title;
    private javax.swing.JPanel pnl_LocTheoKH_wrap;
    private javax.swing.JPanel pnl_LocTheoNV;
    private javax.swing.JPanel pnl_LocTheoNV_title;
    private javax.swing.JPanel pnl_LocTheoNV_wrap;
    private javax.swing.JPanel pnl_LocTheoNgay;
    private javax.swing.JPanel pnl_LocTheoNgay_title;
    private javax.swing.JPanel pnl_LocTheoNgay_wrap;
    private javax.swing.JPanel pnl_MaHD;
    private javax.swing.JPanel pnl_NgayTao;
    private javax.swing.JPanel pnl_NhanVien;
    private javax.swing.JPanel pnl_Tabel;
    private javax.swing.JPanel pnl_XuatHoaDon;
    private javax.swing.JPanel pnl_center;
    private javax.swing.JPanel pnl_top;
    private javax.swing.JPanel pnl_txt_LocTheoKH;
    private javax.swing.JPanel pnl_txt_LocTheoNV;
    private javax.swing.JTable table_DSHD;
    private javax.swing.JTextField txt_KhachHang;
    private javax.swing.JTextField txt_LocTheoKH;
    private javax.swing.JTextField txt_MaHD;
    private javax.swing.JTextField txt_NhanVien;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables
}
