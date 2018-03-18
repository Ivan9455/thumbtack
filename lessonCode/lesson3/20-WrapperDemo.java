package net.thumbtack.lessons;
// оболочки


import java.math.BigDecimal;
import java.math.BigInteger;


public class WrapperDemo {

    public static void main(String[] args) {

        int j1 = 10;
        int j2 = 10;
        j2++;
        System.out.println(j2);
        int j3 = j2 + j1;
        System.out.println(j3);

        Integer i1 = new Integer(10); // boxing 10 into new i1
        Integer i2 = 10;  // boxing 10 into new i2
        i2++; // unboxing from i2 , incrementing and boxing incremented value into new i2
        System.out.println(i2); 
        Integer i3 = i2 + i1; // unboxing from i2 , unboxing from i1 , calculating sum and boxing it into new i3 
        System.out.println(i3); 

        int i = i1.intValue();
        Integer i4 = Integer.parseInt("888");
        System.out.println(i4);
        Float f = Float.parseFloat("888.8");
        System.out.println(f);
        Double d = Double.parseDouble("888.8");
        System.out.println(d);

        BigInteger bi = new BigInteger("555555555555555555555555555555555555555555555555555555555555555555555555555555");
        System.out.println(bi);

        BigDecimal bd = new BigDecimal("8888888888888888888888888888888888888888888888888888888888888888888888888888.8888E5000");
        System.out.println(bd);

        BigDecimal sum = bd.add(new BigDecimal(bi));
        System.out.println(sum);
    }

}
