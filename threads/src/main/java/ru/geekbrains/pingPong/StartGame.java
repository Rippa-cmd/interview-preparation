package ru.geekbrains.pingPong;

public class StartGame {
    public static void main(String[] args) {
        PingPong game = new PingPong();
        new Thread(game::ping).start();
        new Thread(game::pong).start();
    }
}
