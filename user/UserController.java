package user;

import enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserController {
    private static UserService userService = UserServiceImpl.getInstance();
    public List<?> findAll(){
        return userService.findAll();
    }

    public Messenger makeTable(){
        return userService.makeTable();
    }

    public Messenger removeTable(){
        return userService.removeTable();
    }

    public Messenger join(Scanner scan) {
        System.out.println("[INPUT] ID PW Name Phone Job Height Weight");
        return userService.join(User.builder()
                .username(scan.next())
                .password(scan.next())
                .name(scan.next())
                .phone(scan.next())
                .job(scan.next())
                .height(Double.parseDouble(scan.next()))
                .weight(Double.parseDouble(scan.next()))
                .build());
    }

    public Messenger login(Scanner scan) {
        System.out.println("[INPUT] ID PW");
        return userService.login(User.builder()
                .username(scan.next())
                .password(scan.next())
                .build());
    }
}
