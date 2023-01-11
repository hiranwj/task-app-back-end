package lk.hiranwj.app.util;

import lk.hiranwj.app.dto.UserDTO;
import lk.hiranwj.app.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {

    private ModelMapper mapper;

    public User toUser(UserDTO dto) {
        return mapper.map(dto, User.class);
    }
}
