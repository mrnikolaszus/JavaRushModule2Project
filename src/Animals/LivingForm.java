package Animals;

import java.util.concurrent.ThreadLocalRandom;

public abstract class LivingForm {
    String name;
    int posX;
    int posY;
    int step;
    double weight;


    protected LivingForm() {
    }


    public void moveLeft(){
        if(posX!=1) {
            posX = posX-1;}
    }
    public void moveRight(){
        if(posX!=40) {
            posX = posX+1;}
    }
    public void moveUp(){
        if(posY!=40) {
            posY = posY+1;}
    }
    public void moveDown(){
        if(posY!=1) {
            posY = posY-1;}
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

    public abstract void eat();

    public void reproduce(){
    }


}
