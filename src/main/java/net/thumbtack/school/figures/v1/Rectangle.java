package net.thumbtack.school.figures.v1;


import java.util.Objects;

public class Rectangle {
    //переменные
    private Point2D topLeft, bottomRight;

    public int getLength() {
        return Math.abs(topLeft.getX()-bottomRight.getX());
    }

    public int getWidth() {
        return Math.abs(topLeft.getY()-bottomRight.getY());
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

    public Rectangle(Point2D leftTop, Point2D rightBottom){
        setTopLeft(leftTop);
        setBottomRight(rightBottom);
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom){
        setTopLeft(new Point2D(xLeft, yTop));
        setBottomRight(new Point2D(xRight, yBottom));
    }

    public Rectangle(int lengthR, int width){
        setTopLeft(new Point2D(0,-width));
        setBottomRight(new Point2D(lengthR,0));
    }

    public Rectangle(){
        setTopLeft(new Point2D(0,-1));
        setBottomRight(new Point2D(1,0));
    }

    public void moveRel(int dx, int dy){
        topLeft.moveRel(dx,dy);
        bottomRight.moveRel(dx,dy);
    }

    public void enlarge(int nx, int ny){
        bottomRight.moveTo(
                (bottomRight.getX() - topLeft.getX()) * nx + topLeft.getX(),
                (bottomRight.getY() - topLeft.getY()) * ny + topLeft.getY());
    }

    public double getArea(){
        return (bottomRight.getX() - topLeft.getX())*(bottomRight.getY() - topLeft.getY());
    }
    public double getPerimeter(){

        return 2*((bottomRight.getX() - topLeft.getX()) + (bottomRight.getY() - topLeft.getY()));
    }

    public boolean isInside(int x, int y)
    {
        return  (topLeft.getX() <= x && bottomRight.getX() >= x)&&
                (topLeft.getY() <= y && bottomRight.getY() >= y);
    }

    public boolean isInside(Point2D point){
        return  (topLeft.getX() <= point.getX() && bottomRight.getX() >= point.getX())&&
                (topLeft.getY() <= point.getY() && bottomRight.getY() >= point.getY());
    }

    public boolean isIntersects(Rectangle rectangle){
        return
                isInside(rectangle)||
                ((this.topLeft.getX()>=rectangle.topLeft.getX())&&
                (this.bottomRight.getX()<=rectangle.bottomRight.getX())&&
                (this.topLeft.getY()>=rectangle.topLeft.getY())&&
                (this.bottomRight.getY()<=rectangle.bottomRight.getY()));
    }
    public boolean isInside(Rectangle rectangle)
    {
        return
                (isInside(rectangle.topLeft.getX(),rectangle.topLeft.getY())||
                isInside(rectangle.topLeft.getX(),rectangle.bottomRight.getY()))||
                isInside(rectangle.bottomRight.getX(),rectangle.topLeft.getY())||
                isInside(rectangle.bottomRight.getX(),rectangle.bottomRight.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return
                Objects.equals(topLeft, rectangle.topLeft) &&
                Objects.equals(bottomRight, rectangle.bottomRight);
    }

    @Override
    public int hashCode() {

        return Objects.hash(topLeft, bottomRight);
    }


}
