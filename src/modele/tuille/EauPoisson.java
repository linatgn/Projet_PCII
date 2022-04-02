package modele.tuille;

//Classe qui definie l'eau avec des poisson
//Extends Tuille car la classe est une classe fille de Tuille
public class EauPoisson extends Tuille{

    //Constructeur de la classe
    public EauPoisson(int x, int y) {
        super(x, y);
        solid = false;
        x_texture = 1;
        y_texture = 2;
    }
}
