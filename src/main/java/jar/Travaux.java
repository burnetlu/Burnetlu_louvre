package jar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Travaux {

    public String titre;
    public String description;
    public Date dateDeCreation;


    String format = "dd/MM/yy H:mm:ss";
    java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
    Date getDateDeCreation = new Date();

    public List<Photo> listePhotos = new ArrayList<Photo>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    public EtatTravaux etat;

    public static abstract class EtatTravaux {

        protected void setEtat(Travaux pClasse, EtatTravaux pEtat) {
            pClasse.etat = pEtat;
        }

        // Méthodes pour changer d'état
        public abstract void valide(Travaux pClasse);
        public abstract void enAttenteValidation(Travaux pClasse);
        public abstract void prisEnCharge(Travaux pClasse);
        public abstract void attente(Travaux pClasse);

        // Affichage de l'état courant
        public abstract void afficher();
        public abstract String getEtat();

    }


    public void valide() {
        etat.valide(this);
    }

    public void enAttenteValidation() {
        etat.enAttenteValidation(this);
    }

    public void prisEnCharge() {
        etat.prisEnCharge(this);
    }

    public void attente() {
        etat.attente(this);
    }

    /**
     * Affichage de l'état courant
     */
    public void afficher() {
        etat.afficher();
    }


    public void importerPhotoTx(){


        // créer objet photo et initialiser date
        String format = "dd/MM/yy H:mm:ss";
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        Date datePhoto = new Date();
        Scanner recupImportPh = new Scanner(System.in);

        System.out.println("Indiquer le nom de la photo à télécharger : ");
        String nomPhoto =recupImportPh.nextLine();

        Photo photoImport = new Photo(nomPhoto, false, datePhoto);
        this.listePhotos.add(photoImport);
        System.out.println("Votre photo à bien été importé : \nDATE DE LA PHOTO :"
                            + datePhoto+"\nIl faut maintenant attendre la validation de l'historien");

        boolean etatPhoto = photoImport.isEtat();

        String tempEtatPhoto;
        if(etatPhoto == false) {

            tempEtatPhoto = "En attente de validation";
        }else{
            tempEtatPhoto = "Validé par l'historien";
        }
        String nom2 = photoImport.getTitre();
        System.out.println("Récap :\nNom Travaux : "+this.titre+"\nNom de la photo: "+nom2+
                "\netat:"+ tempEtatPhoto
                +"\ndate:"+ photoImport.getDate());
        this.enAttenteValidation();

    }

    public void consultePhoto(){


        String repOui = "oui";
        String repNon = "non";
        Scanner recupValidPh = new Scanner(System.in);


        for(int i=0;i<this.listePhotos.size() ;i++ ){


            EtatTravaux t = new EtatAttente();

            if(this.listePhotos.get(i).etat== false && this.listePhotos != null){
                String nomPhoto = this.listePhotos.get(i).getTitre();
                System.out.println("Visualisation de la photo :" + nomPhoto);

                System.out.println("La photos vous convient elle ? (taper oui ou non)");
                String validPh = recupValidPh.nextLine();

                if(validPh.equals(repOui)){
                    this.validerPhoto(this.listePhotos.get(i));

                }else if(validPh.equals(repNon)){
                    this.refuserPhoto(this.listePhotos.get(i));
                }
            }else{
                System.out.println("rien à afficher");
            }


        }

        Scanner recup = new Scanner(System.in);
        System.out.println("Le travaille est il fini (c.à.d manque il encore des photos) ? (taper oui ou non)");
        String r = recup.nextLine();
        if (r.equals(repOui)){
            this.valide();
        }



    }

    public void validerPhoto(Photo P){

        P.setEtat(true);
        System.out.println("La photo "+P.getTitre()+" est bien ajouté !");

    }

    public void refuserPhoto(Photo P){

        Scanner recupDescriptionPb = new Scanner(System.in);

        System.out.println("Pourquoi la photo ne vous convient pas ? :");
        String descriptionPb = recupDescriptionPb.nextLine();

        String ancienneDescription = this.getDescription();
        String nouvelleDescription = "Photos refusées "+P.getTitre()+" : " + descriptionPb +"\n"+ ancienneDescription;
        this.setDescription(nouvelleDescription);
        this.prisEnCharge();

    }

    public Travaux(String titre, String description) {

        this.titre = titre;
        this.description = description;
        etat = new EtatAttente();

    }



}
