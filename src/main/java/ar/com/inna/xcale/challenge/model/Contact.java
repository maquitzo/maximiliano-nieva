package ar.com.inna.xcale.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Contact  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String surName;
    private String phoneNumber;

    public Contact(String phoneNumber){
        this.setPhoneNumber(phoneNumber);
    }

}
