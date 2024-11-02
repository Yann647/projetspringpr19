package sn.supinfo.projetexamen.service.DTO;

public class ClasseDTO {

    private Long id;
    private String niveau;
    private String specialite;
    private String libelle;

    public ClasseDTO() {}

    public ClasseDTO(Long id, String niveau, String specialite, String libelle) {
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
}
