/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Sua;

import Connect.DButilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Admin;

/**
 *
 * @author admin
 */
public class Sua_Admin {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        Scanner nhap = new Scanner(System.in);
        try
        {
            System.out.println("");
            System.out.print(" Sửa tài khoản Admin thứ: ");
            int id=Integer.parseInt(nhap.nextLine());
            System.out.println("Họ và tên: ");
            String HoTen = nhap.nextLine();
            System.out.println("Tên tài khoản: ");
            String TenTk = nhap.nextLine();
            System.out.println("Mật Khẩu: ");
            String MK = nhap.nextLine();
            System.out.println("Mô tả: ");
            String Mota = nhap.nextLine();
            //
            String err = "";
            con = DButilities.openConnection(); //kết nối cơ sở dữ liệu
            if (HoTen.length() == 0) {
                err = "\n-Chưa nhập họ tên";
            }
            if (TenTk.length() == 0) {
                err += "\n-Chưa nhập tên tài khoản";
            }
            if (MK.length() == 0) {
                err += "\n-Chưa nhập Mật khẩu";
            }
            if (Mota.length() == 0) {
                err += "\n-Chưa nhập mô tả";
            }
            if (err.length() == 0) {
                pstmt = con.prepareStatement("Update tbl_Admin set HoVaTen=?,TenTK=?,MatKhau=?,Mota=? where MaAd=?");
                pstmt.setString(1, HoTen);
                pstmt.setString(2, TenTk);
                pstmt.setString(3, MK);
                pstmt.setString(4, Mota);
                pstmt.setInt(5,id);

                int i = pstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("Sửa thành công");
                    Admin a=new Admin();
                    a.main(args);
                } else {
                    System.out.println("Sửa thất bại");
                    main(args);
                }
            } else {
                System.out.println(""+err);
            }
        }catch (SQLException ex) {
                Logger.getLogger(Sua_Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally {
            DButilities.AllClose(con, pstmt, null, null);
        }
    }
}
