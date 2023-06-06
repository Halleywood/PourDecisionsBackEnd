package com.sei.capstone.model;

public class PostDTO {

    private String title;
    private String tastingNotes;
    private Integer rating;
    private String imgSrc;

    public PostDTO() {
    }

    public PostDTO(String title, String tastingNotes, Integer rating, String imgSrc) {
        this.title = title;
        this.tastingNotes = tastingNotes;
        this.rating = rating;
        this.imgSrc = imgSrc;
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
        return "PostDTO{" +
                "title='" + title + '\'' +
                ", tastingNotes='" + tastingNotes + '\'' +
                ", rating=" + rating +
                ", imgSrc='" + imgSrc + '\'' +
                '}';
    }
}
