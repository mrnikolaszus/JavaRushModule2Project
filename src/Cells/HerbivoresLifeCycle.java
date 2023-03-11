package Cells;

import Animals.Sheep;
import Options.GameField;

public class HerbivoresLifeCycle implements Runnable {

    Sheep a  = new Sheep(1,1, 10, 3 );

    @Override
    public void run() {
        int cycles =0;
        while(true) {
            a.lifeCycle();

            try {
                Thread.sleep(GameField.getCycle() / 20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            cycles++;
            if (cycles >600) {
                System.out.println("прошло 600 циклов жизни овцы");
                System.out.println(a);
                cycles=0;
                a.setPosX(4);
            }
        }


    }

}

