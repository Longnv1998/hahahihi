/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import view.HienThi.HienThi_NguoiNhan;
import view.Sua.Sua_NguoiNhan;
import view.Them.Them_NguoiNhan;
import view.TimKiem.Tim_NguoiNhan;
import view.Xoa.Xoa_NguoiNhan;

/**
 *
 * @author admin
 */
public class NguoiNhan {
    public static void main(String[] args) {
        NguoiNhan nn = new NguoiNhan();
        Scanner nhap = new Scanner(System.in);
        boolean stt = true;
        while (stt) {
            System.out.println("");
            System.out.println("Bạn đã chọn mục Người Nhận");
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
                    Them_NguoiNhan TNN = new Them_NguoiNhan();
                    TNN.main(args);
                    break;
                case 2:
                    stt = false;
                    Sua_NguoiNhan SNN = new Sua_NguoiNhan();
                    SNN.main(args);
                    break;
                case 3:
                    stt = false;
                    Xoa_NguoiNhan XNN = new Xoa_NguoiNhan();
                    XNN.main(args);
                    break;
                case 4:
                    stt = false;
                    Tim_NguoiNhan TimNN = new Tim_NguoiNhan();
                    TimNN.main(args);
                    break;
                case 5:
                    stt = false;
                    HienThi_NguoiNhan HNN = new HienThi_NguoiNhan();
                    HNN.main(args);
                    break;
                case 6:
                    stt=false;
                    System.out.println("Bạn đã kết thúc phiên làm việc với Bảng Người Nhận");
                    System.out.println("");
                    QuanLi ql=new QuanLi();
                    ql.main(args);
            }
        }
    }
}
