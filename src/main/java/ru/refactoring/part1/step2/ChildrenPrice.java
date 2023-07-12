package ru.refactoring.part1.step2;

public class ChildrenPrice extends Price{

    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
