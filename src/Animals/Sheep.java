package Animals;

import Cells.Cell;

import java.util.Map;

/*
Sheep:
максимальный вес 70
за один цикл может съесть 15кг растений, и набрать 10кг массы.


 */
public class Sheep extends Herbivores {

    private static double MAX_weight = 70;
    public Sheep(int posX, int posY, double weight, int speed) {
        super(posX, posY, weight, speed);
        this.cell = Cell.island.get(this.posX + " " + this.posY);

    }

    @Override
    public boolean checkPredator() {
        return super.checkPredator();
    }

    @Override
    public boolean checkPlants() {
        return super.checkPlants();
    }

    @Override
    public void eat() {
        if(this.weight>0 && this.weight < MAX_weight && checkPlants() ){
            if(cell.getPlants()> 15){
                cell.eatPlants(15); //15
                this.weight += 10;  // 15
                if(this.weight> MAX_weight) {this.weight = MAX_weight;}
            }
        }
    }

    @Override
    public void lifeCycle() {
        super.lifeCycle();
    }


    @Override
    public String toString() {
        return "Sheep{" +
                ", posX=" + posX +
                ", posY=" + posY +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
