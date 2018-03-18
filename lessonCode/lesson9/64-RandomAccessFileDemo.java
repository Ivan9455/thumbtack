package net.thumbtack.lessons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

    public static void main(String[] args) {

        int x = 10;
        float f = 3.15f;
        double d = 10.5;
        int y = 12;
        try (RandomAccessFile raf = new RandomAccessFile(new File("1.dat"), "rw"))
        {
            // offset = 0
            raf.writeInt(x);
            // offset = 4;
            raf.writeFloat(f);
            // offset = 8;
            raf.writeDouble(d);
            // offset = 16
            raf.writeInt(y);

            raf.seek(16);
            int y1 = raf.readInt();
            System.out.println(y1);

            raf.seek(8);
            double d1 = raf.readDouble();
            System.out.println(d1);

            raf.seek(0);
            int x1 = raf.readInt();
            System.out.println(y1);

            float f1 = raf.readFloat();
            System.out.println(f1);

            raf.seek(8);
            double d2 = 12.45;
            raf.writeDouble(d2);
            raf.seek(8);
            double d3 = raf.readDouble();
            System.out.println(d3);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
