/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Asus
 */
public class ChiTietHoaDon {
    private HoaDon hoaDon;
    private SanPham sanPham;
    private int soLuong;
    private double thanhTien;
    private double tongDoanhThu;
//    private double vAT;
    
    public ChiTietHoaDon(HoaDon hoaDon, SanPham sanPham, int soLuong, double thanhTien, double tongDoanhThu) {
        this.hoaDon = hoaDon;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.tongDoanhThu = tongDoanhThu;
//        this.vAT = vAT;
    }

    public ChiTietHoaDon(HoaDon hoaDon, SanPham sanPham, int soLuong, double thanhTien) {
        this.hoaDon = hoaDon;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
//        this.vAT = vAT;
    }

    public ChiTietHoaDon() {
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }
    
    public double getThanhTien() {
        return thanhTien;
    }

//    public double getvAT() {
//        return vAT;
//    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

//    public void setvAT(double vAT) {
//        this.vAT = vAT;
//    }
}
