package lk.hiranwj.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
/* There is no need to implement serializable because the super entity is placed */
public class Task implements SuperEntity {

    private int id;
    private String content;
    private Status status;
    private int project_id;

    public Task(String content, Status status, int project_id) {
        this.content = content;
        this.status = status;
        this.project_id = project_id;
    }

    public static enum Status {
        COMPLETED, NOT_COMPLETED;
    }
}
