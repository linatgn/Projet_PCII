package modele.unite.entite.villageois;

import java.util.Queue;

import modele.Modele;

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

public class Villageois extends Entite {
    Tache tache;

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

    }
    @Override
    public String getNom() {
        return "Villageois";
    }

    public void deposer() {
       // System.out.println(quantiteRessource  + " " + "sont déposés");
    }



    public void cible(int x, int y) {

        Unite cible = M.unites[x][y];
        if (cible instanceof Animaux) {
            tache = Tache.ATTAQUE;
        }
        else if (cible == null) {
            tache = Tache.DEPLACE;
            calculerChemin(x,y);
        }
        else if (cible instanceof Batiment) {
            if (((Batiment)cible).getEnConstruction()) {
                tache = Tache.CONSTRUIT;
            }
            else if (cible instanceof Hdv && quantiteRessource > 0) {
                tache = Tache.DEPOSER;
            }
        }
        else if (cible instanceof Recoltable) {
            tache = Tache.RECOLTE;
        }
        else {
            tache = Tache.RIEN;
        }
        uniteCible = cible;
    }




    public void recolte(Recoltable cible){
        if(cible == null){
            tache = Tache.RIEN;
        } else if (typeRessource == ((Unite)cible).typeRessource){
            if(quantiteRessource == M.stockageVillagois){
                tache = Tache.DEPOSER;
                calculerChemin(M.hdv.getX(),M.hdv.getY());
                deplacer(chemin.pop());
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
                    deplacer(chemin.pop());
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
                deplacer(chemin.pop());
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
            if(chemin.isEmpty()){
                calculerChemin(batiment.getX(),batiment.getY());
            }
            deplacer(chemin.pop());
        }
    }

    public void update() {
        switch(tache) {
            case RIEN:
                break;
            case RECOLTE:
                recolte((Recoltable)uniteCible);
                break;
            case ATTAQUE:
                attaquer((Entite)uniteCible);
                break;
            case DEPLACE:
                if (chemin.isEmpty()) {
                    //calculerChemin()
                }
                else {
                    deplacer(chemin.pop());
                }
                break;
            case CONSTRUIT:
                construire((Batiment)uniteCible);
                break;
            case DEPOSER:
                deposer();
                break;
        }
    }

}

