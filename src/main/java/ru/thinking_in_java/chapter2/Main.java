package ru.thinking_in_java.chapter2;

public class Main {

    public static void main(String[] args){
        /**
         * Exercises One
         * */
        System.out.println("\n");
        System.out.println("### Exercises One #1");
        ExercisesOne exercisesOne = new ExercisesOne();
        System.out.println("checkInt " + exercisesOne.getCheckInt());
        System.out.println("checkChar " + exercisesOne.getCheckChar());

        /**
         * Exercises Three
         * */
        System.out.println("\n");
        ATypeName aTypeName = new ATypeName();
        System.out.println("### Exercises Three #3");
        System.out.println(aTypeName.getName());
        /**
         * Exercises Four
         * */
        System.out.println("\n");
        System.out.println("### Exercises Four #4");
        DataOnly dataOnly = new DataOnly();
        System.out.println(dataOnly.i);
        System.out.println(dataOnly.d);
        System.out.println(dataOnly.b);
        /**
         * Exercises Five
         * */
        System.out.println("\n");
        System.out.println("### Exercises Five #5");
        DataOnlyFive dataOnlyFive = new DataOnlyFive();
        System.out.println(dataOnlyFive.i);
        System.out.println(dataOnlyFive.d);
        System.out.println(dataOnlyFive.b);


        /**
         * Exercises Six
         * */
        System.out.println("\n");
        System.out.println("### Exercises Six #6");
        StorageWrapper sw = new StorageWrapper();
        System.out.println("call storage method " + sw.storage("call storage method"));
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

class DataOnlyFive{
    int i = 10;
    double d = 20;
    boolean b = true;
}

class StorageWrapper{
    int storage(String s){
        return s.length() * 2;
    }
}
