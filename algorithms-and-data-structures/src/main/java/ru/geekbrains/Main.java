package ru.geekbrains;


import ru.geekbrains.lists.MyArrayList;
import ru.geekbrains.lists.MyLinkedList;
import ru.geekbrains.lists.MyList;

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();

        list.put("Hello");
        list.put(", ");
        list.put("world");
        list.put("!!!");

        for (String str : list) {
            System.out.print(str);
        }
        System.out.println();

        MyList<String> list2 = new MyArrayList<>("Hello", ", ", "world", "!!!");
        for (String str : list2) {
            System.out.print(str);
        }
        System.out.println();
        System.out.println(list2.get(0));
        list2.remove(1);
        System.out.println(list2.get(1));


        MyList<String> linkedList = new MyLinkedList<>();
        linkedList.put("Hello");
        linkedList.put(", ");
        linkedList.put("world");
        linkedList.put("!!!");
        for (String str : linkedList) {
            System.out.print(str);
        }
        System.out.println(linkedList.get(0));
        linkedList.remove(1);
        System.out.println(linkedList.get(1));
        linkedList.remove(1);
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.size());
    }
}
