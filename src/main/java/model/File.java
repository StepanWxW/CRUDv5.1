package model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "file", schema = "crudfive",catalog = "postgres")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class File {
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column
    private String name;
    @OneToOne (mappedBy = "file")
    @JsonManagedReference
    private Event event;
}
