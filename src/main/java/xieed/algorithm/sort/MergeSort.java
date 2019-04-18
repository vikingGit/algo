package xieed.algorithm.sort;

/**
 * 归并排序：分治思想，迭代分组，最后按大小顺序迭代合并；时间复杂度nlogn；稳定算法，非原地算法，需要O(n)内存进行合并
 */
public class MergeSort {

    public void mergeSort(int[] a, int startIndex, int endIndex) {
        if (endIndex > startIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            mergeSort(a, startIndex, midIndex);
            mergeSort(a, midIndex + 1, endIndex);
            merge(a, startIndex, midIndex, endIndex);
        }
    }

    private void merge(int[] a, int startIndex, int midIndex, int endIndex) {
        int s = startIndex;
        int m = midIndex + 1;
        int[] temp = new int[endIndex - startIndex + 1];
        int i = 0;
        while (s <= midIndex && m <= endIndex) {
            if (a[s] < a[m]) {
                temp[i++] = a[s++];
            } else {
                temp[i++] = a[m++];
            }
        }

        while (s <= midIndex) {
            temp[i++] = a[s++];
        }

        while (m <= endIndex) {
            temp[i++] = a[m++];
        }

        for (int j = 0; j < temp.length; j++) {
            a[startIndex++] = temp[j];
        }
    }
}
