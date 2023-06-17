package ru.check.liskov;

public enum Color {
    RED("Red"),
    BLUE("Blue"),
    YELLOW("Yellow");

    public final String color;

    private Color(String color) {
        this.color = color;
    }

    public static Color valueOfLabel(String color) {
        for (Color c : values()) {
            if (c.color.equals(color)) {
                return c;
            }
        }
        return null;
    }
}
