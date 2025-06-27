package models;

public class Voiture {
    private final int numero;
    private final String nomEquipe;

    public Voiture(int numero, String nomEquipe) {
        this.numero = numero;
        this.nomEquipe = nomEquipe;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    @Override
    public String toString() {
        return "Voiture N°" + numero + " de l'équipe '" + nomEquipe + "'";
        //format (000)
    }
}