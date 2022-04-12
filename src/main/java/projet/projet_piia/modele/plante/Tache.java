package projet.projet_piia.modele.plante;

import java.util.Date;

/**
 * Action a réaliser a une date precise ou a des dates recurrentes
 */
public class Tache implements Comparable<Tache>{
    private Date date;
    private String nomTache;

    private boolean recurrent;

    private int dureeIntervalle;
    private int nbRecursion;

    // Constructeur

    Tache(Date date, String nomTache){
        this.date = date;
        this.nomTache = nomTache;
    }

    // Setter

    public void setDate(Date date) {
        this.date = date;
    }
    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }
    public void setRecurrent(boolean recurrent) {
        this.recurrent = recurrent;
    }
    public void setDureeIntervalle(int dureeIntervalle) {
        this.dureeIntervalle = dureeIntervalle;
    }
    public void setNbRecursion(int nbRecursion) {
        this.nbRecursion = nbRecursion;
    }

    // Getter

    public Date getDate() {
        return date;
    }
    public String getNomTache() {
        return nomTache;
    }
    public int getNbRecursion() {
        return nbRecursion;
    }
    public int getDureeIntervalle() {
        return dureeIntervalle;
    }
    public boolean getRecurrent() {
        return recurrent;
    }

    @Override
    public int compareTo(Tache tache) {
        return date.compareTo(tache.date);
    }
}
