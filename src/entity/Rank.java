/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Asus
 */
public class Rank {
    private String maRank;
    private String tenRank;
    private double tiLeTichDiem;

    public Rank(String maRank, String tenRank, double tiLeTichDiem) {
        this.maRank = maRank;
        this.tenRank = tenRank;
        this.tiLeTichDiem = tiLeTichDiem;
    }
    
    public Rank(String maRank) {
        this.maRank = maRank;
    }

    public Rank() {
    }

    public String getMaRank() {
        return maRank;
    }

    public String getTenRank() {
        return tenRank;
    }

    public double getTiLeTichDiem() {
        return tiLeTichDiem;
    }

    public void setMaRank(String maRank) {
        this.maRank = maRank;
    }

    public void setTenRank(String tenRank) {
        this.tenRank = tenRank;
    }

    public void setTiLeTichDiem(double tiLeTichDiem) {
        this.tiLeTichDiem = tiLeTichDiem;
    }
    
    
}
