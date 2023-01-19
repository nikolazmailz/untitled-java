package ru.java_philosophy.chapter2.exercises09;

public class Main {

    public static void main(String[] args){

        PrimitiveTest pt = new PrimitiveTest();

        System.out.println(
            "b " + pt.b + "\n" +
            "bt " + pt.bt + "\n" +
            "c " + pt.c + "\n" +
            "s " + pt.s + "\n" +
            "i " + pt.i + "\n" +
            "l " + pt.l + "\n" +
            "f " + pt.f + "\n" +
            "d " + pt.d + "\n"
        );

        Boolean bw = pt.b;
        Byte btw = pt.bt;
        Character cw = pt.c;
        Short sw = pt.s;
        Integer iw = pt.i;
        Float fw = pt.f;
        Double dw = pt.d;

        System.out.println(
            "bw " + bw + "\n" +
            "btw " + btw + "\n" +
            "cw " + cw + "\n" +
            "sw " + sw + "\n" +
            "iw " + iw + "\n" +
            "fw " + fw + "\n" +
            "dw " + dw + "\n"
        );

        System.out.println(
            "bw " + bw.getClass().getSimpleName() + "\n" +
                "btw " + btw.getClass().getSimpleName() + "\n" +
                "cw " + cw.getClass().getSimpleName() + "\n" +
                "sw " + sw.getClass().getSimpleName() + "\n" +
                "iw " + iw.getClass().getSimpleName() + "\n" +
                "fw " + fw.getClass().getSimpleName() + "\n" +
                "dw " + dw.getClass().getSimpleName() + "\n"
        );

    }

}

class PrimitiveTest{
    boolean b;
    byte bt;
    char c;
    short s;
    int i;
    long l;
    float f;
    double d;
}
