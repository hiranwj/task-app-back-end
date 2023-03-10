package lk.hiranwj.app.dao.custom.impl;

import lk.hiranwj.app.dao.custom.UserDAO;
import lk.hiranwj.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements UserDAO {

    @Autowired
    private final JdbcTemplate jdbc;    /* Jdbc template variable */

    public UserDAOImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public User save(User user) {
        jdbc.update("INSERT INTO User(username, full_name, password) VALUE (?,?,?)",
                user.getUsername(),
                user.getFullName(),
                user.getPassword());
        return user;

//        PreparedStatement stm = null;
//        try {
//            stm = connection.prepareStatement("INSERT INTO User(username, full_name, password) VALUE (?,?,?)");
//            stm.setString(1, user.getUsername());
//            stm.setString(2, user.getFullName());
//            stm.setString(3, user.getPassword());
//            stm.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
    }

    @Override
    public void update(User user) {
        jdbc.update("UPDATE User SET full_name=?, password=? WHERE username=?",
                user.getFullName(),
                user.getPassword(),
                user.getUsername());
//        try {
//            PreparedStatement stm = connection.prepareStatement("UPDATE User SET full_name=?, password=? WHERE username=?");
//            stm.setString(1, user.getFullName());
//            stm.setString(2, user.getPassword());
//            stm.setString(3, user.getUsername());
//            stm.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void deleteById(String username) {
        jdbc.update("DELETE FROM User WHERE username=?", username);

//        PreparedStatement stm = null;
//        try {
//            stm = connection.prepareStatement("DELETE FROM User WHERE username=?");
//            stm.setString(1, username);
//            stm.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public Optional<User> findById(String username) {
        return Optional.ofNullable(jdbc.query("SELECT full_name, password FROM User WHERE username=?", rst -> {
                return new User(username,
                        rst.getString("password"),
                        rst.getString("full_name")
                        );
        },username));

//        try {
//            PreparedStatement stm = connection.prepareStatement("SELECT full_name, password FROM User WHERE username=?");
//            stm.setString(1, username);
//            ResultSet rst = stm.executeQuery();
//            if (rst.next()) {
//                return Optional.of(new User(username,
//                        rst.getString("password"),
//                        rst.getString("full_name")
//                        ));
//            }
//            return Optional.empty();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public List<User> findAll() {
        return jdbc.query("SELECT * FROM User", (rst, rowNum) ->
             new User(
                rst.getString("username"),
                rst.getString("password"),
                rst.getString("full_name")));

//        List<User> userList = new ArrayList<>();
//        try {
//            PreparedStatement stm = connection.prepareStatement("SELECT * FROM User");
//            ResultSet rst = stm.executeQuery();
//            while (rst.next()) {
//                userList.add(new User(
//                        rst.getString("username"),
//                        rst.getString("password"),
//                        rst.getString("full_name")
//                        ));
//            }
//            return userList;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public long count() {
        return jdbc.queryForObject("SELECT COUNT(username) FROM User", Long.class);

//        try {
//            PreparedStatement stm = connection.prepareStatement("SELECT COUNT(username) FROM User");
//            ResultSet rst = stm.executeQuery();
//            rst.next();
//            return rst.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public boolean existsById(String username) {
        return findById(username).isPresent();
    }
}
