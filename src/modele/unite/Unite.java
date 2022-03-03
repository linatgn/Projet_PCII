package modele.unite;

import modele.Modele;

abstract public class Unite {
    private int x;
    private int y;

    private final Modele M;

    private int x_texture;
    private int y_texture;

    public Unite(int x, int y, Modele m){
        this.x = x;
        this.y = y;
        this.M = m;
    }
}
