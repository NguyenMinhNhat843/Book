/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
    public ArrayList<TaiKhoanService> getAllTK() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TaiKhoan getTK_TheoMa(String maTK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void themTKVaoCSDL(TaiKhoanService tk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void CapNhatTK(String maTK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void XoaTK(String maTK) {
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
                String tenNguoiDung = rs.getString("tenNguoiDung");
                String _username = rs.getString("username");
                String password = rs.getString("password");
                String loaiTK = rs.getString("loaiTK");
                
                tk = new TaiKhoan(maTK, tenNguoiDung ,username, password, loaiTK);
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
