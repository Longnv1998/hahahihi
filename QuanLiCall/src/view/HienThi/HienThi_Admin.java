/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.HienThi;

import Connect.DButilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Admin;

/**
 *
 * @author admin
 */
public class HienThi_Admin {

    public static void main(String[] args) {
        LoadDataAdmin();
        Admin a=new Admin();
        a.main(args);
    }
    
    public static void LoadDataAdmin() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        con = DButilities.openConnection();
        try {
            pstmt = con.prepareStatement("select*from tbl_Admin");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Thông tin:");
                System.out.println("\t id: " + rs.getInt("MaAd"));
                System.out.println("\t Họ và tên: " + rs.getString("HoVaTen"));
                System.out.println("\t Tên tài khoản: " + rs.getString("TenTK"));
                System.out.println("\t Mật Khẩu: " + rs.getString("MatKhau"));
                System.out.println("\t Mô tả: " + rs.getString("Mota"));
                System.out.println("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HienThi_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally 
        {
            DButilities.AllClose(con, pstmt, null, rs);
        }
    }
}
