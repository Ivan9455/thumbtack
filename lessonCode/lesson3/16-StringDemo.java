// строки
package net.thumbtack.lessons;


public class StringDemo {

    public static void main(String[] args) {
        String s1 = new String("888");
        String s2 = "888";
        String s3 = "888";
        if(s2 == s3)
            System.out.println("Equal");
        else
            System.out.println("Not equal");
        if(s1 == s2)
            System.out.println("Equal");
        else
            System.out.println("Not equal");
        if(s1.equals(s3))
            System.out.println("Equal");
        else
            System.out.println("Not equal");
    }

}
