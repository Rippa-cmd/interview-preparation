package ru.geekbrains.extraTasks.linkedList;

import java.util.Iterator;

public class SingleLinkedList implements Iterable<Node> {
    private final Node head;

    public SingleLinkedList(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<>() {
            Node node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Node next() {
                try {
                    return node;
                } finally {
                    node = node.getNext();
                }
            }
        };
    }
}
