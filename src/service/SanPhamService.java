/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.SanPham;
//import java.awt.List;
import java.util.*;

/**
 *
 * @author Asus
 */
public interface SanPhamService {
    public String phatSinhMaTuDong();
    public List<SanPham> getDSSP();
    public SanPham getSP_TheoMa(String maSP);
    
}
