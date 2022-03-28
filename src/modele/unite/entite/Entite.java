package modele.unite.entite;

import modele.Modele;
import modele.unite.Unite;

abstract public  class  Entite extends Unite {
    public int pv;
    public int attaque;
    public int defense;


    public Entite(int x, int y, Modele m) {
        super(x, y, m);

    }

    // méthode qui vérifie si une attaque est possible et la déclenche si oui

   public void attaquer(Entite cible){
       if (cible == null ) {
       }
     //   else if(cible.estACote(this)){
       else  cible.subirDegat(attaque);
       // }
        /* else {
           calculerChemin(cible);
           deplacer(chemin.get(0));
           }
            */

    }

    // methode qui enleve les points de vie de l'entité cible et supprime l'entité si pv=0

    public void subirDegat(int degat){
        if (defense<= degat) {
            degat = 1;
        }
        else degat = degat-defense;

        pv = pv-degat;

        if(pv<= 0) {
            if (M.uniteSelectionnee == this) {
                M.uniteSelectionnee = null;
                M.V.infoPanel.afficherUniteSelectionnee();

            }
                M.grille.getTuille(x, y).solid = false;
                M.unites[x][y] = null;
        }
        else {
            if (M.uniteSelectionnee == this)
                M.V.infoPanel.afficherUniteSelectionnee();
        }
    }


}

