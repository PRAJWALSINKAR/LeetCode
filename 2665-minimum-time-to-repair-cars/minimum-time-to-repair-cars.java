class Solution {
    public long repairCars(int[] ranks, int cars) {
     Arrays.sort(ranks);
        long low = 1;
        long high = (long) ranks[0] * (cars * (long) cars);
        // max time=min(ranks)×(cars)*(cars)
        // less rank more time

      long ans =0;
      while(low <= high){
        long mid = low +(high - low) /2;
        if(helper(ranks , cars , mid)){
            high = mid -1;
            ans = mid ;  
        }else{
            low = mid+1;
        }
      }
      return ans;
    }
    public boolean helper(int[] ranks , int car , long time){
        int reparied = 0;
        for(int rank : ranks){
            reparied += Math.sqrt(time / rank); 
        }
        if(reparied >= car){
            return true;
        }
        return false;
    }
}