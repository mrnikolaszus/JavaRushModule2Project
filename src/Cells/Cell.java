package Cells;

import Animals.Mouse;
import Options.GameField;

import java.util.ArrayList;
import java.util.HashMap;


public class Cell {
    volatile public static HashMap<String, Cell> island = Cell.allCells(GameField.getSizeX(), GameField.getSizeY());
        // String = posX +" "+ posY

    volatile int insectsCount;
    int MAX_insectsCount =1000;
    String name;
    int posX;

    int posY;
    volatile double plants = 0;
    static double MAX_plants = 200;

    @Override
    public String toString() {
        return "Cells.Cell{" +
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

    public static HashMap<String,Cell> allCells(int x, int y) {   // метод для создания всех ячеек
        HashMap<String,Cell> result = new HashMap<>();
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                result.put(i+" "+j, new Cell(i, j));
            }

        } return result;
    }


    public void growing()  {
        if(this.plants>50 && this.plants<100 && this.insectsCount<MAX_insectsCount){
            insectsCount +=1;
        } else if(this.plants>100 && this.plants<150 && this.insectsCount<MAX_insectsCount){
            insectsCount +=3;
        }  else  if(this.plants>150 && this.insectsCount<MAX_insectsCount){
            insectsCount +=6;
        }

        if(this.plants<MAX_plants){
        this.plants += 1;
            }

        if(this.plants==MAX_plants && this.insectsCount==MAX_insectsCount && Mouse.mouses.size()<100){        // автосоздание мышки из ниоткуда
            Mouse.mouses.add(new Mouse(this.posX, this.posY, 1, 0.005));

        }

    }




    public double getPlants() {
        return plants;
    }
    public void eatPlants(double a) {
        this.plants = plants - a;
    }

    public int getInsectsCount() {
        return insectsCount;
    }
    public void eatInsects(int a) {
        this.insectsCount = insectsCount - a;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


}