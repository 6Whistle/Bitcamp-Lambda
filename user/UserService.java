package user;

import enums.Messenger;

public interface UserService {
    Messenger makeTable();

    Messenger removeTable();

    Messenger userExistsByUsername(String username);

    Messenger login(User user);

    Messenger join(User user);
}
