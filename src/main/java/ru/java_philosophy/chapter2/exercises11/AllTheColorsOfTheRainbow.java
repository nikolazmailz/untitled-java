package ru.java_philosophy.chapter2.exercises11;

public class AllTheColorsOfTheRainbow {

    int anIntegerRepresentingColors;

    void changeTheHueOfTheColor(int newValue){
        anIntegerRepresentingColors = newValue;
    }

    public static void main(String[] args) {
        AllTheColorsOfTheRainbow allTheColorsOfTheRainbow = new AllTheColorsOfTheRainbow();
        System.out.println(allTheColorsOfTheRainbow.anIntegerRepresentingColors);
        allTheColorsOfTheRainbow.changeTheHueOfTheColor(5);
        System.out.println(allTheColorsOfTheRainbow.anIntegerRepresentingColors);
    }


}
