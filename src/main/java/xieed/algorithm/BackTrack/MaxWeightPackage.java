package xieed.algorithm.BackTrack;

public class MaxWeightPackage {
    int[] items = new int[]{2,4,3,7};
    int maxWeight = 10;
    int maxPackageWeight;

    //回溯穷举
    public void packageItemExhaustivity(int i, int weight){
        if(weight == maxWeight || i == items.length) {
            if (weight > this.maxPackageWeight) {
                this.maxPackageWeight = weight;
            }

            return;
        }

        packageItemExhaustivity(i+1, weight);
        if((weight + items[i]) <= maxWeight){
            packageItemExhaustivity(i + 1, weight + items[i]);
        }
    }

    //回溯穷举优化 计算过的状态记录下来，后续不用重复计算
    boolean[][] recording = new boolean[items.length][maxWeight];
    public void refinePackageItemExhaustivity(int i, int weight){
        if(weight == maxWeight || i == items.length) {
            if (weight > this.maxPackageWeight) {
                this.maxPackageWeight = weight;
            }

            return;
        }

        if(recording[i][weight]){
            return;
        }
        recording[i][weight] = true;
        refinePackageItemExhaustivity(i+1, weight);
        if((weight + items[i]) <= maxWeight){
            refinePackageItemExhaustivity(i + 1, weight + items[i]);
        }
    }

    //动态规划 二维表记录每个item装入与不装入的状态，第i个item的状态基于第i-1个item的状态推导
    public void packageItemDynimic(){
        boolean[][] weightCombine = new boolean[items.length][maxWeight+1];
        weightCombine[0][0] = true; // 第一行的...
        极客时间版权所有: https://time.geekbang.org/column/article/74788
        if(items[0]<=maxWeight){
            weightCombine[0][items[0]] = true;
        }

        for (int i = 1; i < items.length; i++){
            for(int j = 0; j <maxWeight;j++){
                if(weightCombine[i-1][j] == true){//遍历上一层状态
                    weightCombine[i][j] = true;// 不把第 i 个物品放入背包
                    }
            }

            for(int j = 0; j <=maxWeight-items[i];j++){
                if(weightCombine[i-1][j] == true){//遍历上一层状态
                    weightCombine[i][j + items[i]] = true;//把第 i 个物品放入背包
                }
            }
        }

            for(int j = maxWeight; j>=0; j--){
                if(weightCombine[items.length-1][j]){
                    System.out.println("The max weight is:" + j);
                    return;
                }
            }
    }

    //动态规划优化 优化成一维数组，只记录装入的状态
    public void refinePackageItemDynimic(){
        boolean[] weightCombine = new boolean[maxWeight + 1];
        weightCombine[0]=true;
        if(items[0]<=maxWeight){
            weightCombine[items[0]] = true;
        }

        for (int i = 1; i < items.length; i++){
            for(int j = maxWeight - items[i]; j >=0;j--){//必须倒序循环，否则可能会重复累加第i个元素的重量，因为weightCombine的内容在循环内发生变化（87行），86行判定又会为true
                if(weightCombine[j] == true){
                    weightCombine[items[i] + j] = true;// 把第 i 个物品放入背包
                }
            }

        }

        for(int j = maxWeight; j>=0; j--){
            if(weightCombine[j]){
                System.out.println("The max weight is:" + j);
                return;
            }
        }
    }

}
