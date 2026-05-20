class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int [] ans = new int[n];
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int count = 0;
        for(int i= 0 ; i < n ; i++){
            if(A[i] == B[i]){
                count++;
            }else if(set1.contains(B[i]) && set2.contains(A[i])){
                count += 2;
            }else if(set1.contains(B[i]) || set2.contains(A[i])){
                count++;
            }else{
                count = count;
            }
            set1.add(A[i]);
            set2.add(B[i]);
            ans[i] =count;
        }
        return ans;
    }
}