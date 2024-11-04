package sn.supinfo.projetexamen.service.DTO;

import sn.supinfo.projetexamen.constant.Niveau;
import sn.supinfo.projetexamen.constant.Specialite;

public class ClasseDTO {

    private Long id;
    private Niveau niveau;
    private Specialite specialite;
    private String libelle;

    public ClasseDTO() {}

    public ClasseDTO(Long id, Niveau niveau, Specialite specialite, String libelle) {
        this.id = id;
        this.niveau = niveau;
        this.specialite = specialite;
        this.libelle = libelle;
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
