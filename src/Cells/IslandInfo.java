package Cells;

import Animals.Herbivores;
import Animals.Sheep;
import Cells.Cell;
import Cells.CellGrowing;
import Cells.HerbivoresLifeCycle;
import Options.GameField;

import java.util.ArrayList;

public class IslandInfo implements Runnable {
    double plants;
    int insects;
    int sheeps;
    int mouses;

    @Override
    public void run() {

        while(true) {
            ArrayList<String> herblist = new ArrayList<>();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 1; i < GameField.getSizeX()+1; i++) {
            for (int j = 1; j < GameField.getSizeY()+1; j++) {

               insects += Cell.island.get(i+" "+j).insectsCount;
               plants += Cell.island.get(i+" "+j).plants;
                Cell.island.get(i+" "+j).herbivores.forEach(herbivores -> herblist.add(herbivores.getClass().toString()));

            }
        }
            for (String s : herblist) {

                if (s.toUpperCase().contains("sheep".toUpperCase())) {

                    sheeps++;
                }
                if (s.toUpperCase().contains("mouse".toUpperCase())) {

                    mouses++;
                }
            }


            System.out.println("______________________________________");
        System.out.println("сейчас на острове растений: " + plants);
        System.out.println("сейчас на острове насекомых: " + insects);
        System.out.println("сейчас на острове овечек: " + sheeps);
        System.out.println("сейчас на острове мышей: " + mouses);
        herblist.clear();
        sheeps=0;
        plants=0;
        insects=0;
        mouses=0;
    }}
}
