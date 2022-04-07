package modele.unite.structure.batiment;

import modele.Modele;
import modele.TypeBatiment;
import modele.unite.structure.Structure;
import vue.panel.InfoPanel;

/**
 *  classe parentes des batiments de la grille de jeu
 */
public abstract class Batiment extends Structure {

    public TypeBatiment typeBatiment;

    //Tick de timer déjà écouler depuis le début de la construction
    protected int tickActuel;

    //Tick de timer requis pour construire un batiment
    protected int tickRequis;
    protected boolean enConstruction = true;

    // Cout de creation du batiment

    public Batiment(int x, int y, Modele m){
        super(x,y,m);
        this.x = x;
        this.y = y;

        x_texture = 4;
        y_texture = 2;

        enConstruction = true;

    }

    public boolean getEnConstruction() {
        return enConstruction;
    }

    /**
     * augmente le niveau de construction du batiment
     * @return true si le batiment a fini de se construire sinon false
     */
    public boolean seConstruire(){
        if(tickActuel < tickRequis){
            tickActuel++;
            return true;
        } else if(tickActuel == tickRequis && enConstruction == true){
            enConstruction = false;
            activerBatiment();
        }
        return false;
    }

    /**
     * Affichage du batiment
     */
    protected void activerBatiment(){
        if(M.uniteSelectionnee == this){
            M.V.infoPanel.afficherUniteSelectionnee();
        }
    }

    public boolean estEnConstruction() {
        return enConstruction;
    }
}
