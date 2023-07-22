package models;
import java.util.*;
import models.*;

public class Redis {
    int capacity;
    HashMap<Integer, Integer> data; // extend to use any key value type
    IStratergy evictionStratergy;


    Redis(){
        this.capacity = 0;
        this.data = new HashMap<>();
        evictionStratergy = new LRU();
    }

    Redis(int capacity){
        this.capacity = capacity;
        this.data = new HashMap<>();
        evictionStratergy = new LRU();
    }

    public Integer getData(int key){
        if(data.containsKey(key)){
            return data.get(key);
        }
        else{
            throw new RuntimeException("Data not present in cache");
        }

    }

    public void addData(int key, int value){
        if(data.size() == this.capacity) {
            evictionStratergy.removeElement();
        }
        data.put(key,value);
        evictionStratergy.addElement(key);
    }

    public void deleteElement(int key){
        if(data.containsKey(key)){
            data.remove(key);
            evictionStratergy.removeElement(key);
        }else {
            throw new RuntimeException("Data not present to delete");
        }
    }

    public void updataData(int key, int value){
        if(data.containsKey(key)){
            data.put(key,value);

        }else {
            throw new RuntimeException("Data not present");
        }
    }


}
