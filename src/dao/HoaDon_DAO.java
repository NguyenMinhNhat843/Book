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
    public void themHD(HoaDon hd) {
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        PreparedStatement prstmt = null;
        
        int n = 0;
        
        try {
            prstmt = con.prepareStatement("insert into HoaDon(?, ?, ?, ?, ?)");
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void CapNhatHD(HoaDon hd_old, HoaDon hd_new) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
