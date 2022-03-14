package modele;



import modele.timer.Timer;
import modele.tuille.Herbe;

import modele.unite.Unite;
import modele.unite.entite.animaux.hostile.Loup;
import modele.unite.entite.animaux.passif.Lapin;
import modele.unite.entite.villageois.Villageois;
import vue.Vue;

import modele.grille.Grille;

import static modele.unite.entite.Direction.*;

public class Modele {
    private final Vue V;
    private int i = 0;

    public Grille grille;
    public Unite unites[][];

    public final Timer timer = new Timer(this);

    public Modele(Vue v){
        V = v;
        grille = new Grille();
        unites = new Unite[Grille.HAUTEUR][Grille.LARGEUR];
        unites[6][6] = new Villageois(6,6, this);
        unites[6][4] = new Lapin(6,4, this);
        unites[4][6] = new Loup(4,6, this);

        unites[6][6].deplacer(haut);
        unites[6][4].deplacer(bas);
        unites[4][6].deplacer(droite);




    }

    public void start(){
        timer.run();
    }

    public void update(){
        V.jeuPanel.revalidate();
        V.jeuPanel.repaint();
        i++;
    }
}
