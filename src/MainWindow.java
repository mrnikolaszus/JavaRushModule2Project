
import Animals.Sheep;
import Cells.Cell;
import Cells.CellGrowing;
import Cells.HerbivoresLifeCycle;
import Cells.IslandInfo;

import javax.swing.plaf.TableHeaderUI;


public class MainWindow{


    public static void main(String[] args) throws InterruptedException {

        new Thread(new CellGrowing()).start();
        Thread.sleep(1000);

         new Thread(new HerbivoresLifeCycle()).start();
         new Thread(new IslandInfo()).start();
    }
}


