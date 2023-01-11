package lk.hiranwj.app.service.custom.impl;

import lk.hiranwj.app.dao.custom.UserDAO;
import lk.hiranwj.app.dao.util.ConnectionUtil;
import lk.hiranwj.app.dto.UserDTO;
import lk.hiranwj.app.service.custom.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
@Scope("request")
public class UserServiceImpl implements UserService {

    //private UserDAO userDAO;

    public UserServiceImpl() {

    }

    @Override
    public void createNewUserAccount(UserDTO userDTO) {
        Connection connection = null;
        try {
            InitialContext ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/task-app");
            connection = dataSource.getConnection();
            ConnectionUtil.setConnection(connection);
            UserDAO userDAO = DAOFactory.getInstance().getDAO(DAOTypes.USER, UserDAO.class);
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}