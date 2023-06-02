package com.sei.capstone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="wines")
public class Wine {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String vintage;

    @Column
    private String varietal;

    @Column
    private String vitner;

    @Column
    private String tastingNotes;

    @Column
    private String glassWare;

    @Column
    private String aerationTime;

    @Column
    private Integer servingTemperature;

    @Column
    private String pairing;

    @Column
    private String imgSrc;

    @OneToMany(mappedBy="wine", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Post> postsAboutThisWine;

    public List<Post> getPostsAboutThisWine() {
        return postsAboutThisWine;
    }

    public void setPostsAboutThisWine(List<Post> postsAboutThisWine) {
        this.postsAboutThisWine = postsAboutThisWine;
    }

    /**
     * CONSTRUCTORS
     */
    public Wine() {
    }

    public Wine(String name, String vintage, String varietal, String vitner, String tastingNotes, String glassWare, String aerationTime, Integer servingTemperature, String pairing, String imgSrc) {
        this.name = name;
        this.vintage = vintage;
        this.varietal = varietal;
        this.vitner = vitner;
        this.tastingNotes = tastingNotes;
        this.glassWare = glassWare;
        this.aerationTime = aerationTime;
        this.servingTemperature = servingTemperature;
        this.pairing = pairing;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVintage() {
        return vintage;
    }

    public void setVintage(String vintage) {
        this.vintage = vintage;
    }

    public String getVarietal() {
        return varietal;
    }

    public void setVarietal(String varietal) {
        this.varietal = varietal;
    }

    public String getVitner() {
        return vitner;
    }

    public void setVitner(String vitner) {
        this.vitner = vitner;
    }

    public String getTastingNotes() {
        return tastingNotes;
    }

    public void setTastingNotes(String tastingNotes) {
        this.tastingNotes = tastingNotes;
    }

    public String getGlassWare() {
        return glassWare;
    }

    public void setGlassWare(String glassWare) {
        this.glassWare = glassWare;
    }

    public String getAerationTime() {
        return aerationTime;
    }

    public void setAerationTime(String aerationTime) {
        this.aerationTime = aerationTime;
    }

    public Integer getServingTemperature() {
        return servingTemperature;
    }

    public void setServingTemperature(Integer servingTemperature) {
        this.servingTemperature = servingTemperature;
    }

    public String getPairing() {
        return pairing;
    }

    public void setPairing(String pairing) {
        this.pairing = pairing;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vintage='" + vintage + '\'' +
                ", varietal='" + varietal + '\'' +
                ", vitner='" + vitner + '\'' +
                ", tastingNotes='" + tastingNotes + '\'' +
                ", glassWare='" + glassWare + '\'' +
                ", aerationTime='" + aerationTime + '\'' +
                ", servingTemperature=" + servingTemperature +
                ", pairing='" + pairing + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", postsAboutThisWine=" + postsAboutThisWine +
                '}';
    }
}
