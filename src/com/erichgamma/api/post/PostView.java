package com.erichgamma.api.post;

import java.sql.SQLException;
import java.util.Scanner;

public class PostView {
    private final static PostController controller = PostController.getInstance();

    public static void main(Scanner scan) throws SQLException {
        while (true) {
            System.out.println("[Menu] 0.Exit, 1.Board");
            switch (scan.next()) {
                case "0":
                    System.out.println("Exit");
                    return;
                case "1":
                    System.out.println("=== Board ===");
                    controller.findAll().forEach(System.out::println);
                    break;
                default:
                    System.out.println("Wrong Input");
            }
        }
    }
}