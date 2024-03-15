package com.erichgamma.api.enums;

import com.erichgamma.api.auth.AuthController;
import com.erichgamma.api.menu.Menu;
import com.erichgamma.api.menu.MenuController;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AuthRouter {
    AUTH_EXIT("x", scanner -> {
        System.out.println("EXIT");
        return false;
    }),
    AUTH_JOIN("joi", scanner -> {
        AuthController.getInstance().join(scanner);
        return true;
    }),
    AUTH_LOGIN("log", scanner -> {
        AuthController.getInstance().login(scanner);
        return true;
    }),
    AUTH_FIND_ID("cat", scanner -> {
        AuthController.getInstance().findUserByID(scanner);
        return true;
    }),
    AUTH_UPDATE_PW("ch-p", scanner -> {
        AuthController.getInstance().updatePassword(scanner);
        return true;
    }),
    AUTH_DELETE("rm", scanner -> {
        AuthController.getInstance().deleteUser(scanner);
        return true;
    }),
    AUTH_LIST("ls-a", scanner -> {
        AuthController.getInstance().findUsers().forEach(System.out::println);
        return true;
    }),
    AUTH_SEARCH_NAME("ls-n", scanner -> {
        AuthController.getInstance().findUsersByName(scanner);
        return true;
    }),
    AUTH_SEARCH_JOB("ls-j", scanner -> {
        AuthController.getInstance().findUsersByJob(scanner);
        return true;
    }),
    AUTH_COUNT("cnt", scanner -> {
        AuthController.getInstance().countUsers();
        return true;
    }),
    ROUTING_ERROR("ROUTING_ERROR", scanner -> {
        System.out.println("Wrong Input");
        return true;
    });
    private final String name;
    private final Predicate<Scanner> predicate;

    AuthRouter(String name, Predicate<Scanner> predicate){
        this.name = name;
        this.predicate = predicate;
    }

    public static Boolean routing(Scanner scan){
        MenuController.getInstance().printMenusByCategory("auth");
        String str = scan.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(ROUTING_ERROR).predicate.test(scan);
    }
}
