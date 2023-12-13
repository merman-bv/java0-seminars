import java.util.LinkedList;

public class MyQueue <T> {
    private T element;
    private LinkedList<T> myCrowd = new LinkedList<>();
    public void enqueue(T element){
        // Напишите свое решение ниже
        myCrowd.add(element);
    }

    public T dequeue(){
        // Напишите свое решение ниже
        T buff = myCrowd.getFirst();
        myCrowd.removeFirst();
        return buff;

    }

    public T first(){
        // Напишите свое решение ниже
        return myCrowd.getFirst();
    }

    public LinkedList<T> getElements() {
        // Напишите свое решение ниже

        return myCrowd;
    }

} // --- Окончание класса
