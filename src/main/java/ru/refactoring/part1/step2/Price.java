package ru.refactoring.part1.step2;

abstract class Price {
    abstract int getPriceCode();

    public double getCharge(int daysRental){
        double result = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;

                if (daysRental > 2) {
                    result += (daysRental - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRental * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRental > 3) {
                    result += (daysRental - 3) * 1.5;
                }
                break;
        }
        return result;
    };
}
