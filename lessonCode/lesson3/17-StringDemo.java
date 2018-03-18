// строки
package net.thumbtack.lessons;


public class StringDemo {

    public static void main(String[] args) {
        String s1 = "Hello, World";

        String s2 = s1.substring(7);
        System.out.println(s2);

        String s3 = s1.substring(0,5);
        System.out.println(s3);

        char c = s1.charAt(5);
        System.out.println(c);

        String s4 = "Test";
        String s5 = "Hello";

        if(s4.compareTo(s1) > 0)
            System.out.println("s4 > s1");

        if(s5.compareTo(s1) < 0)
            System.out.println("s5 < s1");

        String s6 = s1 + " " + s4;
        System.out.println(s6);

        String s7 = s1.concat(" ").concat(s4);
        System.out.println(s7);

        if(s1.startsWith("Hello"))
            System.out.println("s1 starts with Hello");

        if(s1.endsWith("World"))
            System.out.println("s1 ends with World");

        int posChar = s1.indexOf('o');
        if( posChar > 0)
            System.out.println("s1 contains o at pos = " + posChar);

        int endPosChar = s1.lastIndexOf('o');
        if( endPosChar > 0)
            System.out.println("s1 contains last o at pos = " + endPosChar);

        String s8 = s1 + " " + s1;
        System.out.println(s8);

        int posString = s8.indexOf("World");
        if( posString > 0)
            System.out.println("s1 contains \"World\" at pos = " + posString);

        int endPosString = s8.lastIndexOf("World");
        if( endPosString > 0)
            System.out.println("s1 contains last \"World\" at pos = " + endPosString);

        String s9 = s1.replace('o', 'u');
        System.out.println(s9);


    }

}
