class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> lis = new ArrayList<>();
        Arrays.sort(arr);
        helper(0 , lis , arr ,new ArrayList<>(), target );
        return lis;
    }
    public void helper(int ind ,List<List<Integer>> lis , int [] arr,List<Integer> temp , int target ){
        if(target == 0){
          lis.add(new ArrayList<>(temp));
          return;
        }
    for(int i = ind ; i < arr.length ;i++){
        if(i > ind && arr[i] == arr[i-1])continue;
        if(arr[ind] > target)break;
        temp.add(arr[i]);
        helper(i+1 , lis , arr , temp , target - arr[i]);
        temp.remove(temp.size() -1);
    }
    }
}