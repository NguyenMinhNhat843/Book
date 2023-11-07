/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ChiTietHoaDon;
import entity.HoaDon;
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
            String sql = "insert into ChiTietHoaDon(maHoaDon, maSanPham, soLuong) values(?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cthd.getHoaDon().getMaHD());
            stmt.setString(2, cthd.getSanPham().getMaSP());
            stmt.setInt(3, cthd.getSoLuong());
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
//                System.out.println("dao.ChiTietHoaDon_DAO.getDSSP_TheoMaHD() " + vAT);
                
                SanPham sp = new SanPham(maSP, tenSP, loaiSP, giaBan, vAT);
                
                int soLuong = rs.getInt("soLuong");
                
                ChiTietHoaDon cthd = new ChiTietHoaDon(new HoaDon(maHD_1), sp, soLuong);
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
    
}
