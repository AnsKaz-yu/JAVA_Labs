import java.util.Random;
class TestClass{
    private final Integer _int;
    private final String _str;
    private final Boolean _bool;

    public TestClass(Integer i, String s, Boolean b){
        _int = i;
        _str = s;
        _bool = b;
    }

    public void print(){
        System.out.println(_int + " " + _str + " " + _bool);
    }
}

public class Main {
    static <T> void swap (T x, T y) {
        try {
            java.lang.reflect.Field[] fields = x.getClass().getDeclaredFields();
            for (java.lang.reflect.Field field : fields) {
                field.setAccessible(true);
                Object help = field.get(x);
                field.set(x, field.get(y));
                field.set(y, help);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        TestClass First = new TestClass(5, "magic", true);
        TestClass Second = new TestClass(2, "physics", false);

        System.out.println("First:");
        First.print();
        System.out.println("Second:");
        Second.print();

        System.out.println("\nSwapping...\n");
        swap(First, Second);

        System.out.println("First:");
        First.print();
        System.out.println("Second:");
        Second.print();
    }
}