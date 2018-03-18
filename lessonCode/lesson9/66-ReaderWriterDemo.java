package net.thumbtack.lessons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class ReaderWriterDemo {

    private static void writeAndReadUsingSpecificCharset(String hw, String fileName, String charsetName) {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File(fileName)),charsetName)) {
            osw.write(hw);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(fileName)),charsetName)) {
            char[] buf = new char[hw.length()];
            isr.read(buf);
            for(char c : buf)
                System.out.print(c);
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeAndReadUsingDefaultCharset(String hw, String fileName) {
        try (FileWriter fw = new FileWriter(new File(fileName))) {
            fw.write(hw);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try (FileReader fr = new FileReader(new File(fileName))) {
            char[] buf = new char[hw.length()];
            fr.read(buf);
            for(char c : buf)
                System.out.print(c);
            System.out.println();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String hw = "Hello, World\r\nПривет, мир\r\n";

        writeAndReadUsingSpecificCharset(hw, "utf8.txt" ,"UTF-8");
        writeAndReadUsingSpecificCharset(hw, "866.txt" ,"CP866");
        writeAndReadUsingSpecificCharset(hw, "1251.txt" ,"CP1251");
        writeAndReadUsingSpecificCharset(hw, "koi8.txt" ,"KOI8-R");

        writeAndReadUsingDefaultCharset(hw, "default.txt");

    }


}
