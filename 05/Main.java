// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //общее количество аргументов
        System.out.println("Общее количество аргументов: " + args.length);

        // итерация по массиву args для вывода аргументов, если они доступны
        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент" + i + ": " + args[i]);
        }
    }
}