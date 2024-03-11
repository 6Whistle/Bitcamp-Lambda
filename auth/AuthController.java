package com.erichgamma.api.auth;


import com.erichgamma.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AuthController {
    AuthServiceImpl auth;

    public AuthController() {
        this.auth = AuthServiceImpl.getInstance();
    }

    public void addUsers() {
        System.out.println(auth.addUsers());
    }

    public Messenger join(Scanner scan) {
        System.out.println("=== 회원가입 ===");
        System.out.println("입력(ID, 비밀번호, 비빌번호 확인, 이름, 주민번호, 전화번호, 주소, 직업)");
        System.out.println(auth.save(Auth.builder()
                .username(scan.next())
                .password(scan.next())
                .passwordConfirm(scan.next())
                .name(scan.next())
                .socialSecurityNumber(scan.next())
                .phoneNumber(scan.next())
                .address(scan.next())
                .job(scan.next())
                .build()));
        return Messenger.SUCCESS;
    }

    public Messenger login(Scanner scan) {
        System.out.println("=== 로그인 ===");
        System.out.println("입력(ID, 비밀번호)");
        return auth.login(Auth.builder()
                .username(scan.next())
                .password(scan.next())
                .build());

    }

    public void findUserByID(Scanner scan) throws SQLException {
        System.out.println("=== ID 검색 ===");
        System.out.println("입력(ID)");
        System.out.println(auth.getOne(scan.next())
                .orElse(Auth.builder().build()).toString());
    }

    public Messenger updatePassword(Scanner scan) {
        System.out.println("=== 비번 변경 ===");
        System.out.println("입력(ID, 비번)");
        return auth.updatePassword(Auth.builder()
                .username(scan.next())
                .password(scan.next())
                .build());
    }


    public Messenger deleteUser(Scanner scan) {
        System.out.println("=== 탈퇴 ===");
        System.out.println("입력(ID)");
        return auth.delete(Auth.builder()
                .username(scan.next())
                .build());
    }

    public void getUsersMap() {
        System.out.println("=== 회원목록 ===");
        auth.getUserMap().forEach((k, v) -> System.out.printf("{%s, %s}\n", k, v));
    }

    public void findUsersByName(Scanner scan) {
        System.out.println("=== 이름 검색 ===");
        System.out.println("입력(이름)");
        auth.findUsersByName(scan.next()).forEach(System.out::println);
    }

    public void findUsersByJob(Scanner scan) {
        System.out.println("=== 직업 검색 ===");
        System.out.println("입력(직업)");
        auth.findUsersByJob(scan.next()).forEach(System.out::println);
    }

    public void countUsers() {
        System.out.println("=== 회원수 ===");
        System.out.println(auth.count());
    }

    public void getOne(Scanner scan) throws SQLException {
        System.out.println("=== ID 검색 ===");
        System.out.println(auth.getOne(scan.next())
                .orElse(Auth.builder().build())
                .toString());
    }

    public String test() {
        System.out.println("=== 회원 정보 ===");
        return auth.test();
    }

    public List<?> findUsers() throws SQLException {
        return auth.findUsers();
    }
}
