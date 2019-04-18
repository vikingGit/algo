package xieed.algorithm.sort;

/**
 * 快速排序：分治思想，迭代划分区排序，；时间复杂度nlogn；非稳定算法，原地算法，无需额外内存
 */
public class QuickSort {
    public void quickSort(int a[], int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int i = partition(a, startIndex, endIndex);
            quickSort(a, startIndex, i -1);
            quickSort(a, i + 1, endIndex);
        }
    }

    private int partition(int[] a, int startIndex, int endIndex) {
        int focalData = a[endIndex];
        int j = startIndex;
        int i= startIndex;//i永远指向所有比focalData大的数据中的第一个

        while(j<endIndex){
            if(a[j] < focalData){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
            j++;
        }

        int temp = a[i];
        a[i] = a[endIndex];
        a[endIndex] = temp;

        return i;
    }
}
