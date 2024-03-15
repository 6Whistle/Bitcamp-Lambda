package com.erichgamma.api.enums;

import com.erichgamma.api.account.AccountController;
import com.erichgamma.api.menu.Menu;
import com.erichgamma.api.menu.MenuController;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AccountRouter {
    ACCOUNT_EXIT("x", scanner -> {
        System.out.println("EXIT");
        return false;
    }),
    ACCOUNT_MAKE_TABLE("mk", scanner -> {
        return true;
    }),
    ACCOUNT_REMOVE_TABLE("rm-r", scanner -> {
        return true;
    }),
    ACCOUNT_CREATE("touch", scanner -> {
        System.out.println(AccountController.getInstance().creatAccount(scanner));
        return true;
    }),
    ACCOUNT_DELETE("rm", scanner -> {
        System.out.println(AccountController.getInstance().deleteAccount(scanner));
        return true;
    }),
    ACCOUNT_WITHDRAW("wdw", scanner -> {
        System.out.println(AccountController.getInstance().withdraw(scanner));
        return true;
    }),
    ACCOUNT_DEPOSIT("dps", scanner -> {
        System.out.println(AccountController.getInstance().deposit(scanner));
        return true;
    }),
    ACCOUNT_BALANCE("bal", scanner -> {
        System.out.println(AccountController.getInstance().getBalance(scanner));
        return true;
    }),
    ACCOUNT_FIND("cat", scanner -> {
        System.out.println(AccountController.getInstance().findAccount(scanner));
        return true;
    }),
    ACCOUNT_LIST("ls-a", scanner -> {
        System.out.println(AccountController.getInstance().getAccountsList());
        return true;
    }),
    ROUTING_ERROR("ROUTING_ERROR", scanner -> {
        System.out.println("Wrong Input");
        return true;
    });
    private final String name;
    private final Predicate<Scanner> predicate;

    AccountRouter(String name, Predicate<Scanner> predicate){
        this.name = name;
        this.predicate = predicate;
    }

    public static Boolean routing(Scanner scan){
        MenuController.getInstance().printMenusByCategory("account");
        String str = scan.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(ROUTING_ERROR).predicate.test(scan);
    }
}
