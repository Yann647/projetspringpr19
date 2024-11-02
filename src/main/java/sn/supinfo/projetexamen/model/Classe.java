package sn.supinfo.projetexamen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String niveau;
    private String specialite;
    private String libelle;

    public Classe() {}

    public Classe(String niveau, String specialite) {
        this.niveau = niveau;
        this.specialite = specialite;
        this.libelle = niveau + specialite.substring(0, 2); // Génération de libelle
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void generateLibelle() {
        this.libelle = niveau + specialite.substring(0, 2).toUpperCase();
    }

}
