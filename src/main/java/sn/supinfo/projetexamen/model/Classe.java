package sn.supinfo.projetexamen.model;

import jakarta.persistence.*;
import sn.supinfo.projetexamen.constant.Niveau;
import sn.supinfo.projetexamen.constant.Specialite;

@Entity
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private String libelle;

    public Classe() {}

    public Classe(Niveau niveau, Specialite specialite) {
        this.niveau = niveau;
        this.specialite = specialite;
        this.libelle = niveau + specialite.toString().substring(0, 2);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
