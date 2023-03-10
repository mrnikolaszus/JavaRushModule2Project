package Animals;

public abstract class LivingForm {
    int posX;
    int posY;
    int step;
    double weight;


    public LivingForm(int posX, int posY, int step, double weight) {
        this.posX = posX;
        this.posY = posY;
        this.step = step;
        this.weight = weight;
    }

    public void moveLeft(){
        posX = posX-1;
    }
    public void moveRight(){
        posX = posX+1;
    }
    public void moveUp(){
        posY = posY+1;
    }
    public void moveDown(){
        posY = posY-1;
    }

    public void eat(){
    }

    public void reproduce(){
    }


}
