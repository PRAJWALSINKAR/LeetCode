class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int [] ans = new int[n];
        Arrays.sort(potions);

        for(int i =0 ; i <n ;i++){
            int low = 0;
            int high = m-1;
            int idx = m;
            long sp = spells[i];
            while(low <= high){
                int mid = low + (high - low ) / 2;
                
                if(sp *potions[mid] >= success){
                    idx=mid;
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            ans[i] = m-idx;
        }
        return ans;
    }
}