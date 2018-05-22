/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import view.HienThi.HienThi_NguoiDung;
import view.Sua.Sua_NguoiDung;
import view.Them.Them_NguoiDung;
import view.TimKiem.Tim_NguoiDung;
import view.Xoa.Xoa_NguoiDung;

/**
 *
 * @author admin
 */
public class NguoiDung {
    public static void main(String[] args) {
        NguoiDung nn = new NguoiDung();
        Scanner nhap = new Scanner(System.in);
        boolean stt = true;
        while (stt) {
            System.out.println("");
            System.out.println("Bạn đã chọn mục Người Dùng");
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
                    Them_NguoiDung TND = new Them_NguoiDung();
                    TND.main(args);
                    break;
                case 2:
                    stt = false;
                    Sua_NguoiDung SND = new Sua_NguoiDung();
                    SND.main(args);
                    break;
                case 3:
                    stt = false;
                    Xoa_NguoiDung XND = new Xoa_NguoiDung();
                    XND.main(args);
                    break;
                case 4:
                    stt = false;
                    Tim_NguoiDung TimND = new Tim_NguoiDung();
                    TimND.main(args);
                    break;
                case 5:
                    stt = false;
                    HienThi_NguoiDung HND = new HienThi_NguoiDung();
                    HND.main(args);
                    break;
                case 6:
                    stt=false;
                    System.out.println("Bạn đã kết thúc phiên làm việc với Bảng Người Dùng");
                    System.out.println("");
                    QuanLi ql=new QuanLi();
                    ql.main(args);
            }
        }
    }
}
