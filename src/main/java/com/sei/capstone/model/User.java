package com.sei.capstone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true)
    private String email;

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * Only one user to one profile!
     */
    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private UserProfile userProfile;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    /**
     * CONSTRUCTORS
     */
    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * GETTERS AND SETTERS
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
