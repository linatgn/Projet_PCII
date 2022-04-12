package projet.projet_piia.modele;

import javafx.scene.image.Image;
import projet.projet_piia.modele.plante.Plante;
import projet.projet_piia.modele.plante.Suivi;
import projet.projet_piia.modele.plante.Tache;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Etat {
    private ArrayList<Plante> listePlante;
    private TreeSet<Tache> listeTachePonctuelle;
    private ArrayList<Tache> listeTacheRecurrente;

    // Element en création

    public Plante planteEnCours;
    public Suivi suiviEnCours;
    public Tache tacheEnCours;

    public boolean basculePresentationPlante;

    public Etat(){
        listePlante = new ArrayList<>();
        listeTachePonctuelle = new TreeSet<>();
        listeTacheRecurrente = new ArrayList<>();

        basculePresentationPlante = true;
    }


}
