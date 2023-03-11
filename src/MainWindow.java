
import Cells.Cell;
import Cells.CellGrowing;
import Cells.HerbivoresLifeCycle;


public class MainWindow{


    public static void main(String[] args) throws InterruptedException {


        new Thread(new CellGrowing()).start();
        new Thread(new HerbivoresLifeCycle()).start();






    }
}


