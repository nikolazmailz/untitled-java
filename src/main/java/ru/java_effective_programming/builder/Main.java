package ru.java_effective_programming.builder;

public class Main {

    public static void main(String[] args){
        System.out.println("start");
        NutritionFacts cocaCola = new NutritionFacts.Builder(240,8).calories(240)
            .fat(100).sodium(35).carbohydrate(129).build();
        System.out.println(cocaCola);
    }
}
