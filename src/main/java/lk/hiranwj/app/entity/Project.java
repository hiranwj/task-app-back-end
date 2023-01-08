package lk.hiranwj.app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@ToString(exclude = "taskSet")
@EqualsAndHashCode(exclude = "taskSet")
/* There is no need to implement serializable because the super entity is placed */
public class Project implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     /* due to id auto generated */
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    private User user;

    /* For bidirectional */
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    @Setter(AccessLevel.NONE)
    private Set<Task> taskSet = new HashSet<>();

    public Project(String name, User user) {
        this.name = name;
        this.user = user;
    }

}
