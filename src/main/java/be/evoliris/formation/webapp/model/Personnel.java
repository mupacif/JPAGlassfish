package be.evoliris.formation.webapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Personnel implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String nom;
    protected String prenom;
    protected String adresse;
    protected double salaire;
    protected LocalDate dateEmploie;


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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public LocalDate getDateEmploie() {
        return dateEmploie;
    }

    public void setDateEmploie(LocalDate dateEmploie) {
        this.dateEmploie = dateEmploie;
    }
}
