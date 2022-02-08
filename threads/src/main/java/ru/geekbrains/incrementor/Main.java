package ru.geekbrains.incrementor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Incrementor incrementor = new Incrementor(lock);
        new Thread(() -> {
            while (true) {
                incrementor.increment();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                incrementor.increment();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                incrementor.increment();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                incrementor.increment();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                incrementor.increment();
            }
        }).start();
    }
}
