package ru.interview.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomIterator<T> implements Iterator<T> {
    Iterator<T> i1;
    Iterator<T> i2;

    public CustomIterator(Iterator<T> i1, Iterator<T> i2) {
        this.i1 = i1;
        this.i2 = i2;
    }

    @Override
    public boolean hasNext() {
        return i1.hasNext() || i2.hasNext();
    }

    @Override
    public T next() {
        if (i1.hasNext()) {
            return i1.next();
        } else if (i2.hasNext()) {
            return i2.next();
        }
        throw new NoSuchElementException("NoSuchElementException");
    }
}
