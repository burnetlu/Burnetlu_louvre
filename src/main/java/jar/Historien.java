package jar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Historien {

    public String nom;
    public String login;


    public List<Travaux> listeTravaux = new ArrayList<Travaux> ();

    public List<Travaux> getDemandeTx() {

        return this.listeTravaux;

    }

    public List<Travaux> getDemandeTxAttenteValidation() {

        List<Travaux> lC = this.listeTravaux;
        List<Travaux> lR = new ArrayList<Travaux> () ;
        if (lC.size()!=0) {
            for (Travaux aLC : lC) {
                if (aLC.etat.getEtat().equals("enAttenteValidation")) {
                    lR.add(aLC);
                }

            }
            return lR;
        }

        return lR;




    }


    public void soumettreDemande(String titre, String description) {

        Travaux demandeTravaux = new Travaux(titre, description);
        // ajoute dans la listeTravaux de historien
        this.listeTravaux.add(demandeTravaux);
        // ajoute dans la listeTravaux de SystemeLouvre
        SystemeLouvre.listeTravaux.add(demandeTravaux);
        System.out.println("Votre demande de travaux a bien été crée !\n____________________");

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

	/*public static List<Travaux> getListeTravaux() {
		return listeTravaux;
	}*/

    public void setListeTravaux(List<Travaux> listeTravaux) {
        this.listeTravaux = listeTravaux;
    }

    public void consultePhoto(){

        Scanner recupNumTxPh = new Scanner(System.in);
        System.out.println("La photo de quel travail voulez vous voir ? :");
        int numTxPh = recupNumTxPh.nextInt();

        Travaux tx = this.listeTravaux.get(numTxPh-1);

        tx.consultePhoto();

    }


    public Historien(String nom, String login) {

        this.nom = nom;
        this.login = login;
    }

}

