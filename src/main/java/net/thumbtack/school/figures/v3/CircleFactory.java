package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

public class CircleFactory {
    private static int CIRCLE_COUN = 0;

    public static Circle createCircle(Point2D center, int radius, Color color) throws ColorException {
        CIRCLE_COUN++;
        return new Circle(center, radius, color);
    }

    public static Circle createCircle(Point2D center, int radius, String color) throws ColorException {
        CIRCLE_COUN++;
        return new Circle(center, radius, color);
    }

    public static int getCircleCount() {
        return CIRCLE_COUN;
    }

    public static void reset() {
        CIRCLE_COUN = 0;
    }
}
