/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public interface KhachHangService {
    public ArrayList<KhachHang> getAllKH();
    public KhachHang getKH_TheoMa(String maKH);
    public void Xoa_KH(String maKH);
    public boolean Them_KH(KhachHang kh_new);
    public void Sua_KH(KhachHang kh_new);
}
