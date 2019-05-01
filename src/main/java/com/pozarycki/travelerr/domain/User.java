package com.pozarycki.travelerr.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NotNull
    @Column(name = "user_name", nullable = false)
    private String userName;

    @NotNull
    @Column(name = "password_hash", nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Email@Size(min = 5)
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Post> posts = new ArrayList<>();

    public User() {
    }

    @java.beans.ConstructorProperties({"userName", "password", "firstName", "lastName", "email", "posts"})
    public User(@NotNull String userName, @NotNull String password, String firstName, String lastName, @Email @NotNull  @Size(min = 5) String email, List<Post> posts) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.posts = posts;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
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

    public @Email @Size(min = 5) @NotNull String getEmail() {
        return this.email;
    }

    public List<Post> getPosts() {
        return this.posts;
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

    public void setEmail(@Email @Size(min = 5) @NotNull String email) {
        this.email = email;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$userName = this.getUserName();
        final Object other$userName = other.getUserName();
        if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$posts = this.getPosts();
        final Object other$posts = other.getPosts();
        if (this$posts == null ? other$posts != null : !this$posts.equals(other$posts)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $userName = this.getUserName();
        result = result * PRIME + ($userName == null ? 43 : $userName.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $posts = this.getPosts();
        result = result * PRIME + ($posts == null ? 43 : $posts.hashCode());
        return result;
    }

    public String toString() {
        return "User(userName=" + this.getUserName() + ", password=" + this.getPassword() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", email=" + this.getEmail() + ", posts=" + this.getPosts() + ")";
    }
}
