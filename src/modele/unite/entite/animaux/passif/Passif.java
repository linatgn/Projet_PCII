package modele.unite.entite.animaux.passif;

import modele.Modele;
import modele.unite.entite.animaux.Animaux;

//Classe qui definie les animaux passifs
//Extends Animaux car la classe est une classe fille de Animaux
abstract class Passif extends Animaux {

    //Constructeur de la classe
    public Passif(int x, int y, Modele m) {
        super(x, y, m);
    }
}
