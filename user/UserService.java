package user;

import java.util.List;
import java.util.Map;

public interface UserService {

    String addUsers();

    String getUsersCount();

    String join(User user);

    Map<String, ?> getUserMap();

    String login(User user);

    String getUserByUsername(User user);

    String updatePassword(User user);

    String deleteUser(User user);

    List<?> findUsersByName(User user);

    List<?> findUsersByJob(User user);
}
