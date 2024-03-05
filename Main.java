import account.AccountView;
import auth.AuthView;
import board.BoardView;
import user.UserView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("0-종료, 1-Auth, 2-성적표, 3-게시판, 4-카우프, 5-User, 6-계좌관리");
            switch(scan.next()){
                case "0":   System.out.println("종료");      return;
                case "1":   AuthView.main(scan);            break;
//                case "2":   GradeView.main(scan);           break;
                case "3":   BoardView.main();               break;
//                case "4":   KaupView.main();                break;
                case "5":   UserView.main(scan);            break;
                case "6":   AccountView.main(scan);         break;
                default:    System.out.println("잘못된 입력입니다");
            }

        }

    }
}
