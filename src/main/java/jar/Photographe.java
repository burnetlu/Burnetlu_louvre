package jar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Photographe {

    public String nom;
    public String login;


    public static List<Travaux> travaux = new ArrayList<Travaux> ();

    public void getSesTx() {

        getTravaux();

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

    public List<Travaux> getTravaux() {
        return this.travaux;
    }

    public void setTravaux(List<Travaux> travaux) {
        this.travaux = travaux;
    }

    public void prendreCharge(Travaux tx) {

        this.travaux.add(tx);
        System.out.println("Votre prise en charge de travail a été éffectuée !\n");
    }

    public void desengager(Travaux tx){

        this.travaux.remove(tx);
        System.out.println("Votre désengagement a été effectuée !\n");
        tx.attente();

    }

    public Travaux getTx()

    {
        Scanner recupNumTxPh = new Scanner(System.in);

        System.out.println("Indiquer le travail correspondant à votre photo:");
        int numTxPh = recupNumTxPh.nextInt();
        return this.travaux.get(numTxPh - 1);
    }

    public static void importerPhoto(Travaux tx){

        tx.importerPhotoTx();
    }

    public Photographe(String nom, String login) {

        this.nom = nom;
        this.login = login;

    }
}
