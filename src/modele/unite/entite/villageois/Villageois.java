package modele.unite.entite.villageois;

import modele.Modele;


import modele.unite.Unite;
import modele.unite.entite.Entite;
import modele.unite.entite.Tache;
import modele.unite.structure.batiment.Batiment;
import modele.unite.entite.animaux.Animaux;
import modele.unite.structure.Recoltable;
import modele.unite.structure.batiment.Hdv;

public class Villageois extends Entite {

    private int x_deplace;
    private int y_deplace;

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
     * si le villageois est à cote de l'hdv il depose ses ressources
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
            if(uniteCible instanceof Recoltable)
                tache = Tache.RECOLTE;
            else
                tache = Tache.RIEN;
            M.V.infoPanel.updateRessource();
        }
        else {
            if (chemin.isEmpty()) {
                calculerChemin(M.hdv.getX(), M.hdv.getY());
            }
            else if(!deplacer(chemin.pop()))
                calculerChemin(M.hdv.getX(), M.hdv.getY());
        }
    }



    public void cible(int x, int y) {

        Unite cible = M.unites[x][y];
        if (cible instanceof Animaux) {
            tache = Tache.ATTAQUE;
        }
        else if (cible == null) {
            x_deplace = x;
            y_deplace = y;
            calculerChemin(x_deplace,y_deplace);
            tache = Tache.DEPLACE;
        }
        else if (cible instanceof Batiment) {
            if (((Batiment)cible).getEnConstruction()) {
                tache = Tache.CONSTRUIT;
            }
            else if (cible instanceof Hdv && quantiteRessource > 0) {
                tache = Tache.DEPOSER;
            }
            else if (cible instanceof Recoltable) { // cas des batiments constructible recoltable
                tache = Tache.RECOLTE;
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
            uniteCible = null;
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
                        if(M.uniteSelectionnee == this)M.V.infoPanel.updateRessource();
                    } else if (quantiteRessource + M.vitesseRecolte < M.stockageVillagois){
                        quantiteRessource += cible.enlever(M.vitesseRecolte);
                        if(M.uniteSelectionnee == this)M.V.infoPanel.updateRessource();
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
                    if(M.uniteSelectionnee == this)M.V.infoPanel.afficherUniteSelectionnee();
                } else if (quantiteRessource + M.vitesseRecolte < M.stockageVillagois){
                    quantiteRessource += cible.enlever(M.vitesseRecolte);
                    if(M.uniteSelectionnee == this)M.V.infoPanel.afficherUniteSelectionnee();
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

