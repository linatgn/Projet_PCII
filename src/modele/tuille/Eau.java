package modele.tuille;

public class Eau extends Tuille{

    public Eau(int x, int y) {
        super(x, y);
        solid = false;
        x_texture = 0;
        y_texture = 2;
    }
}