package net.thumbtack.lessons;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputDemo {

    public static void main(String[] args) {

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("1.dat"))))
        {
            int x = 5;
            float f = 12.34f;
            double d = 135.67;
            dos.writeInt(x);
            dos.writeFloat(f);
            dos.writeDouble(d);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (DataInputStream dis = new DataInputStream(new FileInputStream(new File("1.dat")))) {
            int x = dis.readInt();
            System.out.println(x);
            float f = dis.readFloat();
            System.out.println(f);
            double d = dis.readDouble();
            System.out.println(d);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
