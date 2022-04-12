package projet.projet_piia.controle;

import javafx.scene.input.MouseEvent;
import projet.projet_piia.modele.Etat;
import projet.projet_piia.modele.plante.Plante;
import projet.projet_piia.vue.Affichage;

public class Controle  {

    private final Etat ETAT;
    private final Affichage AFFICHAGE;

    public Controle(Etat etat, Affichage affichage) {
        ETAT = etat;
        AFFICHAGE = affichage;
    }

    public void afficherListePlante(){
        if(!ETAT.basculePresentationPlante) {
            AFFICHAGE.mainPlanteVB.getChildren().add(0,AFFICHAGE.presentationPlanteHB);
            ETAT.basculePresentationPlante = true;
        }

        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.mainTacheHB);
        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.mainGrapheHB);
        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.listeSuivi);

        AFFICHAGE.mainLayout.setCenter(AFFICHAGE.mainListePlanteVB);
    }

    public void afficherAgenda(){
        if(!ETAT.basculePresentationPlante) {
            AFFICHAGE.mainPlanteVB.getChildren().add(0,AFFICHAGE.presentationPlanteHB);
            ETAT.basculePresentationPlante = true;
        }

        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.mainTacheHB);
        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.mainGrapheHB);
        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.listeSuivi);

        AFFICHAGE.mainLayout.setCenter(null);
    }

    public void afficherPlanteTache(){
        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.mainTacheHB);
        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.mainGrapheHB);
        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.listeSuivi);
        AFFICHAGE.mainPlanteVB.getChildren().add(AFFICHAGE.mainTacheHB);
        AFFICHAGE.mainLayout.setCenter(AFFICHAGE.mainPlanteVB);
    }

    public void afficherPlanteGraphe(){
        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.mainTacheHB);
        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.mainGrapheHB);
        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.listeSuivi);

        AFFICHAGE.mainPlanteVB.getChildren().add(AFFICHAGE.mainGrapheHB);
        AFFICHAGE.mainLayout.setCenter(AFFICHAGE.mainPlanteVB);
    }

    public void afficherPlanteSuivi(){
        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.mainTacheHB);
        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.mainGrapheHB);
        AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.listeSuivi);
        
        AFFICHAGE.mainPlanteVB.getChildren().add(AFFICHAGE.listeSuivi);
        AFFICHAGE.mainLayout.setCenter(AFFICHAGE.mainPlanteVB);

        if(ETAT.planteEnCours == null){

        }
        else{

        }
    }

    public void basculerPresentationPlante(){
        if(ETAT.basculePresentationPlante) {
            AFFICHAGE.mainPlanteVB.getChildren().remove(AFFICHAGE.presentationPlanteHB);
            ETAT.basculePresentationPlante = false;
        }
        else {
            AFFICHAGE.mainPlanteVB.getChildren().add(0,AFFICHAGE.presentationPlanteHB);
            ETAT.basculePresentationPlante = true;
        }
    }
}
