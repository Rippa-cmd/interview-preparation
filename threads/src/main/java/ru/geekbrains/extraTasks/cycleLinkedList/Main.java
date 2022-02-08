package ru.geekbrains.extraTasks.cycleLinkedList;

import ru.geekbrains.extraTasks.linkedList.Node;
import ru.geekbrains.extraTasks.linkedList.SingleLinkedList;

public class Main {

    public static void main(String[] args) {
        SingleLinkedList list = createCycleList(10);
        checkList(list);
        SingleLinkedList list2 = createSimpleList(10);
        checkList(list2);
    }

    private static SingleLinkedList createSimpleList(int size) {
        Node[] nodes = new Node[size + 1];
        for (int i = size - 1; i >= 0; i--) {
            nodes[i] = new Node("node" + (i + 1), nodes[i + 1]);
        }
        return new SingleLinkedList(nodes[0]);
    }

    private static SingleLinkedList createCycleList(int size) {
        Node[] nodes = new Node[size + 1];
        for (int i = size - 1; i >= 0; i--) {
            nodes[i] = new Node("node" + (i + 1), nodes[i + 1]);
        }
        nodes[size - 1].setNext(nodes[size/2]);
        return new SingleLinkedList(nodes[0]);
    }

    private static void checkList(SingleLinkedList list) {
        Node curPlusOne;
        Node curPlusTwo = null;
        for (Node node : list) {
            curPlusOne = node;

            if (curPlusTwo == null) {
                curPlusTwo = node;
            } else {
                curPlusTwo = curPlusTwo.getNext();
            }
            if (curPlusTwo == null || curPlusTwo.getNext() == null) {
                System.out.println("Not cycle");
                break;
            }
            curPlusTwo = curPlusTwo.getNext();
            if (curPlusTwo.equals(curPlusOne)) {
                System.out.println("Cycle found");
                break;
            }
        }
    }
}
