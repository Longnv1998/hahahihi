/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class QuanLi {
    public static void main(String[] args) {
        QuanLi ql = new QuanLi();
        Scanner nhap = new Scanner(System.in);
        boolean stt=true;
        while(stt){
            System.out.println("Danh mục quản lí");
            System.out.println("1.Bảng Admin");
            System.out.println("2.Bảng người gọi");
            System.out.println("3.Bảng người nhận");
            System.out.println("4.Bảng người dùng");
            System.out.println("5.Bảng trò chuyện");
            System.out.println("6.Thoát");
            System.out.print("Mời chọn: ");
            int chon=Integer.parseInt(nhap.nextLine());
            switch(chon){
                case 1:
                    stt=false;
                    Admin a=new Admin();
                    a.main(args);
                    break;
                case 2:
                    stt=false;
                    NguoiGoi b=new NguoiGoi();
                    b.main(args);
                    break;
                case 3:
                    stt=false;
                    NguoiNhan c=new NguoiNhan();
                    c.main(args);
                    break;
                case 4:
                    stt=false;
                    NguoiDung d=new NguoiDung();
                    d.main(args);
                    break;
                case 5:
                    stt=false;
                    Call e=new Call();
                    e.main(args);
                    break;
                case 6:
                    stt=false;
                    DangNhap dn =new DangNhap();
                    dn.main(args);
                    break;
            }
        }
    }
}
