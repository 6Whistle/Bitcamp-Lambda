package auth;

import enums.Messenger;

import java.util.List;
import java.util.Map;

public interface AuthService {
    Messenger addUsers();
    Messenger login(Auth user);
    Messenger updatePassword(Auth user);
    List<?> findUsersByName(String name);
    Map<String, ?> findUsersByNameToMap(String name);
    List<?> findUsersByJob(String job);
    Map<String, ?> findUsersByJobToMap(String job);
    Map<String, ?> getUserMap();
}
