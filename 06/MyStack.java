public class MyStack<T> {
    private Object[] MyArray;
    private int top_index;

    public MyStack(int n){
        top_index = -1;
        MyArray = new Object[n];
    }

    public MyStack(){
        top_index = -1;
        MyArray = new Object[1];
    }

    public void push(T el){
        if (MyArray.length == top_index + 1){
            MyArray = java.util.Arrays.copyOf(MyArray, MyArray.length * 2);
        }
        MyArray[++top_index] = el;
    }

    public T top() throws RuntimeException{
        if (top_index == -1){
            throw new RuntimeException("ERROR: stack is empty");
        }
        return (T)MyArray[top_index];
    }

    public void pop() throws RuntimeException{
        if (top_index == -1){
            throw new RuntimeException("ERROR: stack is empty");
        }
        top_index--;
    }

    public void print(){
        for (int i = 0; i <= top_index; i++){
            System.out.printf(MyArray[i] + " ");
        }
        System.out.println();
    }

    public int size(){
        return top_index + 1;
    }

    public int capacity(){
        return MyArray.length;
    }

    public boolean isEmpty(){
        return (top_index == -1);
    }

}
