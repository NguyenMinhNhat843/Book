/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Asus
 */
public class ChiTietHD_NCC {
    private SanPham sanPham;
    private HoaDonNCC hdNCC;
    private int soLuongNhap;
//    private double thue;

    public ChiTietHD_NCC(SanPham sanPham, HoaDonNCC hdNCC, int soLuongNhap) {
        this.sanPham = sanPham;
        this.hdNCC = hdNCC;
        this.soLuongNhap = soLuongNhap;
    }

    public ChiTietHD_NCC() {
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public HoaDonNCC getHdNCC() {
        return hdNCC;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public void setHdNCC(HoaDonNCC hdNCC) {
        this.hdNCC = hdNCC;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }
}
