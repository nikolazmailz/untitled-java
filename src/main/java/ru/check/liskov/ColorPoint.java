package ru.check.liskov;

import java.util.Objects;

public class ColorPoint extends Point{
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Point equals o.getClass() " + o.getClass());
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        if (!super.equals(o)) {
//            return false;
//        }
//        ColorPoint that = (ColorPoint) o;
//        return color == that.color;

        /**
         * нарушаем симмиричность
        if(!(o instanceof ColorPoint)){
            return false;
        }
         */
        if(!(o instanceof ColorPoint)){
            return o.equals(this);
        }

        return super.equals(o) && ((ColorPoint) o).color == color;
    }

}
