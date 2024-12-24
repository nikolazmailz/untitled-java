package ru.leetcode.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        List<CustomGroup> lGroup = List.of(
                CustomGroup.createCustomGroup(0, 0),
                CustomGroup.createCustomGroup(1, 1),
                CustomGroup.createCustomGroup(2, 2),
                CustomGroup.createCustomGroup(3, 3)
        );

        List<Person> lPerson = new ArrayList<>(List.of(
                Person.createPerson("Persona First", lGroup)
        ));


        List<CustomGroup> lGroup2 = List.of(
                CustomGroup.createCustomGroup(0, 0),
                CustomGroup.createCustomGroup(1, 1),
                CustomGroup.createCustomGroup(3, 3),
                CustomGroup.createCustomGroup(4, 4)
        );

        lPerson.add(Person.createPerson("Person Second", lGroup2));
        
        lPerson.stream().filter(person -> person.groups.stream().anyMatch(customGroup -> customGroup.indx == 2)).toList();

    }
}


class Person {
    String name;
    List<CustomGroup> groups;

    static Person createPerson(String name, List<CustomGroup> lGroup) {
        Person p = new Person();
        p.name = name;
        p.groups = lGroup;
        return p;
    }
}

class CustomGroup {
    int id;
    int indx;

    static CustomGroup createCustomGroup(int id, int indx) {
        CustomGroup g = new CustomGroup();
        g.id = id;
        g.indx = indx;
        return g;
    }
}