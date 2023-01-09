package school.app.school.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Objects;



@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
private String schoolName;
private String location;

private String schoolCode;

}
