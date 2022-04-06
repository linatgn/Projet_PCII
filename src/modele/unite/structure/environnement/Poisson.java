package modele.unite.structure.environnement;

import modele.Modele;
import modele.TypeRessource;
import modele.unite.structure.Recoltable;

public class Poisson extends Environnement implements Recoltable {

    public Poisson(int x, int y, Modele m) {
        super(x, y,m);
        x_texture = 2;
        y_texture = 2;

        largeur = 1;
        hauteur = 1;

        typeRessource = TypeRessource.NOURRITURE;
        quantiteRessource = 300;
    }

    @Override
    public double enlever(double qte) {
        if(quantiteRessource>qte){
            quantiteRessource = quantiteRessource - qte;
            return qte;
        }
        else if(quantiteRessource <= qte){
            qte = quantiteRessource;
            if(M.uniteSelectionnee == this) M.V.infoPanel.afficherUniteSelectionnee();
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
        return "Poisson";
    }

}
