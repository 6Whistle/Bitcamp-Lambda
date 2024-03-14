package com.erichgamma.api.user;

import com.erichgamma.api.common.AbstractService;
import com.erichgamma.api.enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl extends AbstractService<User> implements UserService{
    @Getter
    private static final UserServiceImpl instance = new UserServiceImpl();
    private final UserRepository userRepository;

    private UserServiceImpl(){
        userRepository = UserRepository.getInstance();
    }

    @Override
    public Messenger save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Messenger delete(User user) {
        return null;
    }

    @Override
    public Messenger deleteAll() {
        return null;
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Optional<User> getOne(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }

    @Override
    public Messenger makeTable(){
        return !userRepository.checkUsersTable()
                ? userRepository.makeTable()
                : Messenger.FAIL;
    }

    @Override
    public Messenger removeTable(){
        return userRepository.checkUsersTable()
                ? userRepository.removeTable()
                : Messenger.FAIL;
    }


    @Override
    public Messenger userExistsByUsername(String username) {
        return userRepository.userExistsByUsername(username);
    }

    @Override
    public Messenger join(User user) {
        return userRepository.userExistsByUsername(user.getUsername()) == Messenger.FAIL
                ? userRepository.save(user)
                : Messenger.FAIL;
    }

    @Override
    public Messenger login(User user) {
        return userRepository.login(user);
    }

}
