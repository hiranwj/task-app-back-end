package lk.hiranwj.app.entity;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
/* There is no need to implement serializable because the super entity is placed */
public class Project implements SuperEntity {
    private int id;
    private String name;
    private String username;

    public Project(String name, String username) {
        this.name = name;
        this.username = username;
    }
}
