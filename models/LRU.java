package models;
import java.util.*;
import models.*;

public class LRU implements IStratergy {
    HashMap<Integer,Node> nodeAddress;
    LinkedList list; 
    Node end;



    public void removeElement(){
        Node delElement = nodeAddress.get(end.data);
        list.removeElement(delElement);
        nodeAddress.remove(end.data);
        end = end.prev;
    }

    public void removeElement(int key){
        Node delElement = nodeAddress.get(key);
        list.removeElement(delElement);
        nodeAddress.remove(end.data);
        end = end.prev;
    }

    public void addElement(int data){
        Node newInsertion = list.insert(data);
        nodeAddress.put(data, newInsertion);
        end = newInsertion;

    }

    // public void getData(int data){
        
    // }



   
}
