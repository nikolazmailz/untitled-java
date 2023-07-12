package ru.refactoring.part1.step1;

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
        Enumeration rentals = _rentals.elements();
        String result = "Прокат " + getName() + "\n";

        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            
            result += "\t" + each.getMovie().getTitle() + "\t" +
                each.getCharge() + "\n";
        }

        result += "Cумма задолжности: " +
            getTotalCharge() + "\n";
        result += "Вы заработали " + getTotalFrequentRenterPoint() + " бонусных очков";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoint(){
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoint();
        }
        return result;
    }

}
