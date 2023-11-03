/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.TaiKhoan;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public interface TaiKhoanService {
    public ArrayList<TaiKhoanService> getAllTK();
    public TaiKhoan getTK_TheoMa(String maTK);
    public TaiKhoan getTK_Theousername(String username); 
    public void themTKVaoCSDL(TaiKhoanService tk);
    public void CapNhatTK(String maTK);
    public void XoaTK(String maTK);
}
