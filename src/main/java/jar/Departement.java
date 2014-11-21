package jar;

import java.util.ArrayList;
import java.util.List;

public class Departement {

    public String nomDepartement;

    static List<Departement> listeDepartements = new ArrayList<Departement>();

    public Departement(String nomDepartement) {
        // TODO Auto-generated constructor stub
        this.nomDepartement = nomDepartement;
    }

    /* Fonction qui à pour but de récupérer uniquement les oeuvre filtrait par
     * le département séléctioné par l'utilisateur.
     * */
	/* Pour aller plus loin: il sera plus tard judicieux de créer une variable NBOEUVRE dans la classe Oeuvre
	 * si le nombre d'oeuvre devenaient important il faudra créer une liste d'oeuvre par departement
	 * */
    public static void getListeOeuvreByDep(int choix){

        Departement depLocal = Departement.listeDepartements.get(choix);

        for (int i = 0; i < 3; i++) {
            if (Catalogue.listeOeuvres.get(i).getDepartement() == depLocal){
                System.out.println("\t"+(i+1)+") "+Catalogue.listeOeuvres.get(i).getNom());
            }
        }
    }


    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

}
