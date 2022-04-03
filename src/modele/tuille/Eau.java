package modele.tuille;

//Classe qui definie l'eau
//Extends Tuille car la classe est une classe fille de Tuille
public class Eau extends Tuille{

    //Constructeur de la classe
    public Eau(int x, int y) {
        super(x, y);
        solid = true;
        x_texture = 1;
        y_texture = 0;
    }
}
