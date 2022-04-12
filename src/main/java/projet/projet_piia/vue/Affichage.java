package projet.projet_piia.vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import projet.projet_piia.controle.Controle;
import projet.projet_piia.modele.Etat;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class Affichage extends Application {

    public Etat etat;
    public Controle controle;

    public BorderPane mainLayout;

    public MenuBar menuBar;
    public Menu fichier;

    public VBox leftVB;
    public VBox boutonVB;
    public Button listePlanteBt;
    public Button agendaBt;
    public DatePicker jourAgendaDp;

    public VBox mainListePlanteVB;
    public HBox barListePlanteHB;
    public TextField rechercheText;
    public Button ajouterPlanteBt;
    public GridPane listePlanteGrid;
    public VBox mainPlanteVB;
    public HBox presentationPlanteHB;
    public VBox infoPlanteVB;
    public TextArea descriptionPlante;
    public HBox nomSuppHB;
    public Button suppPlanteBt;
    public TextField nomPlante;
    public ImageView imagePlante;
    public HBox ongletPlanteHB;
    public Button suiviBt;
    public Button eventBt;
    public Button grapheBt;
    public Button agrandirBt;
    public Label erreurNom;

    // liste Suivi
    public TableView listeSuivi;

    // Tache

    public HBox mainTacheHB;
    public GridPane tachePonctuelleGrid;
    public Label tachePonctuelleLabel;
    public Label dateTacheLabel;
    public DatePicker dateTacheDp;
    public Label nomTacheLabel;
    public TextField nomTacheTf;
    public Label couleurTacheLabel;
    public ColorPicker couleurTacheCp;
    public Button validerTache;
    public TableView listeTacheRec;

    // graphe
    public HBox mainGrapheHB;
    public VBox grapheVB;
    public ListView listeMesure;
    public LineChart grapheMesure;
    public HBox dateGrapheHB;
    public DatePicker dateFinalDp;
    public DatePicker dateInitial;

    public Affichage() {
    }



    @Override
    public void start(Stage stage) throws IOException {

        etat = new Etat();
        controle = new Controle(etat,this);

        mainLayout  = new BorderPane();

        //Agenda Layout

        // creer la menu bar
        menuBar = new MenuBar();
        fichier = new Menu("fichier");

        leftVB = new VBox();
        listePlanteBt = new Button("Liste de plantes");
        agendaBt = new Button("Agenda");
        boutonVB = new VBox();
        jourAgendaDp = new DatePicker();

        boutonVB.getChildren().addAll(listePlanteBt,agendaBt);
        leftVB.getChildren().addAll(boutonVB,jourAgendaDp);

        jourAgendaDp.setValue(LocalDate.now());

        menuBar.getMenus().addAll(fichier);
        mainLayout.setTop(menuBar);
        mainLayout.setLeft(leftVB);

        // Liste plante Layout

        mainListePlanteVB = new VBox();
        barListePlanteHB = new HBox();
        rechercheText = new TextField();
        ajouterPlanteBt = new Button("ajouter une plante");

        listePlanteGrid = new GridPane();

        barListePlanteHB.getChildren().addAll(ajouterPlanteBt,rechercheText);
        mainListePlanteVB.getChildren().addAll(barListePlanteHB,listePlanteGrid);

        // Plante

        mainPlanteVB = new VBox();
        presentationPlanteHB = new HBox();
        infoPlanteVB = new VBox();
        descriptionPlante = new TextArea();
        nomPlante = new TextField();
        nomSuppHB = new HBox();
        suppPlanteBt = new Button("Supprimer");

        ongletPlanteHB = new HBox();
        suiviBt = new Button("Suivi");
        eventBt = new Button("Tâche");
        grapheBt = new Button("Graphique");
        agrandirBt = new Button("+");

        listeSuivi = new TableView();
        erreurNom = new Label();

        imagePlante = new ImageView("file:images.png");

        mainPlanteVB.getChildren().addAll(presentationPlanteHB,ongletPlanteHB);
        presentationPlanteHB.getChildren().addAll(imagePlante,infoPlanteVB);
        infoPlanteVB.getChildren().addAll(nomSuppHB,erreurNom,descriptionPlante);
        nomSuppHB.getChildren().addAll(nomPlante,suppPlanteBt);

        ongletPlanteHB.getChildren().addAll(suiviBt,eventBt,grapheBt,agrandirBt);

        // Plante Graphe
        mainGrapheHB = new HBox();
        grapheVB = new VBox();
        listeMesure = new ListView();
        //grapheMesure = new  LineChart(new Axis<Date>(),Double);
        dateGrapheHB = new HBox();
        dateFinalDp = new DatePicker();
        dateInitial = new DatePicker();

        mainGrapheHB.getChildren().addAll(listeMesure,grapheVB);
        grapheVB.getChildren().addAll(dateGrapheHB);
        dateGrapheHB.getChildren().addAll(dateFinalDp,dateInitial);

        // Tache

        mainTacheHB = new HBox();

        // tache ponctuelle
        tachePonctuelleGrid = new GridPane();
        tachePonctuelleLabel = new Label("Tache Ponctuelle");
        dateTacheLabel = new Label("date :");
        dateTacheDp = new DatePicker();
        nomTacheLabel = new Label("nom :");
        nomTacheTf = new TextField();
        couleurTacheLabel = new Label("couleur");
        couleurTacheCp = new ColorPicker();
        validerTache = new Button("ajouter la tache");

        tachePonctuelleGrid.add(tachePonctuelleLabel,0,0,2,1 );
        tachePonctuelleGrid.add(dateTacheLabel, 0,1);
        tachePonctuelleGrid.add(dateTacheDp, 1,1);
        tachePonctuelleGrid.add(nomTacheLabel, 0,2);
        tachePonctuelleGrid.add(nomTacheTf, 1,2);
        tachePonctuelleGrid.add(couleurTacheLabel, 0,3);
        tachePonctuelleGrid.add(couleurTacheCp, 1,3);
        tachePonctuelleGrid.add(validerTache, 0,4,2,1);

        // tache recurrente
        listeTacheRec = new TableView();

        mainTacheHB.getChildren().addAll(tachePonctuelleGrid,listeTacheRec);

        // Controleur

        listePlanteBt.setOnMouseClicked(e->controle.afficherListePlante());
        agendaBt.setOnMouseClicked(e->controle.afficherAgenda());

        ajouterPlanteBt.setOnMouseClicked(e->controle.afficherPlanteSuivi());

        suiviBt.setOnMouseClicked(e->controle.afficherPlanteSuivi());
        eventBt.setOnMouseClicked(e->controle.afficherPlanteTache());
        grapheBt.setOnMouseClicked(e->controle.afficherPlanteGraphe());
        agrandirBt.setOnMouseClicked(e->controle.basculerPresentationPlante());

        Scene scene = new Scene(mainLayout,800,600);

        stage.setTitle("Herbie");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}