package models;

public class Pilote {
    public static final int NOMBRE_PNEUS_EN_RESERVE = 16;
    private final String nom;
    private final String nationalite;
    private int nombrePoints;
    private int nombreCourses;
    private int nombreVictoires;
    private int nombrePodiums;
    private Pneu[] pneusEnReserve;
    private Voiture voiture;

    public Pilote(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.nombrePoints = 0;
        this.nombreCourses = 0;
        this.nombreVictoires = 0;
        this.nombrePodiums = 0;
        this.pneusEnReserve = new Pneu[NOMBRE_PNEUS_EN_RESERVE];
    }

    public Pilote(String nom, String nationalite, Voiture voiture) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.voiture = voiture;
        this.nombrePoints = 0;
        this.nombreCourses = 0;
        this.nombreVictoires = 0;
        this.nombrePodiums = 0;
        this.pneusEnReserve = new Pneu[NOMBRE_PNEUS_EN_RESERVE];
    }

    public boolean deposerPneuEnReserve(Pneu pneu) {
        boolean depotReussi = false;

        if (pneu != null) {
            for (int i = 0; i < pneusEnReserve.length; i++) {
                if (pneusEnReserve[i] == null) {
                    pneusEnReserve[i] = pneu;
                    depotReussi = true;
                    break;
                }
            }
        }

        return depotReussi;
    }

    public Pneu retirerPneuEnReserve(TypePneu type) {
        Pneu pneuTrouve = null;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i].getType().equals(type)) {
                pneuTrouve = pneusEnReserve[i];
                pneusEnReserve[i] = null;
                break;
            }
        }

        return pneuTrouve;
    }

    public int compterNombrePneusEnReserveDeType(TypePneu type) {
        int compteurPneusEnReserveType = 0;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                if (pneusEnReserve[i].getType().equals(type)) {
                    compteurPneusEnReserveType++;
                }
            }
        }

        return compteurPneusEnReserveType;
    }

    public int getNombrePneusEnReserve() {
        int compteurPneusEnReserve = 0;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                compteurPneusEnReserve++;
            }
        }

        return compteurPneusEnReserve;
    }

    public Pneu[] getPneusEnReserveSansTrous() {
        Pneu[] nouveauTableau = new Pneu[pneusEnReserve.length];

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                for (int j = 0; j < nouveauTableau.length; j++) {
                    nouveauTableau[j] = pneusEnReserve[i];
                }
            }

            nouveauTableau = pneusEnReserve;
        }

        return pneusEnReserve;
    }

    public String pressionMoyenneDesPneusEnReserveFormatee() {
        String moyenne = "\nPression moyenne des pneus en réserve : ";

        double totalPression = 0;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                totalPression += pneusEnReserve[i].getPression();
            }
        }

        double moyenneDouble = totalPression / getNombrePneusEnReserve();
        moyenne += moyenneDouble;

        return moyenne;

        // format (0.00)
    }

    public int supprimerPneusDePressionInferieur(double pression) {
        int nombrePneusEnleves = 0;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                if (pneusEnReserve[i].getPression() < pression) {
                    pneusEnReserve[i] = null;
                    nombrePneusEnleves++;
                }
            }
        }

        return nombrePneusEnleves;
    }

    public boolean ajouterLotDePneus(Pneu[] pneus) {
        boolean ajoutReussi = false;
        int nombrePlaceDisponible = 0;
        int nombrePneusLot = 0;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] == null) {
                nombrePlaceDisponible++;
            }
        }

        for (int i = 0; i < pneus.length; i++) {
            if (pneus[i] != null) {
                nombrePneusLot++;
            }
        }

        if (nombrePneusLot < nombrePlaceDisponible) {
            for (int i = 0; i < pneusEnReserve.length; i++) {
                if (pneusEnReserve[i] == null) {
                    for (int j = 0; j < pneus.length; j++) {
                        pneusEnReserve[i] = pneus[j];
                        ajoutReussi = true;
                    }
                }                
            }
        }

        return ajoutReussi;
    }

    public String getNom() {
        return nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public int getNombrePoints() {
        return nombrePoints;
    }

    public int getNombreCourses() {
        return nombreCourses;
    }

    public int getNombreVictoires() {
        return nombreVictoires;
    }

    public int getNombrePodiums() {
        return nombrePodiums;
    }

    public void setNombrePoints(int nombrePoints) {
        this.nombrePoints = nombrePoints;
    }

    public void setNombreCourses(int nombreCourses) {
        this.nombreCourses = nombreCourses;
    }

    public void setNombreVictoires(int nombreVictoires) {
        this.nombreVictoires = nombreVictoires;
    }

    public void setNombrePodiums(int nombrePodiums) {
        this.nombrePodiums = nombrePodiums;
    }

    @Override
    public String toString() {
        String resultat = "Pilote: " + nom + "(" + nationalite + ")\n";
        if (voiture != null) {
            String nomEquipe = voiture.getNomEquipe();
            int numero = voiture.getNumero();
            resultat += "-> Voiture " + nomEquipe + "(" + numero + ")\n";

            resultat += "-> Points: " + nombrePoints + "\n";
            resultat += "-> Courses: " + nombreCourses + "\n";
            resultat += "-> Victoires: " + nombreVictoires + "\n";
            resultat += "-> Podiums: " + nombrePodiums + "\n";
        } else {
            resultat += "-> pas de voiture assignée\n";
        }

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                TypePneu type = pneusEnReserve[i].getType();
                resultat += "Pneus en réserve: " + type + "\n";
            }
        }

        return resultat;
    }
}