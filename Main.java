import account.AccountView;
import auth.AuthView;
//import board.BoardView;
import crawler.CrawlerView;
import post.PostView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("0-Exit, 1-Auth, 2-Board, 3-Account, 4-Crawler, 5-Post");
            switch(scan.next()){
                case "0":   System.out.println("종료");      return;
                case "1":   AuthView.main(scan);            break;
//                case "2":   BoardView.main();               break;
                case "3":   AccountView.main(scan);         break;
                case "4":   CrawlerView.main(scan);         break;
                case "5":   PostView.main(scan);            break;
                default:    System.out.println("Wrong Input");
            }

        }

    }
}
