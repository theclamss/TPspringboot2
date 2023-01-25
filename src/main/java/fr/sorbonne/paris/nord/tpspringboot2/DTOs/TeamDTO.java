package fr.sorbonne.paris.nord.tpspringboot2.DTOs;

import javax.persistence.Entity;


public class TeamDTO {
    private Long id;
    private String nom;
    private String slogan;

    public TeamDTO() {}

    public TeamDTO(Long id, String nom, String slogan) {
        this.id = id;
        this.nom = nom;
        this.slogan = slogan;
    }
    public TeamDTO(String nom, String slogan) {

        this.nom = nom;
        this.slogan = slogan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}

