package Cells;


import Animals.Herbivores;
import Animals.Mouse;
import Animals.Sheep;
import Options.GameField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Cell {
    volatile public static ConcurrentHashMap<String, Cell> island = Cell.allCells(GameField.getSizeX(), GameField.getSizeY());
    // String = posX +" "+ posY

    public CopyOnWriteArrayList<Object> predators;
    public CopyOnWriteArrayList<Herbivores> herbivores;
    int insectsCount;
    int MAX_insectsCount =1000;
    String name;
    int posX;
    int posY;
     double plants;
    static double MAX_plants = 300;


    public Cell(int posX, int posY) {

        this.predators = new CopyOnWriteArrayList<>();
        this.herbivores = new CopyOnWriteArrayList<>();
        this.name = + posX +" "+  posY;
        this.posX = posX;
        this.posY = posY;
        this.plants = 270;  // лучше с нуля начинать
        this.insectsCount = 970; // лучше с нуля начинать
    }

    public static ConcurrentHashMap<String,Cell> allCells(int x, int y) {   // метод для создания всех ячеек
        ConcurrentHashMap<String,Cell> result = new ConcurrentHashMap<>();
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                result.put(i+" "+j, new Cell(i, j));
            }
        } return result;
    }


    public void growing()  {
        if(this.plants>50 && this.plants<100 && this.insectsCount<MAX_insectsCount){
            this.insectsCount +=1;
        } else if(this.plants>100 && this.plants<150 && this.insectsCount<MAX_insectsCount){
            this.insectsCount +=3;
        }  else  if(this.plants>150 && this.insectsCount<MAX_insectsCount){
            this.insectsCount +=6;
        } else if (this.plants<50 && this.insectsCount > 1){
            this.insectsCount -=1;
        }

        if(this.plants<MAX_plants){
        this.plants += 1;
            }
        if(this.plants>(MAX_plants*0.9) && this.insectsCount>(MAX_insectsCount*0.9)){
            int random = ThreadLocalRandom.current().nextInt(1, 1001);
            if (random > 999) {
                this.newLife();
            }
        }

    }

    public void newLife(){
        System.out.println("благодаря изобилию и удаче новая жизнь появилась на острове:");
        this.herbivores.add(new Mouse(this.posX,this.posY, 0.02, 1));
       System.out.println(this.herbivores.get(this.herbivores.size()-1));


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


    @Override
    public String toString() {
        return "Cell{" +
                ", name='" + name + '\'' +
                "predators=" + predators.size() +
                ", herbivores=" + herbivores.size() +
                ", insectsCount=" + insectsCount +

                ", posX=" + posX +
                ", posY=" + posY +
                ", plants=" + plants +
                '}';
    }
}