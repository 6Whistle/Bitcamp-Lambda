package com.erichgamma.api.auth;

import java.sql.SQLException;
import java.util.Scanner;

public class AuthView {
    public static void main(Scanner scan) throws SQLException {
        AuthController controller = new AuthController();
        controller.addUsers();

        while(true){
            System.out.println("[메뉴] 0.종료, 1.회원가입, 2.로그인, 3.ID 검색, 4.비번 변경, \n" +
                               "5.탈퇴, 6.회원목록, 7.이름 검색, 8.직업 검색, 9. 회원수, rm-Remove Table, touch-Make Table");
            switch (scan.next()){
                case "0" : System.out.println("종료");           return;
                case "1" : controller.join(scan);               break;
                case "2" : controller.login(scan);              break;
                case "3" : controller.getOne(scan);             break;
                case "4" : controller.updatePassword(scan);     break;
                case "5" : controller.deleteUser(scan);         break;
                case "6" :
//                    controller.getUsersMap();
//                    System.out.println(controller.test());
                    controller.findUsers().forEach(System.out::println);
                    break;
                case "7" : controller.findUsersByName(scan);    break;
                case "8" : controller.findUsersByJob(scan);     break;
                case "9" : controller.countUsers();             break;
                case "rm" :
                    System.out.println("=== remove table ===");
                    System.out.println("==== tables are generated ===");
                    break;
                case "touch" :
                    System.out.println("=== make table ===");
                    System.out.println("==== tables are generated ===");
                    break;
                default  :  System.out.println("잘못된 입력입니다");
            }
        }
    }
}
