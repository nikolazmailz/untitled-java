package ru.refactoring.part1.step2;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private Price _priceCode;

    public Movie(String title, int priceCode){
        _title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return _title;
    }

    public int getPriceCode() {
        return _priceCode.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _priceCode = new RegularPrice();
                break;
            case NEW_RELEASE:
                _priceCode = new NewReleasePrice();
                break;
            case CHILDRENS:
                _priceCode = new ChildrenPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public double getCharge(int daysRental) {
        return _priceCode.getCharge(daysRental);
    }

    public int getFrequentRenterPoint(int daysRental) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRental > 1) {
            return 2;
        } else {
            return 1;
        }
    }

}
