package ru.geekbrains.extraTasks.linkedList;

public class Node {

    private String body;

    private Node next;

    public Node(String body, Node next) {
        this.body = body;
        this.next = next;
    }

    public Object getBody() {
        return body;
    }

    public Node getNext() {
        return next;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
