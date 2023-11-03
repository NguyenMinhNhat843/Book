/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.KhachHang;
import entity.Rank;
import java.util.ArrayList;
import service.KhachHangService;
import sql.connectDB;
import java.sql.*;

/**
 *
 * @author Asus
 */
public class KhachHang_DAO implements KhachHangService{

    @Override
    public ArrayList<KhachHang> getAllKH() {
        ArrayList<KhachHang> result = new ArrayList<KhachHang>();
        
        try {
            connectDB.getInstance();
            Connection con = connectDB.getConnect();
            
            String sql = "select * from KhachHang";
            Statement stm = con.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);;
            
            while(rs.next()) {
                String maKH = rs.getString("maKH");
                String tenKH = rs.getString("tenKH");
                String sDT = rs.getString("sDT");
                String email = rs.getString("email");
                String diaChi = rs.getString("diaChi");
                double tieuPhiTichLuy = rs.getDouble("tieuPhiTichLuy");
                String rank = rs.getString("rank");
                double tichDiem = rs.getDouble("tichDiem");
                
                KhachHang kh = new KhachHang(maKH, tenKH, sDT, email, diaChi, tieuPhiTichLuy, new Rank(rank), tichDiem);
                result.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }

    @Override
    public KhachHang getKH_TheoMa(String maKH_searched) {
        KhachHang result = null;
        connectDB.getInstance();
        Connection con = connectDB.getConnect();
        PreparedStatement stmt = null;
        
        try {
            String sql = "select * from KhachHang where maKH = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maKH_searched);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                String maKH = rs.getString("maKH");
                String tenKH = rs.getString("tenKH");
                String sDT = rs.getString("sDT");
                String email = rs.getString("email");
                String diaChi = rs.getString("diaChi");
                double tieuPhiTichLuy = rs.getDouble("tieuPhiTichLuy");
                String rank = rs.getString("rank");
                double tichDiem = rs.getDouble("tichDiem");
                
                result = new KhachHang(maKH, tenKH, sDT, email, diaChi, tieuPhiTichLuy, new Rank(rank), tichDiem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }

    @Override
    public void Xoa_KH(String maKH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Them_KH(KhachHang kh_new) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Sua_KH(KhachHang kh_new) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}
