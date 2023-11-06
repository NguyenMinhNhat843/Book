/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.ChiTietHoaDon;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public interface ChiTietHoaDonService {
    public boolean ThemCTHDVaoCSDL(ChiTietHoaDon cthd);
    public ArrayList<ChiTietHoaDon> getDSSP_TheoMaHD(String maHD);
}
