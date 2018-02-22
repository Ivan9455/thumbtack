package net.thumbtack.school.figures.v2;


import java.util.Objects;

public class Rectangle extends Figure {
    //переменные
    private Point2D topLeft, bottomRight;


    public int getLength() {
        return Math.abs(topLeft.getX() - bottomRight.getX());
    }

    public int getWidth() {
        return Math.abs(topLeft.getY() - bottomRight.getY());
    }
    //get and set

    public Point2D getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point2D topLeft) {
        this.topLeft = topLeft;
    }

    public Point2D getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Point2D bottomRight) {
        this.bottomRight = bottomRight;
    }
    //методы///////////////////////////////////////////

    public Rectangle(Point2D leftTop, Point2D rightBottom, int color) {
        setTopLeft(leftTop);
        setBottomRight(rightBottom);
        setColor(color);
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {
        setTopLeft(new Point2D(xLeft, yTop));
        setBottomRight(new Point2D(xRight, yBottom));
        setColor(color);
    }

    public Rectangle(int lengthR, int width, int color) {
        setTopLeft(new Point2D(0, -width));
        setBottomRight(new Point2D(lengthR, 0));
        setColor(color);
    }

    public Rectangle(int color) {
        setTopLeft(new Point2D(0, -1));
        setBottomRight(new Point2D(1, 0));
        setColor(color);
    }

    @Override
    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }

    public void enlarge(int nx, int ny) {
        bottomRight.moveTo(
                (bottomRight.getX() - topLeft.getX()) * nx + topLeft.getX(),
                (bottomRight.getY() - topLeft.getY()) * ny + topLeft.getY());
    }

    @Override
    public double getArea() {
        return (bottomRight.getX() - topLeft.getX()) * (bottomRight.getY() - topLeft.getY());
    }

    @Override
    public double getPerimeter() {
        return 2 * ((bottomRight.getX() - topLeft.getX()) + (bottomRight.getY() - topLeft.getY()));
    }

    @Override
    public boolean isInside(int x, int y) {
        return (topLeft.getX() <= x && bottomRight.getX() >= x) &&
                (topLeft.getY() <= y && bottomRight.getY() >= y);
    }

    @Override
    public boolean isInside(Point2D point) {
        return (topLeft.getX() <= point.getX() && bottomRight.getX() >= point.getX()) &&
                (topLeft.getY() <= point.getY() && bottomRight.getY() >= point.getY());
    }

    public boolean isIntersects(Rectangle rectangle) {
        return
                isInside(rectangle) ||
                        ((this.topLeft.getX() >= rectangle.topLeft.getX()) &&
                                (this.bottomRight.getX() <= rectangle.bottomRight.getX()) &&
                                (this.topLeft.getY() >= rectangle.topLeft.getY()) &&
                                (this.bottomRight.getY() <= rectangle.bottomRight.getY()));
    }

    public boolean isInside(Rectangle rectangle) {
        return
                (isInside(rectangle.topLeft.getX(), rectangle.topLeft.getY()) ||
                        isInside(rectangle.topLeft.getX(), rectangle.bottomRight.getY())) ||
                        isInside(rectangle.bottomRight.getX(), rectangle.topLeft.getY()) ||
                        isInside(rectangle.bottomRight.getX(), rectangle.bottomRight.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(topLeft, rectangle.topLeft) &&
                Objects.equals(bottomRight, rectangle.bottomRight);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), topLeft, bottomRight);
    }
}
