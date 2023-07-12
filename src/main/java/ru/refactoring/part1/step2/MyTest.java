package ru.refactoring.part1.step2;


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

//        Прокат Client One
//        Matrix	3.0
//        Matrix II	2.0
//        Matrix III	1.5
//        Cумма задолжности: 6.5
//        Вы заработали 3 бонусных очков
//
//
//        Прокат Client Two
//        Matrix	6.0
//        Matrix II	3.5
//        Matrix III	3.0
//        Cумма задолжности: 12.5
//        Вы заработали 4 бонусных очков
//
//
//        Прокат Client Three
//        Matrix	9.0
//        Matrix II	5.0
//        Matrix III	4.5
//        Cумма задолжности: 18.5
//        Вы заработали 4 бонусных очков


    }

}
