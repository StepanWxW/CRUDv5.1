package model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Event {
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column
    private Status status;
    @Column
    private Timestamp create;
    @Column
    private Timestamp update;
    @Column
    @ManyToOne
    private User user;
    @Column
    @OneToOne
    File file;
}
