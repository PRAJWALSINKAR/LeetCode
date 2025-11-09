class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer , ArrayList<Integer>> map  = new HashMap<>();

        for(int i =0 ; i< n ; i++){
            if(!map.containsKey(nums[i])){
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                map.put(nums[i] , arr);
            }else{
                map.get(nums[i]).add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int key : map.keySet()){
            ArrayList<Integer> arr = map.get(key);

            if(arr.size() < 3)continue;

            for(int i = 0 ; i < arr.size()-2 ; i++){
                int a = arr.get(i);
                int b = arr.get(i+1);
                int c = arr.get(i+2);

                min = Math.min(min , Math.abs(a-b) + Math.abs(b-c) + Math.abs(c-a));
            }
        }
        if(min == Integer.MAX_VALUE)return -1;
        return min;
    }
}