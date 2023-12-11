/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.NhanVien;
import entity.TaiKhoan;
import java.util.ArrayList;
import service.TaiKhoanService;
import sql.connectDB;
import java.sql.*;

/**
 *
 * @author Asus
 */
public class TaiKhoan_DAO implements TaiKhoanService{

    @Override
    public ArrayList<TaiKhoan> getAllTK() {
        ArrayList<TaiKhoan> dsTK = new ArrayList<>();
        
        connectDB.getInstance();
        Connection con = connectDB.getConnect();
        
        Statement stm = null;
        ResultSet rs = null;
        try {
              
            String sql = "select * from TaiKhoan\n" +
                        "join LoaiTK\n" +
                        "on TaiKhoan.loaiTK = LoaiTK.maLoaiTK";
            stm = con.createStatement();
            
            rs = stm.executeQuery(sql);
            
            while(rs.next()) {
                String maTK = rs.getString("maTaiKhoan");
                String maNV = rs.getString("maNV");
                String tenNguoiDung = rs.getString("tenNguoiDung");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String loaiTK = rs.getString("tenLoaiTK");
                
                TaiKhoan tk = new TaiKhoan(maTK, new NhanVien(maNV), tenNguoiDung, username, password, loaiTK);
                dsTK.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsTK;
    }

    @Override
    public TaiKhoan getTK_TheoMa(String maTK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String tuPhatSinhMa() {
        ArrayList<TaiKhoan> dsNV = getAllTK();
        int soLuong = dsNV.size() + 1;
        
        return soLuong < 10 ? "TK00" + soLuong 
                : soLuong < 100 ? "TK0" + soLuong
                : "TK" + soLuong;
    }

    @Override
    public boolean themTKVaoCSDL(TaiKhoan tk) {
         int n = 0;
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        
        java.sql.PreparedStatement stmt = null;
        
        try {
            String sql = "insert into TaiKhoan(maTaiKhoan, maNV , tenNguoiDung, username, password, loaiTK)"
                    + "values (?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, tuPhatSinhMa());
            stmt.setString(2, tk.getMaNV().getMaNV());
            stmt.setString(3, tk.getTenNguoiDung());
            stmt.setString(4, tk.getUsername());
            stmt.setString(5, tk.getPassword());
            stmt.setString(6, tk.getLoaiTK());
            
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
    public boolean CapNhatTK(String maTK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean XoaTK(String maTK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TaiKhoan getTK_Theousername(String username) {
        TaiKhoan tk = null;
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        PreparedStatement stmt = null;
        
        try {
            String sql = "select * from TaiKhoan where username = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                String maTK = rs.getString("maTaiKhoan");
                String maNV = rs.getString("maNV");
                String tenNguoiDung = rs.getString("tenNguoiDung");
                String _username = rs.getString("username");
                String password = rs.getString("password");
                String loaiTK = rs.getString("loaiTK");
                
                tk = new TaiKhoan(maTK, new NhanVien(maNV) ,tenNguoiDung ,username, password, loaiTK);
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
        
        return tk;
    }
    
}
