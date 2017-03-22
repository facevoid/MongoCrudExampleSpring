package com.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Shaurav on 3/17/2017.
 */
@Document(collection="users")
public class User {
    private String id;
    private String username;
    private String password;
    private String role;
    private Location location;

    public User() {
    }

    public User(String id, String username, String password, String role, Location location) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
