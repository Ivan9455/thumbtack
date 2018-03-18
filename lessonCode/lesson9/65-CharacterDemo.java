package net.thumbtack.lessons;

public class CharacterDemo {

    public static void main(String[] args) {

        for (char character = '0'; character <= '9'; character++)
            System.out.print("   " + Character.toString(character));
        System.out.println();
        for (char character = '0'; character <= '9'; character++)
            System.out.print("  " + Integer.toHexString(character));
        System.out.println();


        for (char character = 'A'; character <= 'Z'; character++)
            System.out.print("   " + Character.toString(character));
        System.out.println();
        for (char character = 'A'; character <= 'Z'; character++)
            System.out.print("  " + Integer.toHexString(character));
        System.out.println();

        for (char character = 'a'; character <= 'z'; character++)
            System.out.print("   " + Character.toString(character));
        System.out.println();
        for (char character = 'a'; character <= 'z'; character++)
            System.out.print("  " + Integer.toHexString(character));
        System.out.println();

        for (char character = 'А'; character <= 'Я'; character++)
            System.out.print("   " + Character.toString(character));
        System.out.println();
        for (char character = 'А'; character <= 'Я'; character++)
            System.out.print(" " + Integer.toHexString(character));
        System.out.println();

        for (char character = 'а'; character <= 'я'; character++)
            System.out.print("   " + Character.toString(character));
        System.out.println();
        for (char character = 'а'; character <= 'я'; character++)
            System.out.print(" " + Integer.toHexString(character));
        System.out.println();

    }
}
