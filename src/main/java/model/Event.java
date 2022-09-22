package model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Entity
@Setter
@Getter
@Table(name = "event", schema = "crudfive",catalog = "postgres")
@EqualsAndHashCode

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
    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @JoinColumn (name = "file_id", referencedColumnName = "id")
    @OneToOne
    File file;

    public Event(Long id) {
        this.id = id;
    }

    public Event() {

    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", status=" + status +
                ", create=" + create +
                ", update=" + update +
                ", user=" + user +
                ", file=" + file +
                '}';
    }
}
