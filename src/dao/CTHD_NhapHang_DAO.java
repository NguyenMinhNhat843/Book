/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ChiTietHD_NCC;
import sql.connectDB;

/**
 *
 * @author Asus
 */
public class CTHD_NhapHang_DAO {
    public boolean ThemVaoCSDL(ChiTietHD_NCC cthdnh) {
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        
        int n = 0;
        java.sql.PreparedStatement prstmt = null;
        
        try {
            String sql = "insert into ChiTietHoaDonNhapHang(maSP, maHDNH, soLuongNhap)"
                    + "values (?, ?, ?)";
            prstmt = con.prepareStatement(sql);
            prstmt.setString(1, cthdnh.getSanPham().getMaSP());
            prstmt.setString(2, cthdnh.getHdNCC().getMaHDNCC());
            prstmt.setInt(3, cthdnh.getSoLuongNhap());
            
            n = prstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                prstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }
    
}
