package net.thumbtack.lessons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class PrintStreamDemo {

	public static void main(String[] args) {

		int a = 10;
		double d = 1.1234;
		try (PrintStream ps = new PrintStream(new File("default.txt"))) {
			ps.println("Строка");
			ps.println(a);
			ps.printf("Default = %f\r\n", d);
			ps.printf(Locale.ENGLISH, "English = %f\r\n", d);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try (PrintStream ps = new PrintStream(new File("1251.txt"), "CP1251")) {
			ps.println("Строка");
			ps.println(a);
			ps.printf("Default = %f\r\n", d);
			ps.printf(Locale.ENGLISH, "English = %f\r\n", d);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("Output to System.out");
		System.out.printf("Formatted output to System.out default %f\r\n", d);
		System.out.printf(Locale.ENGLISH, "Formatted output to System.out Englsh %f\r\n", d);
		System.err.println("Output to System.err");
		System.err.printf("Formatted output to System.err default %f\r\n", d);
		System.err.printf(Locale.ENGLISH, "Formatted output to System.err Englsh %f\r\n", d);
		
	}

}
