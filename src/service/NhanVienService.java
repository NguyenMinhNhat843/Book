/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.NhanVien;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public interface NhanVienService {
    public ArrayList<NhanVien> getAllNV();
    public NhanVien getNV_TheoMa(String maNV_searched);
    public void themNVVaoCSDL(NhanVien nv);
    public void xoaNV(String maNV);
    public void capNhatNV(NhanVien nv_old, NhanVien nv_new);
    
}
