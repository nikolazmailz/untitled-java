package ru.java_effective_programming.part_11_2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ForwardingSet<E> implements Set<E> {

    private final Set<E> s;

    public ForwardingSet(Set<E> s){
        this.s = s;
    }

    @Override
    public int size() {
        return s.size();
    }

    @Override
    public boolean isEmpty() {
        return s.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return s.contains(0);
    }

    @Override
    public Iterator iterator() {
        return s.iterator();
    }

    @Override
    public Object[] toArray() {
        return s.toArray();
    }

    @Override
    public boolean add(E e) {
        return s.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return s.remove(o);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return s.addAll(c);
    }

    @Override
    public void clear() {
        s.clear();
    }

    @Override
    public boolean removeAll(Collection c) {
        return s.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return s.retainAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return s.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return s.toArray(a);
    }

}
