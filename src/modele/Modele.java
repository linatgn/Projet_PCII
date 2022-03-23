package modele;


import modele.amelioration.*;
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

import java.util.ArrayList;

public class Modele {
    private final Vue V;

    public Grille grille;
    public static Unite[][] unites;
    public static Unite uniteSelectionnee;

    public final Timer timer = new Timer(this);

    // Ressource

    public int bois = 1000;
    public int pierre = 1000;
    public int nourriture = 1000;
    public int population = 10; // nombre de villagois

    // statistique ameliorable

    public int niveau = 0;
    public int stockageVillagois = 10; // nombre d'unite de ressource maximal stockable par un villagois
    public double vitesseRecolte = 1; // nombre d'unite recolte par un villagois par tick
    public int maxPopulation = 3; // nombre de villagois maximal
    public int pvVillageois = 10;
    public int attaqueVillageois = 3;
    public int defenseVillageois = 0;
    public int quantiteRessourceFerme = 300;

    // Amelioration

    public Amelioration[] ameliorations;
    public ArrayList<Amelioration> ameliorationsEnCours;

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

        // Ajout des ameliorations disponible

        ameliorations = new Amelioration[8];
        ameliorations[0] = new VitesseRecolteAm(this,1, null);
        ameliorations[1] = new VitesseRecolteAm(this,2, ameliorations[0]);
        ameliorations[2] = new NiveauAm(this,0,null);
        ameliorations[3] = new NiveauAm(this,1,ameliorations[2]);
        ameliorations[4] = new FermeAm(this,1,null);
        ameliorations[5] = new FermeAm(this,2,ameliorations[4]);
        ameliorations[6] = new StockageVillageoisAm(this,1,null);
        ameliorations[7] = new StockageVillageoisAm(this,2,ameliorations[6]);

        ameliorationsEnCours = new ArrayList<>();

    }

    public void select(int x, int y) {
        uniteSelectionnee = unites[x][y];
        V.infoPanel.afficherUniteSelectionnee();
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

            }
                //TODO IF LAC ETC.
        }
 */

    public void update() {
        //System.out.println("bois: " + bois + " pierre: " + pierre + " nourriture: " + nourriture + " population: " + population + "/" + maxPopulation);
        //System.out.println("VitesseRecolte:" + vitesseRecolte);
        //System.out.println("Ameliorations:" + ameliorations);
        //System.out.println("AmeliorationEnCours:" + ameliorationsEnCours);

        // reduction des timers des ameliorations en cours de developpement

        //for (Amelioration ameliorationsEnCour : ameliorationsEnCours) {
        for(int i=0; i < ameliorationsEnCours.size(); i++){
                ameliorationsEnCours.get(i).update(V.infoPanel);
        }
        V.ressourcePanel.revalidate();
        V.ressourcePanel.repaint();
        V.jeuPanel.revalidate();
        V.jeuPanel.repaint();
    }

    // Lance le jeu
    public void start(){
        timer.start();
    }
}
