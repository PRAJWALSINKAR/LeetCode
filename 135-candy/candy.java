class Solution {
    public int candy(int[] ratings) {
        int  n = ratings.length;
        if(n==0){
            return 0;        
    }
    int[] candy= new int[n];
        for(int i=0;i<n;i++){
            candy[i]=1;
        }
    for(int i=1;i<n;i++){
        if(ratings[i]>ratings[i-1]){
            candy[i]=candy[i-1]+1;//1 2 3   
        }
         }
         for(int i =n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candy[i]=Math.max(candy[i],candy[i+1]+1);
            }
         }
         int totalcandy=0;
         for(int i : candy){
            totalcandy += i;
         }
         return totalcandy;
        }

    }
    
