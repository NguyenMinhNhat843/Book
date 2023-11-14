/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhuyenMai;
import entity.SanPham;
import service.ChiTietHoaDonService;
import sql.connectDB;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class ChiTietHoaDon_DAO implements ChiTietHoaDonService{

    @Override
    public boolean ThemCTHDVaoCSDL(entity.ChiTietHoaDon cthd) {
        int n = 0;
        
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        java.sql.PreparedStatement stmt = null;
        
        try {
            String sql = "insert into ChiTietHoaDon(maHoaDon, maSanPham, soLuong, thanhTien) values(?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cthd.getHoaDon().getMaHD());
            stmt.setString(2, cthd.getSanPham().getMaSP());
            stmt.setInt(3, cthd.getSoLuong());
            stmt.setDouble(4, cthd.getThanhTien());
//            stmt.setDouble(4, cthd.getvAT());
            
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return n > 0;
    }

    @Override
    public ArrayList<ChiTietHoaDon> getDSSP_TheoMaHD(String maHD) {
        ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<ChiTietHoaDon>();
        
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        
        java.sql.PreparedStatement stmt = null;
        
        try {
            String sql = "select * \n" +
                        "from ChiTietHoaDon cthd join SanPham sp\n" +
                        "on cthd.maSanPham = sp.maSP"
                        + " where maHoaDon = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maHD);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                String maHD_1 = rs.getString("maHoaDon");
                
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                String loaiSP = rs.getString("loaiSP").equals("LSP001") ? "SGK"
                        : rs.getString("loaiSP").equals("LSP002") ? "Truyện"
                        : rs.getString("loaiSP").equals("LSP003") ? "Tiểu thuyết"
                        : rs.getString("loaiSP").equals("LSP004") ? "Dụng cụ học tập"
                        : "Văn phòng phẩm";
                double giaBan = rs.getDouble("giaBan");
                double vAT = rs.getDouble("VAT");
                String maKM = rs.getString("maKhuyenMai");
                
                SanPham sp = new SanPham(maSP, tenSP, loaiSP, giaBan, vAT, new KhuyenMai(maKM));
                
                int soLuong = rs.getInt("soLuong");
                double thanhTien = rs.getDouble("thanhTien");
                
                ChiTietHoaDon cthd = new ChiTietHoaDon(new HoaDon(maHD_1), sp, soLuong, thanhTien);
                dsCTHD.add(cthd);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return dsCTHD;
    }

    @Override
    public ArrayList<ChiTietHoaDon> ThongKe_SP_BanChay() {
        ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<>();
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        
        java.sql.PreparedStatement prstmt = null;
        
        try {
            String sql = "select maSP, tenSP, daBan = sum(soLuong), tongDoanhThu = sum(thanhTien), tienVon = sum(giaNhapHang)\n" +
                            "from ChiTietHoaDon cthd join SanPham sp\n" +
                            "on cthd.maSanPham = sp.maSP\n" +
                            "group by maSanPham, maSP, tenSP\n" +
                            "order by sum(soLuong) desc";
            prstmt = con.prepareStatement(sql);
            ResultSet rs = prstmt.executeQuery();
            
            while(rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                double tienVon = rs.getDouble("tienVon");
                SanPham sp = new SanPham(maSP, tenSP, tienVon);
                
                int soLuong = rs.getInt("daBan");
                double tongDoanhThu = rs.getDouble("tongDoanhThu");
                
//                ChiTietHoaDon cthd = new ChiTietHoaDon(null, sp, soLuong, tienVon, tongDoanhThu);
                ChiTietHoaDon cthd = new ChiTietHoaDon(null, sp, soLuong, tongDoanhThu);
                dsCTHD.add(cthd);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                prstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return dsCTHD;
    }
    
}
