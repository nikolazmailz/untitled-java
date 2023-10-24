package ru.java_effective_programming.part_11_2.myexample;

@FunctionalInterface
public interface NumPlusNum<X, Y> {
    void sum(X x, Y y);
}
