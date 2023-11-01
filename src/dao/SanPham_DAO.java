/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Enum_class;
import entity.KhuyenMai;
import entity.NhaCungCap;
import entity.SanPham;
import java.util.ArrayList;
import java.util.List;
import service.SanPhamService;
import java.sql.*;
import sql.connectDB;

/**
 *
 * @author Asus
 */
public class SanPham_DAO implements SanPhamService{

    @Override
    public String phatSinhMaTuDong() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SanPham getSP_TheoMa(String maSP_tim) {
        SanPham result = null;
        connectDB.getInstance();
        Connection conn = connectDB.getConnect();
        PreparedStatement stmt = null;
        
        try {
            String sql  = "select * from SanPham where maSP = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, maSP_tim);
            
            ResultSet rs = stmt.executeQuery();
            
            //
            while(rs.next()) {
                String maSP = rs.getString("maSP");
                String maKM = rs.getString("maKhuyenMai");
                String maNCC = rs.getString("maNCC");
                String tenSP = rs.getString("tenSP");
                String loaiSP = rs.getString("loaiSP");
                double giaNhapHang = rs.getDouble("giaNhapHang");
                double giaBan = rs.getDouble("giaBan");
                int soLuongBayBan = rs.getInt("soLuongBayBan");
                int soLuongTonKho = rs.getInt("soLuongTonKho");

                result = new SanPham(maSP, new KhuyenMai(maKM), new NhaCungCap(maNCC), tenSP, Enum_class.enum_LoaiSP.SGK, giaNhapHang, giaBan, soLuongBayBan, soLuongTonKho);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }   
        
        return result;
    }

    @Override
    public ArrayList<SanPham> getDSSP() {
        ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
        
        try {
            connectDB.getInstance();
            Connection con = connectDB.getConnect();
            
            String sql = "Select * from SanPham";
            Statement stm = con.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()) {
                
            }
        } catch (Exception e) {
        }
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
