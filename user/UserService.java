package user;

import enums.Messenger;

public interface UserService {
    Messenger makeTable();

    Messenger removeTable();

    Messenger userexistsByUsername(String username);

    Messenger login(User user);
}
