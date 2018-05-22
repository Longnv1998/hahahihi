/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Them;

import Connect.DButilities;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.NguoiDung;

/**
 *
 * @author admin
 */
public class Them_NguoiDung {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        //ResultSet rs = null;
        Scanner nhap = new Scanner(System.in);
        try {
            System.out.println("");
            System.out.println("Thêm Người dùng");
            System.out.println("Họ Và Tên: ");
            String Ten = nhap.nextLine();
            System.out.println("Tên tài khoản: ");
            String TenTk = nhap.nextLine();
            System.out.println("Mật khẩu: ");
            String MK = nhap.nextLine();
            System.out.println("Giới tính: ");
            //giới tính
            boolean GT;
            if (nhap.nextLine() == "nam") {
                GT = true;
            } else {
                GT = false;
            }
            System.out.println("Tuổi: ");
            int Tuoi = Integer.parseInt(nhap.nextLine());
            System.out.println("Địa chỉ: ");
            String DC = nhap.nextLine();
            System.out.println("Số điện thoại: ");
            String SDT = nhap.nextLine();
            //
            String err = "";
            con = DButilities.openConnection(); //kết nối cơ sở dữ liệu
            if (Ten.length() == 0) {
                err = "\n-Chưa nhập họ tên";
            }
            if (TenTk.length() == 0) {
                err += "\n-Chưa nhập tên tài khoản";
            }
            if (MK.length() == 0) {
                err += "\n-Chưa nhập mật khẩu";
            }
            if (Tuoi < 0) {
                err += "\n-Nhập sai Tuổi";
            }
            if (DC.length() == 0) {
                err += "\n-Chưa nhập Địa chỉ";
            }
            if (SDT.length() == 0) {
                err += "\n-Chưa nhập số điện thoại";
            }
            if (err.length() == 0) {
                pstmt = con.prepareStatement("create proc insert_NguoiDung\n"
                        + "	@HoVaTen nvarchar(100),\n"
                        + "	@TenTK varchar(50),\n"
                        + "	@MatKhau nvarchar(50),\n"
                        + "	@GioiTinh bit,\n"
                        + "	@Tuoi int,\n"
                        + "	@DiaChi nvarchar(250),\n"
                        + "	@SDT varchar(50)\n"
                        + "as\n"
                        + "insert into  tbl_User(HoVaTen,TenTK,MatKhau,GioiTinh,Tuoi,DiaChi,SDT) values(@HoVaTen,@TenTK,@MatKhau,@GioiTinh,@Tuoi,@DiaChi,@SDT)");
                pstmt.setString(1, Ten);
                pstmt.setString(2, TenTk);
                pstmt.setString(3, MK);
                pstmt.setBoolean(4, GT);
                pstmt.setInt(5, Tuoi);
                pstmt.setString(6, DC);
                pstmt.setString(7, SDT);

                int i = pstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("Thêm thành công");
                    NguoiDung a = new NguoiDung();
                    a.main(args);
                } else {
                    System.out.println("Thêm thất bại");
                    main(args);
                }
            } else {
                System.out.println("" + err);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Them_NguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DButilities.AllClose(con, pstmt, null, null);
        }
    }
}
