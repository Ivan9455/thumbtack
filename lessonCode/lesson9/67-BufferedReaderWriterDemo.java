package net.thumbtack.lessons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

public class BufferedReaderWriterDemo {

    private static void writeAndReadUsingSpecificCharset(String hw1, String hw2, String fileName, String charsetName) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName)),charsetName))) {
            bw.write(hw1);
            bw.newLine();
            bw.write(hw2);
            bw.newLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName)),charsetName))) {
            String str = br.readLine();
            System.out.println(str);
            str = br.readLine();
            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeAndReadUsingDefaultCharset(String hw1, String hw2, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("default.txt")))) {
            bw.write(hw1);
            bw.newLine();
            bw.write(hw2);
            bw.newLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(new File("default.txt")))) {
            String str = br.readLine();
            System.out.println(str);
            str = br.readLine();
            System.out.println(str);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String hw1 = "Hello, World";
        String hw2 = "Привет, мир";

        writeAndReadUsingSpecificCharset(hw1, hw2, "utf8.txt" ,"UTF-8");
        writeAndReadUsingSpecificCharset(hw1, hw2, "866.txt" ,"CP866");
        writeAndReadUsingSpecificCharset(hw1, hw2, "1251.txt" ,"CP1251");
        writeAndReadUsingSpecificCharset(hw1, hw2, "koi8.txt" ,"KOI8-R");

        writeAndReadUsingDefaultCharset(hw1, hw2, "default.txt");
    }


}
