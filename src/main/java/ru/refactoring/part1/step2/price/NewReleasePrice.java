package ru.refactoring.part1.step2.price;

import ru.refactoring.part1.step2.Movie;

public class NewReleasePrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    public double getCharge(int daysRental) {
        return daysRental * 3;
    }

    @Override
    public int getFrequentRenterPoint(int daysRental) {
        if (daysRental > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
