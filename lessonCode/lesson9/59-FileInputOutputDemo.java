package net.thumbtack.lessons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputDemo {

	public static void main(String[] args) {

		final int SIZE = 10;
		try (FileOutputStream fos = new FileOutputStream(new File("1.dat")))
		{
			for (int i = 0; i < SIZE; i++)
				fos.write(i);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		try (FileInputStream fis = new FileInputStream(new File("1.dat"))) {
			byte[] array1 = new byte[3];
			byte[] array2 = new byte[4];
			fis.read(array1);
			for(int a : array1)
				System.out.print(a + " ");
			System.out.println();
			fis.skip(3);
			fis.read(array2);
			for(int a : array2)
				System.out.print(a + " ");
			System.out.println();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}

}
