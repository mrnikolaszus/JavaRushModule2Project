import java.util.HashMap;
import java.util.HashSet;

public class Cell {
    String name;
    int posX;

    int posY;
    double plants;
    static double max_plants = 200;

    @Override
    public String toString() {
        return "Cell{" +
                "posX=" + posX +
                ", posY=" + posY +
                ", plants=" + plants +
                '}';
    }

    public Cell(int posX, int posY) {
        this.name = "x:"+ posX +" "+ "y:"+ posY;
        if(GameField.getSizeX()<posX){
            this.posX = 1;
        } else { this.posX = posX;}
        if(GameField.getSizeY()<posY){
            this.posY = 1;
        } else { this.posY = posY;}

        this.plants = 0;
        System.out.println("Растения появились в позиции " + this.posX +" " + this.posY);
        System.out.println("Объем растений в " +this.name +" = "+ this.plants);
    }

    public static HashMap<String,Cell> allCells(int x, int y) {
        HashMap<String,Cell> result = new HashMap<>();
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                result.put(i+" "+j, new Cell(i, j));
            }

        } return result;
    }


    public void plantsGrowing(){
        if(this.plants<max_plants){
        this.plants += 1;
            System.out.println("Объем растений увеличился в позиции: " + this.posX +" " + this.posY + " на данный момент объем: "+ this.plants);}
        System.out.println("на данный момент объем растений: "+ this.plants);
    }
    public double getPlants() {
        return plants;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

}