package lk.hiranwj.app.dao.custom.impl;

import lk.hiranwj.app.dao.custom.UserDAO;
import lk.hiranwj.app.entity.User;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {

    private Connection connection;

    public UserDAOImpl(Connection connection) {

    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void deleteById() {

    }

    @Override
    public Optional<User> findById(String pk) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean existById(String pk) {
        return false;
    }
}
