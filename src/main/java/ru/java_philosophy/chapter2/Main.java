package ru.java_philosophy.chapter2;

public class Main {

    public static void main(String[] args){
        /**
         * Exercises One
         * */
        System.out.println("### Exercises One #1");
        ExercisesOne exercisesOne = new ExercisesOne();
        System.out.println("checkInt " + exercisesOne.getCheckInt());
        System.out.println("checkChar " + exercisesOne.getCheckChar());
        System.out.println("\n");
        /**
         * Exercises Three
         * */
        ATypeName aTypeName = new ATypeName();
        System.out.println("### Exercises Three #3");
        System.out.println(aTypeName.getName());
        System.out.println("\n");
        /**
         * Exercises Four
         * */
        System.out.println("### Exercises Four #4");
        DataOnly dataOnly = new DataOnly();
        System.out.println(dataOnly.i);
        System.out.println(dataOnly.d);
        System.out.println(dataOnly.b);
        System.out.println("\n");
    }

}

class ExercisesOne{
    private int checkInt;
    private char checkChar;


    public int getCheckInt() {
        return checkInt;
    }

    public char getCheckChar() {
        return checkChar;
    }
}

class ATypeName{

    private String name;

    public ATypeName() {
        setName(this.getClass().getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class DataOnly{
    int i;
    double d;
    boolean b;
}
