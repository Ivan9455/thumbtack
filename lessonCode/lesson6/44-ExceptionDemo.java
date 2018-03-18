// класс Point2D - сравнение
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

public class ExceptionDemo {

	public static void print(Point2D pt2) {
		if (pt2 != null)
			System.out.println("pt2.x = " + pt2.getX() + " pt2.y = " + pt2.getY());
		else
			throw new NullPointerException("pt2 is null");
	}

	public static void main(String[] args) {

		Point2D point1 = new Point2D(100, 200);
		Point2D point2 = null;

		try {
			print(point1);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

		try {
			print(point2);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}

}
