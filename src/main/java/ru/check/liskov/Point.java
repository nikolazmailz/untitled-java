package ru.check.liskov;

public class Point {

    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o){
        //System.out.println("Point equals o.getClass() " + o.getClass());
        if(!(o instanceof Point)){
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

}
