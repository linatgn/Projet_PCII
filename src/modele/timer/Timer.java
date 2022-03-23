package modele.timer;

import modele.Modele;

import java.util.Random;

/**
 * Horloge du jeu
 *
 * met à jour le jeu à intervalle régulier en fonction du tickrate
 *
 */
public class Timer extends Thread {
    public final Modele M;

    public final Random RAND = new Random();

    public final int TICKRATE = 2; // nombre de tick par seconde
    private int tick = 0; // nombre de tick passe

    private long compteur = 0; // compteur pour un tick

    /**
     * Constructeur
     */
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

                    M.update();
                }
                Thread.sleep(RAND.nextInt(50));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getTick(){
        return tick;
    }
}
