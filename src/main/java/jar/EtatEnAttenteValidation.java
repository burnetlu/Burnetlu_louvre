package jar;

/**
 * Created by funflash on 12/11/14.
 */
public class EtatEnAttenteValidation extends Travaux.EtatTravaux{


        // Méthodes pour changer d'état
        public void valide(Travaux pClasse) {
            setEtat(pClasse, new EtatValide());
            System.out.println("Etat changé : En attente de validation -> Validé");
        }

        public void enAttenteValidation(Travaux pClasse) {
            System.out.println("Classe déjà dans l'état en attente de validation");
        }

        public void prisEnCharge(Travaux pClasse) {
            setEtat(pClasse, new EtatPrisEnCharge());
            System.out.println("Etat changé : En attente de validation -> Pris en charge");
        }

        public void attente(Travaux pClasse) {
            setEtat(pClasse, new EtatAttente());
            System.out.println("Etat changé : En attente de validation -> En attente de prise en charge");
        }





    /**
         * Affichage de l'état courant
         */
        public void afficher() {
            System.out.println("Etat courant : En attente de validation");
        }

    public String getEtat(){
        return "enAttenteValidation";
    }

}

