package jar;

/**
 * Created by funflash on 12/11/14.
 */
public class EtatPrisEnCharge extends Travaux.EtatTravaux{
    // Méthodes pour changer d'état
    public void valide(Travaux pClasse) {
        System.out.println("Changement d'état (Etat changé : Pris en charge -> Validé) non possible");
    }

    public void enAttenteValidation(Travaux pClasse) {
        setEtat(pClasse, new EtatEnAttenteValidation());
        System.out.println("Etat changé : Pris en charge -> En Attente de validation");
    }

    public void prisEnCharge(Travaux pClasse) {
        System.out.println("Classe déjà dans l'état pris en charge");
    }

    public void attente(Travaux pClasse) {
        setEtat(pClasse, new EtatAttente());
        System.out.println("Etat changé : En attente de validation -> En attente de priss en charge");
    }





    /**
     * Affichage de l'état courant
     */
    public void afficher() {
        System.out.println("Etat courant : Pris en charge");
    }

    public String getEtat(){
        return "prisEnCharge";
    }
}
