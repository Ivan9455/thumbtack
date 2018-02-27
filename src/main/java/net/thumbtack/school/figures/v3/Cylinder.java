package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

public class Cylinder extends Circle {
    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public Cylinder(Point2D center, int radius, int height, Color color) throws ColorException {
        super(center, radius, color);
        this.height = height;
    }

    public Cylinder(Point2D center, int radius, int height, String color) throws ColorException {
        super(center, radius, color);
        this.height = height;
    }

    public Cylinder(int xCenter, int yCenter, int radius, int height, Color color) throws ColorException {
        this(new Point2D(xCenter, yCenter), radius, height, color);
    }

    public Cylinder(int xCenter, int yCenter, int radius, int height, String color) throws ColorException {
        this(new Point2D(xCenter, yCenter), radius, height, color);
    }

    public Cylinder(int radius, int height, Color color) throws ColorException {
        this(new Point2D(0, 0), radius, height, color);
    }

    public Cylinder(int radius, int height, String color) throws ColorException {
        this(new Point2D(0, 0), radius, height, color);
    }

    public Cylinder(Color color) throws ColorException {
        this(new Point2D(), 1, 1, color);
    }

    public Cylinder(String color) throws ColorException {
        this(new Point2D(), 1, 1, color);
    }

    public double getVolume() {
        return getArea() * height;
    }

    public boolean isInside(int x, int y, int z) {
        return super.isInside(x, y);
    }

}
