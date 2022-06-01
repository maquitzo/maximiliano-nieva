package ar.com.inna.xcale.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private boolean isPrivate;

    public Room(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private List<Contact> contact;

}
