/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Asus
 */
public class TaiKhoan {
    private String maTK;
    private NhanVien maNV;
    private String tenNguoiDung;
    private String username;
    private String password;
    private String loaiTK;

    public TaiKhoan(String maTK, NhanVien maNV, String tenNguoiDung, String username, String password, String loaiTK) {
        this.maTK = maTK;
        this.maNV = maNV;
        this.tenNguoiDung = tenNguoiDung;
        this.username = username;
        this.password = password;
        this.loaiTK = loaiTK;
    }

    public TaiKhoan() {
    }

    public String getMaTK() {
        return maTK;
    }

    public NhanVien getMaNV() {
        return maNV;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLoaiTK() {
        return loaiTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public void setMaNV(NhanVien maNV) {
        this.maNV = maNV;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoaiTK(String loaiTK) {
        this.loaiTK = loaiTK;
    }
    
    
}
