// класс Point3D
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point2D other = (Point2D) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}

class Point3D extends Point2D {

    private int z;

    public Point3D() {
        super();
        z = 40;
    }

    public Point3D(int x, int y) {
        super(x, y);
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void moveTo(int newX, int newY, int newZ) {
        super.moveTo(newX, newY);
        z = newZ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + z;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point3D other = (Point3D) obj;
        if (z != other.z)
            return false;
        return true;
    }
}

public class Point3DDemo {

    public static void print(Point2D pt2) {
        System.out.println("pt2.x = " + pt2.getX() +" pt2.y = " + pt2.getY());
    }

    public static void print(Point3D pt3) {
        System.out.println("pt3.x = " + pt3.getX() +" pt3.y = " + pt3.getY()+ " pt3.z = " + pt3.getZ());
    }

    public static void main(String[] params) {

        Point2D pt2 = new Point2D(10,20);
        print(pt2);

        Point3D pt3 = new Point3D(100, 200, 300);
        print(pt3);

        pt3.moveTo(10,20,30);
        print(pt3);

        pt3.moveTo(100,200);
        print(pt3);

        Point2D p2 = pt3;
        p2.moveTo(300,  400);
        print(pt3);

    }

}
