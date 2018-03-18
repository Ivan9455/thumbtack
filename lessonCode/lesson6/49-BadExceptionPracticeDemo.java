// exception - так делать не надо
package net.thumbtack.lessons;

class ValueReachedException extends Exception {

    public ValueReachedException() {
        super();
    }

}

public class BadExceptionPracticeDemo {

    static int value;

    public static void increaseValue() throws ValueReachedException {
        value++;
        if (value > 5000)
            throw new ValueReachedException();
    }

    public static void main(String[] args) throws Exception {

        // не подавл€йте исключени€
        int x1 = 1, y1 = 0;
        try {
            int z1 = x1 / y1;
        } catch (ArithmeticException e) {
        }

        // не ловите Exception, ловите его subclass
        int x2 = 1, y2 = 0;
        try {
            int z2 = x2 / y2;
        } catch (Exception e) {
            e.printStackTrace();
        }

        // не выбрасывайте Exception, выбрасывайте его subclass

        if (x1 > y1)
            throw new Exception();

        // не используйте исключени€ там, где нет никакой исключительной ситуации
        while (true) {
            try {
                increaseValue();
            } catch (ValueReachedException ex) {
                ex.printStackTrace();
                break;
            }
        }
    }

}
