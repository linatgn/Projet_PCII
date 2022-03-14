package modele;


import controle.Controle;
import modele.unite.structure.batiment.Ferme;
import modele.unite.Unite;
import modele.unite.structure.batiment.Hdv;
import modele.unite.structure.batiment.Maison;
import modele.unite.structure.environnement.Arbre;
import modele.unite.structure.environnement.Rocher;

import modele.timer.Timer;

import modele.unite.entite.animaux.hostile.Loup;
import modele.unite.entite.animaux.passif.Lapin;
import modele.unite.entite.villageois.Villageois;

import vue.Vue;

import modele.grille.Grille;

import static modele.unite.entite.Direction.*;

public class Modele {
    private final Vue V;

    public Grille grille;
    public static Unite[][] unites;
    public static Unite uniteSelectionee;

    public final Timer timer = new Timer(this);

    public Modele(Vue v){
        V = v;

        grille = new Grille();
        unites = new Unite[Grille.HAUTEUR][Grille.LARGEUR];

        unites[0][0] = new Ferme(0,0,this);
        unites[Grille.HAUTEUR/2][Grille.LARGEUR/2] = new Hdv(Grille.HAUTEUR/2,Grille.LARGEUR/2,this);
        unites[1][1] = new Maison(1,1,this);
        unites[2][2] = new Rocher(2,2,this);
        unites[3][3] = new Arbre(3,3,this);

        unites[6][6] = new Villageois(6,6, this);
        unites[6][4] = new Lapin(6,4, this);
        unites[4][6] = new Loup(4,6, this);

        uniteSelectionee = unites[6][6];

    }

    public static void select(int x, int y) {
        uniteSelectionee = unites[x][y];
        System.out.print("Select work !");
    }
    public static void cible() {
    }
/*
    public static void cible(unites) {
        if (uniteSelectionee == villageois) {
            if (unites == animal) {
//TODO methode attaque + pathfinder
            }
            else if (unites == ressource) {
//TODO methode recolte + pathfinder
            }
            }
            if (uniteSelectionee == hdv) {
//TODO new affichage dans le infoPanel
            }
            if (uniteSelectionee == batiment) {
//??
            }
//TODO IF LAC ETC.
        }
 */

    public void start(){
        timer.run();
    }

    public void update(){
        uniteSelectionee.deplacer(bas);
        V.jeuPanel.revalidate();
        V.jeuPanel.repaint();
    }
}
