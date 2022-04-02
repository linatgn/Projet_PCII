package modele.tuille;

//Classe qui definie la terre
//Extends Tuille car la classe est une classe fille de Tuille
public class Terre extends Tuille{

    //Constructeur de la classe
    public Terre(int x, int y) {
        super(x, y);
        solid = false;
        x_texture = 0;
        y_texture = 1;
    }
}
