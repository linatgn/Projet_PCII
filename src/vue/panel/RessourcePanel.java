package vue.panel;

import javax.swing.*;
import java.awt.*;
import modele.Modele;
import vue.Vue;

public class RessourcePanel extends JPanel{

    /**
     * Const : Largeur de l'affichage
     */
    public static final int LARGEUR = 1280-256;

    /**
     * Const : Hauteur de l'affichage
     */
    public static final int HAUTEUR = 32;

    private Modele M;
    private Vue V;

    private JLabel boisLabel;
    private JLabel pierreLabel;
    private JLabel nourritureLabel;
    private JLabel populationLabel;

    // constructeur
    public RessourcePanel(Modele m, Vue v){
        M = m;
        V = v;

        // Panel
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
        setLayout(new FlowLayout(FlowLayout.LEFT));
        //background
        setBackground(Color.YELLOW);

        // création des images des ressources

        ImageIcon boisIcon = new ImageIcon("bois.png");
        ImageIcon pierreIcon = new ImageIcon("pierre.png");
        ImageIcon nourritureIcon = new ImageIcon("nourriture.png");
        ImageIcon populationIcon = new ImageIcon("population.png");


        boisLabel = new JLabel("bois ", boisIcon,SwingConstants.LEFT);
        add(boisLabel);

        pierreLabel = new JLabel("pierre", pierreIcon,SwingConstants.LEFT);
        add(pierreLabel);

        nourritureLabel = new JLabel("nourriture", nourritureIcon,SwingConstants.LEFT);
        add(nourritureLabel);

        populationLabel = new JLabel("population", populationIcon,SwingConstants.LEFT);
        add(populationLabel);
    }

    /**
     * Permet l'affichage sur le panel du haut les ressources du joueur
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        boisLabel.setText(String.valueOf((int)M.bois));
        pierreLabel.setText(String.valueOf((int)M.pierre));
        nourritureLabel.setText(String.valueOf((int)M.nourriture));
        populationLabel.setText(String.valueOf(M.population)+"/"+String.valueOf(M.maxPopulation));
    }
}