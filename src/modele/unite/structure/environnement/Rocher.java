package modele.unite.structure.environnement;

import modele.Modele;
import modele.TypeRessource;
import modele.unite.structure.Recoltable;
import modele.TypeRessource;
import modele.unite.structure.environnement.Environnement;

public class Rocher extends Environnement implements Recoltable {

    public Rocher(int x, int y, Modele m) {
        super(x, y,m);
        x_texture = 2;
        y_texture = 1;

        largeur = 1;
        hauteur = 1;


        typeRessource = TypeRessource.PIERRE;
        quantiteRessource = 500;
    }

    public double enlever(double qte) {
        if(quantiteRessource>qte){
            quantiteRessource = quantiteRessource - qte;
            return qte;
        }
        else if(quantiteRessource <= qte){
            qte = qte - quantiteRessource;
            quantiteRessource = 0;

            if(M.uniteSelectionnee == this){
                M.uniteSelectionnee = null;
            }
            M.grille.getTuille(x, y).solid = false;
            M.unites[x][y] = null;
            return qte;
        }

        return qte;

    }

    @Override
    public String getNom() {
        return "Rocher";
    }
}
