/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Asus
 */
public class NhanVien {
    private String maNV;
    private TaiKhoan taiKhoan;
    private String tenNV;
    private String sDT;
    private String email;
    private String diaChi;
    private boolean trangThai;

    public NhanVien(String maNV, TaiKhoan taiKhoan, String tenNV, String sDT, String email, String diaChi, boolean trangThai) {
        this.maNV = maNV;
        this.taiKhoan = taiKhoan;
        this.tenNV = tenNV;
        this.sDT = sDT;
        this.email = email;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }
    
    public NhanVien(String maNV) {
        this.maNV = maNV;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getsDT() {
        return sDT;
    }

    public String getEmail() {
        return email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
