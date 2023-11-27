import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> _stack = new MyStack<Integer>();
        //попробуем удалить элемент из пустого стека
        try{
            _stack.pop();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        //проверим работу команды isEmpty
        if (_stack.isEmpty()){
            System.out.println("My stack is empty");
        }
        else{
            System.out.println("My stack isn't empty");
        }
        System.out.println();

        //заполним стек случайными элементами
        Random rand = new Random();
        for (int i = 0; i < 10; i++){
            _stack.push(rand.nextInt(100));
        }

        //узнаем размеры стека и содержимое
        System.out.println("The size of my stack is " + _stack.size());
        System.out.println("The capacity of my stack is " + _stack.capacity());
        _stack.print();
        System.out.println();

        //удалим несколько элементов
        for (int i = 0; i < 5; i ++){
            _stack.pop();
        }

        //узнаем размеры стека и содержимое
        System.out.println("The size of my stack is " + _stack.size());
        System.out.println("The capacity of my stack is " + _stack.capacity());
        _stack.print();
        System.out.println();

        System.out.println("The top of my stack is " + _stack.top());
    }
}