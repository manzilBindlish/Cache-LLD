package models;

import java.util.*;
import models.*;

public class LRU<Key> implements IStrategy<Key> {
    HashMap<Key, Node> nodeAddress;
    LinkedList list;

    public LRU() {
        this.nodeAddress = new HashMap<>();
        this.list = new LinkedList();
    }

    public void addElement(Key data) {
        Node newInsertion = this.list.insertKeyAtEnd(data);
        this.nodeAddress.put(data, newInsertion);
    }

    public Key removeElement() {
        if (this.list.head != null) {
            this.nodeAddress.remove(this.list.head.data);
            Key delKey = (Key) this.list.head.data;
            this.list.removeFirstNode();
            System.out.println("Eviction policy invoked and delted key is " + delKey);
            return delKey;
        } else {
            throw new RuntimeException("");
        }

    }

    public void removeElement(Key key) {
        Node delElement = this.nodeAddress.get(key);
        this.list.removeNode(delElement);
        this.nodeAddress.remove(key);
    }

    public void fetchData(Key key) {
        Node activeNode = this.nodeAddress.get(key);
        this.list.removeNode(activeNode);
        this.list.insertNodeAtEnd(activeNode);
    }

}
