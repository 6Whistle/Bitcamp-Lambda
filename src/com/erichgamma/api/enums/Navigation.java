package com.erichgamma.api.enums;

import com.erichgamma.api.account.AccountView;
import com.erichgamma.api.auth.AuthView;
import com.erichgamma.api.crawler.CrawlerView;
import com.erichgamma.api.menu.MenuController;
import com.erichgamma.api.post.PostView;
import com.erichgamma.api.user.UserView;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Navigation {
    EXIT("x", i -> {
        System.out.println("EXIT");
        return false;
    }),
    ACCOUNT("acc", i -> {
        AccountView.main(i);
        return true;
    }),
    AUTH("ath", i -> {
        AuthView.main(i);
        return true;
    }),
    CRAWLER("cwl", i -> {
        CrawlerView.main(i);
        return true;
    }),
    POST("pst", i -> {
        PostView.main(i);
        return true;
    }),
    USER("usr", i -> {
        UserView.main(i);
        return true;
    }),
    SOCCER("scr", i -> {
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
        MenuController.getInstance().printMenusByCategory("navigate");
        String str = scan.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(NAVIGATION_ERROR).predicate.test(scan);
    }
}
