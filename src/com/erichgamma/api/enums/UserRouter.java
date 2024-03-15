package com.erichgamma.api.enums;

import com.erichgamma.api.menu.MenuController;
import com.erichgamma.api.user.UserController;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouter {
    USER_EXIT("x", (scanner) -> {
        System.out.println("EXIT");
        return false;
    }),
    USER_MAKE_TABLE("mk", (scanner) -> {
        System.out.println("=== Make User Table ===");
        System.out.println("result : " + UserController.getInstance().makeTable());
        System.out.println("========================");
        return true;
    }),
    USER_REMOVE_TABLE("rm-r", (scanner) -> {
        System.out.println("=== Remove User Table ===");
        System.out.println("result : " + UserController.getInstance().removeTable());
        System.out.println("========================");
        return true;
    }),
    USER_LIST("ls-a", (scanner) -> {
        System.out.println("=== User List ===");
        UserController.getInstance().findAll().forEach(System.out::println);
        System.out.println("========================");
        return true;
    }),
    USER_JOIN("joi", (scanner) -> {
        System.out.println("======= Register =======");
        System.out.println("result : " + UserController.getInstance().join(scanner));
        System.out.println("========================");
        return true;
    }),
    USER_LOGIN("log", (scanner) -> {
        System.out.println("=== List User Table ===");
        System.out.println("result : " + UserController.getInstance().login(scanner));
        System.out.println("========================");
        return true;
    }),
    ROUTING_ERROR("Routing Error", (scanner) -> {
        System.out.println("Wrong Input");
        return true;
    });

    private final String name;
    private final Predicate<Scanner> predicate;

    UserRouter(String name, Predicate<Scanner> predicate){
        this.name = name;
        this.predicate = predicate;
    }

    public static Boolean routing(Scanner scan){
        MenuController.getInstance().printMenusByCategory("user");
        String str = scan.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(ROUTING_ERROR).predicate.test(scan);
    }
}
