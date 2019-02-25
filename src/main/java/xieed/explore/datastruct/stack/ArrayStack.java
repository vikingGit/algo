package xieed.explore.datastruct.stack;

public class ArrayStack{

  int elemets[];
  int head;
  int tail;
  public ArrayStack(int size) {
    elemets = new int[size];
  }

  public boolean push(int element) {
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

  public int pop() {
    if(this.head > 0){
      return this.elemets[--head];
    }

    return 0;
  }
}
