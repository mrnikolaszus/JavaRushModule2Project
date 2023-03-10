import Animals.Mouse;
import Animals.allAnimalsEat;
import Cells.Cell;
import Cells.CellGrowing;


public class MainWindow{


    public static void main(String[] args) throws InterruptedException {


        new Thread(new CellGrowing()).start();
     new Thread(new allAnimalsEat()).start();




    }
}


