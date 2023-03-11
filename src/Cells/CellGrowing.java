package Cells;

import Animals.Sheep;
import Options.GameField;

import java.util.HashMap;

public class CellGrowing implements Runnable {

    @Override
    public void run() {

        while(true) {

            try {
                Thread.sleep(GameField.getCycle());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Cell.island.forEach(
                    (key, value)
                            -> {
                            value.growing();

                    });
            Cell.island.forEach(
                    (key, value)
                            -> {
                        System.out.println(value);

                    });
        }
    }
}
