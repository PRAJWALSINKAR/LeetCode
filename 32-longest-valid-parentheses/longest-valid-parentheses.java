class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0)return 0;
        Stack<Integer> stk = new Stack<>();
        int [] vis = new int[s.length()];
        int ans = 0;
        
        for(int i=0;i<s.length();i++){
            int curr= 0;
            if(s.charAt(i) == '('){
                stk.push(i);
           }else{
                if(!stk.isEmpty() && s.charAt(stk.peek()) == '(' ){
                    int prev =stk.pop();;
                    vis[prev] = 1;
                    vis[i] = 1;
                }
           }
        }
        int temp = 0;
        for(int i =0 ; i< s.length() ; i++ ){
            if(vis[i] == 1){
                temp++;
            }else{
                ans = Math.max(ans , temp);
                temp =0;
            }
        }
        ans =Math.max(ans , temp);
        return ans;
    }
}