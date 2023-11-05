/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.sun.jdi.connect.spi.Connection;
import entity.HoaDon;
import java.util.ArrayList;
import service.HoaDonService;
import sql.connectDB;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Asus
 */
public class HoaDon_DAO implements HoaDonService{

    @Override
    public ArrayList<HoaDon> getAllHD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDon getHD_TheoMa(String maHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean themHD(HoaDon hd) {
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        PreparedStatement prstmt = null;
        
        int n = 0;
        
        try {
            prstmt = con.prepareStatement("insert into HoaDon(maHD, maNhanVien,maKhachHang , ngayTao, tienKhachDua)"
                                        + "values(?, ?, ?, ?, ?)");
            prstmt.setString(1, hd.getMaHD());
            prstmt.setString(2, hd.getNv().getMaNV());
            prstmt.setString(3, hd.getKh().getMaKH());
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            prstmt.setString(4, dtf.format(hd.getNgayTao()));
            
            prstmt.setDouble(5, hd.getTienKhachDua());
            
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

    @Override
    public void CapNhatHD(HoaDon hd_old, HoaDon hd_new) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String tuPhatSinhMaHD() {
        int soLuong = 0;
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        
        try {
            String sql = "select count(*) from HoaDon";
            Statement stm = con.createStatement();
            
            java.sql.ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()) {
                soLuong = rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return soLuong < 10 ? "HD00" + soLuong : soLuong < 100 ? "HD0" + soLuong : "HD" + soLuong; 
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
