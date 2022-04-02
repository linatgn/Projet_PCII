package modele.unite.entite.animaux.passif;

import modele.Modele;
import vue.panel.InfoPanel;

//Classe qui definie les lapins
//Extends Passif car la classe est une classe fille de Passif
public class Lapin extends Passif{

    //Constructeur de la classe
    public Lapin(int x, int y, Modele m) {
        super(x, y, m);
        x_texture = 6;
        y_texture = 1;

        largeur = 1;
        hauteur = 1;

        pv=10;

        quantiteRessource = 100;
    }

    @Override
    public String getNom() {
        return "Lapin";
    }
}
