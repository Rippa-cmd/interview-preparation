package ru.geekbrains.lists;


public interface MyList<T> extends Iterable {

    int size();

    void put(T obj);

    T get(int index);

    T getFirst();

    T getLast();

    void remove(int index);

    void clear();

}
