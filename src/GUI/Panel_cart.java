/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.SanPham_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.SanPham;
import entity.KhachHang;
import entity.NhanVien;
import java.awt.Component;
import java.awt.FlowLayout;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Asus
 */
public class Panel_cart extends javax.swing.JPanel {
    private JTextField txt_TimKiem;
    private JPanel pnl_TimKiem;
    private SanPham_DAO sp_dao;
    private KhachHang_DAO kh_dao = new KhachHang_DAO();
    private HoaDon_DAO hd_dao;
    private ChiTietHoaDon_DAO cthd_dao = new ChiTietHoaDon_DAO();
    private DefaultTableModel model_DSSP;
    private double tongTienThanhToan = 0;
    private String _this_maNV;
    private ArrayList<ChiTietHoaDon> dsCTHD;
    private KhachHang kh;
    private double tienVon = 0;
    private double tongThue = 0;
    private double tongKM = 0;
    private static ArrayList<SanPham> tmp = new ArrayList<>();
    /**
     * Creates new form Panel_product
     */
    public Panel_cart(String maNV, ArrayList<ChiTietHoaDon> dsCTHD, KhachHang kh) {
        sp_dao = new SanPham_DAO();
        hd_dao = new HoaDon_DAO();
        this.dsCTHD = dsCTHD;
        this.kh = kh;
        _this_maNV = maNV;
        initComponents();
        
        if(dsCTHD != null) {
            DocChiTietHoaDonLenTable();
        }
        
        if(kh != null) {
            DocDuLieuKH();
        }
        
        setTxt_MaHD_TuPhatSinh();
    }
    
    public void inHoaDon() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        
        if(printerJob.printDialog()) {
            try {
                printerJob.setPrintable((graphics, pageFormat, pageIndex) -> {
                    if (pageIndex > 0) {
                        return NO_SUCH_PAGE;
                    }

                    // Vẽ nội dung hóa đơn
                    StringBuilder content = new StringBuilder("Hóa đơn\n\n");

                    // Thêm thông tin về từng sản phẩm vào hóa đơn
                    for (SanPham sp : tmp) {
                        content.append(sp.getTenSP()).append("\t\t").append(sp.getGiaBan()).append("\n");
                    }

                    graphics.drawString(content.toString(), 100, 100);

                    return PAGE_EXISTS;
                });
                
                 printerJob.print();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi in hóa đơn: " + e.getMessage());
            }
        }
    }
    
//    public void inHoaDon() {
//        // Tạo một công việc in
//        PrinterJob printerJob = PrinterJob.getPrinterJob();
//
//        // Kiểm tra xem người dùng đã chọn máy in chưa
//        if (printerJob.printDialog()) {
//            try {
//                // Đặt nội dung cần in
//                printerJob.setPrintable((graphics, pageFormat, pageIndex) -> {
//                    if (pageIndex > 0) {
//                        return NO_SUCH_PAGE;
//                    }
//
//                    // Vẽ nội dung hóa đơn
//                    StringBuilder content = new StringBuilder("Hóa đơn\n\n");
//
//                    // Thêm thông tin về từng sản phẩm vào hóa đơn
//                    for (SanPham sp : tmp) {
//                        content.append(sp.getTenSP()).append("\t\t").append(sp.getGiaBan()).append("\n");
//                    }
//
//                    graphics.drawString(content.toString(), 100, 100);
//
//                    return PAGE_EXISTS;
//                });
//
//                // In hóa đơn
//                printerJob.print();
//            } catch (PrinterException e) {
//                JOptionPane.showMessageDialog(null, "Lỗi khi in hóa đơn: " + e.getMessage());
//            }
//        }
//    }
//}
  
    
    public void DocChiTietHoaDonLenTable() {
        double tongTien = 0;
        DefaultTableModel temp = (DefaultTableModel) table_DanhSachSP.getModel();
        
        for(ChiTietHoaDon cthd : dsCTHD) {
            tongTien += cthd.getSanPham().getGiaBan() * cthd.getSoLuong();
            Object[] obj = {cthd.getSanPham().getMaSP(), cthd.getSanPham().getTenSP(), cthd.getSanPham().getLoaiSP(), 
                            cthd.getSoLuong(), cthd.getSanPham().getGiaBan(), cthd.getSanPham().getGiaBan() * cthd.getSoLuong()};
            
            temp.addRow(obj);
        }
        
        txt_ThanhToan.setText(tongTien + "");
    }
    
    public void DocDuLieuKH() {
        txt_TenKH.setText(kh.getTenKH());
        txt_Rank.setText(kh.getRank().toString());
        txt_DiemTichLuy.setText(kh.getTichDiem() + "");
        txt_MaKH.setText(kh.getMaKH());
        txt_Email.setText(kh.getEmail());
    }
    
    public void setTxt_MaHD_TuPhatSinh() {
        txt_MaHD.setText(hd_dao.tuPhatSinhMaHD());
    }
    
    public void XoaTable_DSSP() {
        DefaultTableModel temp = (DefaultTableModel) table_DanhSachSP.getModel();
        temp.getDataVector().removeAllElements();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_thongTin = new javax.swing.JPanel();
        pnl_thongTin_KH = new javax.swing.JPanel();
        pnl_timKH = new javax.swing.JPanel();
        txt_TimKH = new javax.swing.JTextField();
        lb_TimKH = new javax.swing.JLabel();
        btn_TimKiem = new javax.swing.JButton();
        pnl_TimKH_row1 = new javax.swing.JPanel();
        lb_DiemTichLuy = new javax.swing.JLabel();
        txt_DiemTichLuy = new javax.swing.JTextField();
        lb_DiaChi = new javax.swing.JLabel();
        lb_TenKH = new javax.swing.JLabel();
        txt_Rank = new javax.swing.JTextField();
        txt_MaKH = new javax.swing.JTextField();
        lb_Rank = new javax.swing.JLabel();
        txt_TenKH = new javax.swing.JTextField();
        txt_Email = new javax.swing.JTextField();
        lb_Email1 = new javax.swing.JLabel();
        pnl_ThongTin_HD = new javax.swing.JPanel();
        txt_TongThuCa = new javax.swing.JTextField();
        lb_MaHD = new javax.swing.JLabel();
        txt_MaHD = new javax.swing.JTextField();
        lb_Ca = new javax.swing.JLabel();
        txt_Ca = new javax.swing.JTextField();
        lb_TongThuCa2 = new javax.swing.JLabel();
        pnl_center = new javax.swing.JPanel();
        pnl_TimSP = new javax.swing.JPanel();
        btn_Them = new javax.swing.JButton();
        txt_TimSP = new javax.swing.JTextField();
        pnl_DanhSachSP = new javax.swing.JPanel();
        scroll_DanhSachSP = new javax.swing.JScrollPane();
        table_DanhSachSP = new javax.swing.JTable();
        pnl_thanhToan = new javax.swing.JPanel();
        lb_TongThuCa1 = new javax.swing.JLabel();
        lb_TongThuCa3 = new javax.swing.JLabel();
        txt_ThanhToan = new javax.swing.JTextField();
        txt_TienThoi = new javax.swing.JTextField();
        btn_ThanhToan = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lbl_TienNhan = new javax.swing.JLabel();
        txt_SudungTichDiem = new javax.swing.JTextField();
        txt_TienNhan = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        pnl_thongTin.setPreferredSize(new java.awt.Dimension(10, 170));
        pnl_thongTin.setLayout(new java.awt.BorderLayout());

        pnl_thongTin_KH.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnl_thongTin_KH.setPreferredSize(new java.awt.Dimension(659, 300));
        pnl_thongTin_KH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_timKH.setBackground(new java.awt.Color(255, 0, 0));
        pnl_timKH.setLayout(new java.awt.BorderLayout());

        txt_TimKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pnl_timKH.add(txt_TimKH, java.awt.BorderLayout.CENTER);

        lb_TimKH.setBackground(new java.awt.Color(255, 0, 0));
        lb_TimKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_TimKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_TimKH.setText("Khách Hàng");
        lb_TimKH.setPreferredSize(new java.awt.Dimension(100, 16));
        lb_TimKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_TimKHMouseClicked(evt);
            }
        });
        pnl_timKH.add(lb_TimKH, java.awt.BorderLayout.WEST);

        btn_TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btn_TimKiem.setPreferredSize(new java.awt.Dimension(50, 27));
        btn_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TimKiemMouseClicked(evt);
            }
        });
        pnl_timKH.add(btn_TimKiem, java.awt.BorderLayout.EAST);

        pnl_thongTin_KH.add(pnl_timKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, 790, 50));

        pnl_TimKH_row1.setPreferredSize(new java.awt.Dimension(20, 50));
        pnl_TimKH_row1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_DiemTichLuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_DiemTichLuy.setText("Điểm tích lũy:");
        pnl_TimKH_row1.add(lb_DiemTichLuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        txt_DiemTichLuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_DiemTichLuy.setEnabled(false);
        txt_DiemTichLuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DiemTichLuyActionPerformed(evt);
            }
        });
        pnl_TimKH_row1.add(txt_DiemTichLuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 100, 40));

        lb_DiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_DiaChi.setText("Email:");
        pnl_TimKH_row1.add(lb_DiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        lb_TenKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_TenKH.setText("Tên: ");
        pnl_TimKH_row1.add(lb_TenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txt_Rank.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_Rank.setText(" ");
        txt_Rank.setEnabled(false);
        txt_Rank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RankActionPerformed(evt);
            }
        });
        pnl_TimKH_row1.add(txt_Rank, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 100, 40));

        txt_MaKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_MaKH.setEnabled(false);
        pnl_TimKH_row1.add(txt_MaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 230, 40));

        lb_Rank.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_Rank.setText("Rank: ");
        pnl_TimKH_row1.add(lb_Rank, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        txt_TenKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_TenKH.setEnabled(false);
        pnl_TimKH_row1.add(txt_TenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 230, 40));

        txt_Email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_Email.setText(" ");
        txt_Email.setEnabled(false);
        pnl_TimKH_row1.add(txt_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 350, 40));

        lb_Email1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_Email1.setText("Mã KH:");
        pnl_TimKH_row1.add(lb_Email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        pnl_thongTin_KH.add(pnl_TimKH_row1, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 57, 790, 100));

        pnl_thongTin.add(pnl_thongTin_KH, java.awt.BorderLayout.CENTER);

        pnl_ThongTin_HD.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnl_ThongTin_HD.setPreferredSize(new java.awt.Dimension(500, 10));
        pnl_ThongTin_HD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_TongThuCa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_TongThuCa.setEnabled(false);
        txt_TongThuCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TongThuCaActionPerformed(evt);
            }
        });
        pnl_ThongTin_HD.add(txt_TongThuCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 160, 40));

        lb_MaHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_MaHD.setText("Mã HD:");
        pnl_ThongTin_HD.add(lb_MaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        txt_MaHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_MaHD.setEnabled(false);
        txt_MaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaHDActionPerformed(evt);
            }
        });
        pnl_ThongTin_HD.add(txt_MaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 370, 40));

        lb_Ca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_Ca.setText("Ca:");
        pnl_ThongTin_HD.add(lb_Ca, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        txt_Ca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_Ca.setText("1");
        txt_Ca.setEnabled(false);
        txt_Ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CaActionPerformed(evt);
            }
        });
        pnl_ThongTin_HD.add(txt_Ca, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 120, 40));

        lb_TongThuCa2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_TongThuCa2.setText("Tổng thu ca:");
        pnl_ThongTin_HD.add(lb_TongThuCa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        pnl_thongTin.add(pnl_ThongTin_HD, java.awt.BorderLayout.EAST);

        add(pnl_thongTin, java.awt.BorderLayout.NORTH);

        pnl_center.setPreferredSize(new java.awt.Dimension(456, 300));
        pnl_center.setLayout(new java.awt.BorderLayout());

        pnl_TimSP.setLayout(new java.awt.BorderLayout());

        btn_Them.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_Them.setText("Thêm");
        btn_Them.setPreferredSize(new java.awt.Dimension(150, 43));
        btn_Them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThemMouseClicked(evt);
            }
        });
        pnl_TimSP.add(btn_Them, java.awt.BorderLayout.EAST);

        txt_TimSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_TimSP.setPreferredSize(new java.awt.Dimension(80, 50));
        pnl_TimSP.add(txt_TimSP, java.awt.BorderLayout.CENTER);

        pnl_center.add(pnl_TimSP, java.awt.BorderLayout.NORTH);

        pnl_DanhSachSP.setPreferredSize(new java.awt.Dimension(456, 300));
        pnl_DanhSachSP.setLayout(new java.awt.BorderLayout());

        scroll_DanhSachSP.setPreferredSize(new java.awt.Dimension(456, 300));

        table_DanhSachSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên mặt hàng", "Loại", "Số lượng", "Thuế", "KM", "Đơn giá (có thuế)", "Thành tiền"
            }
        ));
        scroll_DanhSachSP.setViewportView(table_DanhSachSP);

        pnl_DanhSachSP.add(scroll_DanhSachSP, java.awt.BorderLayout.CENTER);

        pnl_thanhToan.setPreferredSize(new java.awt.Dimension(10, 150));
        pnl_thanhToan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_TongThuCa1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_TongThuCa1.setText("Tiền thối:");
        pnl_thanhToan.add(lb_TongThuCa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, 70, 20));

        lb_TongThuCa3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_TongThuCa3.setText("Sử dụng tích điểm:");
        pnl_thanhToan.add(lb_TongThuCa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        txt_ThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_ThanhToan.setForeground(new java.awt.Color(255, 51, 51));
        txt_ThanhToan.setText("0");
        pnl_thanhToan.add(txt_ThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 390, 60));

        txt_TienThoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_TienThoi.setText("0.00");
        pnl_thanhToan.add(txt_TienThoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 20, 230, 40));

        btn_ThanhToan.setBackground(new java.awt.Color(255, 51, 51));
        btn_ThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_ThanhToan.setText("Thanh Toán");
        btn_ThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThanhToanMouseClicked(evt);
            }
        });
        pnl_thanhToan.add(btn_ThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 60));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Tạo thẻ thành viên");
        pnl_thanhToan.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 660, 60));

        lbl_TienNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_TienNhan.setText("Tiền nhận: ");
        pnl_thanhToan.add(lbl_TienNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 80, 20));

        txt_SudungTichDiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_SudungTichDiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SudungTichDiemKeyReleased(evt);
            }
        });
        pnl_thanhToan.add(txt_SudungTichDiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 390, 40));

        txt_TienNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_TienNhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TienNhanKeyReleased(evt);
            }
        });
        pnl_thanhToan.add(txt_TienNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 230, 40));

        pnl_DanhSachSP.add(pnl_thanhToan, java.awt.BorderLayout.PAGE_END);

        pnl_center.add(pnl_DanhSachSP, java.awt.BorderLayout.CENTER);

        add(pnl_center, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_DiemTichLuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DiemTichLuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DiemTichLuyActionPerformed

    private void txt_RankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RankActionPerformed

    private void txt_TongThuCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TongThuCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TongThuCaActionPerformed

    private void txt_MaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaHDActionPerformed

    private void txt_CaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CaActionPerformed

    private void btn_ThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemMouseClicked
        // TODO add your handling code here:
        String maSP = txt_TimSP.getText();
        SanPham sp = sp_dao.getSP_TheoMa(maSP);
        
        
        if(maSP.compareTo("") != 0 && sp != null) {
            tmp.add(sp);
            tienVon += sp.getGiaNhapHang();
            tongKM += sp.getkM().getLoaiKM().equals("LKM001") 
                        ? sp.getGiaBan() * sp.getkM().getGiaTriKhuyenMai()
                        : sp.getkM().getGiaTriKhuyenMai();
            tongThue += sp.getThue();
            
            // Nhập số lượng sản phẩm
            int soLuong = Integer.parseInt(JOptionPane.showInputDialog(null, "Nhập số lượng", 0));
            
            // Tính tổng tiền thanh toán
            tongTienThanhToan += sp.getGiaBan() * soLuong;
            txt_ThanhToan.setText(tongTienThanhToan + "");
            
            // Lấy số lượng hàng đang có
            int n = table_DanhSachSP.getModel().getRowCount();
            
            // Kiểm tra sản phẩm trùng lặp: cộng dồn số lượng và thành tiền
            for(int i = 0; i < n; ++i) {
                String maSP_Cheked = table_DanhSachSP.getModel().getValueAt(i, 0).toString();
                if(maSP_Cheked.compareTo(maSP) == 0) {
                    int soLuongHienTai = Integer.parseInt(table_DanhSachSP.getModel().getValueAt(i, 3).toString());
                    int soLuongMoi = soLuongHienTai + soLuong;
                    table_DanhSachSP.getModel().setValueAt(soLuongMoi, i, 3);
                    
                    
                    table_DanhSachSP.getModel().setValueAt(
                            Double.parseDouble(table_DanhSachSP.getValueAt(i, 6).toString()) * soLuongMoi, i, 7);
                    return;
                }
            }
            
            // Them sp vao giao hang
//            Object[] obj;
            if(sp.getkM().getLoaiKM().equals("LKM001")) {
                double donGia = sp.getGiaBan() * (1 - sp.getkM().getGiaTriKhuyenMai() + sp.getThue());
               Object[] obj = {sp.getMaSP(), sp.getTenSP(), sp.getLoaiSP(), soLuong, sp.getThue(), sp.getkM().getGiaTriKhuyenMai() * 100 + "%", 
                                        donGia ,donGia * soLuong};
                model_DSSP = (DefaultTableModel)table_DanhSachSP.getModel();
                model_DSSP.addRow(obj);
            } else {
                double donGia = sp.getGiaBan() * (1 - sp.getThue()) - sp.getkM().getGiaTriKhuyenMai();
                Object[] obj = {sp.getMaSP(), sp.getTenSP(), sp.getLoaiSP(), soLuong, sp.getThue(), sp.getkM().getGiaTriKhuyenMai(), 
                                        donGia ,donGia * soLuong};
                model_DSSP = (DefaultTableModel)table_DanhSachSP.getModel();
                model_DSSP.addRow(obj);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm");
        }
         
    }//GEN-LAST:event_btn_ThemMouseClicked

    private void txt_TienNhanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TienNhanKeyReleased
        // TODO add your handling code here:
        double tienNhan = txt_TienNhan.getText().equals("") ? 0 : Double.parseDouble(txt_TienNhan.getText());
        double tienThanhToan = Double.parseDouble(txt_ThanhToan.getText());
        
        double suDungTichDiem = 0;
        if(txt_SudungTichDiem.getText().compareTo("") != 0)
        {
            suDungTichDiem = Double.parseDouble(txt_SudungTichDiem.getText());
        }
        
        double tienThoi = tienNhan + suDungTichDiem - tienThanhToan;
        
        txt_TienThoi.setText(tienThoi + "");
    }//GEN-LAST:event_txt_TienNhanKeyReleased

    private void lb_TimKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_TimKHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_TimKHMouseClicked

    // ========================== TIM KIEM KHACH HANG ===================
    // =========================
    // ========================
    private void btn_TimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiemMouseClicked
        // TODO add your handling code here:
        String maKM_searched = txt_TimKH.getText();
        
        KhachHang kh = kh_dao.getKH_TheoMa(maKM_searched);
        if(kh != null) {
            txt_TenKH.setText(kh.getTenKH());
            txt_DiemTichLuy.setText(kh.getTieuPhiTichLuy() + "");
            txt_MaKH.setText(kh.getMaKH());
            txt_Email.setText(kh.getEmail());
            
            String rank;
            switch (kh.getRank().getMaRank()) {
                case "R001":
                {
                    rank = "Đồng";
                    break;
                }
                case "R002": {
                    rank = "Bạc";
                    break;
                }   
                case "R003": {
                    rank = "Vàng";
                    break;
                }
                case "R004": {
                    rank = "Kim Cương";
                    break;
                }
                default:
                    throw new AssertionError();
            }
            txt_Rank.setText(rank);
            
            txt_TimKH.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Khách hàng chưa đăng ký thành viên!!!");
        }
    }//GEN-LAST:event_btn_TimKiemMouseClicked

    private void txt_SudungTichDiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SudungTichDiemKeyReleased
        // TODO add your handling code here:
        double tienNhan = Double.parseDouble(txt_TienNhan.getText());
        double tienThanhToan = Double.parseDouble(txt_ThanhToan.getText());
        
        double suDungTichDiem = 0;
        if(txt_SudungTichDiem.getText().compareTo("") != 0)
        {
            suDungTichDiem = Double.parseDouble(txt_SudungTichDiem.getText());
        }
        
        double tienThoi = tienNhan + suDungTichDiem - tienThanhToan;
        
        txt_TienThoi.setText(tienThoi + "");
    }//GEN-LAST:event_txt_SudungTichDiemKeyReleased

    private void btn_ThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThanhToanMouseClicked
        // TODO add your handling code here:
        String maHD = txt_MaHD.getText();
        String maNV = _this_maNV;
        String maKH = "";
        if(!txt_MaKH.getText().equals("")) {
            maKH = txt_MaKH.getText();
        }
        LocalDateTime ngayTao = LocalDateTime.now();
        double tienKhachDua = txt_TienNhan.getText().equals("") ? 0 : Double.parseDouble(txt_TienNhan.getText());
        
        double suDungTichDiem = !txt_SudungTichDiem.getText().equals("") 
                ? Double.parseDouble(txt_SudungTichDiem.getText())
                : 0;
        
//      Tao Hoa Don
        HoaDon hd = null;
        if(maKH.equals("")) {
            hd = new HoaDon(maHD, new NhanVien(maNV),null, ngayTao, tienKhachDua, 
                    Double.parseDouble(txt_ThanhToan.getText()), suDungTichDiem, tongKM, tongThue, tienVon);
        } else {
            hd = new HoaDon(maHD, new NhanVien(maNV),new KhachHang(maKH), ngayTao, 
                    tienKhachDua, Double.parseDouble(txt_ThanhToan.getText()), suDungTichDiem, tongKM, tongThue, tienVon);
        }
        
        if(txt_TienNhan.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(this, "Chưa nhận tiền của khách!!!");
        } else if(txt_TienThoi.getText().compareTo("") == 0  || Double.parseDouble(txt_TienThoi.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Chưa đủ tiền thanh toán !!!");
        } else {
            // Them hoa don thanh cong
            if(hd_dao.themHD(hd)) {
                JOptionPane.showMessageDialog(this, "Lưu hóa đơn thành công!!!");
                
                // Luu chi tiet hoa don
                for(int i = 0; i < table_DanhSachSP.getRowCount(); ++i) {
                    String maHD_CTHD = txt_MaHD.getText();
                    String maSP_CTHD = table_DanhSachSP.getValueAt(i, 0).toString();
                    int soLuong = Integer.parseInt(table_DanhSachSP.getValueAt(i, 3).toString());
                    double thanhTien = Double.parseDouble(table_DanhSachSP.getValueAt(i, 7).toString());
                    
                    ChiTietHoaDon cthd = new ChiTietHoaDon(new HoaDon(maHD_CTHD), new SanPham(maSP_CTHD), soLuong, thanhTien);
                    cthd_dao.ThemCTHDVaoCSDL(cthd);
                }
                
                inHoaDon();
                
                XoaTable_DSSP();
                txt_TienNhan.setText("");
                txt_TienThoi.setText("");
                txt_ThanhToan.setText("");
                txt_SudungTichDiem.setText("");
                txt_TimSP.setText("");
                tongThue = 0;
                tongKM = 0;
                tongTienThanhToan = 0;
            } else {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, vui lòng thử lại!!!");
            }
        }
    }//GEN-LAST:event_btn_ThanhToanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel lb_Ca;
    private javax.swing.JLabel lb_DiaChi;
    private javax.swing.JLabel lb_DiemTichLuy;
    private javax.swing.JLabel lb_Email1;
    private javax.swing.JLabel lb_MaHD;
    private javax.swing.JLabel lb_Rank;
    private javax.swing.JLabel lb_TenKH;
    private javax.swing.JLabel lb_TimKH;
    private javax.swing.JLabel lb_TongThuCa1;
    private javax.swing.JLabel lb_TongThuCa2;
    private javax.swing.JLabel lb_TongThuCa3;
    private javax.swing.JLabel lbl_TienNhan;
    private javax.swing.JPanel pnl_DanhSachSP;
    private javax.swing.JPanel pnl_ThongTin_HD;
    private javax.swing.JPanel pnl_TimKH_row1;
    private javax.swing.JPanel pnl_TimSP;
    private javax.swing.JPanel pnl_center;
    private javax.swing.JPanel pnl_thanhToan;
    private javax.swing.JPanel pnl_thongTin;
    private javax.swing.JPanel pnl_thongTin_KH;
    private javax.swing.JPanel pnl_timKH;
    private javax.swing.JScrollPane scroll_DanhSachSP;
    private javax.swing.JTable table_DanhSachSP;
    private javax.swing.JTextField txt_Ca;
    private javax.swing.JTextField txt_DiemTichLuy;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_MaHD;
    private javax.swing.JTextField txt_MaKH;
    private javax.swing.JTextField txt_Rank;
    private javax.swing.JTextField txt_SudungTichDiem;
    private javax.swing.JTextField txt_TenKH;
    private javax.swing.JTextField txt_ThanhToan;
    private javax.swing.JTextField txt_TienNhan;
    private javax.swing.JTextField txt_TienThoi;
    private javax.swing.JTextField txt_TimKH;
    private javax.swing.JTextField txt_TimSP;
    private javax.swing.JTextField txt_TongThuCa;
    // End of variables declaration//GEN-END:variables
}
