package com.sei.capstone.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

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

    public Post() {
    }

    public Post(String title, String tastingNotes, Integer rating) {
        this.title = title;
        this.tastingNotes = tastingNotes;
        this.rating = rating;
    }

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

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tastingNotes='" + tastingNotes + '\'' +
                ", rating=" + rating +
                '}';
    }
}
