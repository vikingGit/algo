package xieed.explore.datastruct.queue;

public class ArrayBasedQueue<T> {
    private T[] array;
    int head;
    int tail;

    T[] getArray() {
        return array;
    }

    public ArrayBasedQueue(int size) {
        this.array = (T[]) new Object[size];
    }

    public void enQueue(T e) {
        if(this.tail == this.array.length){
            if(this.head == 0){
                extendArray();
            }else{
                moveArray();
            }
        }
        this.array[this.tail++]=e;
    }

    private void moveArray() {
        for(int i = this.head; i < this.tail; i++){
            this.array[i- this.head] = this.array[i];
        }
        this.tail -= this.head;
        this.head = 0;
    }

    private void extendArray() {
        T[] extendArray = (T[]) new Object[this.array.length * 2];
        for (int i = 0; i < this.array.length; i++) {
            extendArray[i] = this.array[i];
        }
        this.array = extendArray;
    }


    public int size() {
        return this.tail - this.head;
    }

    public int capacity(){
        return this.array.length;
    }

    public T deQueue() {
        return this.array[this.head++];
    }
}
