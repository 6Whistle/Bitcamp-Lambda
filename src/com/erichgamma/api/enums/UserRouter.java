package com.erichgamma.api.enums;

import com.erichgamma.api.user.UserController;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouter {
    EXIT("exit", (scanner) -> {
        System.out.println("EXIT");
        return false;
    }),
    MAKE_TABLE("touch", (scanner) -> {
        System.out.println("=== Make User Table ===");
        System.out.println("result : " + UserController.getInstance().makeTable());
        System.out.println("========================");
        return true;
    }),
    REMOVE_TABLE("rm", (scanner) -> {
        System.out.println("=== Remove User Table ===");
        System.out.println("result : " + UserController.getInstance().removeTable());
        System.out.println("========================");
        return true;
    }),
    LIST("ls", (scanner) -> {
        System.out.println("=== User List ===");
        UserController.getInstance().findAll().forEach(System.out::println);
        System.out.println("========================");
        return true;
    }),
    LOGIN("login", (scanner) -> {
        System.out.println("=== List User Table ===");
        System.out.println("result : " + UserController.getInstance().login(scanner));
        System.out.println("========================");
        return true;
    }),
    JOIN("join", (scanner) -> {
        System.out.println("======= Register =======");
        System.out.println("result : " + UserController.getInstance().join(scanner));
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
        System.out.println("[User] exit(Exit), touch(Make Table), rm(Remove Table), ls(List Table),\n" +
                "join(Register), login(Login)");
        String str = scan.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(ROUTING_ERROR).predicate.test(scan);
    }
}
