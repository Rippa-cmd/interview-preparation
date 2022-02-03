package ru.geekbrains;

/**
 *
 */
interface Moveable {
    void move();
}

/**
 * Следовало бы назвать Stoppable, и возможно объединить с Moveable
 */
interface Stopable {
    void stop();
}

/**
 * Любая машина должна двигаться, добавить интерфейс Moveable и Stopable к абстрактному классу,
 * а не конкретной реализации
 */
abstract class Car {
    // Почему public?
//    public Engine engine;
    private String color;
    private String name;

    // Возможно имеет смысл вынести этот метод в отдельный интерфейс, или добавить в уже существующий
    protected void start() {
        System.out.println("Car starting");
    }

    abstract void open();

    // Закрыл, что бы компилятор не ругался
//    public Engine getEngine() {
//        return engine;
//    }
//
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * Забыта реализация интерфейса Stopable
 */
class LightWeightCar extends Car implements Moveable {
    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}
/**
 *  Множественное наследование от классов в Java невозможно, только от интерфейсов, с обязательной реализацией
 *  методов
 *  class Lorry extends Car, implements Moveable, Stopable {
 *
 *      ***
 *
 *      @Override
 *      public void move(){}
 *
 *      @Override
 *      public void stop(){}
 *
 *      @Override
 *      public void open(){}
 *
 *  }
 */
//class Lorry extends Car, Moveable, Stopable {
//    public void move(){
//        System.out.println("Car is moving");
//    }
//
//    public void stop(){
//        System.out.println("Car is stop");
//    }
//}

