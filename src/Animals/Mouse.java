package Animals;

import Cells.Cell;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/*
Sheep:
максимальный вес 70
за один цикл может съесть 15кг растений, и набрать 10кг массы.


 */
public class Mouse extends Herbivores {

    private static double MAX_weight = 0.05;
    public Mouse(int posX, int posY, double weight, int speed) {
        super(posX, posY, weight, speed);
        this.hunger = 0.004;
        this.cell = Cell.island.get(this.posX + " " + this.posY);
//        System.out.println("конструктор мышки + this.hunger: " + this.hunger );

    }

    @Override
    public boolean checkPredator() {
        return super.checkPredator();
    }

    @Override
    public boolean checkInsects(){
        return this.cell.getInsectsCount()>5;
    }


    @Override
    public boolean checkPlants(){
        return this.cell.getPlants()>3;
    }

    @Override
    public void reproduce() {
        int mouses = 0;


        ArrayList<String> herblist = new ArrayList<>();

        this.cell.herbivores.forEach(herbivores -> herblist.add(herbivores.getClass().toString()));
        for (String s : herblist) {
            if (s.toUpperCase().contains("mouse".toUpperCase())) {
                mouses++;
            }
        }


            if (mouses > 2 && mouses<100 ) {
//                System.out.println("на этой ячейки всего животных такого типа: " + thisAnimalCount);
                int random = ThreadLocalRandom.current().nextInt(1, 1000);
                if (random > 950) {
                   System.out.println("рождение мышки, всего мышек на этой ячейке: " + mouses);
                    this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
//                    System.out.println(this.cell.herbivores.get(this.cell.herbivores.size() - 1));
                }
            }
        if (mouses > 100 && mouses<200 ) {
//                System.out.println("на этой ячейки всего животных такого типа: " + thisAnimalCount);
            int random = ThreadLocalRandom.current().nextInt(1, 1000);
            if (random > 850) {
                System.out.println("рождение двух мышек, всего мышек на этой ячейке: " + mouses);
                this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
                this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
//                    System.out.println(this.cell.herbivores.get(this.cell.herbivores.size() - 1));
            }
        }
        if (mouses > 200 && mouses<400 ) {
//                System.out.println("на этой ячейки всего животных такого типа: " + thisAnimalCount);
            int random = ThreadLocalRandom.current().nextInt(1, 1000);
            if (random > 750) {
                System.out.println("рождение четырех мышек, всего мышек на этой ячейке: " + mouses);
                this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
                this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
                this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
                this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
//                    System.out.println(this.cell.herbivores.get(this.cell.herbivores.size() - 1));
            }
        }
        if (mouses > 400 && mouses<500 ) {
//                System.out.println("на этой ячейки всего животных такого типа: " + thisAnimalCount);
            int random = ThreadLocalRandom.current().nextInt(1, 1000);
            if (random > 650) {
                System.out.println("рождение восьми мышек, всего мышек на этой ячейке: " + mouses);
                this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
                this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
                this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
                this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
                this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
                this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
                this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
                this.cell.herbivores.add(new Mouse(this.posX, this.posY, 0.02, 1));
//                    System.out.println(this.cell.herbivores.get(this.cell.herbivores.size() - 1));
            }
        }

        }


    @Override
    public void eat() {
        boolean insects = false;
        if(this.weight>0 && this.weight < MAX_weight && checkInsects() ){
//            System.out.println("кушаем гусениц");
            insects = true;
            if(cell.getInsectsCount()> 5){
                cell.eatInsects(5);
                this.weight += 0.01;  // 0.01
                if(this.weight> MAX_weight) {this.weight = MAX_weight;}
            }
        }

        if(this.weight>0 && this.weight < MAX_weight && checkPlants() && !insects ){
//            System.out.println("кушаем травку");
            if(cell.getPlants()> 3){
                cell.eatPlants(3);
                this.weight += 0.01;  // 0.01
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
        return "Mouse{" +
                ", posX=" + posX +
                ", posY=" + posY +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
