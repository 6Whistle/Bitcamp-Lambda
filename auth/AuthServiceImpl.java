package auth;

import common.AbstractService;
import common.UtilService;
import common.UtilServiceImpl;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public class AuthServiceImpl extends AbstractService<Auth> implements AuthService {
    @Getter
    private static final AuthServiceImpl instance = new AuthServiceImpl();

    private final Map<String, Auth> users;

    private AuthServiceImpl() {
        users = new HashMap<>();
    }

    @Override
    public String addUsers() {
        UtilService util = UtilServiceImpl.getInstance();
        while (users.size() < 5) {
            String username = util.createRandomUsername();
            users.put(username, Auth.builder()
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
    public String login(Auth user) {
        return users.getOrDefault(user.getUsername(), Auth.builder().password("").build())
                .getPassword()
                .equals(user.getPassword()) ?
                "로그인 성공" : "로그인 실패";
    }

    @Override
    public String updatePassword(Auth user) {
        users.getOrDefault(user.getUsername(), Auth.builder().password("").build())
                .setPassword(user.getPassword());
        return "비밀번호 변경 성공";
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
    public Map<String, ?> findUsersByNameToMap(String name) {
        return users.entrySet().stream()
                .filter(i -> i.getValue().getName().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return users.values().stream().filter(i->i.getJob().equals(job)).toList();
    }

    @Override
    public Map<String, ?> findUsersByJobToMap(String job) {
        return users.entrySet().stream()
                .filter(i -> i.getValue().getName().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public String save(Auth user) {
        users.put(user.getUsername(), user);
        return "회원가입 성공";
    }

    @Override
    public String delete(Auth user) {
        return Objects.isNull(users.remove(user.getUsername())) ? "실패" : "성공";
    }

    @Override
    public String deleteAll() {
        users.clear();
        return "전체 삭제 성공";
    }

    @Override
    public List<Auth> findAll() {
        return users.values().stream().toList();
    }

    @Override
    public Optional<Auth> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long count() {
        return (long) users.size();
    }

    @Override
    public Optional<Auth> getOne(String id) {
        return Optional.of(users.get(id));
    }

    @Override
    public Boolean existsById(Long id) {
        return users.values().stream()
                .anyMatch(i->i.getId().equals(id));
    }
}
