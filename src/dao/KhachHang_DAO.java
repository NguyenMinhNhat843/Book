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
    public String phatSinhMaTuDong() {
        ArrayList<KhachHang> dsKH = getDSKH();
        int soLuong = dsKH.size() + 1;
        
        return soLuong < 10 ? "KH00" + soLuong 
                : soLuong < 100 ? "KH0" + soLuong
                : "KH" + soLuong;
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
   
    public ArrayList<KhachHang> getDSKH() {
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        
        connectDB.getInstance();
        Connection con = connectDB.getConnect();
        
        Statement stm = null;
        ResultSet rs = null;
        try {
              
            String sql = "Select * from KhachHang";
            stm = con.createStatement();
            
            rs = stm.executeQuery(sql);
            
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
                dsKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsKH;
    }

    @Override
    public boolean Xoa_KH(String maKH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Sua_KH(KhachHang kh_new) {
        connectDB.getInstance();
        Connection conn = connectDB.getConnect();
        PreparedStatement stmt = null;
        
        int n = 0;
        try {
             String sql = "update KhachHang set maKH = ?, tenKH = ?, sDT = ?, email = ?, diaChi = ?,"
                     + "tieuPhiTichLuy = ?, rank = ?, tichDiem = ? where maKH = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, kh_new.getMaKH());
            stmt.setString(2, kh_new.getTenKH());
            stmt.setString(3, kh_new.getSDT());
            stmt.setString(4, kh_new.getEmail());
            stmt.setString(5, kh_new.getDiaChi());
            stmt.setDouble(6, kh_new.getTieuPhiTichLuy());
            stmt.setString(7, kh_new.getRank().getMaRank());
            stmt.setDouble(8, kh_new.getTichDiem());
            stmt.setString(9, kh_new.getMaKH());
            
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return n > 0;
    }

    @Override
    public boolean Them_KH(KhachHang kh_new) {
        int n = 0;
        connectDB.getInstance();
        Connection con = connectDB.getConnect();
        PreparedStatement stmt = null;
        try {
            String sql = "insert into KhachHang(maKH,tenKH, sDT,email,diaChi,tieuPhiTichLuy,rank,tichDiem)" 
                    + "values(?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, phatSinhMaTuDong());
            stmt.setString(2, kh_new.getTenKH());
            stmt.setString(3, kh_new.getSDT());
            stmt.setString(4, kh_new.getEmail());
            stmt.setString(5, kh_new.getDiaChi());
            stmt.setDouble(6, kh_new.getTieuPhiTichLuy());
            stmt.setString(7, kh_new.getRank().getMaRank());
            stmt.setDouble(8, kh_new.getTichDiem());
            
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                stmt.close();;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }
        
    public ArrayList<KhachHang> getKH_TheoRank(String maRank) {
        KhachHang result = null;
        connectDB.getInstance();
        Connection con = connectDB.getConnect();
        PreparedStatement stmt = null;
        
        ArrayList<KhachHang> dsKH = new ArrayList<>();
        
        try {
            String sql = "select * from KhachHang where rank = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maRank);
            
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
                dsKH.add(result);
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
        
        return dsKH;
    }
    
    public ArrayList<KhachHang> LocTheoTichDiem(double batdau, double ketthuc) {
        KhachHang result = null;
        connectDB.getInstance();
        Connection con = connectDB.getConnect();
        PreparedStatement stmt = null;
        
        ArrayList<KhachHang> dsKH = new ArrayList<>();
        
        try {
            String sql = "select * from KhachHang where tichDiem >= ? and tichDiem <= ?";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, batdau);
            stmt.setDouble(2, ketthuc);
            
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
                dsKH.add(result);
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
        
        return dsKH;
    }
    
    public ArrayList<KhachHang> LocTheoTieuPhi(double batdau, double ketthuc) {
        KhachHang result = null;
        connectDB.getInstance();
        Connection con = connectDB.getConnect();
        PreparedStatement stmt = null;
        
        ArrayList<KhachHang> dsKH = new ArrayList<>();
        
        try {
            String sql = "select * from KhachHang where tieuPhiTichLuy >= ? and tieuPhiTichLuy <= ?";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, batdau);
            stmt.setDouble(2, ketthuc);
            
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
                dsKH.add(result);
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
        
        return dsKH;
    }
}
