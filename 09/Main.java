import java.lang.reflect.*;

class MyClass{
    public MyClass(){
        System.out.println("An instance of the class has been created");
    }
    public void sayHello(){
        System.out.println("Hello world!");
    }
}

public class Main {
    public static void createClassAndCallFunction(String clsName, String methodName){
        try{
            Class<?> cls = Class.forName(clsName);
            Constructor<?> constructor = cls.getConstructor();
            Object myClassObject = constructor.newInstance();
            Method method = cls.getMethod(methodName);
            method.invoke(myClassObject);

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) {
        createClassAndCallFunction("MyClass", "sayHello");
    }
}