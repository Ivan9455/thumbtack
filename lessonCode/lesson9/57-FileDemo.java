// перед выполнением этого примера создайте каталог C:\\1 и в нем файл 1.dat и удалите каталог C:\\2, если он существует
package net.thumbtack.lessons;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) {

        File f1 = new File("C:/1/1.dat");
        String absolutePathF1 = f1.getAbsolutePath();
        System.out.println(absolutePathF1);

        File f2 = new File("Z:\\1", "2.dat");
        String absolutePathF2 = f2.getAbsolutePath();
        System.out.println(absolutePathF2);

        File f3 = new File(f1.getParent(),"3.dat");
        String absolutePathF3 = f3.getAbsolutePath();
        System.out.println(absolutePathF3);

        File f4 = new File("4.dat");
        String absolutePathF4 = f4.getAbsolutePath();
        System.out.println(absolutePathF4);

        boolean existsF1 = f1.exists();
        System.out.println("f1 exists: " + existsF1);

        boolean isFileF1 = f1.isFile();
        System.out.println("f1 is file: " + isFileF1);

        boolean isDirectoryF1 = f1.isDirectory();
        System.out.println("f1 is directory: " + isDirectoryF1);

        File f5 = new File("C:/1");
        boolean isDirectoryF5 = f5.isDirectory();
        System.out.println("f5 is directory: " + isDirectoryF5);

        File fNewDir = new File("C:/123");
        boolean result = fNewDir.mkdir();
        System.out.println("C:/123 created : " + result);
        boolean isDirectoryFNewDir = fNewDir.isDirectory();
        System.out.println("fNewDir is directory: " + isDirectoryFNewDir);

        File fNewDirMulti = new File("C:/2/3/4");
        boolean resultMulty = fNewDirMulti.mkdirs();
        System.out.println("C:/2/3/4 created : " + resultMulty);

        File fWrongName = new File("CC:/1.dat");
        String absolutePathWrongName = fWrongName.getAbsolutePath();
        System.out.println(absolutePathWrongName);

        try {
            String absolutePathWrongNameCanonical = fWrongName.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
