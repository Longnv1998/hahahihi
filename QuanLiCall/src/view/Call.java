/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import view.HienThi.HienThi_Call;
import view.Sua.Sua_Call;
import view.Them.Them_Call;
import view.TimKiem.Tim_Call;
import view.Xoa.Xoa_Call;

/**
 *
 * @author admin
 */
public class Call {
    public static void main(String[] args) {
        Call nn = new Call();
        Scanner nhap = new Scanner(System.in);
        boolean stt = true;
        while (stt) {
            System.out.println("");
            System.out.println("Bạn đã chọn mục Trò truyện");
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
                    Them_Call TC = new Them_Call();
                    TC.main(args);
                    break;
                case 2:
                    stt = false;
                    Sua_Call SC = new Sua_Call();
                    SC.main(args);
                    break;
                case 3:
                    stt = false;
                    Xoa_Call XC = new Xoa_Call();
                    XC.main(args);
                    break;
                case 4:
                    stt = false;
                    Tim_Call TimC = new Tim_Call();
                    TimC.main(args);
                    break;
                case 5:
                    stt = false;
                    HienThi_Call HTC = new HienThi_Call();
                    HTC.main(args);
                    break;
                case 6:
                    stt=false;
                    System.out.println("Bạn đã kết thúc phiên làm việc với Bảng Trò truyện");
                    System.out.println("");
                    QuanLi ql=new QuanLi();
                    ql.main(args);
            }
        }
    }
}
