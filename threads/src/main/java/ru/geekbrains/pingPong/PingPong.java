package ru.geekbrains.pingPong;

public class PingPong {

    private String word = "ping";

    public synchronized void ping() {
        while (true) {
            try {
                while ("pong".equals(word) || Thread.interrupted()) {
                    Thread.sleep(10);
                    this.wait();
                }
                System.out.println(word);
                word = "pong";
                Thread.sleep(500);
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void pong() {
        while (true) {
            try {
                while ("ping".equals(word) || Thread.interrupted()) {
                    Thread.sleep(10);
                    this.wait();
                }
                System.out.println(word);
                word = "ping";
                Thread.sleep(500);
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
