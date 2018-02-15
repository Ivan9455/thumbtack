package net.thumbtack.school.figures.v1;

public class CircleFactory {
    private static  int CIRCLE_COUN = 0;
    public static Circle createCircle(Point2D center, int radius){
        CIRCLE_COUN++;
        return new Circle(center,radius);
    }
    public static int getCircleCount(){
        return CIRCLE_COUN;
    }

    public static void reset(){
         CIRCLE_COUN = 0 ;
    }
}
