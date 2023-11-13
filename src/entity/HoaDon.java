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
    private double suDungTichDiem;
    private double TongTien;
    private double tongKM;
    private double tongThue;
    private double tienVon;
    

    public HoaDon(String maHD, NhanVien nv, KhachHang kh, LocalDateTime ngayTao, double tienKhachDua, double TongTien, double sdtd, double tongKM, double tongThue) {
        this.maHD = maHD;
        this.nv = nv;
        this.kh = kh;
        this.ngayTao = ngayTao;
        this.tienKhachDua = tienKhachDua;
        this.TongTien = TongTien;
        this.suDungTichDiem = sdtd;
        this.tongKM = tongKM;
        this.tongThue = tongThue;
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
    
    public Double getSuDungTichDiem() {
        return suDungTichDiem;
    }
    
    public Double getTongKM() {
        return tongKM;
    }
    
    public Double getTongThue() {
        return tongThue;
    }

    public void setSuDungTichDiem(double suDungTichDiem) {
        this.suDungTichDiem = suDungTichDiem;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public void setTongKM(double tongKM) {
        this.tongKM = tongKM;
    }

    public void setTongThue(double tongThue) {
        this.tongThue = tongThue;
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
