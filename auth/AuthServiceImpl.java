package auth;

import common.UtilService;
import common.UtilServiceImpl;

import java.util.*;

public class AuthServiceImpl implements AuthService {
    private static AuthService instance = new AuthServiceImpl();

    private Map<String, User> users;
    private List<User> userDTOList;

    private AuthServiceImpl() {
        users = new HashMap<>();
        userDTOList = new ArrayList<>();
    }

    public static AuthService getInstance() {
        return instance;
    }

    @Override
    public String addUsers() {
        UtilService util = UtilServiceImpl.getInstance();
        while (users.size() < 5) {
            String username = util.createRandomUsername();
            users.put(username, User.builder()
                    .username(username)
                    .password("1")
                    .passwordConfirm("1")
                    .name(util.createRandomName())
                    .socialSecurityNumber("2")
                    .phoneNumber("3")
                    .address("aaa")
                    .job("bbb")
                    .build());
        }
        return "5명이 추가됬습니다.";
    }

    @Override
    public String join(User user) {
        users.put(user.getUsername(), user);
        return "회원가입 성공";
    }

    @Override
    public String login(User user) {
        return users.getOrDefault(user.getUsername(), User.builder().password("").build())
                .getPassword()
                .equals(user.getPassword()) ?
                "로그인 성공" : "로그인 실패";
    }

    @Override
    public User findUserByID(String username) {
        User findUser = users.get(username);
        return User.builder()
                .username(findUser.getUsername())
                .password(findUser.getPassword())
                .passwordConfirm(findUser.getPasswordConfirm())
                .name(findUser.getName())
                .socialSecurityNumber(findUser.getSocialSecurityNumber())
                .phoneNumber(findUser.getPhoneNumber())
                .address(findUser.getAddress())
                .job(findUser.getJob())
                .build();
    }

    @Override
    public String updatePassword(User user) {
        users.getOrDefault(user.getUsername(), User.builder().password("").build())
                .setPassword(user.getPassword());
        return "비밀번호 변경 성공";
    }

    @Override
    public String deleteUser(String username) {
        return Objects.isNull(users.remove(username)) ? "실패" : "성공";
    }

    @Override
    public Map<String, ?> getUserMap() {
        return new HashMap<>(users);
    }

    @Override
    public List<?> findUsersByName(String name) {
        return users.values().stream().filter(i->i.getName().equals(name)).toList();
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return users.values().stream().filter(i->i.getJob().equals(job)).toList();
    }

    @Override
    public String countUsers() {
        return users.size() + "명";
    }
}
