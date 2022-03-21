package modele.unite.structure.environnement;

import modele.Modele;
import modele.TypeRessource;
import modele.unite.structure.Recoltable;

public class Arbre extends Environnement implements Recoltable {

    public Arbre(int x, int y, Modele m) {
        super(x, y,m);
        x_texture = 2;
        y_texture = 0;

        largeur = 1;
        hauteur = 1;

        typeRessource = TypeRessource.BOIS;
        quantiteRessource = 300;
    }

    @Override
    public int enlever(int qte) {
        if(quantiteRessource>qte){
            quantiteRessource = quantiteRessource - qte;
            return qte;
        }
        else if(quantiteRessource <= qte){
            qte = quantiteRessource;
            quantiteRessource = 0;

            if(M.uniteSelectionee == this){
                M.uniteSelectionee = null;
            }
            M.grille.getTuille(x, y).solid = false;
            M.unites[x][y] = null;
            return qte;
        }

        return qte;

    }
}
