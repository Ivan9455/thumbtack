package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Circle {
    private Point2D center;
    private int radius;

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


    public Circle(Point2D center, int raduis){
        setCenter(center);
        setRadius(raduis);
    }


    public Circle(int xCenter, int yCenter, int radius){
        this(new Point2D(xCenter, yCenter),radius);
    }

    public Circle(int radius){
        this(new Point2D(),radius);
    }

    public Circle(){
        this(new Point2D(),1);
    }

    public void moveRel(int dx, int dy){
        setCenter(new Point2D(center.getX() + dx,center.getY() + dy));
    }

    public void enlarge(int n){
        setRadius(radius*n);
    }

    public double getArea(){
        return Math.PI*Math.pow(radius,2);
    }

    public double getPerimeter(){
        return 2*Math.PI*getRadius();
    }

    public boolean isInside(int x, int y){
        return getRadius()>=Math.pow((center.getX() - x)*(center.getX() -  x) +(center.getY() - y)*(center.getY() - y),0.5);
    }

    public boolean isInside(Point2D point){
        return getRadius()>=Math.pow((center.getX() - point.getX())*(center.getX() -  point.getX()) +(center.getY() - point.getY())*(center.getY() - point.getY()),0.5);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius &&
                Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}

