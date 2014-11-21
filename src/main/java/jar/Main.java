package jar;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static jar.SystemeLouvre.*;

public class Main {

	public static void affichageRechercheTP1() {


		int choix1 = 0;
		String choixRecherche = null;
		String choixLettre = null;
		String sWhatever = null;

		System.out.println("Bienvenue sur la borne de recherche du Louvre !\r"
				+ "----------------------------------------------\r");
		System.out.println("Quelle recherche souhaitez vous effectuer ?\r");
		System.out.println("\t 1- Recherche par liste alphabétique\r");
		System.out.println("\t 2- Recherche par département\r");
		System.out.println("Taper 1 ou 2 : \r");
		Scanner recupRep = new Scanner(System.in);
		Scanner recupLettre = new Scanner(System.in);

		choix1 = recupRep.nextInt();


		// création des oeuvres et départements
		Catalogue catalogue = new Catalogue();
		Departement peintures = new Departement(" Peintures");
		Departement sculptures = new Departement(" Sculptures");
		Departement.listeDepartements.add(peintures);
		Departement.listeDepartements.add(sculptures);


		Catalogue.listeOeuvres.add(new Oeuvre("Joconde", "Léonard de Vinci", "77 × 53 cm", "La Joconde est le portrait d'une jeune femme sur fond d'un paysage montagneux aux horizons lointains et brumeux.", peintures));
		Catalogue.listeOeuvres.add(new Oeuvre("JAOeuvre", "auteur2", "taille2", "description oeuvre 2", sculptures));
		Catalogue.listeOeuvres.add(new Oeuvre("BOeuvre", "auteur3", "taille3", "description oeuvre 3", peintures));
		Catalogue.listeOeuvres.add(new Oeuvre("JDurand", "Michel", "3m", "description", sculptures));


		switch (choix1) {
		case 1:
			choixRecherche = "Recherche Alphabétique\r";

			System.out.println("Selectionnez la premiere lettre de votre recherche :");
			choixLettre = recupLettre.next();


			Catalogue.getListeAlpha(choixLettre);

			System.out.println("Taper le numero de l'oeuvre que vous voulez:");

			choix1 = recupRep.nextInt();
			selectOeuvre(choix1 - 1);

			break;
		case 2:
			choixRecherche = "Recherche Département\r";
			System.out.println("Selectionnez un département dans la liste :");
			for (int i = 0; i < 2; i++) {
				System.out.println("\t" + (i + 1) + ")" + Departement.listeDepartements.get(i).getNomDepartement());
			}
			System.out.println("Taper le numéro du departement que vous voulez:");


			choix1 = recupRep.nextInt();

			System.out.println("Selectionner une oeuvre dans la liste:");
			Departement.getListeOeuvreByDep(choix1 - 1);

			choix1 = recupRep.nextInt();
			selectOeuvre(choix1 - 1);

			break;


		}
	}


	public static void main(String[] arg) throws IOException {

		String choixFin = "A";

		int nbTx = SystemeLouvre.listeTravaux.size() +1;
		Scanner recupChoix0 = new Scanner(System.in);
		Scanner recupChoixHistorien = new Scanner(System.in);
		Scanner recupChoixPhotographe = new Scanner(System.in);
		// on crée les historien et photographe
		Historien historienMarcel = new Historien("Marcel Cohen", "CohenM");
		Historien historienFrancois = new Historien("Francois Caillet", "CaillF");
		SystemeLouvre.listeHistorien.add(historienMarcel);
		SystemeLouvre.listeHistorien.add(historienFrancois);
		Photographe photographeMyrtille = new Photographe("Myrtille Framboise", "FrambM");
		SystemeLouvre.listePhotographe.add(photographeMyrtille);

		System.out.println("--------------------\n");
		System.out.println("Bienvenue sur le site du Louvre\n");
		System.out.println("--------------------\n");
		System.out.println("Que voulez vous faire ? (Tapez le chiffre correspondant) :\n\t1) Vous etes un Historien "
				+ "\n\t2) Vous êtes un Photographe"
				+ "\n\t3) Effectuer une recherche");
		int choix0 = recupChoix0.nextInt();

		switch (choix0) {
			case 1:
				Historien historienCourant = connexion();

				if(historienCourant != null) {
					List<Travaux> listeTravauxCourant = demandeHistorienConsultationSesTx(historienCourant);

					while (choixFin != "q") {

						//demande travaux et consulte ces travaux
						System.out.println("____________________\nTapez votre choix :\n\t1)Faire une demande de travaux"
								+ "\n\t2)Consulter ces travaux"
								+ "\n\t3)Consulter Photos"
								+ "\n\t4)Déconnexion");
						int choixHisto = recupChoixHistorien.nextInt();
						System.out.println("____________________");

						switch (choixHisto) {
							case 1:
								demandeTx(historienCourant);
								break;
							case 2:
								afficheTx(listeTravauxCourant);
								break;
							case 3:
								consultePhoto(historienCourant);
								break;
							case 4:
								main(arg);

							default:
								System.out.println("ERREUR DE SAISIE");


						}


						System.out.println("-------------------------------------------------");
						System.out.println("| Si vous voulez vous retourner au menu taper q |");
						System.out.println("-------------------------------------------------");
						Scanner recupChoixFin = new Scanner(System.in);

						String choixFin1 = recupChoixFin.nextLine();
						choixFin1 = choixFin;

					}
				}else{
					System.out.println("ERREUR LOGIN");
					main(arg);
				}


			break;
		case 2:

			Photographe photographeCourant = connexion1();


			if(photographeCourant != null ) {
				List<Travaux> listeTravauxPCourant = demandePhotographeConsultationSesTx(photographeCourant);
				while (choixFin != "q") {

					//demande travaux et consulte ces travaux

					System.out.println("____________________\nTapez votre choix :\n\t1)Consulter travaux en attentes"
							+ "\n\t2)Prendre en charge un travail"
							+ "\n\t3)Consulter ces travaux "
							+ "\n\t4)Se désengager"
							+ "\n\t5)Importer une photo"
							+ "\n\t6)Déconnexion");
					int choixPhotog = recupChoixPhotographe.nextInt();
					System.out.println("____________________");

					switch (choixPhotog) {

						case 1:
							consulteTxAttente(SystemeLouvre.listeTravaux);
							break;
						case 2:
							prendreCharge(SystemeLouvre.listeTravaux, photographeCourant);
							break;
						case 3:
							afficheTx(photographeCourant.getTravaux());
							break;
						case 4:
							seDesengager(photographeCourant);
							break;
						case 5:
							if( photographeCourant.getTravaux().size() == 0){
								break;
							}

							importerTx(photographeCourant);
							break;
						case 6:
							main(arg);
						default:
							System.out.println("ERREUR DE SAISIE");
							break;

					}


					System.out.println("-------------------------------------------------");
					System.out.println("| Si vous voulez vous retourner au menu taper q |");
					System.out.println("-------------------------------------------------");
					Scanner recupChoixFin = new Scanner(System.in);

					String choixFin1 = recupChoixFin.nextLine();
					choixFin1 = choixFin;


				}
			}
			else {
				System.out.println("Mauvais login");
				main(arg);
				break;
			}


		case 3:

			affichageRechercheTP1();
			break;

			default:
				System.out.println("ERREUR DE SAISIE");
				main(arg);

		}



	}
}

