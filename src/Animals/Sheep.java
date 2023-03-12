package Animals;

import Cells.Cell;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/*
Sheep:
максимальный вес 70
за один цикл может съесть 15кг растений, и набрать 10кг массы.


 */
public class Sheep extends Herbivores {

    private static double MAX_weight = 70;
    public Sheep(int posX, int posY, double weight, int speed) {
        super(posX, posY, weight, speed);
        this.hunger = 3;
        this.cell = Cell.island.get(this.posX + " " + this.posY);
        System.out.println("конструктор овечки + this.hunger: " + this.hunger );

    }

    public boolean checkPlants(){
        return this.cell.getPlants()>15;
    }
    public boolean checkInsects(){
        return this.cell.getInsectsCount()>30;
    }

    @Override
    public void eat() {
        if(this.weight>0 && this.weight < MAX_weight && checkPlants() ){
            if(cell.getPlants()> 15){
                cell.eatPlants(15); //15
                this.weight += 15;  // 15
                if(this.weight> MAX_weight) {this.weight = MAX_weight;}
            }
        }
    }
    @Override
    public void reproduce(){
//        System.out.println("начинаем плодится так как вес  такой: " + this.weight );
        int thisAnimalCount =0;
//        System.out.println(this + " проверяет ячейку" + this.cell + "нет ли тут таких же как животное.");
        for (int i = 0; i < this.cell.herbivores.size(); i++) {
            if(this.cell.herbivores.get(i).getClass()==this.getClass()){
                thisAnimalCount++;
            }

            if(thisAnimalCount>2){
//                System.out.println("на этой ячейки всего животных такого типа: " + thisAnimalCount);
                int random = ThreadLocalRandom.current().nextInt(1, 100);
                if(random>90){
//                    System.out.println("рождение животного");
                    this.cell.herbivores.add(new Sheep(this.posX,this.posY, 10, 3));
                    System.out.println(this.cell.herbivores.get(this.cell.herbivores.size()-1));
                }
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
