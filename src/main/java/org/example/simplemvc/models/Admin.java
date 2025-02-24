package org.example.simplemvc.models;

import jakarta.persistence.*;

@Entity
@Table
public class Admin {

    @Id
    private Integer user_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

}
