class Solution {
    public List<String> fizzBuzz(int n) {
        String [] arr = {"FizzBuzz" , "Fizz" ,  "Buzz" };
        List<String> ans = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            if(i % 3 == 0 && i %5==0){
                ans.add(arr[0]);
            }else if(i % 3 == 0){
                ans.add(arr[1]);
            }else if(i  % 5 == 0){
                ans.add(arr[2]);
            }else{
                ans.add(Integer.toString(i));
            }
        }
        return ans;
    }
}