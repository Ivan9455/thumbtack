package net.thumbtack.lessons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class PrintStreamDemo {

	public static void main(String[] args) {

		int a = 10;
		double d = 1.1234;
		try (PrintWriter pw = new PrintWriter(new File("default.txt"))) {
			pw.println("Строка");
			pw.println(a);
			pw.printf("Default = %f\r\n", d);
			pw.printf(Locale.ENGLISH, "English = %f\r\n", d);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try (PrintWriter pw = new PrintWriter(new File("1251.txt"), "CP1251")) {
			pw.println("Строка");
			pw.println(a);
			pw.printf("Default = %f\r\n", d);
			pw.printf(Locale.ENGLISH, "English = %f\r\n", d);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
	}

}
