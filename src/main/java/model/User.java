package model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table (name = "user", schema = "crudfive",catalog = "postgres")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column (name= "name")
    private String name;
    @Column (name = "event")
    @OneToMany (mappedBy = "user")
    private List<Event> eventList;

}
