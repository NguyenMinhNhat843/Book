/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.sun.jdi.connect.spi.Connection;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
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
        ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        Statement stm = null;
        
        ResultSet rs = null;
        
        try {
            String sql = "select *\n" +
                            "from HoaDon hd left join NhanVien nv\n" +
                            "on hd.maNhanVien = nv.maNV\n" +
                            "left join KhachHang kh\n" +
                            "on kh.maKH = hd.maKhachHang";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()) {
                String maHD = rs.getString("maHD");
                String maNV = rs.getString("maNV");
                String tenNV = rs.getString("tenNV");
                String maKH = rs.getString("maKH");
                String tenKH = rs.getString("tenKH");
                
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String ngayTao = rs.getString("ngayTao").substring(0, 19);
                LocalDateTime ngayTao_lcd = LocalDateTime.parse(ngayTao, dtf);
                
                double tienKhachDua = rs.getDouble("tienKhachDua");
                double tongTien = rs.getDouble("tongTien");
                double sdtd = rs.getDouble("suDungTichDiem");
                double tongKM = rs.getDouble("tongKM");
                double tongThue = rs.getDouble("tongThue");
                
                HoaDon hd = new HoaDon(maHD, new NhanVien(maNV, tenNV), new KhachHang(maKH, tenKH), ngayTao_lcd, tienKhachDua, tongTien, sdtd, tongKM, tongThue);
                
                dsHD.add(hd);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dsHD;
    }

    @Override
    public HoaDon getHD_TheoMa(String maHD) {
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        
        HoaDon hd = null;
        
        try {
            String sql = "select * from HoaDon where maHD = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maHD);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                String maHD_1 = rs.getString("maHD");
                double tienNhan = rs.getDouble("tienKhachDua");
                double tongTien = rs.getDouble("tongTien");
                double suDungTichDiem = rs.getDouble("suDungTichDiem");
                double tongKM = rs.getDouble("tongKM");
                double tongThue = rs.getDouble("tongThue");
                
                hd = new HoaDon(maHD_1, null, null, null, tienNhan, tongTien, suDungTichDiem, tongKM, tongThue);
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
        
        return hd;
    }

    @Override
    public boolean themHD(HoaDon hd) {
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        PreparedStatement prstmt = null;
        
        int n = 0;
        
        try {
            prstmt = con.prepareStatement("insert into HoaDon(maHD, maNhanVien,maKhachHang , ngayTao, tienKhachDua, tongTien)"
                                        + "values(?, ?, ?, ?, ?, ?)");
            prstmt.setString(1, hd.getMaHD());
            prstmt.setString(2, hd.getNv().getMaNV());
            
            if(hd.getKh() != null) {
                prstmt.setString(3, hd.getKh().getMaKH());
            } else {
                prstmt.setNull(3, java.sql.Types.NULL);
            }
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            prstmt.setString(4, dtf.format(hd.getNgayTao()));
            
            prstmt.setDouble(5, hd.getTienKhachDua());
            prstmt.setDouble(6, hd.getTongTien());
            
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
