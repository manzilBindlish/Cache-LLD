import models.*;

public class Main {
    public static void main(String[] args) {
        StrategyFactory strategyObject = new StrategyFactory(StrategyFactory.Strategy.LRU);
        Redis cache = new Redis(3, strategyObject.strategy);
        cache.addData(1, 1);
        cache.addData(2, 2);
        cache.addData(3, 3);

        cache.addData(4, 4); // should remove 1

        try {
            cache.getData(1);
        } catch (Exception e) {
            System.out.println("Element not found");
        }

        cache.getData(2); // should update linkedList

        cache.addData(5, 5);// should remove 3.
        cache.updataData(5, 6);
        cache.addData(7, 7); // should remove 4

        // empty linked list
        cache.deleteData(7);
        cache.deleteData(5);
        cache.deleteData(2);

        try {
            cache.getData(7);
        } catch (Exception e) {
            System.out.println("Element not found");
        }
        cache.addData(8, 8);
        cache.addData(9, 9);

    }

}
