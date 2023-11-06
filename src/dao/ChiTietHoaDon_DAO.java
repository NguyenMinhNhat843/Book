/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ChiTietHoaDon;
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
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        
        java.sql.PreparedStatement stmt = null;
        
        try {
            String sql = "select * ChiTietHoaDon where maHD = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maHD);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                
            }
            
        } catch (Exception e) {
        } finally {
        }
        
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
