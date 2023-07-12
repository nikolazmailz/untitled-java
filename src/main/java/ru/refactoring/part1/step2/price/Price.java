package ru.refactoring.part1.step2.price;

public abstract class Price {

    public abstract int getPriceCode();

    public abstract double getCharge(int daysRental);

    public int getFrequentRenterPoint(int daysRental) {
        return 1;
    }
}
