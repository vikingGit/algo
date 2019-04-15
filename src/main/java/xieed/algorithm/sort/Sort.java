package xieed.algorithm.sort;

public class Sort {
  //O(N),O(N平方)，O(N平方)
  public void bubbleSort(int[] numbers) {
    for (int i=0; i<numbers.length; i++){
      boolean noChanged = true;
      for(int j=0; j<numbers.length-i-1; j++){
        if(numbers[j] > numbers[j+1]){
          noChanged = false;
          int temp = numbers[j];
          numbers[j] = numbers[j+1];
          numbers[j+1]=temp;
        }
      }
      if(noChanged){
        return;
      }
    }
  }


  /**
   * 插入排序 从头到尾比较,数据交换次数和insertSort1一样，但是比较次数会可能会更多
   * 例如：1234638， 当开始插入6的时候，从尾到头则分别要和1,2,3,4比较，而从尾到头（insertSort1）则只需要和4比较
   * @param numbers
   */
  ////O(N),O(N平方)，O(N平方)
  public void insertSort(int[] numbers){
    for (int i = 1; i < numbers.length ; i++){
      int value = numbers[i];
      for(int j = 0; j < i; j++){
        if(value < numbers[j]) {
          for (int z = i; z > j; z--) {
            numbers[z] = numbers[z - 1];
          }
          numbers[j] = value;
          break;
        }
      }
    }
  }

  // 插入排序 从尾到头比较
  ////O(N),O(N平方)，O(N平方)
  public void insertSort1(int[] a) {
    if (a.length <= 1) return;

    for (int i = 1; i < a.length; ++i) {
      int value = a[i];
      int j = i - 1;
      // 查找插入的位置
      for (; j >= 0; --j) {
        if (a[j] > value) {
          a[j+1] = a[j];  // 数据移动
        } else {
          break;
        }
      }
      a[j+1] = value; // 插入数据
    }
  }

  //选择排序也分排序区和未排序区,但选择排序是每次找到剩余未排序中最小值，再放到已经排序区域后面。而选择排序是不找未排序中最小的，只是把未排序中当前的元素插入到排序区中正确的位置
  //O(N平方),O(N平方)，O(N平方)
  public void selectSort(int[] a){
    if(a.length <= 1){
      return;
    }

    int minIndex;
    for(int i = 0; i <a.length; i++){
      minIndex=i;
      for(int j = i; j<a.length-1; j++){
        if(a[j+1]<minIndex){
          minIndex= j+1;
        }
      }

      int temp = a[i];
      a[i] = a[minIndex];
      a[minIndex] = temp;
    }
  }
}
