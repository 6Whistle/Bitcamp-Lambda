package com.erichgamma.api.enums;

import com.erichgamma.api.account.AccountView;
import com.erichgamma.api.auth.AuthView;
import com.erichgamma.api.crawler.CrawlerView;
import com.erichgamma.api.post.PostView;
import com.erichgamma.api.user.UserController;
import com.erichgamma.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouter {
    EXIT("exit", (controller, scanner) -> {
        System.out.println("EXIT");
        return false;
    }),
    MAKE_TABLE("touch", (controller, scanner) -> {
        System.out.println("=== Make User Table ===");
        System.out.println("result : " + controller.makeTable());
        System.out.println("========================");
        return true;
    }),
    REMOVE_TABLE("rm", (controller, scanner) -> {
        System.out.println("=== Remove User Table ===");
        System.out.println("result : " + controller.removeTable());
        System.out.println("========================");
        return true;
    }),
    LIST("ls", (controller, scanner) -> {
        System.out.println("=== User List ===");
        controller.findAll().forEach(System.out::println);
        System.out.println("========================");
        return true;
    }),
    LOGIN("login", (controller, scanner) -> {
        System.out.println("=== List User Table ===");
        System.out.println("result : " + controller.login(scanner));
        System.out.println("========================");
        return true;
    }),
    JOIN("join", (controller, scanner) -> {
        System.out.println("======= Register =======");
        System.out.println("result : " + controller.join(scanner));
        System.out.println("========================");
        return true;
    }),
    ROUTING_ERROR("Routing Error", (controller, scanner) -> {
        System.out.println("Wrong Input");
        return true;
    });

    private final String name;
    private final BiPredicate<UserController, Scanner> biPredicate;

    UserRouter(String name, BiPredicate<UserController, Scanner> biPredicate){
        this.name = name;
        this.biPredicate = biPredicate;
    }

    public static Boolean routing(UserController controller, Scanner scan){
        System.out.println("[User] exit(Exit), touch(Make Table), rm(Remove Table), ls(List Table),\n" +
                "join(Register), login(Login)");
        String str = scan.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(ROUTING_ERROR).biPredicate.test(controller, scan);
    }
}
