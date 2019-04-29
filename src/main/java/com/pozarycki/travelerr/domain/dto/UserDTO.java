package com.pozarycki.travelerr.domain.dto;

import com.pozarycki.travelerr.domain.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {

    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String password;

    private String firstName;

    private String lastName;

    @Email
    @Size(min = 5)
    private String email;

    public UserDTO(){}

    public UserDTO(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.password = user.getPassword();
    }

    public Long getId() {
        return this.id;
    }

    public @NotNull String getUserName() {
        return this.userName;
    }

    public @NotNull String getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public @Email @Size(min = 5) String getEmail() {
        return this.email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(@NotNull String userName) {
        this.userName = userName;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(@Email @Size(min = 5) String email) {
        this.email = email;
    }

    public String toString() {
        return "UserDTO(id=" + this.getId() + ", userName=" + this.getUserName() + ", password=" + this.getPassword() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", email=" + this.getEmail() + ")";
    }
}
