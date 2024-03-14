package com.erichgamma.api.enums;

import com.erichgamma.api.auth.AuthController;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AuthRouter {
    EXIT("exit", scanner -> {
        System.out.println("EXIT");
        return false;
    }),
    JOIN("join", scanner -> {
        AuthController.getInstance().join(scanner);
        return true;
    }),
    LOGIN("login", scanner -> {
        AuthController.getInstance().login(scanner);
        return true;
    }),
    FIND_ID("findId", scanner -> {
        AuthController.getInstance().findUserByID(scanner);
        return true;
    }),
    UPDATE_PW("updatePw", scanner -> {
        AuthController.getInstance().updatePassword(scanner);
        return true;
    }),
    DELETE("delete", scanner -> {
        AuthController.getInstance().deleteUser(scanner);
        return true;
    }),
    AUTH_LIST("list", scanner -> {
        AuthController.getInstance().findUsers().forEach(System.out::println);
        return true;
    }),
    SEARCH_NAME("searchName", scanner -> {
        AuthController.getInstance().findUsersByName(scanner);
        return true;
    }),
    SEARCH_JOB("searchJob", scanner -> {
        AuthController.getInstance().findUsersByJob(scanner);
        return true;
    }),
    AUTH_COUNT("count", scanner -> {
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
        System.out.println("[메뉴] exit.종료, join.회원가입, login.로그인, findId.ID 검색, updatePw.비번 변경, \n" +
                "delete.탈퇴, list.회원목록, searchName.이름 검색, searchJob.직업 검색, count. 회원수");
        String str = scan.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(ROUTING_ERROR).predicate.test(scan);
    }
}
