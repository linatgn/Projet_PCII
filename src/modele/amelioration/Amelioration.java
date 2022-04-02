package modele.amelioration;

import modele.Modele;
import modele.TypeBatiment;
import vue.Vue;
import vue.panel.InfoPanel;

import javax.swing.*;

//Classe qui a definir les améliorations
abstract public class Amelioration {

    //Declaration d'un modele
    protected Modele M;

    // Type de batiment sur lequel on peut prendre l'amelioration
    public TypeBatiment typeBatiment;


    /**
     * Var : Bois requis pour une amelioration
     */
    public int coutBois;

    /**
     * Var : Pierre requis pour une amelioration
     */
    public int coutPierre;

    /**
     * Var : Nourriture requis pour une amelioration
     */
    public int coutNourriture;

    /**
     * Var : Ressources consomme en fonction de la population
     */
    public int coutPopulation;

    /**
     * Var : Niveau du joueur
     */
    protected int niveauJoueur;

    /**
     * Var : Temps necessaire pour l'amelioration
     */
    public int dureeAmelioration;

    //Amelioration necessaire pour avoir l'amelioration
    protected Amelioration amNec;

    //Bolleen qui donne acces ou non a l'amelioration
    protected boolean activer = false;

    //Timer avant que l'amelioration soit consomee
    public int timerAmelioration = 0;

    //Si le timer pour l'amelioration est lance ou non
    public boolean timerLancer = false;

    //Affichage de la progression de l'amelioration
    public JProgressBar progressBar;

    //Coordoonee sur le tailset pour l'affichage
    protected int x_texture;
    protected int y_texture;



    //Constructeur de la classe
    public Amelioration(Modele m){
        M = m;
    }


    /**
     * Renvois faux ou vrai si les conditions de l'amelioration sont atteint
     * @return true si les conditions sont respecté, false sinon
     */
    abstract public boolean testCondition();


    /**
     * Activation de l'amelioration
     */
    abstract public void activer();


    /**
     * Verifie si le niveau du joueur est assez elevé et s'il y a une amelioration a recupérer avant
     *
     * @return true si les conditions sont respecté, false sinon
     */
    public boolean estDeblocable(){
        if(activer)
            return false;
        //Verifie que le niveau du joueur est au dessus du niveau du modele
        if(niveauJoueur > M.niveau)
            return false;
        //Verifie que les ameliorations sont null
        if(amNec != null)
            return amNec.activer;

        return true;
    }


    /**
     * Lance le timer pour l'amelioration et retire les ressources du a l'amelioration
     */
    public void lancerTimer(){
        //Bolleen deviens true lorsque l'amelioration est lance
        timerLancer = true;

        //Retire les ressources requises a l'amelioration
        M.bois -= coutBois;
        M.pierre -= coutPierre;
        M.nourriture -= coutNourriture;

        M.ameliorationsEnCours.add(this);
    }

    /**
     * Update les informations du panel et les affichent
     * @param infoPanel
     */
    public void update(InfoPanel infoPanel){
        //Incremente le timer
        timerAmelioration++;

        //Verifie que la barre de progression de l'amelioration n'est pas null
        if(progressBar != null)
            progressBar.setValue(timerAmelioration);

        //Verifie que le timer est arrive au temps necessaire pour l'amelioration
        if(timerAmelioration >= dureeAmelioration) {
            activer();
            M.ameliorationsEnCours.remove(this);
            infoPanel.afficherUniteSelectionnee();
        }
    }

    /**
     *
     * @return le nom voulu
     */
    abstract public String getNom();

}