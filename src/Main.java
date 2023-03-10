import java.util.HashMap;
import java.util.HashSet;

public class Main{
    public static void main(String[] args) {
      HashMap<String, Cell> island = Cell.allCells(GameField.getSizeX(), GameField.getSizeY());

        System.out.println(island);
        System.out.println(island.size());

        System.out.println(island.get(5+" "+6));

    }
}

