/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.HoaDonNCC;
import entity.NhaCungCap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import sql.connectDB;

/**
 *
 * @author Asus
 */
public class HoaDon_NCC_DAO {
    public String TuPhatSinhMa() {
        ArrayList<HoaDonNCC> dsHDNH = getAllHDNCC();
        int n = dsHDNH.size() + 1;
        
        return n < 10 ? "HDNH00" + n
                : n < 100 ? "HDNH0" + n
                : "HDNH" + n;
    }
    
    public ArrayList<HoaDonNCC> getAllHDNCC() {
        ArrayList<HoaDonNCC> dsHDNH = new ArrayList<>();
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        
        java.sql.PreparedStatement prstmt = null;
        java.sql.ResultSet rs = null;
        
        try {
            String sql = "select * from HoaDonNhapHang";
            prstmt = con.prepareStatement(sql);
            
            rs = prstmt.executeQuery();
            
            while(rs.next()) {
                String maHDNH = rs.getString("maHDNH");
                String maNCC = rs.getString("maNCC");
                
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime ngayNhap = LocalDateTime.parse(rs.getString("ngayNhap").substring(0, 19), dtf);
                String ghiChu = rs.getString("ghiChu");
                boolean isThanhToan = rs.getString("thanhToan").equals("true") ? true : false;
                
                HoaDonNCC tmp = new HoaDonNCC(maNCC, new NhaCungCap(maNCC), ngayNhap, ghiChu, isThanhToan);
                dsHDNH.add(tmp);
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
        return dsHDNH;
    }
    
    public boolean ThemHDNCCVaoCSDL(HoaDonNCC hdncc) {
        int n = 0;
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        java.sql.PreparedStatement prstmt = null;
        
        try {
            String sql = "insert into HoaDonNhapHang(maHDNH, maNCC, ngayNhap, ghiChu, thanhToan) "
                    + "values (?, ?, ?, ?, ?)";
            prstmt = con.prepareStatement(sql);
            prstmt.setString(1, hdncc.getMaHDNCC());
            prstmt.setString(2, hdncc.getNCC().getMaNCC());
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            prstmt.setString(3, dtf.format(hdncc.getNgayNhap()));
            prstmt.setString(4, hdncc.getGhiChu());
            prstmt.setString(5, hdncc.isIsThanhToan() ? "true" : "false");
            
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
