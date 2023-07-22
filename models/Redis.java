package models;

import java.util.*;

public class Redis<Key, Value> {
    int capacity;
    HashMap<Key, Value> storage; // Can be extended to have different types of storage as well by making storage
                              // a different class.
    IStrategy<Key> evictionStratergy;

    public Redis(int capacity, IStrategy<Key> evictionStratergy) {
        this.capacity = capacity;
        this.storage = new HashMap<Key, Value>(capacity);
        this.evictionStratergy = evictionStratergy;
    }

    public void addData(Key key, Value value) {
        if (this.storage.size() == this.capacity) {
            Key removedKey = this.evictionStratergy.removeElement();
            this.storage.remove(removedKey);

        }
        this.storage.put(key, value);
        this.evictionStratergy.addElement(key);
        System.out.println("Data added with key " + key);
    }

    public Value getData(Key key) {
        if (this.storage.containsKey(key)) {
            this.evictionStratergy.fetchData(key);
            System.out.println("Data accessed with key " + key);
            return this.storage.get(key);
        } else {
            throw new RuntimeException("Data not present in cache");
        }
    }

    public void deleteData(Key key) {
        if (this.storage.containsKey(key)) {
            this.storage.remove(key);
            this.evictionStratergy.removeElement(key);
            System.out.println("Data deleted with key " + key);
        } else {
            throw new RuntimeException("Data not present to delete");
        }
    }

    public void updataData(Key key, Value value) {
        if (this.storage.containsKey(key)) {
            this.storage.put(key, value);
            this.evictionStratergy.fetchData(key);
            System.out.println("Data updated for key " + key);

        } else {
            throw new RuntimeException("Data not present for updation");
        }
    }

}
