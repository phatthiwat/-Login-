package com.example.demo.model;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users") // แนะนำให้ใช้ชื่อตารางเป็นพหูพจน์
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    // ควรมี setters ด้วย (ละไว้เพื่อความกระชับ)
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }
}
