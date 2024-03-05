package user;

import java.util.Scanner;

public class UserView {

    public static void main(Scanner scan) {

        UserController userController = new UserController();
        System.out.println("addUsers : " + userController.addUser());

        while(true){
            System.out.println("[메뉴] 0.종료 1.회원가입 2.로그인 3.ID 탐색 4.PW 변경 5.탈퇴\n" +
                                " 6.회원 목록 7.이름 검색, 8.직업 검색 9.회원 수");
            switch (scan.next()){
                case "0" :  System.out.println("종료");                                          return;
                case "1" :  System.out.println(userController.join(scan));                      break;
                case "2" :  System.out.println(userController.login(scan));                     break;
                case "3" :  System.out.println(userController.getUserByUsername(scan));         break;
                case "4" :  System.out.println(userController.updatePassword(scan));            break;
                case "5" :  System.out.println(userController.deleteUser(scan));                break;
                case "6" :  userController.getUserMap();                                        break;
                case "7" :  userController.findUsersByName(scan);                               break;
                case "8" :  userController.findUsersByJob(scan);                                break;
                case "9" :  System.out.println(userController.getUsersCount());     break;
                default  :  System.out.println("잘못된 입력입니다");
            }
        }
    }
}
