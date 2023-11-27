// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //использование логических операций
        //&& - и
        //|| - или
        //! - не
        int x = 5, y = 12, z = 13;
        boolean d = x < y && !(y + z < x || z + x > y);
        System.out.println("Логическое выражение x < y && !(y + z < x || z + x > y),");
        System.out.println("при x = 5, y = 12, z = 13");
        System.out.println("принимает значение " + d);
        System.out.println();

        //Использование тернарных операций
        System.out.println("При помощи тернарных операций вычислим max(x, y):");
        int max = x > y ? x : y;
        System.out.println("max(x, y) = " + max);
        System.out.println();

        //Использование поразрядных логических операций
        //& - логическое и
        //| - логическое или
        //^ - логическое исключающее или (xor)
        //~ - поразрядный оператор отрицания
        x = 60;
        y = 79;
        System.out.println("Применим логические операции к переменным:");
        System.out.println("x = " + x + " (в двоичной системе счисления " + Integer.toBinaryString(x) + ")");
        System.out.println("y = " + y + " (в двоичной системе счисления " + Integer.toBinaryString(y) + ")");
        System.out.println();

        int result = x & y;
        System.out.println("x & y = " + result + " (в двоичной системе счисления " + Integer.toBinaryString(result) + ")");
        result = x | y;
        System.out.println("x | y = " + result + " (в двоичной системе счисления " + Integer.toBinaryString(result) + ")");
        result = x ^ y;
        System.out.println("x ^ y = " + result + " (в двоичной системе счисления " + Integer.toBinaryString(result) + ")");
        result = ~x;
        System.out.println("~x = " + result + " (в двоичной системе счисления " + Integer.toBinaryString(result) + ")");
        System.out.println();

        //использование операций сдвига
        //>> - побитовый сдвиг вправо (равносилен делению числа нацело на 2)
        //<< - побитовый сдвиг влево (равносилен умножению числа на 2)
        //>>> - беззнаковый побитовый сдвиг вправо (освободившиеся слева n разрядов заполняет не единицами, как оператор >>, а нулями)

        result = x >> 1;
        System.out.println("x >> 1 = " + result + " (в двоичной системе счисления " + Integer.toBinaryString(result) + ")");
        result = x << 1;
        System.out.println("x << 1 = " + result + " (в двоичной системе счисления " + Integer.toBinaryString(result) + ")");
        result = (~x) >> 1;
        System.out.println("(~x) >> 1 = " + result + " (в двоичной системе счисления " + Integer.toBinaryString(result) + ")");
        result = (~x) >>> 1;
        System.out.println("(~x) >>> 1 = " + result + " (в двоичной системе счисления " + Integer.toBinaryString(result) + ")");

    }
}