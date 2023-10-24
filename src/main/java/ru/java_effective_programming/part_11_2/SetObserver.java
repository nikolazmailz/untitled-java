package ru.java_effective_programming.part_11_2;

@FunctionalInterface public interface SetObserver<E> {
    void added(ObservableSet<E> set, E element);
}
