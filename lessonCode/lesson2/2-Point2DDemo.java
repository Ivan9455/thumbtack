// класс Point2D - создание экземпляров и установка полей
package net.thumbtack.lessons;

class Point2D {

    private int x, y;

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

        Point2D point = new Point2D();
        point.setX(100);
        point.setY(50);
        point.moveTo(300, 400);

    }

}
