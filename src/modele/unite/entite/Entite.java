package modele.unite.entite;

import java.util.LinkedList;

import modele.Modele;
import modele.unite.Unite;

import modele.unite.entite.animaux.Animaux;
import modele.unite.structure.Recoltable;
import vue.panel.InfoPanel;

import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Stack;



abstract public  class  Entite extends Unite {

    public int pv;
    public int attaque;
    public int defense;


    protected LinkedList<Direction> chemin;


    public Entite(int x, int y, Modele m) {
        super(x, y, m);
        chemin = new LinkedList<>();
        m.listeEntite.add(this);
    }

    public Stack<Direction> chemin;

    public Entite(int x, int y, Modele m) {
        super(x, y, m);
       chemin = new Stack<>();

    }

    /**
     * Implementation de l'algorithme A* pour calculer le chemin d'une unite pour aller à un noeud
     * @return true si un chemin a ete trouver, false sinon
     */
    public boolean calculerChemin(int x, int y){
        LinkedList<Noeud> closedList = new LinkedList<>(); // liste des noeuds déjà vérifié
        PriorityQueue<Noeud> openList = new PriorityQueue<>(); // queue prioritaire des noeuds à calculer

        Noeud depart = new Noeud(this.x,this.y);
        Noeud arrive = new Noeud(x,y);

        openList.add(depart);

        while(!openList.isEmpty()){
            Noeud u = openList.remove(); // on recuperer le noeud avec la meilleur valeur d'heuristique

            // si ce noeud est le noeud d'arrivé, on recalcule le chemin
            if(u.x == arrive.x && u.y == arrive.y){

                reconstruireChemin(u);
                return true;
            }
            else // sinon on evalue ces noeuds voisin
            {

                System.out.println("nouveau noeud:"+u);
                // voisin gauche
                if(u.y>=1) {
                    Noeud v = new Noeud(u.x , u.y-1);
                    if (!M.grille.getTuille(u.x , u.y-1).solid || v.equals(arrive)) {
                        v.cout = u.cout + 1;
                        if (!closedList.contains(v)) {
                            boolean estDansOpen = false;
                            for(Noeud n : openList){
                                if (n.x == v.x && n.y == v.y && n.cout <= v.cout) {
                                    estDansOpen = true;
                                    break;
                                }

                            }
                            if(!estDansOpen) {
                                v.heuristique = v.cout + Math.sqrt(Math.pow(arrive.x - v.x, 2) + Math.pow(arrive.y - v.y, 2));
                                v.pred = u;
                                openList.add(v);
                            }
                        }
                    }
                }
                // voisin droit
                if(u.y<M.grille.LARGEUR-1) {
                    Noeud v = new Noeud(u.x, u.y+1);
                    if (!M.grille.getTuille(u.x, u.y+1).solid|| v.equals(arrive)) {
                        v.cout = u.cout + 1;
                        if (!closedList.contains(v)) {
                            boolean estDansOpen = false;
                            for(Noeud n : openList){
                                if (n.x == v.x && n.y == v.y && n.cout <= v.cout) {
                                    estDansOpen = true;
                                    break;
                                }

                            }
                            if(!estDansOpen) {
                                v.heuristique = v.cout + Math.sqrt(Math.pow(arrive.x - v.x, 2) + Math.pow(arrive.y - v.y, 2));
                                v.pred = u;
                                openList.add(v);
                            }
                        }
                    }
                }
                // voisin haut
                if(u.x>=1) {
                    Noeud v = new Noeud(u.x-1, u.y);
                    if (!M.grille.getTuille(u.x-1, u.y).solid || v.equals(arrive)) {
                        v.cout = u.cout + 1;
                        if (!closedList.contains(v)) {
                            boolean estDansOpen = false;
                            for(Noeud n : openList){
                                if (n.x == v.x && n.y == v.y && n.cout <= v.cout) {
                                    estDansOpen = true;
                                    break;
                                }

                            }
                            if(!estDansOpen) {
                                v.heuristique = v.cout + Math.sqrt(Math.pow(arrive.x - v.x, 2) + Math.pow(arrive.y - v.y, 2));
                                v.pred = u;
                                openList.add(v);
                            }
                        }
                    }
                }
                // voisin bas
                if(u.x<M.grille.HAUTEUR-1) {
                    Noeud v = new Noeud(u.x+1, u.y);
                    if (!M.grille.getTuille(u.x+1, u.y).solid|| v.equals(arrive)) {
                        v.cout = u.cout + 1;
                        if (!closedList.contains(v)) {
                            boolean estDansOpen = false;
                            for(Noeud n : openList){
                                if (n.x == v.x && n.y == v.y && n.cout <= v.cout) {
                                    estDansOpen = true;
                                    break;
                                }

                            }
                            if(!estDansOpen) {
                                v.heuristique = v.cout + Math.sqrt(Math.pow(arrive.x - v.x, 2) + Math.pow(arrive.y - v.y, 2));
                                v.pred = u;
                                openList.add(v);
                            }
                        }
                    }
                }
                closedList.add(u);
            }

        }
        return false;
    }

    /**
     * reconstruit le chemin en partant du noeud d'arrive
     * @param arrive noeud d'arrive
     */
    private void reconstruireChemin(Noeud arrive) {
        Noeud it = arrive;

        if(M.grille.getTuille(it.x,it.y).solid)
            it = it.pred;

        // pour chaque noeud du chemin en partant de la fin, on ajoute la direction à prendre pour l'unite
        while (it != null && it.pred != null){
            if(it.y + 1 == it.pred.y) { // si it est à gauche de son predecesseur
               chemin.add(Direction.GAUCHE) ;
            }
            else if(it.y - 1 == it.pred.y) { // si it est à droite de son predecesseur
                chemin.add(Direction.DROITE);
            }
            else if(it.x + 1 == it.pred.x) { // si it est en haut de son predecesseur
                chemin.add(Direction.HAUT);
            }
            else if(it.x - 1 == it.pred.x) { // si it est en bas de son predecesseur
                chemin.add(Direction.BAS);
            }
            it = it.pred;
        }
    }




    public boolean estaCote(Unite cible){
        //Test à gauche
        if((x>0 && cible.getX() == x-1) && (cible.getY() == y)){
            return true;
        }
        //Test en haut
        else if ((cible.getX() == x) && (y>0 && cible.getY() == y-1)){
            return true;
        }
        //Test à droite
        else if ((x<M.grille.LARGEUR && cible.getX() == x+1) && (cible.getY() == y)){
            return true;
        }
        //Test en bas
        else if ((cible.getX() == x) && (y<M.grille.HAUTEUR && cible.getY() == y+1)){
            return true;
        }
        return false;
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


/**
 *  Structure represantant un noeud d'un graphe
 *  x,y: coordonées du noeud dans le graphe
 *  cout: nombre de noeud qu'il faut traverser pour acceder à ce noeud
 *  heuristique: cout + distance entre ce noeud et le noeud d'arrive
 */
class Noeud implements Comparable<Noeud>{
    public int x;
    public int y;
    public int cout;
    public double heuristique;

    public Noeud pred;

    public Noeud(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Noeud noeud = (Noeud) o;
        return x == noeud.x && y == noeud.y;// && cout == noeud.cout && heuristique == noeud.heuristique;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, cout, heuristique);
    }

    @Override
    public int compareTo(Noeud n) {
        if(heuristique < n.heuristique)
            return -1;
        else if(heuristique == n.heuristique)
            return 0;
        else
            return 1;
    }

    @Override
    public String toString() {
        return "Noeud{" +
                "x=" + x +
                ", y=" + y +
                ", cout=" + cout +
                ", heuristique=" + heuristique +
                "}\n";
    }
}
