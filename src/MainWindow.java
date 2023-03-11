
import Animals.Sheep;
import Cells.Cell;
import Cells.CellGrowing;
import Cells.HerbivoresLifeCycle;

import javax.swing.plaf.TableHeaderUI;


public class MainWindow{


    public static void main(String[] args) throws InterruptedException {


        new Thread(new CellGrowing()).start();

        Thread.sleep(1000);
//        Cell.island.get(1+ " "+1).herbivores.add(new Sheep(1,1, 1, 3));
//        Cell.island.get(1+ " "+1).herbivores.add(new Sheep(1,1, 1, 3));



         new Thread(new HerbivoresLifeCycle()).start();






    }
}


