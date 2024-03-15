package com.erichgamma.api.enums;

import com.erichgamma.api.menu.MenuController;
import com.erichgamma.api.post.PostController;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum PostRouter {
    POST_EXIT("x", scanner -> {
        System.out.println("EXIT");
        return false;
    }),
    POST_MAKE_TABLE("mk", scanner -> {
        return true;
    }),
    POST_REMOVE_TABLE("rm-r", scanner -> {
        return true;
    }),
    POST_LIST("ls-a", scanner -> {
        PostController.getInstance().findAll().forEach(System.out::println);
        return true;
    }),
    ROUTING_ERROR("ROUTING_ERROR", scanner -> {
        System.out.println("Wrong Input");
        return true;
    });
    private final String name;
    private final Predicate<Scanner> predicate;

    PostRouter(String name, Predicate<Scanner> predicate){
        this.name = name;
        this.predicate = predicate;
    }

    public static Boolean routing(Scanner scan){
        MenuController.getInstance().printMenusByCategory("post");
        String str = scan.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(ROUTING_ERROR).predicate.test(scan);
    }
}
