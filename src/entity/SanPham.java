/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Asus
 */
public class SanPham {
    private String maSP;
    private KhuyenMai kM;
    private NhaCungCap nCC;
    private String tenSP;
    private Enum_class.enum_LoaiSP loaiSP;
    private double giaNhapHang;
    private double giaBan;
    private int soLuongBayBan;
    private int soLuongTonKho;

    public SanPham(String maSP, KhuyenMai kM, NhaCungCap nCC, String tenSP, Enum_class.enum_LoaiSP loaiSP, double giaNhapHang, double giaBan, int soLuongBayBan, int soLuongTonKho) {
        this.maSP = maSP;
        this.kM = kM;
        this.nCC = nCC;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.giaNhapHang = giaNhapHang;
        this.giaBan = giaBan;
        this.soLuongBayBan = soLuongBayBan;
        this.soLuongTonKho = soLuongTonKho;
    }

    public SanPham() {
    }

    public String getMaSP() {
        return maSP;
    }

    public KhuyenMai getkM() {
        return kM;
    }

    public NhaCungCap getnCC() {
        return nCC;
    }

    public String getTenSP() {
        return tenSP;
    }

    public Enum_class.enum_LoaiSP getLoaiSP() {
        return loaiSP;
    }

    public double getGiaNhapHang() {
        return giaNhapHang;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public int getSoLuongBayBan() {
        return soLuongBayBan;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setkM(KhuyenMai kM) {
        this.kM = kM;
    }

    public void setnCC(NhaCungCap nCC) {
        this.nCC = nCC;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setLoaiSP(Enum_class.enum_LoaiSP loaiSP) {
        this.loaiSP = loaiSP;
    }

    public void setGiaNhapHang(double giaNhapHang) {
        this.giaNhapHang = giaNhapHang;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public void setSoLuongBayBan(int soLuongBayBan) {
        this.soLuongBayBan = soLuongBayBan;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.maSP);
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
        final SanPham other = (SanPham) obj;
        return Objects.equals(this.maSP, other.maSP);
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
