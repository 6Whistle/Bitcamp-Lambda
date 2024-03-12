package com.erichgamma.api.enums;

import com.erichgamma.api.account.AccountView;
import com.erichgamma.api.auth.AuthView;
import com.erichgamma.api.crawler.CrawlerView;
import com.erichgamma.api.post.PostView;
import com.erichgamma.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Navigation {
    EXIT("exit", i -> {
        System.out.println("EXIT");
        return false;
    }),
    USER("user", i -> {
        UserView.main(i);
        return true;
    }),
    ACCOUNT("account", i -> {
        AccountView.main(i);
        return true;
    }),
    CRAWLER("crawler", i -> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    POSTS("posts", i -> {
        try {
            PostView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    AUTH("auth", i -> {
        try {
            AuthView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    NAVIGATION_ERROR("navigation_error", i -> {
        System.out.println("Wrong Input");
        return true;
    });

    private final String name;
    private final Predicate<Scanner> predicate;

    Navigation(String name, Predicate<Scanner> predicate){
        this.name = name;
        this.predicate = predicate;
    }

    public static Boolean navigate(Scanner scan){
        System.out.println("exit-Exit, auth-Auth, account-Account, crawler-Crawler, post-Post, user-User");
        String str = scan.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(NAVIGATION_ERROR).predicate.test(scan);
    }
}
