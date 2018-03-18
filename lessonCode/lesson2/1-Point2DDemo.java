// класс Point2D
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

}

public class Point2DDemo {

    public static void main(String[] args) {
        Point2D point = new Point2D();
        point.setX(100);
        point.setY(50);
        System.out.println("point.x = " + point.getX());
        System.out.println("point.y = " + point.getY());

        Point2D point1 = point;

        System.out.println("point1.x = " + point1.getX());
        System.out.println("point1.y = " + point1.getY());

        point = null;
        point1 = null;
        // теперь на созданный выше экземпл€р нет ссылок
        // и он может быть уничтожен сборщиком мусора

    }

}
