package org.example.simplemvc.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String name;

    @Column(unique =  true, nullable = false)
    @Size(max = 100)
    private String email;

    @Column(nullable = false)
    @Size(min = 8, max = 50)
    private String password;

    @Column(nullable = false)
    private Integer role;

    public User() {}

    public User(Integer id, String name, String email, String password, Integer role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String name, String email, String password, Integer role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = 0;
    }


    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Integer getRole() { return role; }

    public void setRole(Integer role) { this.role = role; }
    

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
