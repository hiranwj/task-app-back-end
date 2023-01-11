package lk.hiranwj.app.service.custom.impl;

import lk.hiranwj.app.dao.custom.UserDAO;
import lk.hiranwj.app.dto.UserDTO;
import lk.hiranwj.app.service.custom.UserService;
import lk.hiranwj.app.util.Transformer;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final Transformer transformer;

    public UserServiceImpl(UserDAO userDAO, Transformer transformer) {
        this.userDAO = userDAO;
        this.transformer = transformer;
    }

    @Override
    public void createNewUserAccount(UserDTO userDTO) {
        userDAO.save(transformer.toUser(userDTO));
    }
}
