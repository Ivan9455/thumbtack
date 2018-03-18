package net.thumbtack.lessons;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayInputOutputDemo {

	public static void main(String[] args) {

		byte[] byteArray = null;
		final int SIZE = 10;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			for (int i = 0; i < SIZE; i++)
				baos.write(i);
			byteArray = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (ByteArrayInputStream bais = new ByteArrayInputStream(byteArray)) {
			byte[] array1 = new byte[3];
			byte[] array2 = new byte[4];
			bais.read(array1);
			for(int a : array1)
				System.out.print(a + " ");
			System.out.println();
			bais.skip(3);
			bais.read(array2);
			for(int a : array2)
				System.out.print(a + " ");
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
