package ru.refactoring.part1.step2;

import ru.refactoring.part1.step2.price.ChildrenPrice;
import ru.refactoring.part1.step2.price.NewReleasePrice;
import ru.refactoring.part1.step2.price.Price;
import ru.refactoring.part1.step2.price.RegularPrice;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private Price _price;

    public Movie(String title, int priceCode){
        _title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return _title;
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            case CHILDRENS:
                _price = new ChildrenPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public double getCharge(int daysRental) {
        return _price.getCharge(daysRental);
    }

    public int getFrequentRenterPoint(int daysRental) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRental > 1) {
            return 2;
        } else {
            return 1;
        }
    }

}
