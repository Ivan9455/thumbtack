public class FileInputOutputDemo {

	public static void main(String[] args) {

		FileOutputStream fos = null;
		FileInputStream fis = null;
		final int SIZE = 10;
		try {
			fos = new FileOutputStream(new File("1.dat"));
			for (int i = 0; i < SIZE; i++)
				fos.write(i);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			fis = new FileInputStream(new File("1.dat"));
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
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}