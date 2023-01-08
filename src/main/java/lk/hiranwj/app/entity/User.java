package lk.hiranwj.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
/* There is no need to implement serializable because the super entity is placed */
public class User implements SuperEntity {

    private String username;
    private String password;
    private String fullName;
}
