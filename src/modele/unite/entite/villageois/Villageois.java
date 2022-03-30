package modele.unite.entite.villageois;

import modele.Modele;
import modele.unite.Unite;
import modele.unite.entite.Entite;
import modele.unite.structure.Structure;
import modele.unite.structure.batiment.Batiment;
import vue.panel.InfoPanel;
import modele.unite.entite.animaux.Animaux;
import modele.unite.structure.Recoltable;

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

        System.out.println(x_texture);
    }
    @Override
    public String getNom() {
        return "Villageois";
    }

    public void recolte(int x,  int y) {

    }


    public void cible(Unite unite) {
        if (unite instanceof Recoltable) {
            tache = Tache.RECOLTE;
        }
        else if (unite instanceof Animaux) {
            tache = Tache.ATTAQUE;
        }
        else if (unite == null) {
            tache = Tache.DEPLACE;
        }
        //System.out.println("Ceci est un arbre TEST" + " " + unite );
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

    }

}

