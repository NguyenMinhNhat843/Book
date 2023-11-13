/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.lang.Exception;

/**
 *
 * @author Asus
 */
public class KhuyenMai {
    private String maKM;
    private String loaiKM;
    private double giaTriKhuyenMai;
    private LocalDateTime ngayBatDau;
    private LocalDateTime ngayKetThuc;
    private double giaTriHoaDonBatDauKM;

    public KhuyenMai(String maKM, String loaiKM, double giaTriKhuyenMai, LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc, double giaTriHoaDonBatDauKM) {
        this.maKM = maKM;
        this.loaiKM = loaiKM;
        this.giaTriKhuyenMai = giaTriKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giaTriHoaDonBatDauKM = giaTriHoaDonBatDauKM;
    }
    
    public KhuyenMai(String maKM) {
        this.maKM = maKM;
    }

    public KhuyenMai() {
    }

    public String getMaKM() {
        return maKM;
    }

    public String getLoaiKM() {
        return loaiKM;
    }

    public double getGiaTriKhuyenMai() {
        return giaTriKhuyenMai;
    }

    public LocalDateTime getNgayBatDau() {
        return ngayBatDau;
    }

    public LocalDateTime getNgayKetThuc() {
        return ngayKetThuc;
    }

    public double getGiaTriHoaDonBatDauKM() {
        return giaTriHoaDonBatDauKM;
    }

    public void setMaKM(String maKM) throws Exception {
        if(maKM.compareTo("") == 0)
            throw new Exception("Mã khuyến mãi không được rỗng!");
        else 
            this.maKM = maKM;
    }

    public void setLoaiKM(String loaiKM) {
        this.loaiKM = loaiKM;
    }

    public void setGiaTriKhuyenMai(double giaTriKhuyenMai) {
        if(giaTriKhuyenMai >= 0)
            this.giaTriKhuyenMai = giaTriKhuyenMai;
        else 
            this.giaTriKhuyenMai = 0;
    }

    public void setNgayBatDau(LocalDateTime ngayBatDau) throws Exception  {
        if(ngayBatDau.isAfter(LocalDateTime.now()) || ngayBatDau.isEqual(LocalDateTime.now()))
            this.ngayBatDau = ngayBatDau;
        else
            throw new Exception("Ngày khuyến mãi phải >= ngày hiện tại");
    }

    public void setNgayKetThuc(LocalDateTime ngayKetThuc) throws Exception {
        if(ngayKetThuc.isAfter(ngayBatDau))
           this.ngayKetThuc = ngayKetThuc;
        else
            throw new Exception("Ngày kết thúc phải sau ngày bắt đầu");
    }

    public void setGiaTriHoaDonBatDauKM(double giaTriHoaDonBatDauKM) {
        if(giaTriHoaDonBatDauKM >= 0)
            this.giaTriHoaDonBatDauKM = giaTriHoaDonBatDauKM;
        else
            this.giaTriHoaDonBatDauKM = 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.maKM);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KhuyenMai other = (KhuyenMai) obj;
        return Objects.equals(this.maKM, other.maKM);
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
