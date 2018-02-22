package net.thumbtack.school.figures.v2;

import java.util.Objects;

public class Rectangle3D extends Rectangle {
    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle3D(Point2D leftTop, Point2D rightBottom, int height, int color) {
        super(leftTop, rightBottom, color);
        setHeight(height);

    }

    public Rectangle3D(int xLeft, int yTop, int xRight, int yBottom, int height, int color) {
        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom), height, color);
    }

    public Rectangle3D(int length, int width, int height, int color) {
        super(length, width, color);
        setHeight(height);
    }

    public Rectangle3D(int color) {
        this(1, 1, 1, color);
    }

    public boolean isInside(Rectangle3D rectangle) {
        return super.isInside(rectangle) && height >= rectangle.height;
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle3D that = (Rectangle3D) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), height);
    }
}
