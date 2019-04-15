package xieed.explore.datastruct.queue;

public class CircularQueue<T> {
    T[] array;
    int capacity;
    int head;
    int tail;

    public CircularQueue(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(T i) {
        if((tail + 1)%capacity == head){
            return false;
        }
        this.array[tail]=i;
        this.tail=(tail + 1)%capacity;
        return true;
    }

    public T[] getArray() {
        return array;
    }

    public T dequeue() {
        if(tail == head){
            return null;
        }
        T t = this.array[head];
        this.head = (head + 1)%capacity;
        return t;

    }
}
