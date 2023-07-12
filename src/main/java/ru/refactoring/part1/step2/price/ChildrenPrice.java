package ru.refactoring.part1.step2.price;

import ru.refactoring.part1.step2.Movie;

public class ChildrenPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }

    public double getCharge(int daysRental) {
        double result = 1.5;
        if (daysRental > 3) {
            result += (daysRental - 3) * 1.5;
        }
        return result;
    }
}
