package xieed.algorithm.sort;

public class CountSort {
    void countSort(int[] a){
        int maxValue = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                maxValue = a[i + 1];
            }
        }

        int[] countArrays = new int[maxValue+1];
        for(int i=0; i<a.length; i++){
            countArrays[a[i]]++;
        }

        for(int i=1; i<countArrays.length; i++){
            countArrays[i] += countArrays[i-1];
        }

        int[] temp=new int[a.length];
        for(int i=0; i<a.length; i++){
          int index = countArrays[a[i]] - 1;
          temp[index]=a[i];
          countArrays[a[i]]= index;
        }

        for(int i=0; i<a.length; i++){
            a[i] = temp[i];
        }

    }
}
