package ru.interview.iterator;

import java.util.*;

public class Main {

    /**
     * Даны два итератора. Реализовать итератор,
     * который может объединить два данных итератора:
     * позволяет сначала получить элементы из первого, затем из второго
     * <p>
     * Реализовать итератор, который может объединять произвольное количество итераторов
     */

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<String>();
        l1.add("l1_l1");
        l1.add("l1_l2");
        l1.add("l1_l3");

        List<String> l2 = new ArrayList<String>();
        l2.add("l2_l1");
        l2.add("l2_l2");
        l2.add("l2_l3");

        List<String> l3 = new ArrayList<String>();
        l3.add("l3_l1");
        l3.add("l3_l2");
        l3.add("l3_l3");

//        ru.interview.iterator.CustomIterator c = new ru.interview.iterator.CustomIterator(l1.iterator(), l2.iterator());

        Iterator c2 = uniteCI(l1.iterator(), l2.iterator(), l3.iterator());

        while (c2.hasNext()) {
            System.out.println(c2.next());
        }

    }

    public static <T> Iterator<T> uniteCI(Iterator<T>... listI) {
        List<Iterator<T>> localListIter = Arrays.stream(listI).toList();

        if (listI.length == 0) {
            return Collections.emptyIterator();
        } else if (listI.length == 1) {

            return localListIter.get(0);
        } else if (listI.length == 2) {

            return new CustomIterator<>(getByIndex(localListIter, 0), getByIndex(localListIter, 1));
        } else if (listI.length > 2) {

            CustomIterator localIterator =
                    new CustomIterator<>(getByIndex(localListIter, 0), getByIndex(localListIter, 1));

            for (int i = 2; i < listI.length; i++) {
                localIterator = new CustomIterator(localIterator, getByIndex(localListIter, i));
            }

            return localIterator;
        }

        throw new NoSuchElementException("NoSuchElementException");
    }

    private static <T> Iterator<T> getByIndex(List<Iterator<T>> listI, int index) {
        return listI.get(index);
    }


}
