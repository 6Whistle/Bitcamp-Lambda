package auth;

import java.util.List;
import java.util.Map;

public interface AuthService {
    String addUsers();
    String join(User user);
    String login(User user);
    User findUserByID(String username);
    String updatePassword(User user);
    String deleteUser(String username);
    Map<String, ?> getUserMap();
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);

    String countUsers();
}
