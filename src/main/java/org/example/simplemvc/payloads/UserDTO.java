package org.example.simplemvc.payloads;

public class UserDTO {

    private String name;
    private String email;
    private String password;
    private Integer role;

    public UserDTO() {}

    public UserDTO(String name, String email, String password, Integer role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Integer getRole() { return role; }

    public void setRole(Integer role) { this.role = role; }

}
