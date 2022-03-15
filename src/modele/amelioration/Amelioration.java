package modele.amelioration;

import modele.Modele;
import modele.TypeBatiment;

abstract public class Amelioration {
    protected Modele M;

    protected TypeBatiment tb; // Type de batiment sur lequel on peut prendre l'amelioration

    protected int coutBois;
    protected int coutPierre;
    protected int coutNourriture;
    protected int coutPopulation;

    protected int niveau; // niveau du joueur necessaire pour avoir l'amelioration
    protected Amelioration amNec; // amelioration necessaire pour avoir l'amelioration
    protected boolean activer = false;

    protected int dureeAmelioration; // temps necessaire pour consommer l'amelioration
    protected int timerAmelioration = 0; // timer avant que l'amelioration soit consomee

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

        if(niveau > M.niveau)
            return false;

        if(amNec != null)
            return amNec.activer;

        return true;
    }

    public void lancerTimer(){
        M.ameliorationsEnCours.add(this);
    }

    public void update(){
        timerAmelioration++;
        System.out.println("Timer:" + (dureeAmelioration-timerAmelioration));
        if(timerAmelioration >= dureeAmelioration)
        {
            activer();
            M.ameliorationsEnCours.remove(this);
        }
    }
}
