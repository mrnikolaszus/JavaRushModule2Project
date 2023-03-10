package Animals;

import Cells.Cell;
import Options.GameField;

public class allAnimalsEat implements Runnable{


    @Override
    public void run() {
        while(true) {
       if(!Mouse.mouses.isEmpty()) {
            try {
                Thread.sleep(GameField.getCycle()/2);
           } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Mouse.mouses.forEach(Mouse::eat);
        }
   }
    }
}
