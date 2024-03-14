package com.erichgamma.api.enums;

import com.erichgamma.api.post.PostController;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum PostRouter {
    EXIT("0", scanner -> {
        System.out.println("EXIT");
        return false;
    }),
    BOARD("1", scanner -> {
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
        System.out.println("[Menu] 0.Exit, 1.Board");
        String str = scan.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(ROUTING_ERROR).predicate.test(scan);
    }
}
