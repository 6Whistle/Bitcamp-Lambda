package com.erichgamma.api.enums;

import com.erichgamma.api.account.AccountView;
import com.erichgamma.api.auth.AuthView;
import com.erichgamma.api.crawler.CrawlerView;
import com.erichgamma.api.menu.Menu;
import com.erichgamma.api.menu.MenuController;
import com.erichgamma.api.post.PostView;
import com.erichgamma.api.user.UserView;
import lombok.Getter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public enum NavigationOfSup {
    EXIT("exit", () -> {
        System.out.println("EXIT");
        return false;
    }),
    USER("user", () -> {
        UserView.main(getSCANNER());
        return true;
    }),
    ACCOUNT("account", () -> {
        AccountView.main(getSCANNER());
        return true;
    }),
    CRAWLER("crawler", () -> {
        CrawlerView.main(getSCANNER());
        return true;
    }),
    POSTS("post", () -> {
        PostView.main(getSCANNER());
        return true;
    }),
    AUTH("auth", () -> {
        AuthView.main(getSCANNER());
        return true;
    }),
    NAVIGATION_ERROR("navigation_error", () -> {
        System.out.println("Wrong Input");
        return true;
    });

    private final String name;
    private final Supplier<Boolean> supplier;
    @Getter
    private static final Scanner SCANNER = new Scanner(System.in);

    NavigationOfSup(String name, Supplier<Boolean> supplier) {
        this.name = name;
        this.supplier = supplier;
    }

    public static Boolean navigate(){
        System.out.println("[MENU]");
        MenuController.getInstance().getMenusByCategory("navigate").forEach(i -> System.out.print(((Menu)i).getItem() + ", "));
        System.out.println();
        String str = getSCANNER().next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(NAVIGATION_ERROR).supplier.get();
    }
}
