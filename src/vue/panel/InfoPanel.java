package vue.panel;
import controle.ControleAmelioration;
import modele.Modele;
import modele.TypeRessource;
import modele.amelioration.Amelioration;
import modele.tuille.Tuille;
import modele.unite.entite.Entite;
import modele.unite.structure.batiment.Batiment;
import modele.unite.structure.batiment.Hdv;
import vue.Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class InfoPanel extends JPanel{

    private final Modele M;
    private final Vue V;

    /**
     * Const : Largeur de l'affichage
     */
    public static final int LARGEUR = 256;

    /**
     * Const : Hauteur de l'affichage
     */
    public static final int HAUTEUR = 1280;

    private JLabel titreLabel;
    public String titre;

    private JLabel imageLabel;
    private ImageIcon ImageIcon;
    private int paddingImage = 30;

    public JPanel statPanel;
    private JLabel pvLabel;
    private JLabel attaqueLabel;
    private JLabel defenseLabel;
    private ImageIcon statIcon[];

    public JLabel ressourceLabel;
    private ImageIcon ressourceIcon[];

    public JPanel ameliorationsPanel;


    public InfoPanel(Modele m, Vue v){
        M = m;
        V = v;

        // Panel
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        // background
        setBackground(Color.WHITE);

        // Title
        titreLabel = new JLabel();
        titreLabel.setAlignmentX(CENTER_ALIGNMENT);
        titreLabel.setPreferredSize(new Dimension(LARGEUR,30));
        add(titreLabel);

        // ImagePanel
        imageLabel = new JLabel();
        imageLabel.setAlignmentX(CENTER_ALIGNMENT);
        ImageIcon = new ImageIcon();
        add(imageLabel);

        // StatistiquePanel
        statPanel = new JPanel();
        statPanel.setLayout(new FlowLayout());
        statPanel.setMaximumSize(new Dimension(LARGEUR,60));

        statIcon = new ImageIcon[]{
                new ImageIcon("vie.png"),
                new ImageIcon("attaque.png"),
                new ImageIcon("defense.png"),
        };

        pvLabel = new JLabel(statIcon[0]);
        attaqueLabel = new JLabel(statIcon[1]);
        defenseLabel = new JLabel(statIcon[2]);

        statPanel.add(pvLabel);
        statPanel.add(attaqueLabel);
        statPanel.add(defenseLabel);

        add(statPanel);

        // Ressource
        ressourceLabel = new JLabel();
        ressourceIcon = new ImageIcon[]{
                new ImageIcon("bois.png"),
                new ImageIcon("pierre.png"),
                new ImageIcon("nourriture.png"),
                new ImageIcon("population.png"),
        };

        add(ressourceLabel);

        // Amelioration

        ameliorationsPanel = new JPanel();
        ameliorationsPanel.setLayout(new BoxLayout(ameliorationsPanel,BoxLayout.Y_AXIS));
        add(ameliorationsPanel);

        add(Box.createVerticalGlue());

        // on cache tout au debut car il n'y a pas d'unite selectionnee

        titreLabel.setVisible(false);
        imageLabel.setVisible(false);
        statPanel.setVisible(false);
        ameliorationsPanel.setVisible(false);
        ressourceLabel.setVisible(false);

    }

    public void afficherUniteSelectionnee(){
        if(M.uniteSelectionnee != null) {

            // Nom
            titreLabel.setText(M.uniteSelectionnee.getNom());
            titreLabel.setVisible(true);
            repaint();

            // image
            BufferedImage subImg;

            // Recuperation de la position de la texture de l'unité
            Point textureCoord = new Point(M.uniteSelectionnee.x_texture, M.uniteSelectionnee.y_texture);
            textureCoord.x *= Tuille.TAILLE_TUILLE;
            textureCoord.y *= Tuille.TAILLE_TUILLE;

            // Initialisation de la sous image de la texture
            subImg = V.TILESET.getSubimage(
                    textureCoord.y ,
                    textureCoord.x,
                    Tuille.TAILLE_TUILLE * M.uniteSelectionnee.largeur,
                    Tuille.TAILLE_TUILLE * M.uniteSelectionnee.hauteur);

            Image sc = subImg.getScaledInstance(LARGEUR-paddingImage,LARGEUR-paddingImage,Image.SCALE_DEFAULT);
            ImageIcon.setImage(sc);
            imageLabel.setIcon(ImageIcon);
            imageLabel.setVisible(true);

            // Statistique

            if(M.uniteSelectionnee instanceof Entite) {

                pvLabel.setText(String.valueOf( ((Entite)M.uniteSelectionnee).pv));
                attaqueLabel.setText(String.valueOf( ((Entite)M.uniteSelectionnee).attaque));
                defenseLabel.setText(String.valueOf( ((Entite)M.uniteSelectionnee).defense));

                statPanel.setVisible(true);

            }
            else
            {
                statPanel.setVisible(false);
            }

            // Ressource
            if(M.uniteSelectionnee.typeRessource != null)
            {
                switch (M.uniteSelectionnee.typeRessource){
                    case BOIS -> ressourceLabel.setIcon(ressourceIcon[0]);
                    case PIERRE -> ressourceLabel.setIcon(ressourceIcon[1]);
                    case NOURRITURE -> ressourceLabel.setIcon(ressourceIcon[2]);
                }
                ressourceLabel.setText(String.valueOf(M.uniteSelectionnee.quantiteRessource));
                ressourceLabel.setVisible(true);
            }
            else{
                ressourceLabel.setVisible(false);
            }

            // Amelioration
            if(M.uniteSelectionnee instanceof Batiment) {

                ameliorationsPanel.removeAll();
                for(Amelioration amelioration :M.ameliorations){
                    if(amelioration.typeBatiment == ((Batiment) M.uniteSelectionnee).typeBatiment && amelioration.estDeblocable()){

                        JPanel ameliorationPanel = new JPanel();
                        if(!amelioration.timerLancer)
                            ameliorationPanel.setBackground(Color.GRAY);
                        else
                            ameliorationPanel.setBackground(Color.CYAN);

                        ameliorationPanel.setLayout(new BorderLayout());
                        ameliorationPanel.setSize(new Dimension(LARGEUR,60));
                        ameliorationPanel.setMaximumSize(new Dimension(LARGEUR,60));

                        //nom
                        JLabel nomAmelioration = new JLabel(amelioration.getNom());
                        nomAmelioration.setHorizontalAlignment(SwingConstants.CENTER);

                        // cout de l'amelioration
                        JPanel coutPanel = new JPanel();
                        coutPanel.setLayout(new FlowLayout());
                        coutPanel.add(new JLabel( String.valueOf(amelioration.coutBois), ressourceIcon[0], SwingConstants.LEFT));
                        coutPanel.add(new JLabel( String.valueOf(amelioration.coutPierre), ressourceIcon[1], SwingConstants.LEFT));
                        coutPanel.add(new JLabel( String.valueOf(amelioration.coutNourriture), ressourceIcon[2], SwingConstants.LEFT));
                        coutPanel.add(new JLabel( String.valueOf(amelioration.coutPopulation), ressourceIcon[3], SwingConstants.LEFT));

                        // barre de progression
                        JProgressBar timerAmelioration = new JProgressBar(0,amelioration.dureeAmelioration);
                        amelioration.progressBar = timerAmelioration;
                        timerAmelioration.setValue(amelioration.timerAmelioration);

                        ameliorationPanel.add(nomAmelioration, BorderLayout.NORTH);
                        ameliorationPanel.add(coutPanel, BorderLayout.CENTER);
                        ameliorationPanel.add(timerAmelioration, BorderLayout.SOUTH);

                        // MouseListener pour prendre l'amelioration
                        ControleAmelioration ca = new ControleAmelioration(ameliorationPanel,amelioration);
                        ameliorationPanel.addMouseListener(ca);

                        ameliorationsPanel.add(ameliorationPanel);

                    }
                }

                ameliorationsPanel.setVisible(true);
            }
            else
            {
                ameliorationsPanel.setVisible(false);
            }
        }
        else
        {
            titreLabel.setVisible(false);
            imageLabel.setVisible(false);
            statPanel.setVisible(false);
            ameliorationsPanel.setVisible(false);
            ressourceLabel.setVisible(false);
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }
}
