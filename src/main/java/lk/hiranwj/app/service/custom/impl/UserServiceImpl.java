package lk.hiranwj.app.service.custom.impl;

import lk.hiranwj.app.dao.custom.UserDAO;
import lk.hiranwj.app.dto.UserDTO;
import lk.hiranwj.app.entity.User;
import lk.hiranwj.app.service.custom.UserService;
import lk.hiranwj.app.util.Transformer;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final Transformer transformer;

    public UserServiceImpl(UserDAO userDAO, Transformer transformer) {
        this.userDAO = userDAO;
        this.transformer = transformer;
    }

    @Override
    public void createNewUserAccount(UserDTO userDTO) {
        userDTO.setPassword(DigestUtils.sha256Hex(userDTO.getPassword()));
        userDAO.save(transformer.toUser(userDTO));

//        if (true) throw new RuntimeException("Failed");
//        userDAO.save(new User("testing", "testing", "testing"));
    }
}
