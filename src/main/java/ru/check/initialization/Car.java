package ru.check.initialization;

abstract public class Car {

    public static int carCounter = 0;

    public Car() {
        System.out.println("constructor Car");
    }

   abstract public String getDescription();

}
