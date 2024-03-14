package com.erichgamma.api.enums;

import com.erichgamma.api.account.AccountController;
import com.erichgamma.api.menu.Menu;
import com.erichgamma.api.menu.MenuController;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AccountRouter {
    EXIT("0", scanner -> {
        System.out.println("EXIT");
        return false;
    }),
    CREATE("1", scanner -> {
        System.out.println(AccountController.getInstance().creatAccount(scanner));
        return true;
    }),
    WITHDRAW("2", scanner -> {
        System.out.println(AccountController.getInstance().withdraw(scanner));
        return true;
    }),
    DEPOSIT("3", scanner -> {
        System.out.println(AccountController.getInstance().deposit(scanner));
        return true;
    }),
    BALANCE("4", scanner -> {
        System.out.println(AccountController.getInstance().getBalance(scanner));
        return true;
    }),
    DELETE_ACCOUNT("5", scanner -> {
        System.out.println(AccountController.getInstance().deleteAccount(scanner));
        return true;
    }),
    FIND_ACCOUNT("6", scanner -> {
        System.out.println(AccountController.getInstance().findAccount(scanner));
        return true;
    }),
    ACCOUNT_LIST("7", scanner -> {
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
        System.out.println("[MENU]");
        MenuController.getInstance().getMenusByCategory("account").forEach(i -> System.out.print(((Menu)i).getItem() + ", "));
        System.out.println();
        String str = scan.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(ROUTING_ERROR).predicate.test(scan);
    }
}
