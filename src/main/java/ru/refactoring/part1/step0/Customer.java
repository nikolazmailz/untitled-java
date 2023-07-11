package ru.refactoring.part1.step0;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRentals(Rental rental) {
        _rentals.addElement(rental);
    }

    public String getName() {
        return _name;
    }

    public String statement(){
        double totalAmount = 0;
        int frequentRenterPoint = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Прокат " + getName() + "\n";

        while (rentals.hasMoreElements()){
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            switch (each.getMovie().getPriceCode()){
                case Movie.REGULAR:
                    thisAmount += 2;

                    if(each.getDaysRented() > 2){
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if(each.getDaysRented() > 3){
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }

            frequentRenterPoint++;

            if( (each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1){
                frequentRenterPoint++;
            }

            result += "\t" + each.getMovie().getTitle() + "\t" +
                String.valueOf(thisAmount) + "\n";

            totalAmount += thisAmount;
        }

        result += "Cумма задолжности: " +
            String.valueOf(totalAmount) + "\n";
        result += "Вы заработали " + String.valueOf(frequentRenterPoint) + " бонусных очков";
        return result;
    }

}
