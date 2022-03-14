package modele.unite;

import modele.Modele;

abstract public class Unite {
    protected int x;
    protected int y;
    private final Modele M;

    public int x_texture;
    public int y_texture;


    public int LARGEUR;
    public int HAUTEUR;


    public Unite(int x, int y, Modele m){
        this.x = x;
        this.y = y;
        this.M = m;
    }
}
