package models;

import models.*;

public class LinkedList {

    Node head;
    Node end;
    
    public LinkedList (){
        head = new Node();
        end = head;
    }

    public Node insert(int data){
        Node newNode = new Node(data);
        while(head.next != null){
            head = head.next;
        }
        head.next = newNode;
        return newNode;
    }

    public void insertAtEnd(Node newNode){
        removeElement(newNode);


    }

    public void removeElement(Node delNode){
        Node temp = delNode.prev;
        temp.next = delNode.next;
    }
}
