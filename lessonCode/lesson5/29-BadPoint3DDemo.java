// плохая практика - не делайте так
package net.thumbtack.lessons;

class Point2D {

	int x;
	protected int y;

	public Point2D() {
	}

}

class Point3D extends Point2D {

	private int z;

	public Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

}

public class BadPoint3DDemo {

	public static void main(String[] params) {

		Point3D point3 = new Point3D(10, 20, 30);
		System.out.println(point3.x);

	}

}
