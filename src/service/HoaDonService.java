/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.HoaDon;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public interface HoaDonService {
    public String tuPhatSinhMaHD();
    public ArrayList<HoaDon> getAllHD();
    public HoaDon getHD_TheoMa(String maHD);
    public boolean themHD(HoaDon hd);
    public void CapNhatHD(HoaDon hd_old, HoaDon hd_new);
//    public 
}
