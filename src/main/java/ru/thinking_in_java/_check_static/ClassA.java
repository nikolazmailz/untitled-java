package ru.thinking_in_java._check_static;

public class ClassA {

    public static class ClassB {
        public int i;
        public static int j;

        public ClassB(int i, int j){
            this.i = i;
            this.j = j;
        }

        public String toString(){
            return "i " + i + ", j " + j;
        }
    }

    public static void main(String[] args) {

        ClassA.ClassB b1 = new ClassA.ClassB(1, 0);
        ClassA.ClassB b2 = new ClassA.ClassB(2, 1);
        ClassA.ClassB b3 = new ClassA.ClassB(3, 2);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

    }
}
