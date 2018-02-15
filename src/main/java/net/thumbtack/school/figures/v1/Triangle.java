package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Triangle {
    private Point2D point1;
    private Point2D point2;
    private Point2D point3;

    public Point2D getPoint1() {
        return point1;
    }

    public void setPoint1(Point2D point1) {
        this.point1 = point1;
    }

    public Point2D getPoint2() {
        return point2;
    }

    public void setPoint2(Point2D point2) {
        this.point2 = point2;
    }

    public Point2D getPoint3() {
        return point3;
    }

    public void setPoint3(Point2D point3) {
        this.point3 = point3;
    }

    public Triangle(Point2D point1, Point2D point2, Point2D point3)
    {
        setPoint1(point1);
        setPoint2(point2);
        setPoint3(point3);
    }
    public double getSide12(){
        return Math.pow(Math.pow(point1.getX() - point2.getX(),2) + Math.pow(point1.getY() - point2.getY(),2),0.5);
    }
    public double getSide13(){
        return Math.pow(Math.pow(point1.getX() - point3.getX(),2) + Math.pow(point1.getY() - point3.getY(),2),0.5);
    }
    public double getSide23(){
        return Math.pow(Math.pow(point2.getX() - point3.getX(),2) + Math.pow(point2.getY() - point3.getY(),2),0.5);
    }
    public void moveRel(int dx, int dy){
        setPoint1(new Point2D(point1.getX() + dx,point1.getY() + dy));
        setPoint2(new Point2D(point2.getX() + dx,point2.getY() + dy));
        setPoint3(new Point2D(point3.getX() + dx,point3.getY() + dy));
    }
    public double getArea(){
        return Math.pow((getPerimeter()/2*(getPerimeter()/2 - getSide12())*(getPerimeter()/2 - getSide13())*(getPerimeter()/2 - getSide23())),0.5);//здесь не должно быть деления онодолжно быть в функции ниже
    }
    public double getPerimeter(){
        return ((getSide12()+ getSide13() + getSide23()));//тут по должно делиться на 2
    }

    public boolean isInside(int x, int y)
    {
        double a = ((point1.getX() - x) * (point2.getY() - point1.getY()) - (point2.getX() - point1.getX()) * (point1.getY() - y));
        double b = ((point2.getX() - x) * (point3.getY() - point2.getY()) - (point3.getX() - point2.getX()) * (point2.getY() - y));
        double c = ((point3.getX() - x) * (point1.getY() - point3.getY()) - (point1.getX() - point3.getX()) * (point3.getY() - y));
        return  ((a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0));
    }
    public boolean isInside(Point2D point){
        double a = ((point1.getX() - point.getX()) * (point2.getY() - point1.getY()) - (point2.getX() - point1.getX()) * (point1.getY() - point.getY()));
        double b = ((point2.getX() - point.getX()) * (point3.getY() - point2.getY()) - (point3.getX() - point2.getX()) * (point2.getY() - point.getY()));
        double c = ((point3.getX() - point.getX()) * (point1.getY() - point3.getY()) - (point1.getX() - point3.getX()) * (point3.getY() - point.getY()));
        return  ((a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(point1, triangle.point1) &&
                Objects.equals(point2, triangle.point2) &&
                Objects.equals(point3, triangle.point3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(point1, point2, point3);
    }
}
