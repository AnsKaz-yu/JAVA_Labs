import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String dir = System.getProperty("user.dir"); // каталог запуска

        try {
            Scanner fin = new Scanner(Paths.get(dir, "example.txt"), "UTF-8");
            String final_string = new String();
            while (fin.hasNext()){
                final_string += fin.next() + " ";
            }
            System.out.println(final_string);

        } catch (NoSuchFileException e) {
            System.out.println("Exception 1: " + e);
        } catch (IOException e) {
            System.out.println("Exception 2: " + e);
        } catch (Exception e) {
            System.out.println("Exception 3: " + e);
        }
    }
}