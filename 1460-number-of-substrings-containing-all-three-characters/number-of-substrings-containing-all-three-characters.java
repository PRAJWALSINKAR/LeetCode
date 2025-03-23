class Solution {
    public int numberOfSubstrings(String s) {
    int count = 0;
    int n =s.length();
    int left = 0;
    
    int [] arr = new int[3];

    for(int right = 0;right < n ; right++){
        arr[s.charAt(right) - 97]++;

        while(arr[0] > 0 && arr[1] > 0 && arr[2] > 0){
         count += n- right;
         arr[s.charAt(left) - 97]--;
         left++;
        }
    }
    return count;
    }
}