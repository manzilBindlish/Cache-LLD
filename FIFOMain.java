import models.*;

public class FIFOMain {
    public static void main(String[] args) {
        StrategyFactory strategyObject = new StrategyFactory(StrategyFactory.Strategy.FIFO);
        Redis cache = new Redis (3,strategyObject.strategy);

        cache.addData(1, 1);
        cache.addData(2, 2);
        cache.addData(3, 3);

        cache.addData(4, 4); // should remove 1
        
        try{
            cache.getData(1);
        } 
        catch(Exception e){
            System.out.println("Element not found");
        }

        cache.getData(2);
        cache.addData(5, 5);// should remove 2.

        cache.deleteData(5);
        cache.deleteData(4);
        cache.deleteData(3);

        try{
            cache.getData(5);
        } 
        catch(Exception e){
            System.out.println("Element not found");
        }

        
        
    }
}

