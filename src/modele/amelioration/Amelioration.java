package modele.amelioration;

import modele.Modele;
import modele.TypeBatiment;
import vue.Vue;
import vue.panel.InfoPanel;

import javax.swing.*;

abstract public class Amelioration {
    protected Modele M;

    public TypeBatiment typeBatiment; // Type de batiment sur lequel on peut prendre l'amelioration

    public int coutBois;
    public int coutPierre;
    public int coutNourriture;
    public int coutPopulation;

    protected int niveauJoueur; // niveau du joueur necessaire pour avoir l'amelioration
    protected Amelioration amNec; // amelioration necessaire pour avoir l'amelioration
    protected boolean activer = false;

    public int dureeAmelioration; // temps necessaire pour consommer l'amelioration
    public int timerAmelioration = 0; // timer avant que l'amelioration soit consomee
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
        M.ameliorationsEnCours.add(this);
    }

    public void update(InfoPanel infoPanel){
        timerAmelioration++;
        //System.out.println("Timer:" + (dureeAmelioration-timerAmelioration));


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
