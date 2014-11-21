package jar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemeLouvre {

    public static List<Travaux> listeTravaux = new ArrayList<Travaux>();

    public static List<Historien> listeHistorien = new ArrayList<Historien> ();

    public static List<Photographe> listePhotographe = new ArrayList<Photographe> ();

    public static void selectOeuvre(int choixOeuvre){
        System.out.println("\nFiche détaillant l'oeuvre selectionnée\r"
                + "--------------------------------------");

        System.out.println(Catalogue.listeOeuvres.get(choixOeuvre).getNom() + "\r" +
                Catalogue.listeOeuvres.get(choixOeuvre).getAuteur() + "\r" +
                Catalogue.listeOeuvres.get(choixOeuvre).getTaille() + "\r" +
                Catalogue.listeOeuvres.get(choixOeuvre).getDescription());
    }

    public static void afficheTxAttente(List<Travaux> lT) {

        int taille = lT.size();
        String etatTravail;

        if(taille == 0){
            System.out.println("\nLa liste des travaux en attente est vide\n");

        }

        for (int i = 0; i < taille; i++) {

            if(lT.get(i).etat.getEtat().equals("enAttente") ) {
                System.out.println("\t" + (i + 1) + ") " + lT.get(i).getTitre()
                        + "\n        - Description : " + lT.get(i).getDescription());

                lT.get(i).afficher();

            }
            else{
                System.out.println("\nLa liste des travaux en attente est vide\n");

            }
        }


    }



    public static void demandeTx(Historien historien) {

        String demandeTitreTx, demandeDescrTx;

        Scanner recupTitreDemandeTx = new Scanner(System.in);
        Scanner recupDescrDemandeTx = new Scanner(System.in);

        System.out.println("\nNouvelle demande de travaux\n");
        System.out.println("Titre de votre demande : ");

        demandeTitreTx = recupTitreDemandeTx.nextLine();

        System.out.println("\nDescription de votre demande : ");

        demandeDescrTx = recupDescrDemandeTx.nextLine();

        historien.soumettreDemande(demandeTitreTx,demandeDescrTx);

    }


    public static List<Travaux> demandePhotographeConsultationSesTx(Photographe photographeCourant) {

        System.out.println("Voici la liste des travaux du photographe :" + photographeCourant.getLogin());
        return photographeCourant.getTravaux();

    }

    public static List<Travaux> demandeHistorienConsultationSesTx(Historien historienCourant) {

        //System.out.println("Voici la liste des demandes de travaux de l'historien :" + historienCourant.getLogin());
        return historienCourant.getDemandeTx();

    }

    public static void afficheTx(List<Travaux> lT) {

        int taille = lT.size();


        if(taille == 0){
            System.out.println("\nLa liste de vos travaux est vide !\n");
        }

        for (int i = 0; i < taille; i++) {



            System.out.println("\t"+(i+1)+") "+lT.get(i).getTitre()
                    +"\n        - Description : " + lT.get(i).getDescription());
            lT.get(i).afficher();

        }

    }

    public static void consulteTxAttente(List<Travaux> lT) {

        System.out.println("Travaux en attente ");
        afficheTxAttente(lT);

    }

    public static void prendreCharge(List<Travaux> lT, Photographe P) {

    Scanner recupPrendreCharge = new Scanner(System.in);

    consulteTxAttente(lT);
    System.out.println("\nTaper le numéro du travail que vous voulez prendre en charge");
    int prendreCharge = recupPrendreCharge.nextInt()-1;

    //lT.get(prendreCharge).setEtat(true);
    Travaux travailPrisEnCharge = lT.get(prendreCharge);
    travailPrisEnCharge.prisEnCharge();

    P.prendreCharge(travailPrisEnCharge);



    }

    public static Historien connexion() {

        String login;
        Scanner recupLogin = new Scanner(System.in);

        // connexion, on regarde juste si le login existe dans la liste des historiens
        System.out.println("--------------------");
        System.out.println("\nEntrez votre login : ");
        login = recupLogin.nextLine();

        for(int i = 0; i < listeHistorien.size(); i++ ){
            if (login.equals(listeHistorien.get(i).getLogin()) && i < listeHistorien.size()){
                System.out.println("Vous etes connecté en tant que : "+ listeHistorien.get(i).getLogin());
                return listeHistorien.get(i);

            }
        }


        return null;

    }

    public static Photographe connexion1() {

        String login;
        Scanner recupLogin = new Scanner(System.in);

        // connexion, on regarde juste si le login existe dans la liste des historiens
        System.out.println("\nEntrez votre login : ");
        login = recupLogin.nextLine();



        for(int i = 0; i< listePhotographe.size(); i++ ){
            if (login.equals(listePhotographe.get(i).getLogin()) && i < listeHistorien.size()){
                System.out.println("Vous etes connecté en tant que : "+ listePhotographe.get(i).getLogin());
                return listePhotographe.get(i);

            }
        }


        return null;

    }

    public static void seDesengager(Photographe P){

     Scanner recuperTxDesengage = new Scanner(System.in);

     afficheTx(P.getTravaux());
     System.out.println("Taper le numéro du travail pour vous desengagez :");
     int numTxDesengage = recuperTxDesengage.nextInt();

     Travaux travailDesengage = P.getTravaux().get(numTxDesengage - 1);
     travailDesengage.attente();

     P.desengager(travailDesengage);


    }

    public static void importerTx(Photographe photographeCourant){

        afficheTx(photographeCourant.getTravaux());
        Travaux t =  photographeCourant.getTx();
        photographeCourant.importerPhoto(t);
    }

    public static void consultePhoto(Historien H){

        if (H.getDemandeTxAttenteValidation().size()  != 0) {

            afficheTx(H.getDemandeTxAttenteValidation());
            H.consultePhoto();
        }
        else {

            System.out.println("Aucune photo en attente de validation");

        }
    }





}
