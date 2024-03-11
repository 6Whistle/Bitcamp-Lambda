package com.erichgamma.api;

import com.erichgamma.api.account.AccountView;
import com.erichgamma.api.auth.AuthView;
//import com.erichgamma.api.board.BoardView;
import com.erichgamma.api.crawler.CrawlerView;
import com.erichgamma.api.post.PostView;
import com.erichgamma.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("x-Exit, au-com.erichgamma.api.auth, b-Board, a-Account, c-Crawler, p-Post, u-User");
            switch(scan.next()){
                case "x":   System.out.println("종료");      return;
                case "au":   AuthView.main(scan);            break;
//                case "b":   BoardView.main();               break;
                case "a":   AccountView.main(scan);         break;
                case "c":   CrawlerView.main(scan);         break;
                case "p":   PostView.main(scan);            break;
                case "u":   UserView.main(scan);            break;
                default:    System.out.println("Wrong Input");
            }

        }

    }
}
