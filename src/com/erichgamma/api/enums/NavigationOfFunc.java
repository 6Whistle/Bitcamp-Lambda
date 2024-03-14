package com.erichgamma.api.enums;

import com.erichgamma.api.account.AccountView;
import com.erichgamma.api.auth.AuthView;
import com.erichgamma.api.crawler.CrawlerView;
import com.erichgamma.api.post.PostView;
import com.erichgamma.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum NavigationOfFunc {
    EXIT("exit", i -> {
        System.out.println("EXIT");
        return "exit";
    }),
    USER("user", i -> {
        UserView.main(i);
        return "";
    }),
    ACCOUNT("account", i -> {
        AccountView.main(i);
        return "";
    }),
    CRAWLER("crawler", i -> {
        CrawlerView.main(i);
        return "";
    }),
    POSTS("posts", i -> {
        PostView.main(i);
        return "";
    }),
    AUTH("auth", i -> {
        AuthView.main(i);
        return "";
    }),
    NAVIGATION_ERROR("navigation_error", i -> {
        System.out.println("Wrong Input");
        return "";
    });

    private final String name;
    private final Function<Scanner, String> function;

    NavigationOfFunc(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static Boolean navigate(Scanner scan){
        System.out.println("exit-Exit, auth-Auth, account-Account, crawler-Crawler, posts-Post, user-User");
        String str = scan.next();
        return !Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(NAVIGATION_ERROR).function.apply(scan).equals("exit");
    }
}
