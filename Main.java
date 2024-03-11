package com.erichgamma.api;

import com.erichgamma.api.account.AccountView;
import com.erichgamma.api.auth.AuthView;
//import com.erichgamma.api.board.BoardView;
import com.erichgamma.api.crawler.CrawlerView;
import com.erichgamma.api.enums.Navigation;
import com.erichgamma.api.post.PostView;
import com.erichgamma.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        while(Navigation.navigate(new Scanner(System.in)));
    }
}
