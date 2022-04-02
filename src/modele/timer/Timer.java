package modele.timer;

import modele.Modele;

import java.util.Random;

//Horloge du jeu
//Classe qui met à jour le jeu à intervalle régulier en fonction du tickrate
public class Timer extends Thread {

    //Declaration d'un modele
    public final Modele M;

    /**
     * Const : Variable aléatoire
     */
    public final Random RAND = new Random();

    /**
     * Const : Nombre de tick par seconde
     */
    public final int TICKRATE = 2;

    /**
     * Var : Nombre de tick passe
     */
    private int tick = 0;

    /**
     * Compteur pour un tick
     */
    private long compteur = 0; //

    //Constructeur de la classe
    public Timer(Modele m){
        M = m;
    }

    /**
     * thread qui met à jour le jeu quand la durée écoulée depuis le dernier tick est plus grande que la durée d'un tick
     */
    @Override
    public void run() {
        long t = System.currentTimeMillis();

        while(true)
        {
            try {
                compteur += System.currentTimeMillis() - t;
                t = System.currentTimeMillis();

                // on update autant de fois qu'il le faut si on a sauter des ticks
                while(compteur >= 1000/TICKRATE) {
                    tick+=1;
                    compteur -= 1000/TICKRATE;
                    System.out.println("update");
                    M.update();
                }
                Thread.sleep(RAND.nextInt(50));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Getter de la variable Tick
     * @return la valeur de valeur
     */
    public int getTick(){
        return tick;
    }
}
