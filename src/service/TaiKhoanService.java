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
    public ArrayList<TaiKhoan> getAllTK();
    public TaiKhoan getTK_TheoMa(String maTK);
    public TaiKhoan getTK_Theousername(String username); 
    public boolean themTKVaoCSDL(TaiKhoan tk);
    public boolean CapNhatTK(String maTK);
    public boolean XoaTK(String maTK);
}
