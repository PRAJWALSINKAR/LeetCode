class Solution {
    public int countPrimes(int n) {
         if(n <= 2)return 0;
        int [] isPrime = new int[n];
        Arrays.fill(isPrime , 1);
        isPrime[0]=isPrime[1] = 0;//it is prime number 0 1
        for(int i= 2; i*i<n;i++){
            if(isPrime[i] == 1){
                for(int j = i*i ; j < n ; j += i){
                    isPrime[j] = 0;
                }
            }
        }
        int count = 0;
        for(int k : isPrime){
            count += k;
        }
        return count;
    }
}