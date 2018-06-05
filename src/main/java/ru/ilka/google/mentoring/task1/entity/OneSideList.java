package ru.ilka.google.mentoring.task1.entity;

public class OneSideList {
    private Node root;
    private Node head;
    private int length;

    public OneSideList() {
        this.length = 0;
    }

    public OneSideList(Node root) {
        this.root = root;
        this.head = root;
        this.length = 1;
    }

    public OneSideList(int[] values) {
        for (int i = 0; i < values.length; i++) {
            push(values[i]);
        }
        this.length = values.length;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getLength() {
        return length;
    }

    public void push(Node newNode) {
        head.setNext(newNode);
        head = newNode;
        length++;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            root = newNode;
        } else {
            head.setNext(newNode);
        }
        head = newNode;
        length++;
    }
}
