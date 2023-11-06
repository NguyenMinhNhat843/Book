/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 *
 * @author Asus
 */
public class HoaDon {
    private String maHD;
    private NhanVien nv;
    private KhachHang kh;
    private LocalDateTime ngayTao;
    private double tienKhachDua;
    private Double TongTien;
    

    public HoaDon(String maHD, NhanVien nv, KhachHang kh, LocalDateTime ngayTao, double tienKhachDua, double TongTien) {
        this.maHD = maHD;
        this.nv = nv;
        this.kh = kh;
        this.ngayTao = ngayTao;
        this.tienKhachDua = tienKhachDua;
        this.TongTien = TongTien;
    }
    
    public HoaDon(String maHoaDon) {
        this.maHD = maHoaDon;
    }

    public HoaDon() {
    }

    public String getMaHD() {
        return maHD;
    }

    public NhanVien getNv() {
        return nv;
    }

    public KhachHang getKh() {
        return kh;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public double getTienKhachDua() {
        return tienKhachDua;
    }

    public Double getTongTien() {
        return TongTien;
    }
    
    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setTienKhachDua(double tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }
    
    
}
