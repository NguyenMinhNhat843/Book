/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public interface HoaDon {
    public ArrayList<HoaDon> getAllHoaDon();
    public HoaDon getHoaDon_TheoMa();
    public void themHoaDonVaoCSDL();
    public void CapNhatHoaDon(HoaDon hd_old ,HoaDon hd_new);
}