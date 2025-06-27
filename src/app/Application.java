package app;

import models.Pilote;
import models.Pneu;
import models.TypePneu;
import models.Voiture;

public class Application {

    public static void main(String[] args) {

        // ---------------------------------------------------------------------------------------
        // Etape 1 : Création d'une voiture de Formule 1
        // ---------------------------------------------------------------------------------------
        Voiture Ferrari = new Voiture(16, "Ferrari");
        // ---------------------------------------------------------------------------------------
        // Etape 2 : Afficher la voiture
        // ---------------------------------------------------------------------------------------
        System.out.println(Ferrari);
        // ---------------------------------------------------------------------------------------
        // Etape 3 : Création d'un pilote de Formule 1 et afficher ses informations
        // ---------------------------------------------------------------------------------------
        Pilote Leclerc = new Pilote("Charles Leclerc", "Monégasque", Ferrari);
        Leclerc.setNombreCourses(16);
        Leclerc.setNombrePoints(65);
        Leclerc.setNombreVictoires(3);
        Leclerc.setNombrePodiums(7);
        // ---------------------------------------------------------------------------------------
        // Etape 4 : Afficher le Pilote
        // ---------------------------------------------------------------------------------------
        System.out.println(Leclerc);
        // ---------------------------------------------------------------------------------------
        // Etape 5 : Tests des méthodes de la classe Pilote
        // ---------------------------------------------------------------------------------------
        Pneu pneuDurBlanc01 = new Pneu(TypePneu.DUR_BLANC, 1.5);
        Pneu pneuMediumJaune01 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.8);
        Pneu pneuTendreRouge = new Pneu(TypePneu.TENDRE_ROUGE, 2.0);
        Pneu pneuDurBlanc02 = new Pneu(TypePneu.DUR_BLANC, 1.6);
        Pneu pneuMediumJaune02 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.7);

        // deposerPneuEnReserve() 5 fois de types différents
        Leclerc.deposerPneuEnReserve(pneuDurBlanc01);
        Leclerc.deposerPneuEnReserve(pneuMediumJaune01);
        Leclerc.deposerPneuEnReserve(pneuTendreRouge);
        Leclerc.deposerPneuEnReserve(pneuDurBlanc02);
        Leclerc.deposerPneuEnReserve(pneuMediumJaune02);

        // retirerPneuEnReserve() de type TENDRE_ROUGE et l'afficher
        System.out
                .println("Le pneu TENDRE_ROUGE a été retiré : " + Leclerc.retirerPneuEnReserve(TypePneu.TENDRE_ROUGE));

        // getNombrePneusEnReserve() et afficher le nombre de pneus en réserve
        System.out.println("\nNombre de pneus en réserve : " + Leclerc.getNombrePneusEnReserve());

        // getPneusEnReserveSansTrous() et afficher les pneus en réserve
        System.out.println("\nPneus en réserve sans trous : \n");
        Pneu[] pneusSansTrous;
        pneusSansTrous = Leclerc.getPneusEnReserveSansTrous();
        for (int i = 0; i < pneusSansTrous.length; i++) {
            System.out.println("-" + pneusSansTrous[i].getType() + " avec pression " + pneusSansTrous[i].getPression());
        }

        // pressionMoyenneDesPneusEnReserveFormatee() et afficher la pression moyenne
        // des
        // pneus
        System.out.println(Leclerc.pressionMoyenneDesPneusEnReserveFormatee());

        // compterNombrePneusEnReserveDeType() et afficher le nombre de pneus en réserve
        // de type DUR_BLANC
        System.out.println("\n Nombre pneus en réserve de type DUR_BLANC : "
                + Leclerc.compterNombrePneusEnReserveDeType(TypePneu.DUR_BLANC));

        // Créer les 3 pneus et ajout le lot de pneus pour le pilote et afficher réussi
        // ou échoué

        Pneu[] lotsPneus = new Pneu[4];
        lotsPneus[0] = new Pneu(TypePneu.DUR_BLANC, 1.3);
        lotsPneus[1] = new Pneu(TypePneu.DUR_BLANC, 1.2);
        lotsPneus[2] = new Pneu(TypePneu.DUR_BLANC, 1.1);

        Leclerc.ajouterLotDePneus(lotsPneus);

        if (Leclerc.ajouterLotDePneus(lotsPneus)) {
            System.out.println("Ajout du lot de pneus réussi :-)");

        }
        // Supprimer les pneus de pression inférieure à 1.4 et afficher le nombre de
        // pneus supprimés
        System.out.println("Nombre de pneus supprimés de pression inférieur à 1.4 : "
                + Leclerc.supprimerPneusDePressionInferieur(1.4));
        // ---------------------------------------------------------------------------------------
    }
}