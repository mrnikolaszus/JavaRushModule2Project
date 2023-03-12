package Animals;

import Cells.Cell;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivores extends Animal{
    public Herbivores(int posX, int posY, double weight, int speed) {
        super(posX, posY, weight, speed);
    }

    public void checkStatus(){ // check XY of animal and XY of Cell;

//        System.out.println("проверяем позицию");
//        System.out.println("привязананая ячейка:" +  this.cell.getPosX() + " " +this.cell.getPosY());
//        System.out.println("позиция животного :" +  this.posX + " " +this.posY);
    if (this.cell.getPosX() != this.posX || this.cell.getPosY() != this.posY){
        this.cell = Cell.island.get(posX + " " + posY);
//        System.out.println("меняем позицию, итог:");
//        System.out.println("привязананая ячейка:" +  this.cell.getPosX() + " " +this.cell.getPosY());
//        System.out.println("позиция животного :" +  this.posX + " " +this.posY);
    }

    }
    public boolean checkPredator(){
        return this.cell.predators.isEmpty();
    }
    public abstract boolean checkPlants();
    public abstract boolean checkInsects();
    public void move(){
        int tempX = this.posX;
        int tempY = this.posY;
//        System.out.println("животное двигается");
//        System.out.println(" позиция животного :" +  this.posX + " " +this.posY);
//        System.out.println(" уходит с ячейки: " + this.cell);
        Cell.island.get(posX + " " +posY).herbivores.remove(this);
        for (int i = 0; i < this.speed; i++) {

//            System.out.println("текущая позиция животного: "+this.posX + " " + this.posY);
            int random = ThreadLocalRandom.current().nextInt(1, 5);
            if(random == 1){ stepDown();
                }
            if(random == 2){ stepUP();
                }
            if(random == 3){ stepRight();
                }
            if(random == 4){ stepLeft();
                }
        }
        Cell.island.get(posX + " " +posY).herbivores.add(this);
        this.cell = Cell.island.get(posX + " " + posY);
//        System.out.println(" пришла в позицию позиция животного :" +  this.posX + " " +this.posY);
//        System.out.println("ячейка : " + this.cell);
//        System.out.println("проверяем позицию прошлую : " + Cell.island.get(tempX + " " + tempY));

    }
    public void reproduce(){
//
    }
    public void eat(){

    }
    public void death(){
        Cell.island.get(this.posX + " "+this.posY).herbivores.remove(this);
        this.cell = null;
        this.posX = 0;
        this.posY =0;

         // test


    }

    public void lifeCycle(){
//        System.out.println("начался цикл живтного : "+ this);
        if(this.weight > 0) {
            this.weight -= this.hunger;
  //          System.out.println("с утра животное "  + this.getClass()+ " проголадалась на: " + this.hunger + " вес: " +this.weight);
            this.checkStatus();
//            System.out.println("Проверяем на этой ячейке нет ли хищников:");
//            System.out.println(this.checkPredator());
//            System.out.println("Проверяем на этой ячейке есть ли растения > 15:");
//            System.out.println(this.checkPlants());
            if (this.checkPredator() && this.checkPlants()) {
              if(this.weight >= (MAX_weight*0.8)){
                  this.reproduce();}
                this.eat();
            } else {
//                System.out.println("Не нашла еду, бегаем:");
                this.move();
            }

        }
       else {

            System.out.println(this + "животное умерло от голода");
           this.death();
        }
}
}
