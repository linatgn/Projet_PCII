package modele.amelioration;

import modele.Modele;
import modele.TypeBatiment;
import vue.Vue;
import vue.panel.InfoPanel;

import javax.swing.*;

//Classe qui a definir les améliorations
abstract public class Amelioration {

    protected Modele M;

    // Type de batiment sur lequel on peut prendre l'amelioration
    public TypeBatiment typeBatiment;


    public int coutBois;
    public int coutPierre;
    public int coutNourriture;
    public int coutPopulation;

    // niveau du joueur necessaire pour avoir l'amelioration
    protected int niveauJoueur;

    // amelioration necessaire pour avoir l'amelioration
    protected Amelioration amNec;

    protected boolean activer = false;

    // temps necessaire pour consommer l'amelioration
    public int dureeAmelioration;

    // timer avant que l'amelioration soit consomee
    public int timerAmelioration = 0;
    public boolean timerLancer = false;
    public JProgressBar progressBar;

    protected int x_texture;
    protected int y_texture;

    public Amelioration(Modele m){
        M = m;
    }


    abstract public boolean testCondition();
    abstract public void activer();

    /**
     * Verifie si le niveau du joueur est assez elevé et s'il y a une amelioration a recupérer avant
     *
     * @return true si les conditions sont respecté, false sinon
     */
    public boolean estDeblocable(){

        if(activer)
            return false;

        if(niveauJoueur > M.niveau)
            return false;

        if(amNec != null)
            return amNec.activer;

        return true;
    }

    public void lancerTimer(){
        timerLancer = true;

        M.bois -= coutBois;
        M.pierre -= coutPierre;
        M.nourriture -= coutNourriture;

        M.ameliorationsEnCours.add(this);
    }

    public void update(InfoPanel infoPanel){
        timerAmelioration++;

        if(progressBar != null)
            progressBar.setValue(timerAmelioration);
        if(timerAmelioration >= dureeAmelioration)
        {
            activer();
            M.ameliorationsEnCours.remove(this);
            infoPanel.afficherUniteSelectionnee();
        }
    }

    abstract public String getNom();

}