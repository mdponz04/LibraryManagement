package model;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;
    private boolean activeUser;

    public User() {
    }

    public User(String id, String name, LocalDate dateOfBirth,
                String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.activeUser = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActiveUser() {
        return activeUser;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActiveUser(boolean activeUser) {
        this.activeUser = activeUser;
    }
}
