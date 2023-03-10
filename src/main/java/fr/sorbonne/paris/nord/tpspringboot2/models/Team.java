package fr.sorbonne.paris.nord.tpspringboot2.models;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Override
    public String toString() {
        return "team{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", slogan='" + slogan + '\'' +
                '}';
    }

    @Column(name = "nom")
    private String nom;

    public Team(String nom, String slogan) {
        this.nom = nom;
        this.slogan = slogan;
    }
    public Team(Long id, String nom, String slogan) {
        this.nom = nom;
        this.slogan = slogan;
        this.id=id;
    }
    public Team() {

    }
    @Column(name = "slogan")
    private String slogan;




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
