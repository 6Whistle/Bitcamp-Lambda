package user;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private static UserService instance = new UserServiceImpl();

    private UserRepository userRepository;

    private UserServiceImpl() {
        userRepository = UserRepository.getInstance();
    }

    public static UserService getInstance() {
        return instance;
    }

    @Override
    public String addUsers() {
        return userRepository.addUsers();
    }

    @Override
    public String getUsersCount() {
        return userRepository.getUsersCount();
    }

    @Override
    public String join(User user) {
        return userRepository.join(user);
    }

    @Override
    public Map<String, ?> getUserMap() {
        return userRepository.getUserMap();
    }

    @Override
    public String login(User user) {
        return userRepository.login(user);
    }

    @Override
    public String getUserByUsername(User user) {
        return userRepository.getUserByUsername(user);
    }

    @Override
    public String updatePassword(User user) {
        return userRepository.updatePassword(user);
    }

    @Override
    public String deleteUser(User user) {
        return userRepository.deleteUser(user);
    }

    @Override
    public List<?> findUsersByName(User user) {
        return userRepository.findUsersByName(user);
    }

    @Override
    public List<?> findUsersByJob(User user) {
        return userRepository.findUsersByJob(user);
    }
}
