package model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
@Entity
@Table(name = "event")
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Event {
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column (name = "createtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp create;
    @Column (name = "updatetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp update;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @JoinColumn (name = "file_id", referencedColumnName = "id")
    @OneToOne
    File file;
}
