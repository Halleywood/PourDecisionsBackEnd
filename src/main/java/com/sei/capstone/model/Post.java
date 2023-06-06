package com.sei.capstone.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String tastingNotes;

    @Column
    private Integer rating;

    @Column
    private String imgSrc;

    /**
     * many posts belong to one userprofile
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userProfile_id")
    @JsonIgnoreProperties(value={"following", "followers"})
    private UserProfile userProfile;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    /**
     * many posts belong to one wine
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="wine_id")
    @JsonIgnore
    private Wine wine;

    public Wine getWine() {
        return wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

    /**
     * CONSTRUCTORS
     */
    public Post() {
    }

    public Post(String title, String tastingNotes, Integer rating, String imgSrc) {
        this.title = title;
        this.tastingNotes = tastingNotes;
        this.rating = rating;
        this.imgSrc = imgSrc;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTastingNotes() {
        return tastingNotes;
    }

    public void setTastingNotes(String tastingNotes) {
        this.tastingNotes = tastingNotes;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tastingNotes='" + tastingNotes + '\'' +
                ", rating=" + rating +
                ", imgSrc='" + imgSrc + '\'' +
                ", userProfile=" + userProfile +
                ", wine=" + wine +
                '}';
    }
}
