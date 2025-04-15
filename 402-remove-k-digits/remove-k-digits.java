class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i< num.length();i++){
            int digit = num.charAt(i) - '0';
            while(!stk.isEmpty() && stk.peek() > digit && k >0){
                 stk.pop();
                 k--;
            }
            stk.push(digit);
        }
        while(k>0 && !stk.isEmpty()){
            stk.pop();;
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        sb.reverse();
           
        StringBuilder result = new StringBuilder(sb);
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        String str = result.toString();
            
          if(str.length() == 0){
            return "0";
        }
        return str;

    }
}