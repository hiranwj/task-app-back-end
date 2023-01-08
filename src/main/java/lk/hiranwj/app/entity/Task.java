package lk.hiranwj.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
/* There is no need to implement serializable because the super entity is placed */
public class Task implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id", nullable = false)
    private Project project;

    public Task(String content, Status status, Project project) {
        this.content = content;
        this.status = status;
        this.project = project;
    }

    public static enum Status {
        COMPLETED, NOT_COMPLETED;
    }
}
