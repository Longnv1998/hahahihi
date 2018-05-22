/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Connect.DButilities;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class DangNhap {

    public static void main(String[] args) {
        DangNhap dn = new DangNhap();
        Scanner nhap = new Scanner(System.in);
        boolean stt=true;
        while (stt) {
            System.out.println("Phần mềm quản lí");
            System.out.println("1.Đăng nhập");
            System.out.println("2.Thoát");
            System.out.print("Mời chọn: ");
            int chon = Integer.parseInt(nhap.nextLine());
            switch (chon) {
                case 1:
                    stt=false;
                    dn.Login();
                    System.out.println("");
                    QuanLi ql=new QuanLi();
                    ql.main(args);
                    break;
                case 2:
                    System.exit(0);
            }
        }
    }

    private void Login() {
        Connection con;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Scanner nhap = new Scanner(System.in);
        //input
        System.out.println("Đăng nhập");
        System.out.println("Tên đăng nhập: ");
        String TenTK = nhap.nextLine().trim();
        System.out.println("Mật Khẩu: ");
        String MK = nhap.nextLine().trim();
        //validate
        String err = "";
        if (TenTK.length() == 0) {
            err = "\n-Chưa nhập tên đăng nhập";
        }
        if (MK.length() == 0) {
            err += "\n-Chưa nhập mật khẩu";
        }
        if (err.length() == 0) {
            con = DButilities.openConnection();
            try {
                cstmt = con.prepareCall("{call login (?,?)}");
                cstmt.setString(1, TenTK);
                cstmt.setString(2, MK);
                rs = cstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Đăng nhập thành công");
                } else {
                    System.out.println("Tên đăng nhập hoặc mật khẩu không đúng");
                    System.out.println("");
                    DangNhap dn=new DangNhap();
                    dn.Login();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DButilities.AllClose(con, null, cstmt, rs);
            }
        } else {
            System.out.println(""+err);
        }
    }
}
