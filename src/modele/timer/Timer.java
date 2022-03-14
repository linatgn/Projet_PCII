package modele.timer;

import modele.Modele;

import java.util.Random;

public class Timer extends Thread {
    public final Modele M;

    public final Random RAND = new Random();

    public final int TICKRATE = 2; // nombre de tick par seconde
    private int tick = 0; // nombre de tick passe

    private long compteur = 0; // compteur pour un tick

    public Timer(Modele m){
        M = m;
    }

    @Override
    public void run() {
        long t = System.currentTimeMillis();

        while(true)
        {
            try {
                compteur += System.currentTimeMillis() - t;
                t = System.currentTimeMillis();
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
