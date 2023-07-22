package models;

public class Node<Key> {

    Key data;
    Node prev;
    Node next;

    Node() {
        this.prev = null;
        this.next = null;
    }

    Node(Key data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    Node(Key data, Node prev) {
        this.data = data;
        this.prev = prev;
        this.next = null;
    }

}
