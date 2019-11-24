package xieed.leetCode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int head;
        int tail;
        for(int i = 0; i < nums.length-2; i++){
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            head = i + 1;
            tail = nums.length - 1;
            while(true){
                if(head >= tail){
                    break;
                }

                int sum = nums[head] + nums[tail];
                if(nums[i]+ sum ==0){
                    if(result.size()>0){
                        List<Integer> lastMatchedList = result.get(result.size() - 1);
                        if(lastMatchedList.get(1) == nums[head] && lastMatchedList.get(2) == nums[tail]){
                            head++;
                            tail--;
                            continue;
                        }
                    }
                    List<Integer> intList = new ArrayList<>();
                    intList.add(nums[i]);
                    intList.add(nums[head]);
                    intList.add(nums[tail]);
                    result.add(intList);
                    head++;
                    tail--;
                }else if(sum <= 0 || Math.abs(sum) < Math.abs(nums[i])){
                    head++;
                }else{
                    tail--;
                }
            }
        }
        return result;
    }
}