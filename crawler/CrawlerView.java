package crawler;

import auth.AuthController;

import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner scan) {
        CrawlerController controller = new CrawlerController();

        while(true){
            System.out.println("[메뉴] 0.종료, 1.벅스뮤직, 2.로그인, 3.ID 검색, 4.비번 변경, \n" +
                    "5.탈퇴, 6.회원목록, 7.이름 검색, 8.직업 검색, 9. 회원수");
            switch (scan.next()){
                case "0" : System.out.println("종료");           return;
                case "1" :
                    Map<String, ?> map = controller.findBugsMusic(scan);
                    break;
                case "2" :               break;
                case "3" :        break;
                case "4" :      break;
                case "5" : break;
                case "6" :             break;
                case "7" :     break;
                case "8" :      break;
                case "9" :              break;
                default  :  System.out.println("잘못된 입력입니다");
            }
        }
    }
}
