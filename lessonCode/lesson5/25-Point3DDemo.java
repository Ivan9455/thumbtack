// анонимный класс
package net.thumbtack.lessons;

class Point2D {

    private int x, y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
        x = 20;
        y = 30;
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

    public void moveTo(int newX, int newY) {
        super.moveTo(newX, newY);
        z = 1000;
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

class Parallelepiped extends Point3D {
    public Parallelepiped(int x, int y, int z) {
        super(x, y, z);
    }

    public int getVolume() {
        return getX() * getY() * getZ();
    }
}

public class Point3DDemo {

    public static void main(String[] params) {

        Parallelepiped parallelepiped = new Parallelepiped(10,20,30);
        int volume = parallelepiped.getVolume();
        System.out.println(volume);

        int vol = new Point3D(10,20,30) {
            int getVolume() {
                return getX() * getY() * getZ();
            }
        }.getVolume();

        System.out.println(vol);

    }

}
