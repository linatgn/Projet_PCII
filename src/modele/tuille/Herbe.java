package modele.tuille;

//Classe qui definie l'herbe
//Extends Tuille car la classe est une classe fille de Tuille
public class Herbe extends Tuille{

    //Constructeur de la classe
    public Herbe(int x, int y) {
        super(x, y);
        solid = false;
        x_texture = 0;
        y_texture = 0;
    }
}