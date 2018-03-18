// класс Point2D - конструктор с параметрами
package net.thumbtack.lessons;

class Point2D {

    private int x, y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
        this(20, 30);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveTo(int newX, int newY) {
        x = newX;
        y = newY;
    }

}

public class Point2DDemo {
    public static void main(String[] args) {

        Point2D point1 = new Point2D(100, 50);
        point1.moveTo(300, 400);

        Point2D point2 = new Point2D();
        point2.moveTo(30, 40);
    }
}
