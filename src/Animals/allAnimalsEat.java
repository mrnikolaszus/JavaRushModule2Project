package Animals;

import Cells.Cell;
import Options.GameField;

import java.util.Collection;

public class allAnimalsEat implements Runnable{

    public static void iterateAnimals(Collection<? extends LivingForm> animals) {

        for(LivingForm animal: animals) {

           animal.eat();
        }
    }


    @Override
    public void run() {
        while(true) {
       if(!Mouse.mouses.isEmpty()) {
            try {
                Thread.sleep(GameField.getCycle()/2);
           } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
           iterateAnimals(Mouse.mouses);

           }
        }
   }
    }

