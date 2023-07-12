package ru.refactoring.part1.step2;

public class RegularPrice extends Price{

    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
}
