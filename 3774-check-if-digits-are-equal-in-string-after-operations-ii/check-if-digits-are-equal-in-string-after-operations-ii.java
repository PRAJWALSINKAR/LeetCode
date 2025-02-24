class Solution {
    public boolean hasSameDigits(String s) {
         // Loop until the string is reduced to two digits
         int n=s.length()-2,x=0,y=0;
        for(int k=0;k<=n;k++){
            int bcoeff=binMod10(n,k);
            x=(x+((s.charAt(k)-'0')*bcoeff))%10;
            y=(y+((s.charAt(k+1)-'0')*bcoeff))%10;
        }
        return x==y;
    }
    // Use chinese reminder theorem to combine binMod2 and binMod5
    public int binMod10(int n,int k){
        int bm2=binMod2(n,k);
        int bm5=binMod5(n,k);
        for(int x=0;x<=9;x++){
            if(x%2==bm2 && x%5==bm5) return x;
        }
        return 0;
    }
    // Find binMod2 using Lucas algorithm, simplified since it's 2
    // See the explaination why this will work
    public int binMod2(int n,int k){
        return (n&k)==k ? 1 : 0;
    }
    // Find binMod5 using Lucas algorithm
    public int binMod5(int n,int k){
        int pascalTriangleMod5[][] = {
            {1},
            {1,1},
            {1,2,1},
            {1,3,3,1},
            {1,4,1,4,1}
        };
        int ans=1;
        while(n>0 || k>0){
            int ndigit=n%5,kdigit=k%5;
            if(kdigit>ndigit) return 0;
            ans=(ans*pascalTriangleMod5[ndigit][kdigit])%5;
            n/=5;k/=5;
        }
        return ans;
    }
}