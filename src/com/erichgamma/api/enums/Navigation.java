package com.erichgamma.api.enums;

import com.erichgamma.api.account.AccountView;
import com.erichgamma.api.auth.AuthView;
import com.erichgamma.api.crawler.CrawlerView;
import com.erichgamma.api.menu.Menu;
import com.erichgamma.api.menu.MenuController;
import com.erichgamma.api.post.PostView;
import com.erichgamma.api.user.UserView;

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
        CrawlerView.main(i);
        return true;
    }),
    POSTS("post", i -> {
        PostView.main(i);
        return true;
    }),
    AUTH("auth", i -> {
        AuthView.main(i);
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
        System.out.println("[MENU]");
        MenuController.getInstance().getMenusByCategory("navigate").forEach(i -> System.out.print(((Menu)i).getItem() + ", "));
        System.out.println();
        String str = scan.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(NAVIGATION_ERROR).predicate.test(scan);
    }
}
