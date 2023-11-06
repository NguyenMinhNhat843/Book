/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import entity.Rank;
import java.util.Objects;

/**
 *
 * @author Asus
 */
public class KhachHang {
    private String maKH;
    private String tenKH;
    private String sDT;
    private String email;
    private String diaChi;
    private double tieuPhiTichLuy;
    private Rank rank;
    private double tichDiem;

    public KhachHang(String maKH, String tenKH, String sDT, String email, String diaChi, double tieuPhiTichLuy, Rank rank, double tichDiem) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sDT = sDT;
        this.email = email;
        this.diaChi = diaChi;
        this.tieuPhiTichLuy = tieuPhiTichLuy;
        this.rank = rank;
        this.tichDiem = tichDiem;
    }
    
    public KhachHang(String maKH) {
        this.maKH = maKH;
    }
    
    public KhachHang(String maKH, String tenKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
    }

    public KhachHang() {
    }

    public String getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
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
    
    public double getTieuPhiTichLuy() {
        return tieuPhiTichLuy;
    }

    public Rank getRank() {
        return rank;
    }

    public double getTichDiem() {
        return tichDiem;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
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
    
    public void setTieuPhiTichLuy(double tieuPhiTichLuy) {
        this.tieuPhiTichLuy = tieuPhiTichLuy;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setTichDiem(double tichDiem) {
        this.tichDiem = tichDiem;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.maKH);
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
        final KhachHang other = (KhachHang) obj;
        return Objects.equals(this.maKH, other.maKH);
    }
    
    
}
