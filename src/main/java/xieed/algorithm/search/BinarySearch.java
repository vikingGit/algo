package xieed.algorithm.search;

@SuppressWarnings("Duplicates")
public class BinarySearch {

    public int binarySearch(int[] a, int value){
        int startIndex = 0;
        int endIndex = a.length - 1;
        int midFloorIndex = 0;
        int midCeilIndex = 0;
        while(startIndex <= a.length - 1 && endIndex >= 0){
            midFloorIndex = (int) Math.floor((endIndex - startIndex)/2.0)+ startIndex;
            midCeilIndex = (int) Math.ceil((endIndex - startIndex)/2.0) + startIndex;
            if(a[midFloorIndex] > value){
                endIndex = midFloorIndex - 1;
            }else if(a[midFloorIndex] < value){
                if(a[midCeilIndex] == value){
                    return midCeilIndex;
                }
                startIndex = midCeilIndex + 1;
            }else{
                return midFloorIndex;
            }
        }
        return -1;
    }

    //答案：不需要用到两个index:midFloorIndex,midCeilIndex
//    public int bsearch(int[] a, int n, int value) {
//        int low = 0;
//        int high = n - 1;
//
//        while (low <= high) {
//            int mid = (low + high) / 2; //为如果 low 和 high 比较大的话，两者之和就有可能会溢出，可以写成low+(high-low)/2
//            if (a[mid] == value) {
//                return mid;
//            } else if (a[mid] < value) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//
//        return -1;
//    }


    public int binarySearchViaRecursion(int[] a, int value, int startIndex, int endIndex){
        if(startIndex > a.length -1 || endIndex < 0){
            return -1;
        }
        int midFloorIndex = (int) Math.floor((endIndex - startIndex)/2.0)+ startIndex;
        int midCeilIndex = (int) Math.ceil((endIndex - startIndex)/2.0) + startIndex;
        if(a[midFloorIndex] > value){
            endIndex = midFloorIndex - 1;
        }else if(a[midFloorIndex] < value){
            if(a[midCeilIndex] == value){
                return midCeilIndex;
            }
            startIndex = midCeilIndex + 1;
        }else{
            return midFloorIndex;
        }

       return  binarySearchViaRecursion(a, value, startIndex, endIndex);
    }
}
