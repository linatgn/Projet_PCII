package modele.tuille;

//Classe qui definie le sable
//Extends Tuille car la classe est une classe fille de Tuille
public class Sable extends Tuille{

    //Constructeur de la classe
    public Sable(int x, int y) {
        super(x, y);
        solid = false;
        x_texture = 0;
        y_texture = 2;
    }
}
