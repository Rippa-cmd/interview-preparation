package ru.geekbrains.extraTasks.singleLinkedList;

import ru.geekbrains.extraTasks.linkedList.Node;
import ru.geekbrains.extraTasks.linkedList.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList list = create();
        for (Node node : list) {
            System.out.println(node.getBody());
        }

            Node head = null;
            Node next;
            Node prev;
            for (Node node : list) {
                prev = head;
                next = node;
                next.setNext(prev);
                head = next;
            }

        SingleLinkedList list2 = new SingleLinkedList(head);
        for (Node node : list2) {
            System.out.println(node.getBody());
        }
    }

    private static SingleLinkedList create() {
        return new SingleLinkedList(new Node("first", new Node("second", new Node("third", null))));
    }
}
