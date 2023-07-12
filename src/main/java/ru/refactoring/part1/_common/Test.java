package ru.refactoring.part1._common;

import ru.refactoring.part1.step0.Customer;
import ru.refactoring.part1.step0.Movie;
import ru.refactoring.part1.step0.Rental;

public class Test {

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

        ru.refactoring.part1.step1.Movie s1_matrix = new ru.refactoring.part1.step1.Movie("Matrix", 1);
        ru.refactoring.part1.step1.Movie s1_matrix2 = new ru.refactoring.part1.step1.Movie("Matrix II", 0);
        ru.refactoring.part1.step1.Movie s1_matrix3 = new ru.refactoring.part1.step1.Movie("Matrix III", 2);

        ru.refactoring.part1.step1.Customer s1_client1 = new ru.refactoring.part1.step1.Customer("Client One");
        ru.refactoring.part1.step1.Customer s1_client2 = new ru.refactoring.part1.step1.Customer("Client Two");
        ru.refactoring.part1.step1.Customer s1_client3 = new ru.refactoring.part1.step1.Customer("Client Three");

        s1_client1.addRentals(new ru.refactoring.part1.step1.Rental(s1_matrix, 1));
        s1_client1.addRentals(new ru.refactoring.part1.step1.Rental(s1_matrix2, 2));
        s1_client1.addRentals(new ru.refactoring.part1.step1.Rental(s1_matrix3, 3));

        s1_client2.addRentals(new ru.refactoring.part1.step1.Rental(s1_matrix, 2));
        s1_client2.addRentals(new ru.refactoring.part1.step1.Rental(s1_matrix2, 3));
        s1_client2.addRentals(new ru.refactoring.part1.step1.Rental(s1_matrix3, 4));

        s1_client3.addRentals(new ru.refactoring.part1.step1.Rental(s1_matrix, 3));
        s1_client3.addRentals(new ru.refactoring.part1.step1.Rental(s1_matrix2, 4));
        s1_client3.addRentals(new ru.refactoring.part1.step1.Rental(s1_matrix3, 5));

        System.out.println(client1.statement().equals(s1_client1.statement()));
        System.out.println(client2.statement().equals(s1_client2.statement()));
        System.out.println(client3.statement().equals(s1_client3.statement()));

        System.out.println("\n");
        System.out.println(s1_client1.htmlStatement());
        System.out.println("\n");

        testStep2(client1,
            client2,
            client3,
            s1_client1,
            s1_client2,
            s1_client3);
    }

    private static void testStep2(Customer client1, Customer client2, Customer client3,
        ru.refactoring.part1.step1.Customer s1_client1, ru.refactoring.part1.step1.Customer s1_client2,
        ru.refactoring.part1.step1.Customer s1_client3) {

        ru.refactoring.part1.step2.Movie s2_matrix = new ru.refactoring.part1.step2.Movie("Matrix", 1);
        ru.refactoring.part1.step2.Movie s2_matrix2 = new ru.refactoring.part1.step2.Movie("Matrix II", 0);
        ru.refactoring.part1.step2.Movie s2_matrix3 = new ru.refactoring.part1.step2.Movie("Matrix III", 2);

        ru.refactoring.part1.step2.Customer s2_client1 = new ru.refactoring.part1.step2.Customer("Client One");
        ru.refactoring.part1.step2.Customer s2_client2 = new ru.refactoring.part1.step2.Customer("Client Two");
        ru.refactoring.part1.step2.Customer s2_client3 = new ru.refactoring.part1.step2.Customer("Client Three");

        s2_client1.addRentals(new ru.refactoring.part1.step2.Rental(s2_matrix, 1));
        s2_client1.addRentals(new ru.refactoring.part1.step2.Rental(s2_matrix2, 2));
        s2_client1.addRentals(new ru.refactoring.part1.step2.Rental(s2_matrix3, 3));

        s2_client2.addRentals(new ru.refactoring.part1.step2.Rental(s2_matrix, 2));
        s2_client2.addRentals(new ru.refactoring.part1.step2.Rental(s2_matrix2, 3));
        s2_client2.addRentals(new ru.refactoring.part1.step2.Rental(s2_matrix3, 4));

        s2_client3.addRentals(new ru.refactoring.part1.step2.Rental(s2_matrix, 3));
        s2_client3.addRentals(new ru.refactoring.part1.step2.Rental(s2_matrix2, 4));
        s2_client3.addRentals(new ru.refactoring.part1.step2.Rental(s2_matrix3, 5));

        System.out.println(client1.statement().equals(s2_client1.statement()));
        System.out.println(client2.statement().equals(s2_client2.statement()));
        System.out.println(client3.statement().equals(s2_client3.statement()));

        System.out.println(s1_client1.statement().equals(s2_client1.statement()));
        System.out.println(s1_client2.statement().equals(s2_client2.statement()));
        System.out.println(s1_client3.statement().equals(s2_client3.statement()));
    }
}
