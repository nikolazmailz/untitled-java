package ru.refactoring.part1.step2;

public class NewReleasePrice extends Price{

    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}
