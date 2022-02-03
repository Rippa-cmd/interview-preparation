package ru.geekbrains.lists;

public class MyNode<T> {

    MyNode<T> previous;

    MyNode<T> next;

    T value;

    MyNode(MyNode<T> previous, T value, MyNode<T> next) {
        this.previous = previous;
        this.next = next;
        this.value = value;
    }
}
