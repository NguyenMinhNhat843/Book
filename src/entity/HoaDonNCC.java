/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDateTime;

/**
 *
 * @author Asus
 */
public class HoaDonNCC {
    private String maHDNCC;
    private NhaCungCap nCC;
    private LocalDateTime ngayNhap;
    private String ghiChu;
    private boolean isThanhToan;

    public HoaDonNCC(String maHDNCC, NhaCungCap nCC, LocalDateTime ngayNhap, String ghiChu, boolean isThanhToan) {
        this.maHDNCC = maHDNCC;
        this.nCC = nCC;
        this.ngayNhap = ngayNhap;
        this.ghiChu = ghiChu;
        this.isThanhToan = isThanhToan;
    }
    
    public HoaDonNCC(String maHDNH) {
        this.maHDNCC = maHDNH;
    }

    public HoaDonNCC() {
    }

    public String getMaHDNCC() {
        return maHDNCC;
    }

    public NhaCungCap getNCC() {
        return nCC;
    }

    public LocalDateTime getNgayNhap() {
        return ngayNhap;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public boolean isIsThanhToan() {
        return isThanhToan;
    }

    public void setMaHDNCC(String maHDNCC) {
        this.maHDNCC = maHDNCC;
    }

    public void setNCC(NhaCungCap maNCC) {
        this.nCC = maNCC;
    }

    public void setNgayNhap(LocalDateTime ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setIsThanhToan(boolean isThanhToan) {
        this.isThanhToan = isThanhToan;
    }
}
