class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int maintain = 0;
        int curr = 1;

        for(int i = 1 ; i <= n ; i++){
             if(i%7 ==1 && i >1){
                maintain++;
                curr = maintain + 1;
            } 
            ans +=curr;
            curr++;    
        }
        return ans;
    }
}