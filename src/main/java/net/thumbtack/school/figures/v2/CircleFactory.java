package net.thumbtack.school.figures.v2;

public class CircleFactory {
    private static int CIRCLE_COUN = 0;

    public static Circle createCircle(Point2D center, int radius, int color) {
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
