package ru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * 1. Есть таблица Person(name, age). Необходимо написать запрос,
 *  который выведет имена и максимальный возраст для каждого имени
 *
 *  3. Реализовать метод List<Person> getTopAgeForName(List<Person> persons),
 *  который повторяет логику из первой задачи
 * */
public class CheckSet {

    public static void main(String[] args) {

        List<Person> li = new ArrayList<>();
        li.add(new Person(new String("1"), 10));
        li.add(new Person(new String("1"), 20));
        li.add(new Person("2", 30));
        li.add(new Person("2", 10));
        li.add(new Person("4", 50));

        System.out.println(
                getTopAgeForName(li)
        );

    }

    public static List<Person> getTopAgeForName(List<Person> persons){

        List<Person> l = new ArrayList<>();
        Map<String, Person> mapPerson = new HashMap<>();

        for(Person person : persons){ // n

            mapPerson.get(person.name);

            Optional<Person> fromList = l.stream().filter(p -> p.name.equals(person.name)).findFirst(); // n

            if(fromList.isPresent()){
                if(fromList.get().age < person.age){
                    l.remove(fromList.get());
                    l.add(person);
                }
            } else {
                l.add(person);
            }
        }

         return l;
    }
}
