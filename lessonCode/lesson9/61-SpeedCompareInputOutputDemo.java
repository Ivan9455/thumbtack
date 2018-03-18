package net.thumbtack.lessons;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SpeedCompareInputOutputDemo {

	private static void nonBufferringDemo() {
		final int SIZE = 100000;
		long timeStart, timeEnd;
		try (FileOutputStream fos = new FileOutputStream(new File("1.dat"))) {
			timeStart = System.nanoTime();
			for(int i = 0; i < SIZE; i++)
				fos.write(i);
			timeEnd = System.nanoTime();
			System.out.println("NonBuffering Write Time = " + TimeUnit.NANOSECONDS.toMillis(timeEnd - timeStart));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(FileInputStream fis = new FileInputStream(new File("1.dat"))) {
			timeStart = System.nanoTime();
			for(int i = 0; i < SIZE; i++) {
				byte b = (byte)fis.read();
			}
			timeEnd = System.nanoTime();
			System.out.println("NonBuffering Read Time = " + TimeUnit.NANOSECONDS.toMillis(timeEnd - timeStart));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void bufferingDemo() {
		final int SIZE = 100000;
		long timeStart, timeEnd;
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("2.dat")))) {
			timeStart = System.nanoTime();
			for(int i = 0; i < SIZE; i++)
				bos.write(i);
			timeEnd = System.nanoTime();
			System.out.println("Buffering Write Time = " + TimeUnit.NANOSECONDS.toMillis(timeEnd - timeStart));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("2.dat")))) {
			timeStart = System.nanoTime();
			for(int i = 0; i < SIZE; i++) {
				byte b = (byte)bis.read();
			}
			timeEnd = System.nanoTime();
			System.out.println("Buffering Read Time = " + TimeUnit.NANOSECONDS.toMillis(timeEnd - timeStart));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		nonBufferringDemo();
		bufferingDemo();
	}

}
