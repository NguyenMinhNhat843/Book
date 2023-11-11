/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.NhaCungCap;
import java.util.ArrayList;
import service.NhaCungCapService;
import sql.connectDB;

/**
 *
 * @author Asus
 */
public class NhaCungCap_DAO implements NhaCungCapService{

    @Override
    public ArrayList<NhaCungCap> getAllNCC() {
        ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
        
        connectDB.getInstance();
        java.sql.Connection con  = connectDB.getConnect();
        
        java.sql.Statement stm = null;
        java.sql.ResultSet rs = null;
        
        try {
            String sql = "select * from NhaCungCap";
            stm = con.createStatement();
            
            rs = stm.executeQuery(sql);
            
            while(rs.next()) {
                String maNCC = rs.getString("maNCC");
                String tenNCC = rs.getString("tenNCC");
                String diaChi = rs.getString("diaChi");
                String sDT = rs.getString("sDT");
                String email = rs.getString("email");
                
                NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sDT, email);
                dsNCC.add(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dsNCC;
    }

    @Override
    public NhaCungCap getNCC_TheoMa(String maNCC) {
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        
        NhaCungCap ncc = null;
        
        java.sql.PreparedStatement stmt = null;
        
        try {
            String sql  = "select * from NhaCungCap where maNCC = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maNCC);
            
            java.sql.ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                String maNCC_1 = rs.getString("maNCC");
                String tenNCC = rs.getString("tenNCC");
                String diaChi = rs.getString("diaChi");
                String sDT = rs.getString("sDT");
                String email = rs.getString("email");
                
                ncc = new NhaCungCap(maNCC_1, tenNCC, diaChi, sDT, email);
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
        
        return ncc;
    }

    @Override
    public boolean ThemNCC(NhaCungCap ncc) {
        int n = 0;
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        
        java.sql.PreparedStatement stmt = null;
        
        try {
            String sql = "insert into NhaCungCap(maNCC, tenNCC, diaChi, sDT, email)"
                    + "values (?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, tuPhatSinhMa());
            stmt.setString(2, ncc.getTenNCC());
            stmt.setString(3, ncc.getDiaChi());
            stmt.setString(4, ncc.getSDT());
            stmt.setString(5, ncc.getEmail());
            
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
    public boolean CapNhatNCC(NhaCungCap ncc_new) {
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        
        int n = 0;
        
        java.sql.PreparedStatement stmt = null;
        
        try {
            String sql = "update NhaCungCap set tenNCC = ?, diaChi = ?, sDT = ?, email = ? where maNCC = ?";
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, ncc_new.getTenNCC());
            stmt.setString(2, ncc_new.getDiaChi());
            stmt.setString(3, ncc_new.getSDT());
            stmt.setString(4, ncc_new.getEmail());
            stmt.setString(5, ncc_new.getMaNCC());
            
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
    public String tuPhatSinhMa() {
        ArrayList<NhaCungCap> dsNCC = getAllNCC();
        int soLuong = dsNCC.size() + 1;
        
        return soLuong < 10 ? "NCC00" + soLuong 
                : soLuong < 100 ? "NCC0" + soLuong
                : "NCC" + soLuong;
    }
    
}
