package xieed.algorithm;

public class Recursion {
  public int caculateWaysOfClimbingStairs(int n){
    if(n == 1){
      return  1;
    }
    if(n ==2){
      return  2;
    }

    return caculateWaysOfClimbingStairs(n-1) + caculateWaysOfClimbingStairs(n-2);
  }

  public String getUltimateReferer(Referee r,String initialRefereeName){
    if(r.referer == null){
      if(r.name.equals(initialRefereeName)){
        return null;
      }else{
        return r.name;
      }
    }

    return getUltimateReferer(r.referer, initialRefereeName);
  }

  class Referee{
    String name;
    public Referee(String name){
      this.name = name;
    }
    Referee referer;
  }
}
