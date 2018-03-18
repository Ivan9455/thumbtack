// строки
package net.thumbtack.lessons;


public class StringBuilderDemo {

    public static void main(String[] args) {
        String[] stringArray = {"Hello,", " ", "World", ", " ,"I", " " ,"like", " ", "you", "."};
        StringBuilder sb = new StringBuilder();
        for(String elem : stringArray) {
            sb.append(elem);
        }
        String fullString = sb.toString();
        System.out.println(fullString);

        sb.insert(7, "my ");
        fullString = sb.toString();
        System.out.println(fullString);

        sb.delete(7, 10);
        fullString = sb.toString();
        System.out.println(fullString);

    }

}
