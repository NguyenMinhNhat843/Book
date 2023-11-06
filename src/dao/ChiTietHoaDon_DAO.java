/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import service.ChiTietHoaDonService;
import sql.connectDB;
import java.sql.*;

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
    
}
