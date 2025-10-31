class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        int count =0;
        HashMap<Integer , Integer > map = new HashMap<>();
        for(int i : nums ){
            map.put(i , map.getOrDefault(i,0)+1);
                if(map.get(i) == 2)ans[count++]=i;
                if(count ==2)break;
        }
        return ans;
    }
}