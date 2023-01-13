package lk.hiranwj.app.service.custom;

import lk.hiranwj.app.dto.UserDTO;
import lk.hiranwj.app.service.SuperService;

public interface UserService extends SuperService {

    void createNewUserAccount(UserDTO userDTO);

    UserDTO verifyUser(String username, String password);
}
