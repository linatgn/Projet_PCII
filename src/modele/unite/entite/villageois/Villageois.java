package modele.unite.entite.villageois;

import java.util.Queue;

import modele.Modele;
import modele.TypeRessource;
import modele.unite.Unite;
import modele.unite.entite.Direction;
import modele.unite.entite.Entite;
import modele.unite.structure.Structure;
import modele.unite.structure.batiment.Batiment;
import vue.panel.InfoPanel;
import modele.unite.entite.animaux.Animaux;
import modele.unite.structure.Recoltable;
import modele.unite.structure.batiment.Batiment;
import modele.unite.structure.batiment.Hdv;

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

        chemin.add(Direction.BAS);
        chemin.add(Direction.BAS);
        chemin.add(Direction.BAS);
        chemin.add(Direction.BAS);
        chemin.add(Direction.BAS);
        chemin.add(Direction.BAS);

    }
    @Override
    public String getNom() {
        return "Villageois";
    }


    public void seConstruire(Batiment cible) {
        //System.out.println(cible + " " + "est en construction");
    }

    public void deposer() {
       // System.out.println(quantiteRessource  + " " + "sont déposés");
    }


    public void cible(Unite cible) {
        if (cible instanceof Animaux) {
            tache = Tache.ATTAQUE;
            System.out.println(tache);
        }
        else if (cible == null) {
            tache = Tache.DEPLACE;
            System.out.println(tache);
        }
        else if (cible instanceof Batiment) {
            if (((Batiment)cible).getEnConstruction()) {
                tache = Tache.CONSTRUIT;
                System.out.println(tache);
            }
            else if (cible instanceof Hdv && quantiteRessource > 0) {
                tache = Tache.DEPOSER;
                System.out.println(tache);
            }
        }
        else if (cible instanceof Recoltable) {
            tache = Tache.RECOLTE;
            System.out.println(tache);
        }
        else {
            tache = Tache.RIEN;
            System.out.println(tache);
        }
        uniteCible = cible;
        System.out.println(cible);
    }




    public void recolte(Recoltable cible){
        if(cible == null){
            tache = Tache.RIEN;
        } else if (typeRessource == ((Unite)cible).typeRessource){
            if(quantiteRessource == M.stockageVillagois){
                tache = Tache.DEPOSER;
                //Calcul du chemin avec pathfinder jusqu'à l'hdv
                //deplacer(chemin.remove()
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
                    //Calcul du chemin avec pathfinder
                    //deplacer(chemin.remove()
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
                //Calcul du chemin avec pathfinder
                //deplacer(chemin.remove()
            }
        }
    }

    public void update() {
        boolean a;
        //System.out.println(this + " " + tache);
        switch(tache) {
            case RIEN:
                break;
            case RECOLTE:
                recolte((Recoltable)uniteCible);
                break;
            case ATTAQUE:
                attaque((Entite)uniteCible);
                break;
            case DEPLACE:
                if (!chemin.isEmpty())
                    a = deplacer(chemin.remove());
                break;
            case CONSTRUIT:
                seConstruire((Batiment)uniteCible);
                break;
            case DEPOSER:
                deposer();
                break;
        }
    }

}

