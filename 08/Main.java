import java.lang.reflect.*;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void Information(Class<?> cls){
        System.out.println("Package name: " + cls.getPackage().getName());
        System.out.println("Class name: " + cls.getName());
        System.out.println();

        System.out.println("This class fields:");
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field " + field.getName() + " has type " + field.getType().getName());
        }
        System.out.println();

        System.out.println("This class constructors:");
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.print("  " + constructor.getName() + "(");
            Parameter[] parameters = constructor.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                System.out.print(parameters[i].getType().getName() + " " + parameters[i].getName());
                if (i < parameters.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }
        System.out.println();

        System.out.println("This class methods:");
        Method[] methods = cls.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.print("  " + method.getReturnType().getName() + " " + method.getName() + "(");
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                System.out.print(parameters[i].getType().getName() + " " + parameters[i].getName());
                if (i < parameters.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Information(Stack.class);
    }
}
