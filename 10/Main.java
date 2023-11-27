// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Triple<T>{
    public T first;
    public T second;
    public T third;

    public Triple(T f, T s, T t){
        first = f;
        second = s;
        third = t;
    }
    public Triple(){
        first = null;
        second = null;
        third = null;
    }

    T min(){
        if (!(first instanceof Comparable)){
            throw new RuntimeException("Impossible to perform min");
        }
        T answer = first;
        if (((Comparable) second).compareTo(answer) < 0){
            answer = second;
        }
        if (((Comparable) third).compareTo(answer) < 0){
            answer = third;
        }
        return answer;
    }

    T max(){
        if (!(first instanceof Comparable)){
            throw new RuntimeException("Impossible to perform min");
        }
        T answer = first;
        if (((Comparable) second).compareTo(answer) > 0){
            answer = second;
        }
        if (((Comparable) third).compareTo(answer) > 0){
            answer = third;
        }
        return answer;
    }

    double mean(){
        if (first instanceof Number) {
            return (((Number) first).doubleValue() + ((Number) second).doubleValue() + ((Number) third).doubleValue()) / 3;
        } else {
            throw new RuntimeException("Impossible to perform mean");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Triple<Integer> _triple = new Triple<>(10, 23, 4);
        System.out.println("min = " + _triple.min());
        System.out.println("max = " + _triple.max());
        System.out.println("mean = " + _triple.mean());
    }
}