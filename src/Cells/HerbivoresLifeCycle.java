package Cells;

import Animals.Herbivores;
import Animals.Sheep;
import Options.GameField;

public class HerbivoresLifeCycle implements Runnable {



    @Override
    public void run() {


        while(true) {
            for (int i = 1; i < GameField.getSizeX()+1; i++) {
                for (int j = 1; j < GameField.getSizeY()+1; j++) {
                    Cell.island.get(i+" "+j).herbivores.forEach(Herbivores::lifeCycle);
                    }
                }
            try {
                Thread.sleep(GameField.getCycle() / 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            }
        }
    }



