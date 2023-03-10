package Animals;

import Cells.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Mouse extends LivingForm{

    volatile public static ArrayList<Mouse> mouses = new ArrayList<>();


    private int posX;
    private int posY;
    private double weight ;
    static double max_weight = 0.05;

    public Mouse( int posX, int posY, int step, double weight) {
        this.posX = posX;
        this.posY = posY;
        this.step = step;
        this.weight = weight;

    }

    @Override
    public void eat() {
        int insects = (Cell.island.get(posX +" "+ posY).getInsectsCount());
        System.out.println(insects);
        if(insects>10){
            System.out.println("Первый РАЗДЕЛ");
            Cell.island.get(posX +" "+  posY).eatInsects(1);
            if(this.weight<max_weight) {this.weight += 0.01;}
            else {this.weight=max_weight;}
        }

        double plants = (Cell.island.get(posX +" "+ posY).getPlants());

        if(plants>30){
            System.out.println("ВТОРОЙ РАЗДЕЛ");
            System.out.println(Cell.island.get(posX +" "+ posY).getPlants());
            Cell.island.get(posX +" "+ posY).eatPlants(1);
            if(this.weight<max_weight) {this.weight += 0.01;}
            else {this.weight=max_weight;}
        }

        System.out.println("мышка покушала");
        System.out.println(Cell.island.get( posX +" "+ posY).getPlants());
        System.out.println(Cell.island.get( posX +" "+ posY).getInsectsCount());
    }

    public void move(){

        for (int i = 0; i < this.step; i++) {
            System.out.println("текущая позиция мышки: "+this.posX + " " + this.posY);
            int random = ThreadLocalRandom.current().nextInt(1, 5);
            if(random == 1){ moveDown();
                System.out.println("мышка ушла Вниз "+ this.posX + " " + this.posY);}
            if(random == 2){ moveUp();
                System.out.println("мышка ушла Вверх "+ this.posX + " " + this.posY);}
            if(random == 3){ moveRight();
                System.out.println("мышка ушла Вправо "+ this.posX + " " + this.posY);}
            if(random == 4){ moveLeft();
                System.out.println("мышка ушла Влево "+ this.posX + " " + this.posY);}
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


    @Override
    public String toString() {
        return "Mouse{" +
                ", posX=" + posX +
                ", posY=" + posY +
                ", weight=" + weight +
                '}';
    }
}
