/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.NhaCungCap;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public interface NhaCungCapService {
    public String tuPhatSinhMa();
    public ArrayList<NhaCungCap> getAllNCC();
    public NhaCungCap getNCC_TheoMa(String maNCC);
    public boolean ThemNCC(NhaCungCap ncc);
    public boolean CapNhatNCC(NhaCungCap ncc_new);
}
