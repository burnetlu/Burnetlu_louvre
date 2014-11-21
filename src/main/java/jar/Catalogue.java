package jar;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {

    static List<Oeuvre> listeOeuvres = new ArrayList<Oeuvre>();


    public static void getListeAlpha(String choixLettre)
    {

        System.out.println("Liste des oeuvres commencant par la lettre :" +choixLettre );
        for (int i = 0; i < 4; i++) {
            String var = listeOeuvres.get(i).getNom().substring(0, 1);

            if(var.equals(choixLettre)){

                System.out.println("\t"+(i+1)+")"+listeOeuvres.get(i).getNom());
            }

        }



    }}