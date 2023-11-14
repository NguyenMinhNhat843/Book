
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Enum_class;
import entity.KhuyenMai;
import entity.NhaCungCap;
import entity.SanPham;
import java.util.ArrayList;
import java.util.List;
import service.SanPhamService;
import java.sql.*;
//import java.time.LocalDate;
import java.time.*;
import java.time.format.*;
import sql.connectDB;

/**
 *
 * @author Asus
 */
public class SanPham_DAO implements SanPhamService{

    @Override
    public String phatSinhMaTuDong() {
        ArrayList<SanPham> dsSP = getDSSP();
        int soLuong = dsSP.size() + 1;
        
        return soLuong < 10 ? "SP00" + soLuong 
                : soLuong < 100 ? "SP0" + soLuong
                : "SP" + soLuong;
    }

    @Override
    public SanPham getSP_TheoMa(String maSP_tim) {
        SanPham result = null;
        connectDB.getInstance();
        Connection conn = connectDB.getConnect();
        PreparedStatement stmt = null;
        
        try {
            String sql  = "select * \n" +
                        "from SanPham sp join LoaiSanPham lsp\n" +
                        "on sp.loaiSP = lsp.maLoaiSP\n" +
                        "join KhuyenMai km\n" +
                        "on km.maKM = sp.maKhuyenMai"
                        + " where maSP = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, maSP_tim);
            
            ResultSet rs = stmt.executeQuery();
            
            //
            while(rs.next()) {
                String maSP = rs.getString("maSP");
                
                // Tao Doi Tuong Khuyen mai
                String maKM = rs.getString("maKhuyenMai");
                String loaiKM = rs.getString("loaiKM");
                double giaTriKM = rs.getDouble("giaTriKhuyenMai");
//                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.0");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime ngayBatDau = LocalDateTime.parse(rs.getString("ngayBatDau").substring(0, 19), dtf);
                LocalDateTime ngayKetThuc = LocalDateTime.parse(rs.getString("ngayKetThuc").substring(0, 19), dtf);
                double giaTriHoaDonBatDauKM = rs.getDouble("giaTriHoaDonBatDauKhuyenMai");
                
                KhuyenMai km = !maKM.equals("null") 
                        ? new KhuyenMai(maKM, loaiKM, giaTriKM, ngayBatDau, ngayKetThuc, giaTriHoaDonBatDauKM)
                        : new KhuyenMai(null, "loi", 0, null, null, 0);
//                System.out.println("dao.SanPham_DAO.getSP_TheoMa() " + maKM);
                
                String maNCC = rs.getString("maNCC");
                String tenSP = rs.getString("tenSP");
                String loaiSP = rs.getString("loaiSP");
                double giaNhapHang = rs.getDouble("giaNhapHang");
                double giaBan = rs.getDouble("giaBan");
                int soLuongBayBan = rs.getInt("soLuongBayBan");
                int soLuongTonKho = rs.getInt("soLuongTonKho");
                double thue = rs.getDouble("VAT");

                result = new SanPham(maSP, km, new NhaCungCap(maNCC), tenSP, 
                                loaiSP, giaNhapHang, giaBan, soLuongBayBan, soLuongTonKho, thue);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }   
        
        return result;
    }
    
    
    public boolean updateSP(SanPham sp_new) {
        connectDB.getInstance();
        Connection conn = connectDB.getConnect();
        PreparedStatement stmt = null;
        
        int n = 0;
        try {
            String sql  = "update SanPham set maKhuyenMai = ?, maNCC = ?, tenSP = ?, loaiSP = ? , giaNhapHang = ?, giaBan = ? , soLuongBayBan = ?, soLuongTonKho = ? where maSP = ?";
            stmt = conn.prepareStatement(sql);
                    
            //
            stmt.setString(1, sp_new.getkM().getMaKM());
            stmt.setString(2, sp_new.getnCC().getMaNCC());
            stmt.setString(3, sp_new.getTenSP());
            stmt.setString(4, sp_new.getLoaiSP());
            stmt.setDouble(5, sp_new.getGiaNhapHang());
            stmt.setDouble(6, sp_new.getGiaBan());
            stmt.setInt(7, sp_new.getSoLuongBayBan());
            stmt.setInt(8, sp_new.getSoLuongTonKho());
            stmt.setString(9, sp_new.getMaSP());
            
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
    
    public boolean themSanPham(SanPham sp){
        int n = 0;
        connectDB.getInstance();
        Connection con = connectDB.getConnect();
        PreparedStatement stmt = null;
        try {
            String sql = "insert into SanPham(maSP, maKhuyenMai, maNCC, tenSP, loaiSP, giaNhapHang, giaBan, soLuongBayBan, soLuongTonKho)" 
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, phatSinhMaTuDong());
            stmt.setString(2, sp.getkM() == null ? null : sp.getkM().getMaKM());
            stmt.setString(3, sp.getnCC().getMaNCC());
            stmt.setString(4, sp.getTenSP());
            stmt.setString(5, sp.getLoaiSP());
            stmt.setDouble(6, sp.getGiaNhapHang());
            stmt.setDouble(7, sp.getGiaBan());
            stmt.setInt(8, sp.getSoLuongBayBan());
            stmt.setInt(9, sp.getSoLuongTonKho());
            
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
    
    @Override
    public ArrayList<SanPham> getDSSP() {
        ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
        
        connectDB.getInstance();
        Connection con = connectDB.getConnect();
        
        Statement stm = null;
        ResultSet rs = null;
        try {
              
            String sql = "Select * from SanPham";
            stm = con.createStatement();
            
            rs = stm.executeQuery(sql);
            
            while(rs.next()) {
               String maSP = rs.getString("maSP");
                String maKM = rs.getString("maKhuyenMai");
//                System.out.println("dao.SanPham_DAO.getSP_TheoMa() " + maKM);
                
                String maNCC = rs.getString("maNCC");
                String tenSP = rs.getString("tenSP");
                String loaiSP = rs.getString("loaiSP");
                double giaNhapHang = rs.getDouble("giaNhapHang");
                double giaBan = rs.getDouble("giaBan");
                int soLuongBayBan = rs.getInt("soLuongBayBan");
                int soLuongTonKho = rs.getInt("soLuongTonKho");
                double thue = rs.getDouble("VAT");

                SanPham sp = new SanPham(maSP, new KhuyenMai(maKM), new NhaCungCap(maNCC), tenSP, 
                                loaiSP, giaNhapHang, giaBan, soLuongBayBan, soLuongTonKho, thue);
                dsSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsSP;
    }
    
}
