/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Them;

import Connect.DButilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.NguoiGoi;

/**
 *
 * @author admin
 */
public class Them_NguoiGoi {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        Scanner nhap = new Scanner(System.in);
        try
        {
            System.out.println("");
            System.out.println("Thêm Người gọi");
            System.out.println("Mã gọi: ");
            String MaGoi = nhap.nextLine();
            System.out.println("Họ và tên: ");
            String HoTen = nhap.nextLine();
            System.out.println("Mô tả: ");
            String Mota = nhap.nextLine();
            //
            String err = "";
            con = DButilities.openConnection(); //kết nối cơ sở dữ liệu
            if (MaGoi.length() == 0) {
                err = "\n-Chưa nhập Mã Gọi";
            }
            if (HoTen.length() == 0) {
                err += "\n-Chưa nhập họ tên";
            }
            if (Mota.length() == 0) {
                err += "\n-Chưa nhập mô tả";
            }
            if (err.length() == 0) {
                pstmt = con.prepareStatement("insert into tbl_NguoiGoi values(?,?,?)");
                pstmt.setString(1, MaGoi);
                pstmt.setString(2, HoTen);
                pstmt.setString(3, Mota);
                
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("Thêm thành công");
                    NguoiGoi a=new NguoiGoi();
                    a.main(args);
                } else {
                    System.out.println("Thêm thất bại");
                    main(args);
                }
            } else {
                System.out.println(""+err);
            }
        }catch (SQLException ex) {
                Logger.getLogger(Them_NguoiGoi.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally {
            DButilities.AllClose(con, pstmt, null, null);
        }
    }
}
