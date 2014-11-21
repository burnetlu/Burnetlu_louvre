package jar;

/**
 * Created by funflash on 12/11/14.
 */
public class EtatAttente extends Travaux.EtatTravaux {
    // Méthodes pour changer d'état
    public void valide(Travaux pClasse) {
        System.out.println("Changement d'état (En attente de prise en charge -> Validé) non possible");
    }

    public void enAttenteValidation(Travaux pClasse) {
        System.out.println("Changement d'état (En attente de prise en charge -> En Attente de validation) non possible");
    }

    public void prisEnCharge(Travaux pClasse) {
        setEtat(pClasse, new EtatPrisEnCharge());
        System.out.println("Etat changé : En attente de prise en charge -> Pris en charge ");
    }

    public void attente(Travaux pClasse) {
        System.out.println("Classe déjà dans l'état en attente de prise en charge");
    }





    /**
     * Affichage de l'état courant
     */
    public void afficher() {
        System.out.println("Etat courant : En attente de prise en charge");
    }

    public String getEtat(){
        return "enAttente";
    }
}
