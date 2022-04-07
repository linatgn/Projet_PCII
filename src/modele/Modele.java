package modele;


import modele.amelioration.*;
import modele.unite.structure.Recoltable;
import modele.unite.entite.Entite;
import modele.unite.structure.batiment.Batiment;
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

import javax.swing.*;
import java.util.ArrayList;

public class Modele {
    public final Vue V;

    public Grille grille;
    public  Unite[][] unites;
    public  Unite uniteSelectionnee;
    public ArrayList<Entite> listeEntite;

    public Hdv hdv;

    public final Timer timer = new Timer(this);

    // Ressource

    public double bois = 0;
    public double pierre = 0;
    public double nourriture = 1000;
    public int population = 0; // nombre de villagois

    // statistique ameliorable

    public int niveau = 0;
    public int stockageVillagois = 10; // nombre d'unite de ressource maximal stockable par un villagois
    public double vitesseRecolte = 1; // nombre d'unite recolte par un villagois par tick
    public int maxPopulation = 3; // nombre de villagois maximal
    public int pvVillageois = 10;
    public int attaqueVillageois = 1;
    public int defenseVillageois = 1;
    public int quantiteRessourceFerme = 500;
    public double Cout_Nourriture_Tick = 0.1; //nombre de nourriture retiré pour un villageois à chaque tick

    // Amelioration

    public Amelioration[] ameliorations;
    public ArrayList<Amelioration> ameliorationsEnCours;

    public int coutVillageois = 50;

    public boolean modeConstruction;
    public TypeBatiment batimentAConstruire;

    public Modele(Vue v){
        V = v;

        listeEntite = new ArrayList<>();

        grille = new Grille(this);
        unites = new Unite[Grille.HAUTEUR][Grille.LARGEUR];

        grille.construireGrille();

        new Hdv(Grille.HAUTEUR/2,Grille.LARGEUR/2,this);
        hdv = (Hdv) unites[Grille.HAUTEUR/2][Grille.LARGEUR/2];

        // Ajout des ameliorations disponible

        ameliorations = new Amelioration[11];
        ameliorations[0] = new CreerVillageois(this,1, null);
        ameliorations[1] = new VitesseRecolteAm(this,1, null);
        ameliorations[2] = new VitesseRecolteAm(this,2, ameliorations[1]);
        ameliorations[3] = new NiveauAm(this,0,null);
        ameliorations[4] = new NiveauAm(this,1,ameliorations[3]);
        ameliorations[5] = new FermeAm(this,1,null);
        ameliorations[6] = new FermeAm(this,2,ameliorations[5]);
        ameliorations[7] = new StockageVillageoisAm(this,1,null);
        ameliorations[8] = new StockageVillageoisAm(this,2,ameliorations[7]);
        ameliorations[9] = new DefenseAm(this,1,null);
        ameliorations[10] = new DefenseAm(this,2,ameliorations[9]);

        ameliorationsEnCours = new ArrayList<>();
    }

    public void select(int x, int y) {
        uniteSelectionnee = unites[x][y];
        V.infoPanel.afficherUniteSelectionnee();
    }

    public void ReduireNourriture(){
        if(nourriture > 0){
            if(nourriture < Cout_Nourriture_Tick * population){
                nourriture = 0;
            } else {
                nourriture = nourriture - (Cout_Nourriture_Tick * population);
            }
        } else if(nourriture == 0 ){
            for(int i = 0; i < listeEntite.size() ; i++){
                if(listeEntite.get(i) instanceof Villageois){
                    listeEntite.get(i).subirDegat(1);
                }
            }
        }
    }

    public boolean testPerdu(){
        return (population == 0 && nourriture < coutVillageois);
    }
  
    public void update() {

        // update des entitees
        for(int i=0; i < listeEntite.size(); i++) {
            listeEntite.get(i).update();
        }

        // reduction des timers des ameliorations en cours de developpement

        for(int i=0; i < ameliorationsEnCours.size(); i++){
            ameliorationsEnCours.get(i).update(V.infoPanel);
        }
        ReduireNourriture();
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
