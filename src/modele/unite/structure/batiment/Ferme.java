package modele.unite.structure.batiment;

import modele.Modele;
import modele.TypeRessource;
import modele.unite.structure.Recoltable;
import modele.TypeBatiment;

public class Ferme extends Batiment implements Recoltable {

    public Ferme(int x, int y, Modele m) {
        super(x, y,m);
        if(quantiteRessource>0 && quantiteRessource <= 75){
            y_texture = 3;
        } else if (quantiteRessource>75 && quantiteRessource <= 150){
            y_texture = 2;
        } else if (quantiteRessource>150 && quantiteRessource <= 225){
            y_texture = 1;
        } else if (quantiteRessource>225 && quantiteRessource <= 300){
            y_texture = 0;
        }
        x_texture = 5;


        largeur = 1;
        hauteur = 1;

        typeBatiment = TypeBatiment.FERME;
        quantiteRessource = m.quantiteRessourceFerme;
    }

    @Override
    public int enlever(int qte) {

        int recolte; // qantite de ressource recupere

        if(quantiteRessource>=qte){
            quantiteRessource -= qte;
            recolte = qte;

            if(quantiteRessource>0 && quantiteRessource <= 75){
                y_texture = 3;
            } else if (quantiteRessource>75 && quantiteRessource <= 150){
                y_texture = 2;
            } else if (quantiteRessource>150 && quantiteRessource <= 225){
                y_texture = 1;
            } else if (quantiteRessource>225 && quantiteRessource <= 300){
                y_texture = 0;
            }

        }
        else {
            recolte = quantiteRessource;
            quantiteRessource = 0;
        }

        if(quantiteRessource == 0){

            if(M.uniteSelectionnee == this){
                M.uniteSelectionnee = null;
            }
            M.grille.getTuille(x, y).solid = false;
            M.unites[x][y] = null;

        }

        return recolte;

    }

    @Override
    public String getNom() {
        return "Ferme";
    }
}
