package xieed.algorithm.MapReduce;

public class MapReducer {
    //求逆序度
    public int countReversePair(int[] data, int start, int end){
        if(start >= end){
            return 0;
        }
        int middle = (end + start)/2;
        int leftEnd = middle;
        int rightStart = middle+1;
        int reversePair = 0;
        reversePair+=countReversePair(data, start,leftEnd);
        reversePair+=countReversePair(data, rightStart, end);

        reversePair+= mergeCountReverse(data, start, leftEnd, rightStart, end);
        return reversePair;
    }

    private int mergeCountReverse(int[] data, int start, int leftEnd, int rightStart, int end) {
        int i  =start;
        int j = rightStart;
        int reversePair = 0;
        int[] temp = new int[end - start + 1];
        int tempIndex = 0;
        while(i <= leftEnd && j<= end){
            if(data[i]>data[j]){
                reversePair+=(leftEnd- i + 1);
                temp[tempIndex++]=data[j];
                j++;
            }else{
                temp[tempIndex++]=data[i];
                i++;
            }
        }

        while(i<=leftEnd){
            temp[tempIndex++]=data[i++];
        }

        while(j<=end){
            temp[tempIndex++]=data[j++];
        }

        for (int tempData : temp) {
            data[start++] = tempData;
        }

        return reversePair;
    }

}
