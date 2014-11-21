package jar;

public class Oeuvre {

    public String nom;
    public String auteur;
    public String taille;
    public String description;
    public Departement sonDepartement;
    //public Date dateCreation;

    Oeuvre(String nom, String auteur, String taille, String description, Departement sonDepartement){
        this.nom = nom;
        this.auteur = auteur;
        this.taille = taille;
        this.description = description;
        this.sonDepartement = sonDepartement;
        //this.dateCreation = dateCreation;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTaille() {
        return taille;
    }

    public Departement getDepartement() {
        return sonDepartement;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
