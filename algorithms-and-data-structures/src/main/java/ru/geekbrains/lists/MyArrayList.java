package ru.geekbrains.lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class MyArrayList<T> implements MyList<T> {

    private T[] arr;

    private final int extraLength = 5;

    private int filledSize;

    @SafeVarargs
    public MyArrayList(T... keys) {
        arr = (T[])new Object[keys.length];
        for (int i = 0; i < keys.length; i++) {
            arr[i] = keys[i];
        }
        filledSize = arr.length;
    }

    public MyArrayList() {
        arr = (T[])new Object[0];
        filledSize = 0;
    }

    public MyArrayList(int size) {
        arr = (T[])new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        filledSize = 0;
    }

    @Override
    public int size() {
        return filledSize;
    }

    @Override
    public void put(T obj) {
        if (arr.length == filledSize) {
            T[] newArr = (T[])new Object[arr.length + extraLength];

            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[1];
            }

            for (int i = filledSize; i < newArr.length; i++) {
                newArr[i] = null;
            }

            arr = newArr;
        }
        arr[filledSize] = obj;
        filledSize++;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, arr.length);
        return arr[index];
    }

    @Override
    public T getFirst() {
        if (arr.length > 0) {
            return arr[0];
        } else {
            throw new NullPointerException("Empty list");
        }
    }

    @Override
    public T getLast() {
        if (arr.length > 0) {
            return arr[filledSize];
        } else {
            throw new NullPointerException("Empty list");
        }
    }

    @Override
    public void remove(int index) {
        Objects.checkIndex(index, arr.length);
        for (int i = index; i < filledSize-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[filledSize-1] = null;
        filledSize--;
    }

    @Override
    public void clear() {
        arr = (T[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
        filledSize = 0;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", extraLength=" + extraLength +
                ", filledSize=" + filledSize +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int curIndex = 0;

            @Override
            public boolean hasNext() {
                return curIndex < filledSize;
            }

            @Override
            public T next() {
                try {
                    return arr[curIndex];
                } finally {
                    curIndex++;
                }
            }
        };
    }
}
