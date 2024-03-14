package com.erichgamma.api.enums;

import com.erichgamma.api.account.AccountView;
import com.erichgamma.api.auth.AuthView;
import com.erichgamma.api.crawler.CrawlerView;
import com.erichgamma.api.post.PostView;
import com.erichgamma.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public enum NavigationOfCons {
    EXIT("exit", i -> {
        System.out.println("EXIT");
        throw new RuntimeException("");
    }),
    USER("user", i -> {
        UserView.main(i);
    }),
    ACCOUNT("account", i -> {
        AccountView.main(i);
    }),
    CRAWLER("crawler", i -> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }),
    POSTS("posts", i -> {
        try {
            PostView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    AUTH("auth", i -> {
        try {
            AuthView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    NAVIGATION_ERROR("navigation_error", i -> {
        System.out.println("Wrong Input");
    });

    private final String name;
    private final Consumer<Scanner> consumer;

    NavigationOfCons(String name, Consumer<Scanner> consumer) {
        this.name = name;
        this.consumer = consumer;
    }


    public static Boolean navigate(Scanner scan){
        System.out.println("exit-Exit, auth-Auth, account-Account, crawler-Crawler, post-Post, user-User");
        String str = scan.next();
        try{
            Stream.of(values()).filter(i -> i.name.equals(str))
                    .findAny().orElse(NAVIGATION_ERROR).consumer.accept(scan);
        } catch (RuntimeException e){
            return false;
        }
        return true;
    }
}
