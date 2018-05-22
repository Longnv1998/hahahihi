/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Xoa;

import Connect.DButilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class Xoa_Admin {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        Scanner nhap = new Scanner(System.in);
        try {
            System.out.print("Tên tài khoản: ");
            String TenTk = nhap.nextLine();
            con = DButilities.openConnection();
            pstmt = con.prepareStatement("Delete from tbl_Admin where TenTk=?");

            pstmt.setString(1, TenTk);

            int i = pstmt.executeUpdate();
            if (i > 0) {
                System.out.println("Xóa Thành công");
                Admin a = new Admin();
                a.main(args);
            } else {
                System.out.println("Xóa Thất bại");
                main(args);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Xoa_Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DButilities.AllClose(con, pstmt, null, null);
        }
    }
}
