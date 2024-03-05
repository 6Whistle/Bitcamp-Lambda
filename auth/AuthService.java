package auth;

import java.util.List;
import java.util.Map;

public interface AuthService {
    String addUsers();
    String login(Auth user);
    String updatePassword(Auth user);
    List<?> findUsersByName(String name);
    Map<String, ?> findUsersByNameToMap(String name);
    List<?> findUsersByJob(String job);
    Map<String, ?> findUsersByJobToMap(String job);
    Map<String, ?> getUserMap();
}
