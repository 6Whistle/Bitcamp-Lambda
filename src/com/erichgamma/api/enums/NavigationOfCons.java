package com.erichgamma.api.enums;

import com.erichgamma.api.account.AccountView;
import com.erichgamma.api.auth.AuthView;
import com.erichgamma.api.crawler.CrawlerView;
import com.erichgamma.api.menu.Menu;
import com.erichgamma.api.menu.MenuController;
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
    USER("user", UserView::main),
    ACCOUNT("account", AccountView::main),
    CRAWLER("crawler", CrawlerView::main),
    POSTS("post", PostView::main),
    AUTH("auth", AuthView::main),
    NAVIGATION_ERROR("navigation_error", i -> System.out.println("Wrong Input"));

    private final String name;
    private final Consumer<Scanner> consumer;

    NavigationOfCons(String name, Consumer<Scanner> consumer) {
        this.name = name;
        this.consumer = consumer;
    }


    public static Boolean navigate(Scanner scan){
        System.out.println("[MENU]");
        MenuController.getInstance().getMenusByCategory("navigate").forEach(i -> System.out.print(((Menu)i).getItem() + ", "));
        System.out.println();
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
