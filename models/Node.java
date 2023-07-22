package models;

public class Node {

  
    int data;
    Node prev;
    Node next;

    Node(){
        this.prev = null;
        this.next = null;
    }

    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    Node(int data, Node prev){
        this.data = data;
        this.prev = prev;
        this.next = null;
    }

    
}
