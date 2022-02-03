package ru.geekbrains.lists;

import java.util.Iterator;
import java.util.Objects;

public class MyLinkedList<T> implements MyList<T> {

    private MyNode<T> first;

    private MyNode<T> last;

    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(T value) {
        MyNode<T> l = last;
        MyNode<T> newNode = new MyNode<>(l, value, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return findNode(index).value;
    }

    @Override
    public T getFirst() {
        if (first != null) {
            return first.value;
        } else {
            throw new NullPointerException("Empty list");
        }
    }

    @Override
    public T getLast() {
        if (last != null) {
            return last.value;
        } else {
            throw new NullPointerException("Empty list");
        }
    }

    @Override
    public void remove(int index) {
        Objects.checkIndex(index, size);
        MyNode<T> node = findNode(index);
        MyNode<T> prevTemp = node.previous;
        MyNode<T> nextTemp = node.next;
        if (node.equals(first)) {
            nextTemp.previous = null;
            this.first = nextTemp;
        } else if (node.equals(last)) {
            prevTemp.next = null;
            this.last = prevTemp;
        } else {
            prevTemp.next = nextTemp;
            nextTemp.previous = prevTemp;
        }
        clearNode(node);
        size--;
    }

    @Override
    public void clear() {
        for (MyNode<T> node = first; node != null; ) {
            MyNode<T> next = node.next;
            clearNode(node);
            node = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    private void clearNode(MyNode<T> node) {
        node.next = null;
        node.previous = null;
        node.value = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyNode<T> node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                try {
                    return node.value;
                } finally {
                    node = node.next;
                }
            }
        };
    }

    public MyNode<T> findNode(int index) {
        MyNode<T> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.previous;
        }
        return x;
    }
}
