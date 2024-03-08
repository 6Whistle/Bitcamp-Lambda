package user;

import java.sql.SQLException;
import java.util.Scanner;
public class UserView {
    private static final UserController userController = new UserController();
    public static void main(Scanner scan){
        while (true) {
            System.out.println("[User] exit(Exit), touch(Make Table), rm(Remove Table), ls(List Table),\n" +
                    "join(Register), login(Login)");
            switch (scan.next()) {
                case "exit":
                    System.out.println("Exit");
                    return;
                case "touch":
                    System.out.println("=== Make User Table ===");
                    System.out.println("result : " + userController.makeTable());
                    System.out.println("========================");
                    break;
                case "rm":
                    System.out.println("=== Remove User Table ===");
                    System.out.println("result : " + userController.removeTable());
                    System.out.println("========================");
                    break;
                case "ls":
                    System.out.println("=== List User Table ===");
                    userController.findAll().forEach(System.out::println);
                    System.out.println("========================");
                    break;
                case "join":
                    System.out.println("======= Register =======");
                    System.out.println("result : " + userController.join(scan));
                    System.out.println("========================");
                    break;
                case "login":
                    System.out.println("=== List User Table ===");
                    System.out.println("result : " + userController.login(scan));
                    System.out.println("========================");
                    break;
                default:
                    System.out.println("===== Wrong Input =====");
            }
        }
    }
}
