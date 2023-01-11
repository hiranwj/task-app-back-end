package lk.hiranwj.app.dao.custom.impl;

import lk.hiranwj.app.dao.custom.UserDAO;
import lk.hiranwj.app.entity.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements UserDAO {

    private final Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public User save(User user) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("INSERT INTO User(username, full_name, password) VALUE (?,?,?)");
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getFullName());
            stm.setString(3, user.getPassword());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(User user) {
        try {
            PreparedStatement stm = connection.prepareStatement("UPDATE User SET full_name=?, password=? WHERE username=?");
            stm.setString(1, user.getFullName());
            stm.setString(2, user.getPassword());
            stm.setString(3, user.getUsername());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(String username) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("DELETE FROM User WHERE username=?");
            stm.setString(1, username);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findById(String username) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT full_name, password FROM User WHERE username=?");
            stm.setString(1, username);
            ResultSet rst = stm.executeQuery();
            if (rst.next()) {
                return Optional.of(new User(username,
                        rst.getString("password"),
                        rst.getString("full_name")
                        ));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM User");
            ResultSet rst = stm.executeQuery();
            while (rst.next()) {
                userList.add(new User(
                        rst.getString("username"),
                        rst.getString("password"),
                        rst.getString("full_name")
                        ));
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long count() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT COUNT(username) FROM User");
            ResultSet rst = stm.executeQuery();
            rst.next();
            return rst.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(String username) {
        return findById(username).isPresent();
    }
}
