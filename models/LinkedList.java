package models;

import models.*;

public class LinkedList<Key> {

    Node head;
    Node end;

    public LinkedList() {
        this.head = new Node();
        this.end = null;
    }

    public Node insertKeyAtEnd(Key data) {

        if (this.end != null) {
            Node newNode = new Node(data, end);
            this.end.next = newNode;
            this.end = end.next;
            return newNode;
        } else {
            Node newNode = new Node(data);
            this.head = newNode;
            this.end = newNode;
            return newNode;
        }

    }

    public void removeFirstNode() {
        if (this.head == this.end || this.head == null) {
            this.head = null;
            this.end = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }

    }

    public void insertNodeAtEnd(Node newNode) {

        if (end == null) {
            this.head = newNode;
            this.end = newNode;
            return;
        } else {
            this.end.next = newNode;
            newNode.prev = this.end;
            this.end = end.next;
            return;
        }

    }

    public void removeNode(Node delNode) {
        if (this.head == this.end && this.head == delNode) {
            this.head = null;
            this.end = null;
            return;
        } else if (this.head == delNode) {
            this.head = head.next;
            if (this.head != null)
                this.head.prev = null;
        } else if (this.end == delNode) {
            this.end = end.prev;
            this.end.next = null;
        } else {
            Node temp = delNode.prev;
            temp.next = delNode.next;
            if (delNode.next != null)
                delNode.next.prev = temp;
        }

    }

}
