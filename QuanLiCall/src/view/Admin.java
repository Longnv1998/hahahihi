/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.webkit.ThemeClient;
import java.util.Scanner;
import view.HienThi.HienThi_Admin;
import view.Sua.Sua_Admin;
import view.Them.Them_Admin;
import view.TimKiem.Tim_Admin;
import view.Xoa.Xoa_Admin;

/**
 *
 * @author admin
 */
public class Admin {

    public static void main(String[] args) {
        Admin ad = new Admin();
        Scanner nhap = new Scanner(System.in);
        boolean stt = true;
        while (stt) {
            System.out.println("");
            System.out.println("Bạn đã chọn mục Admin");
            System.out.println("1.Thêm");
            System.out.println("2.Sửa");
            System.out.println("3.Xóa");
            System.out.println("4.Tìm kiếm");
            System.out.println("5.Hiển thị");
            System.out.println("6.Thoát");
            System.out.print("Mời chọn: ");
            int chon = Integer.parseInt(nhap.nextLine());
            switch (chon) {
                case 1:
                    stt = false;
                    Them_Admin TA = new Them_Admin();
                    TA.main(args);
                    break;
                case 2:
                    stt = false;
                    Sua_Admin SA = new Sua_Admin();
                    SA.main(args);
                    break;
                case 3:
                    stt = false;
                    Xoa_Admin XA = new Xoa_Admin();
                    XA.main(args);
                    break;
                case 4:
                    stt = false;
                    Tim_Admin TimA = new Tim_Admin();
                    TimA.main(args);
                    break;
                case 5:
                    stt = false;
                    HienThi_Admin HTA = new HienThi_Admin();
                    HTA.main(args);
                    break;
                case 6:
                    stt=false;
                    System.out.println("Bạn đã kết thúc phiên làm việc với Bảng Admin");
                    System.out.println("");
                    QuanLi ql=new QuanLi();
                    ql.main(args);
            }
        }
    }
}
