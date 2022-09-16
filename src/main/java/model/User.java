package model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "user", schema = "crudfive",catalog = "postgres")

public class User {
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column (name= "name")
    private String name;
    @OneToMany (mappedBy = "user")
    private List<Event> eventList;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(eventList, user.eventList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, eventList);
    }
}
