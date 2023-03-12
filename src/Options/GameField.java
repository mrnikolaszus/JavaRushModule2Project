package Options;

public class GameField {


    /*
    1. Растения:
    каждая ячейка это природа, на ней растут растения (обобщенный вид), максимальный объем растений на ячейке 200.
    рост растений должен идти намного медленнее, чем рост и размножение других животных, что бы животные мигрировали по ячейкам,
    и не было перенаселения животными.
    планируем 20 условных шагов для роста растений.
    2. Насекомые
    Насекомых вывожу не как животных, а как часть ячейки и природы, чем больше на ячейке растений, тем больше становится на ней насекомых.
    Чем меньше растений, тем меньше насекомых.
    10 циклов до появления насекомых, если растений много ( больше 150)
    15 циклов до появления насекомых, если растений среднее кол-во (от 100 до 150)
    20 циклов до появления насекомых, если растений малое кол-во (от 50 до 100)
    насекомые не появляются, если объем растений на ячейке меньше 50.
    Максимальное количество насекомых на ячейке 1000.

    3. Животные
    животное рождается с весом 1/10 от максимального
    каждые 3 условных шага понижает вес на 1/10.
    если вес животного становится 0/10, то животное умирает.
    если вес животного менее 7/10, то животное пытается кушать.
    каждый 1 условный шаг, животное пытается скушать максимальное количество еды на ячейке, но не может повысить вес более чем на 4/10 (менее может).
    если вес животного более 7/10, то животное пытается не кушать, а плодить потомство.


    */

    static private int cycle = 50;
    static private int sizeX = 30;
    static private int sizeY = 30;

    static public int getSizeX() {
        return sizeX;
    }

    static public int getSizeY() {
        return sizeY;
    }
    public static int getCycle() {
        return cycle;
    }
}
