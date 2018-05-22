/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.TimKiem;

import Connect.DButilities;
import java.net.SocketOptions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.Admin;

/**
 *
 * @author admin
 */
public class Tim_Admin {

    public static void main(String[] args) {
        System.out.print("Nhập Họ và tên người bạn cần tìm: ");
        Scanner nhap = new Scanner(System.in);
        String tim = nhap.nextLine();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        //tableModel.setRowCount(0);
        con = DButilities.openConnection();
        try {
            pstmt = con.prepareStatement("Select*from tbl_Admin where HoVaTen=?");
            pstmt.setString(1, tim);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Tìm thấy kết quả:");
                System.out.println("\t Họ Và tên: " + rs.getString("HoVaTen"));
                System.out.println("\t Tên Tài Khoản: " + rs.getString("TenTK"));
                System.out.println("\t Mật khẩu: " + rs.getString("MatKhau"));
                System.out.println("\t Mô tả: " + rs.getString("Mota"));
                Admin a = new Admin();
                a.main(args);
            } else {
                System.out.println("Không tìm thấy");
                main(args);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tim_Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DButilities.AllClose(con, pstmt, null, rs);
        }
    }
}
