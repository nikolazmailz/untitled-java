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

    public String htmlStatement(){
        Enumeration rentals = _rentals.elements();
        StringBuilder result = new StringBuilder("<H1>Прокат <EM>" + getName() + "</EM></H1><P>\n");

        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();

            result.append(each.getMovie().getTitle()).append(": ").append(each.getCharge()).append("<BR>\n");
        }

        result.append("<P>Cумма задолжности: <EM>").append(getTotalCharge()).append("</EM><P>\n");
        result.append("Вы заработали <EM>").append(getTotalFrequentRenterPoint()).append("</EM> бонусных очков<P>");
        return result.toString();
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
