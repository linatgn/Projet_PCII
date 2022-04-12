package projet.projet_piia.modele.plante;

import javafx.scene.image.Image;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Set;

public class Plante {
    private String nom;
    private String description;
    private Image image;
    private Set<Suivi> listeSuivi;
    private ArrayList<String> listeNomMesure;
    private Set<Tache> listeTache;

    public Plante(){

    }

    public void ajouterSuivi(Suivi suivi){
        listeSuivi.add(suivi);
    }
    public void ajouterMesure(String mesure){
        listeNomMesure.add(mesure);
    }
    public void ajouterTache(Tache tache){
        listeTache.add(tache);
    }

    // Setter

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    // Getter

    public String getNom() {
        return nom;
    }
    public String getDescription() {
        return description;
    }
    public Image getImage() {
        return image;
    }
    public Set<Suivi> getListeSuivi() {
        return listeSuivi;
    }
    public ArrayList<String> getListeNomMesure() {
        return listeNomMesure;
    }
    public Set<Tache> getListeTache() {
        return listeTache;
    }
}
