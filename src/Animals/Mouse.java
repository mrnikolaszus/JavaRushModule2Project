package Animals;

import Cells.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Mouse extends LivingForm{

    volatile public static ArrayList<LivingForm> mouses = new ArrayList<>();


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
        double full = max_weight * 0.4;
        double temp =0;
        if (this.weight < (max_weight * 0.8)) {               // если мышка сыта, то кушать не будет
            while (this.weight < (max_weight * 0.8) || temp <= full || ((Cell.island.get(posX + " " + posY).getInsectsCount()) > 30 || (Cell.island.get(posX + " " + posY).getPlants() > 10))) {
                if ((Cell.island.get(posX + " " + posY).getInsectsCount()) > 30) {
                    Cell.island.get(posX + " " + posY).eatInsects(1);
                    temp +=0.01;
                } else if ((Cell.island.get(posX + " " + posY).getPlants()) > 10) {
                    Cell.island.get(posX + " " + posY).eatPlants(1);
                    temp +=0.01;
                }
                if (temp >= full){ this.weight +=temp;
                break;}
            }
            this.weight +=temp;
        }
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
