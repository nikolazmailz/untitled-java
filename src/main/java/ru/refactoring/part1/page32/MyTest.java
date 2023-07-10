package ru.refactoring.part1.page32;


public class MyTest {

    public static void main(String[] args) {

        Movie matrix = new Movie("Matrix", 1);
        Movie matrix2 = new Movie("Matrix II", 0);
        Movie matrix3 = new Movie("Matrix III", 2);

        Customer client1 = new Customer("Client One");
        Customer client2 = new Customer("Client Two");
        Customer client3 = new Customer("Client Three");

        client1.addRentals(new Rental(matrix, 1));
        client1.addRentals(new Rental(matrix2, 2));
        client1.addRentals(new Rental(matrix3, 3));

        client2.addRentals(new Rental(matrix, 2));
        client2.addRentals(new Rental(matrix2, 3));
        client2.addRentals(new Rental(matrix3, 4));

        client3.addRentals(new Rental(matrix, 3));
        client3.addRentals(new Rental(matrix2, 4));
        client3.addRentals(new Rental(matrix3, 5));

        System.out.println(client1.statement());
        System.out.println("\n");
        System.out.println(client2.statement());
        System.out.println("\n");
        System.out.println(client3.statement());


    }

}
