package xieed.explore.datastruct.stack;

public class ArrayStack<T>{

  T elemets[];
  int head;
  public ArrayStack(int size) {
    elemets = (T[])new Object[size];
  }

  public boolean push(T element) {
    if (head == elemets.length) {
      for (int i = 0; i < elemets.length - 1; i++) {
        elemets[i] = elemets[i + 1];
      }
      elemets[head - 1] = element;
    } else {
      this.elemets[head++] = element;
    }
    return true;
  }

  public int size() {
    return this.head;
  }

  public T pop() {
    if(this.head > 0){
      return this.elemets[--head];
    }

    return null;
  }

  public T peek() {
    if(this.head > 0){
      return this.elemets[head - 1];
    }

    return null;
  }
}
