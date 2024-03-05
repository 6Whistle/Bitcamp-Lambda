package auth;

import common.AbstractService;
import common.UtilServiceImpl;
import enums.Messenger;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AuthServiceImpl extends AbstractService<Auth> implements AuthService {
    @Getter
    private static final AuthServiceImpl instance = new AuthServiceImpl();

    private final Map<String, Auth> users;

    private AuthServiceImpl() {
        users = new HashMap<>();
    }

    @Override
    public Messenger addUsers() {
        IntStream.range(0, 5)
                .mapToObj(i -> UtilServiceImpl.getInstance().createRandomUsername())
                .forEach(i -> users.put(i, Auth.builder()
                        .username(i)
                        .password("1")
                        .passwordConfirm("1")
                        .name(UtilServiceImpl.getInstance().createRandomName())
                        .socialSecurityNumber("2")
                        .phoneNumber("3")
                        .address("aaa")
                        .job("bbb")
                        .build()));
        return Messenger.SUCCESS;
    }

    @Override
    public Messenger login(Auth user) {
        return users.getOrDefault(user.getUsername(), Auth.builder().password("").build())
                .getPassword()
                .equals(user.getPassword()) ?
                Messenger.SUCCESS : Messenger.FAIL;
    }

    @Override
    public Messenger updatePassword(Auth user) {
        users.getOrDefault(user.getUsername(), Auth.builder().password("").build())
                .setPassword(user.getPassword());
        return Messenger.SUCCESS;
    }

    @Override
    public Map<String, ?> getUserMap() {
        return new HashMap<>(users);
    }

    @Override
    public List<?> findUsersByName(String name) {
        return users.values().stream().filter(i -> i.getName().equals(name)).toList();
    }

    @Override
    public Map<String, ?> findUsersByNameToMap(String name) {
        return users.entrySet().stream()
                .filter(i -> i.getValue().getName().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return users.values().stream().filter(i -> i.getJob().equals(job)).toList();
    }

    @Override
    public Map<String, ?> findUsersByJobToMap(String job) {
        return users.entrySet().stream()
                .filter(i -> i.getValue().getName().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public Messenger save(Auth user) {
        users.put(user.getUsername(), user);
        return Messenger.SUCCESS;
    }

    @Override
    public Messenger delete(Auth user) {
        return Objects.isNull(users.remove(user.getUsername())) ? Messenger.FAIL : Messenger.SUCCESS;
    }

    @Override
    public Messenger deleteAll() {
        users.clear();
        return Messenger.SUCCESS;
    }

    @Override
    public List<Auth> findAll() {
        return users.values().stream().toList();
    }

    @Override
    public Optional<Auth> findById(Long id) {
        return users.values().stream()
                .filter(i -> i.getId().equals(id))
                .findAny();
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
                .anyMatch(i -> i.getId().equals(id));
    }
}
