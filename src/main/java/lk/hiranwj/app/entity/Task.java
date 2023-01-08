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
    private int projectId;

    public Task(String content, Status status, int projectId) {
        this.content = content;
        this.status = status;
        this.projectId = projectId;
    }

    public static enum Status {
        COMPLETED, NOT_COMPLETED;
    }
}
