package ru.check.initialization;

public class Truck extends Car {

    public static int truckCounter = 1;

    Truck(){
        System.out.println("constructor Truck");
    }

    @Override
    public String getDescription() {
        return "Truck";
    }


    public static void main(String[] args) {

        Truck truck = new Truck();

        System.out.println(truck.getDescription());

    }
}
