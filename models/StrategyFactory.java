package models;
import java.util.*;

public class StrategyFactory {
    public IStrategy strategy;

    public StrategyFactory(Strategy strategyInput){
        switch (strategyInput){
            case LRU:
                this.strategy = new LRU();
                break;
            case FIFO:
                this.strategy = new FIFO();
                break;
            default:
                this.strategy = new LRU();
        }

    }

    public enum Strategy{
        LRU,
        FIFO
    }
}
