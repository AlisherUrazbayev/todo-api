package com.todoapp.model;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class User {
    private final String id;
    private String username;
    private String password;
    private String email;

    public User() {

        this(UUID.randomUUID().toString(),"","","");
    }

    public User(String id, String username, String password, String email) {
        this.id = id;
        setUsername(username);
        setPassword(password);
        setEmail(email);
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        if(!isUsernameValid(username)) {
            throw new IllegalArgumentException("Invalid username.");
        }
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        if(!isEmailValid(email)) {
            throw new IllegalArgumentException("Invalid email address format.");
        }
        this.email = email;
    }

    //Validation methods
    private boolean isUsernameValid(String username) {
        return username != null && !username.trim().isEmpty();
    }

    private boolean isEmailValid(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && Pattern.matches(emailRegex, email);
    }
    //Password hashing method
    private String hashPassword(String password) {
        //return BCrypt.withDefaults().hashToString();
        return "";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
