package ru.geekbrains.incrementor;

import java.util.concurrent.locks.Lock;

public class Incrementor {
    private final Lock lock;
    private int counter;

    public Incrementor(Lock lock) {
        this.lock = lock;
    }

    public void increment() {
        lock.lock();
        counter++;
        System.out.println(counter);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}
