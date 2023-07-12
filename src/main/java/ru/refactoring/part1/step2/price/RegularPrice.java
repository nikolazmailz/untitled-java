package ru.refactoring.part1.step2.price;

import ru.refactoring.part1.step2.Movie;

public class RegularPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    public double getCharge(int daysRental) {
        double result = 2;
        if (daysRental > 2) {
            result += (daysRental - 2) * 1.5;
        }
        return result;
    }
}
