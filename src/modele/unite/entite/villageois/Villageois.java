package modele.unite.entite.villageois;

import java.util.Queue;

import modele.Modele;

import modele.TypeBatiment;
import modele.TypeRessource;


import modele.grille.Grille;
import modele.unite.entite.Direction;


import modele.unite.Unite;
import modele.unite.entite.Direction;
import modele.unite.entite.Entite;
import modele.unite.structure.batiment.Batiment;
import modele.unite.entite.animaux.Animaux;
import modele.unite.structure.Recoltable;
import modele.unite.structure.batiment.Batiment;
import modele.unite.structure.batiment.Hdv;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

//Classe qui definie les villageois
//Extends Entite car la classe est une classe fille de Entite
public class Villageois extends Entite {

    /**
     * Var : Nouvelle coordonnee x apres deplacement
     */
    private int x_deplace;

    /**
     * Var : Nouvelle coordonnee y apres deplacement
     */
    private int y_deplace;

    //Constructeur de la classe
    public Villageois(int x, int y, Modele m) {
        super(x, y, m);
        x_texture = 6;
        y_texture = 0;

        largeur = 1;
        hauteur = 1;

        pv = m.pvVillageois;
        attaque = m.attaqueVillageois;
        defense = m.defenseVillageois;

        tache = Tache.RIEN;

        M.population++;

    }

    @Override
    public String getNom() {
        return "Villageois";
    }

    /**
     * si le villageois est a cote de l'hdv il depose ses ressources
     * sinon il commence a y aller.
     * une fois qu'il depose ses ressources, il retourne recolter
     */
    public void deposer() {

        if(estaCote(M.hdv)){
            switch (typeRessource) {
                case PIERRE -> {
                    M.pierre += quantiteRessource;
                }
                case NOURRITURE -> {
                    M.nourriture += quantiteRessource;
                }

                case BOIS -> {
                    M.bois += quantiteRessource;
                }
            }
            quantiteRessource = 0;
            tache = Tache.RECOLTE;
            M.V.infoPanel.afficherUniteSelectionnee();
        }
        else {
            if (chemin.isEmpty()) {
                calculerChemin(M.hdv.getX(), M.hdv.getY());
            }
            else if(!deplacer(chemin.pop()))
                calculerChemin(M.hdv.getX(), M.hdv.getY());
        }
    }


    /**
     * Recupere le type de la cible et effectue des actions en consequences
     * @param x Coordonnee x de la cible
     * @param y Coordonnee y de la cible
     */
    public void cible(int x, int y) {

        //Recuperation de l'unite au coordonnee donnee
        Unite cible = M.unites[x][y];
        //Verifie que la cible est un animal
        if (cible instanceof Animaux) {
            //Le villageois attaque l'animal
            tache = Tache.ATTAQUE;
        }
        //Verifie que la cible est une case vide
        else if (cible == null) {
            //Le villageois se deplace uniquement sur la case vide
            x_deplace = x;
            y_deplace = y;
            calculerChemin(x_deplace,y_deplace);
            tache = Tache.DEPLACE;
        }
        //Verifie que la cible est un batiment
        else if (cible instanceof Batiment) {
            //Verifie que le batiment est en construction et continue a construire si c'est le cas
            if (((Batiment)cible).getEnConstruction()) {
                tache = Tache.CONSTRUIT;
            }
            //Verifie que le batiment est un HDV et depose ses ressourves
            else if (cible instanceof Hdv && quantiteRessource > 0) {
                tache = Tache.DEPOSER;
            }
            //Verifie que le batiment est un recoltable et commence a recolter les ressources
            else if (cible instanceof Recoltable) {
                tache = Tache.RECOLTE;
            }
        }
        //Verifie que le cible est un recoltable
        else if (cible instanceof Recoltable) {
            tache = Tache.RECOLTE;
        }
        else {
            tache = Tache.RIEN;
        }
        uniteCible = cible;
    }


    /**
     * Recolte les ressources du recoltable cible
     * @param cible La cible qui est un recoltable
     */
    public void recolte(Recoltable cible){
        if(cible == null){
            tache = Tache.RIEN;
        } else if (typeRessource == ((Unite)cible).typeRessource){
            if(quantiteRessource == M.stockageVillagois){
                tache = Tache.DEPOSER;
                calculerChemin(M.hdv.getX(),M.hdv.getY());

                if(chemin.isEmpty())
                    calculerChemin(((Unite) cible).getX(),((Unite) cible).getY());
                else if(!deplacer(chemin.pop()))
                    calculerChemin(((Unite) cible).getX(),((Unite) cible).getY());

            } else if(quantiteRessource < M.stockageVillagois){
                if(estaCote(((Unite)cible))) {
                    if(quantiteRessource + M.vitesseRecolte >= M.stockageVillagois){
                        quantiteRessource += cible.enlever(M.stockageVillagois-quantiteRessource);
                        M.V.infoPanel.afficherUniteSelectionnee();
                    } else if (quantiteRessource + M.vitesseRecolte < M.stockageVillagois){
                        quantiteRessource += cible.enlever(M.vitesseRecolte);
                        M.V.infoPanel.afficherUniteSelectionnee();
                    }
                }
                else {
                    if(chemin.isEmpty())
                        calculerChemin(((Unite) cible).getX(),((Unite) cible).getY());
                    else if(!deplacer(chemin.pop()))
                        calculerChemin(((Unite) cible).getX(),((Unite) cible).getY());
                }
            }
        } else if(typeRessource != ((Unite)cible).typeRessource){
            if(estaCote(((Unite)cible))) {
                quantiteRessource = 0;
                typeRessource = ((Unite)cible).typeRessource;
                if(quantiteRessource + M.vitesseRecolte >= M.stockageVillagois){
                    quantiteRessource += cible.enlever(M.stockageVillagois-quantiteRessource);
                } else if (quantiteRessource + M.vitesseRecolte < M.stockageVillagois){
                    quantiteRessource += cible.enlever(M.vitesseRecolte);
                }
            }
            else {
                if(chemin.isEmpty())
                    calculerChemin(((Unite) cible).getX(),((Unite) cible).getY());
                else if(!deplacer(chemin.pop()))
                    calculerChemin(((Unite) cible).getX(),((Unite) cible).getY());
            }
        }
    }

    public void construire(Batiment batiment){
        if(batiment == null){
            tache = Tache.RIEN;
        } else if(estaCote(batiment) && batiment.estEnConstruction()){
            tache = Tache.CONSTRUIT;
            if(!batiment.seConstruire()){
                tache = Tache.RIEN;
            }

        } else {
            if(chemin.isEmpty())
                calculerChemin(batiment.getX(),batiment.getY());
            else if(!deplacer(chemin.pop()))
                calculerChemin(batiment.getX(),batiment.getY());
        }
    }

    public void update() {
        switch(tache) {
            case RIEN:
                break;
            case RECOLTE: // recolter un recoltable
                recolte((Recoltable)uniteCible);
                break;
            case ATTAQUE: // attaquer un animal
                attaquer((Entite)uniteCible);
                break;
            case DEPLACE: // se deplacer sur une tuille vide
                if (chemin.isEmpty())
                    calculerChemin(x_deplace,y_deplace);
                else if(x_deplace == x && y_deplace == y) // si l'entite est arriver a destination
                    tache = Tache.RIEN;
                else if(!deplacer(chemin.pop()))
                    calculerChemin(x_deplace,y_deplace);
                break;
            case CONSTRUIT: // construire un batiment en construction
                construire((Batiment)uniteCible);
                break;
            case DEPOSER: // deposer des ressources recolter
                deposer();
                break;
        }
    }

    @Override
    public void mourrir(){
        super.mourrir();
        M.population--;
    }
}

