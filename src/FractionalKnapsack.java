import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        final Item item1 = new Item(4, 20);
        final Item item2 = new Item(3, 18);
        final Item item3 = new Item(2, 14);

        final Item[] items = {item1, item2, item3}; // набор всех предметов

        // делаем сортировку массива
        // по удельному вес
        // от большого к меньшему
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());

        // выводим отсортированный массив
        System.out.println(Arrays.toString(items));

        // вместимость рюдзака
        final int W = 7;

        int weightSoFar = 0;   // какой вес мы набрали 
        double valueSoFar = 0; // сколько мы ценностей набрали
        int currentItem= 0;    // индекс текущего элемента

        while (currentItem < items.length && //пока индекс не вышел за границы
                weightSoFar != W){ // покан е заполнили рюдзак
            if (weightSoFar + items[currentItem].getWeight() < W) {
                // берем объект целиком
                valueSoFar+=items[currentItem].getValue();
                weightSoFar+=items[currentItem].getWeight();
            } else {
                // берем только часть объекта
                valueSoFar +=  ((W-weightSoFar)/(double) items[currentItem].getWeight())*items[currentItem].getValue();
                weightSoFar = W; // полный рюкзак
            }
            currentItem++;
        }

        System.out.println("ценность наилучшего набора: "+ valueSoFar);
    }

}

class Item {
    private int weight;
    private int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public double valuePerUnitOfWeight() {
        return 1.0 * value / weight;
    }

    @Override
    public String toString() {
        return "{weight=" + weight + ", value=" + value + '}';
    }
}
