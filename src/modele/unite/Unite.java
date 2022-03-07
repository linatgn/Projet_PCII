package modele.unite;

import modele.Modele;

abstract public class Unite {
    protected int x;
    protected int y;

    protected final Modele M;

    public int x_texture;
    public int y_texture;
    public int x_textureSize;
    public int y_textureSize;

    public Unite(int x, int y, Modele m){
        this.x = x;
        this.y = y;
        this.M = m;
    }



}
