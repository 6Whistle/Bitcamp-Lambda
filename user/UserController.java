package user;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserController {
    UserService userService;

    public UserController() {
        this.userService = UserServiceImpl.getInstance();
    }

    public String addUser() {
        return userService.addUsers();
    }

    public String join(Scanner scan) {
        System.out.println("=== 회원가입 ===");
        System.out.println("입력(ID, PW, PW 확인, 이름, 주민번호, 전화번호, 주소, 직장");
        return userService.join(User.builder()
                .username(scan.next())
                .password(scan.next())
                .passwordConfirm(scan.next())
                .name(scan.next())
                .socialSecurityNumber(scan.next())
                .phoneNumber(scan.next())
                .address(scan.next())
                .job(scan.next())
                .build());
    }

    public String login(Scanner scan) {
        System.out.println("=== 로그인 ===");
        System.out.println("입력(ID, PW)");
        return userService.login(User.builder()
                .username(scan.next())
                .password(scan.next())
                .build());
    }

    public String getUserByUsername(Scanner scan) {
        System.out.println("=== ID 탐색 ===");
        System.out.println("입력(ID)");
        return userService.getUserByUsername(User.builder()
                .username(scan.next())
                .build());
    }

    public String updatePassword(Scanner scan) {
        System.out.println("=== PW 변경 ===");
        System.out.println("입력(ID, PW)");
        return userService.updatePassword(User.builder()
                .username(scan.next())
                .password(scan.next())
                .build());
    }

    public String deleteUser(Scanner scan) {
        System.out.println("=== 탈퇴 ===");
        System.out.println("입력(ID)");
        return userService.deleteUser(User.builder()
                .username(scan.next())
                .build());
    }

    public Map<String, ?> getUserMap() {
        System.out.println("=== 회원 목록 ===");
        Map<String, ?> user = userService.getUserMap();
        user.forEach((k, v) -> System.out.printf("{%s, %s}\n", k, v));
        return user;
    }

    public List<?> findUsersByName(Scanner scan) {
        System.out.println("=== 이름 검색 ===");
        System.out.println("입력(이름)");
        List<?> userList = userService.findUsersByName(User.builder()
                .name(scan.next())
                .build());
        userList.forEach(i -> System.out.println(i.toString()));
        return userList;
    }

    public List<?> findUsersByJob(Scanner scan) {
        System.out.println("=== 직업 검색 ===");
        System.out.println("입력(직업)");
        List<?> userList = userService.findUsersByJob(User.builder()
                .job(scan.next())
                .build());
        userList.forEach(i -> System.out.println(i.toString()));
        return userList;
    }

    public String getUsersCount() {
        return userService.getUsersCount();
    }

}
