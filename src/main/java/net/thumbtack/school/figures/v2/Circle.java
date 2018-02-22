package net.thumbtack.school.figures.v2;

import java.util.Objects;

public class Circle extends Figure {
    private Point2D center;
    private int radius;

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


    public Circle(Point2D center, int raduis, int color) {
        setCenter(center);
        setRadius(raduis);
        setColor(color);
    }


    public Circle(int xCenter, int yCenter, int radius, int color) {
        this(new Point2D(xCenter, yCenter), radius, color);
    }

    public Circle(int radius, int color) {
        this(new Point2D(), radius, color);
    }

    public Circle(int color) {
        this(new Point2D(), 1, color);
    }

    @Override
    public void moveRel(int dx, int dy) {
        setCenter(new Point2D(center.getX() + dx, center.getY() + dy));
    }

    public void enlarge(int n) {
        setRadius(radius * n);
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }

    @Override
    public boolean isInside(int x, int y) {
        return getRadius() >= Math.pow((center.getX() - x) * (center.getX() - x) + (center.getY() - y) * (center.getY() - y), 0.5);
    }

    @Override
    public boolean isInside(Point2D point) {
        return getRadius() >= Math.pow((center.getX() - point.getX()) * (center.getX() - point.getX()) + (center.getY() - point.getY()) * (center.getY() - point.getY()), 0.5);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius &&
                Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), center, radius);
    }
}

