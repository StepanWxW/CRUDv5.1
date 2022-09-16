package model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getCreate() {
        return create;
    }

    public void setCreate(Timestamp create) {
        this.create = create;
    }

    public Timestamp getUpdate() {
        return update;
    }

    public void setUpdate(Timestamp update) {
        this.update = update;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
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
