package ru.check.liskov;

public class Main {

    public static void main(String[] args) {
        Point p = new Point(1,1);
        ColorPoint cp = new ColorPoint(1,1, Color.RED);

        System.out.println(
            p.equals(cp)
        );
        System.out.println(
            cp.equals(p)
        );
        System.out.println("\n");

        ColorPoint cp2 = new ColorPoint(1,1,Color.BLUE);

        System.out.println(cp.equals(p));
        System.out.println(p.equals(cp2));
        System.out.println(cp2.equals(cp));

    }
}
