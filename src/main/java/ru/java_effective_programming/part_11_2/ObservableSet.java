package ru.java_effective_programming.part_11_2;

import ru.java_effective_programming.part_11_2.myexample.NumPlusNum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set<E> s) {
        super(s);
    }

    private final List<SetObserver<E>> observers = new ArrayList<>();
    private final List<NumPlusNum<Double, Double>> numPlusNums = new ArrayList<>();

    public void addObserver(SetObserver<E> observer) {
        synchronized (observers){
            observers.add(observer);
        }
    }

    public void addNumPlusNum(NumPlusNum<Double, Double> numPlusNum) {
        synchronized (numPlusNums){
            numPlusNums.add(numPlusNum);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers){
            return observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element){
        synchronized (observers){
            for(SetObserver<E> observer: observers){
                observer.added(this, element);
            }
        }
    }

    private void notifyElementAdded(Double i1, Double i2){
        synchronized (observers){
            for(NumPlusNum<Double, Double> numPlusNum: numPlusNums){
                numPlusNum.sum(i1, i2);
            }
        }
    }

    @Override
    public boolean add(E element){
        boolean added = super.add(element);

        if(added) {
            notifyElementAdded(element);
        }

        return added;
    }

    public void add(Double i1, Double i2){
        notifyElementAdded(i1, i2);
    }

    @Override
    public boolean addAll(Collection<? extends E> c){
        boolean result = false;
        for(E element: c){
            result |= add(element);
        }
        return result;
    }


    public boolean removeElement(E element){
        boolean added = super.remove(element);

        if(added) {
            notifyElementAdded(element);
        }

        return added;
    }
}
