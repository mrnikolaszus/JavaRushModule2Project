package Animals;

import Cells.Cell;

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
                cell.eatPlants(50); //15
                this.weight += 0;  // 15
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
                "cell=" + cell +
                ", posX=" + posX +
                ", posY=" + posY +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
