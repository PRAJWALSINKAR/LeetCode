class Solution {
    public int maxSumSubmatrix(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int res = Integer.MIN_VALUE;
        for(int left =0 ; left < n ; left++){
            int [] arr = new int[m];
            for(int right = left ; right < n ; right++){
                for(int i =0 ; i< m ; i++){
                    arr[i] += mat[i][right];
                }
                res = Math.max(res , helper(arr , k));
                if(res == k )return k;
            }
        }
        return res;
    }
    public int helper(int [] arr , int k ){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int preSum =0;
        int ans = Integer.MIN_VALUE;

        for(int i : arr){
            preSum += i;
            Integer target = set.ceiling(preSum - k );//oldPreSum
            if(target != null){
                ans = Math.max(ans , preSum - target);//oldPreSum - NewPreSum 
            }
            set.add(preSum);
        }
        return ans;
    }
}