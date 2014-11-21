package jar;
    /**
     * Sous-classe concrète de l'interface "Etat"
     * On peut passer de l'état A vers l'état B ou l'état C
     */
    public class EtatValide extends Travaux.EtatTravaux {

        // Méthodes pour changer d'état
        //
        public void valide(Travaux pClasse) {
            System.out.println("Classe déjà dans l'état validé");
        }

        public void enAttenteValidation(Travaux pClasse) {
            System.out.println("Changement d'état (Validé -> En attente de validation) non possible");
        }

        public void prisEnCharge(Travaux pClasse) {
            System.out.println("Changement d'état (Etat changé : Validé -> Pris en charge) non possible");
        }

        public void attente(Travaux pClasse) {
            System.out.println("Changement d'état (Validé -> En attente de prise en charge) non possible");
        }

        /**
         * Affichage de l'état courant
         */
        public void afficher() {
            System.out.println("Etat courant : Validé");
        }

        public String getEtat(){
            return "Validé";
        }
    }

