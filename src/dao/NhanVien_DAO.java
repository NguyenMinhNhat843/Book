/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entity.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import service.NhanVienService;
import sql.connectDB;

/**
 *
 * @author Asus
 */
public class NhanVien_DAO implements NhanVienService{

    @Override
    public ArrayList<NhanVien> getAllNV() {
         ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
        
        connectDB.getInstance();
        Connection con = connectDB.getConnect();
        
        Statement stm = null;
        ResultSet rs = null;
        try {
              
            String sql = "Select * from NhanVien";
            stm = con.createStatement();
            
            rs = stm.executeQuery(sql);
            
            while(rs.next()) {
                String maNV = rs.getString("maNV");
                String tenNV = rs.getString("tenNV");
                String chucVu = rs.getString("chucVu");
                String gioiTinh = rs.getString("gioiTinh");
                String diaChi = rs.getString("diaChi");
                String email = rs.getString("email");
                Date ngaySinh =rs.getDate("ngaySinh");
                String sDT = rs.getString("sDT");
                
               

                NhanVien nv = new NhanVien(maNV, tenNV, chucVu, gioiTinh, diaChi, email, ngaySinh, sDT);
                dsNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsNV;
    }
     public String tuPhatSinhMa() {
        ArrayList<NhanVien> dsNV = getAllNV();
        int soLuong = dsNV.size() + 1;
        
        return soLuong < 10 ? "NV00" + soLuong 
                : soLuong < 100 ? "NV0" + soLuong
                : "NV" + soLuong;
    }
    
@Override
    public NhanVien getNV_TheoMa(String maNV) {
          connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        
        NhanVien nv = null;
        
        java.sql.PreparedStatement stmt = null;
        
        try {
            String sql  = "select * from NhanVien where maNV = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maNV);
            
            java.sql.ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                String maNV_1 = rs.getString("maNV");
                String tenNV = rs.getString("tenNV");
                String chucVu = rs.getString("chucVu");
                String gioiTinh = rs.getString("gioiTinh");
                String diaChi = rs.getString("diaChi");
                String email = rs.getString("email");
                Date ngaySinh =rs.getDate("ngaySinh");
                String sDT = rs.getString("sDT");
                nv = new NhanVien(maNV_1, tenNV, chucVu, gioiTinh, diaChi, email, ngaySinh, sDT);
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
        
        return nv;
    }

  
    public boolean ThemNV(NhanVien nv) {
        int n = 0;
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        
        java.sql.PreparedStatement stmt = null;
        
        try {
            String sql = "insert into NhanVien(maNV, tenNV, chucVu, gioiTinh, diaChi, email, ngaySinh, sDT)"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, tuPhatSinhMa());
            stmt.setString(2, nv.getTenNV());
            stmt.setString(3, nv.getChucVu());
            stmt.setString(4, nv.getGioiTinh());
            stmt.setString(5, nv.getDiaChi());
            stmt.setString(6, nv.getEmail());
            stmt.setDate(7, (Date) nv.getNgaySinh());
            stmt.setString(8, nv.getsDT());
            
            
            
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
    public void xoaNV(String maNV) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean CapNhatNV(NhanVien nv_new) {
        connectDB.getInstance();
        java.sql.Connection con = connectDB.getConnect();
        
        int n = 0;
        
        java.sql.PreparedStatement stmt = null;
        
        try {
            String sql = "update NhanVien set tenNV = ?, chucVu = ?, gioiTinh = ?, diaChi = ?, email = ?, ngaySinh = ?, sDT = ? where maNV = ?";
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, nv_new.getTenNV());
            stmt.setString(2, nv_new.getChucVu());
            stmt.setString(3, nv_new.getGioiTinh());
            stmt.setString(4, nv_new.getDiaChi());
            stmt.setString(5, nv_new.getEmail());
            stmt.setDate(6, (Date) nv_new.getNgaySinh());
            stmt.setString(7, nv_new.getsDT());
            
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
    public void themNVVaoCSDL(NhanVien nv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void capNhatNV(NhanVien nv_old, NhanVien nv_new) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

