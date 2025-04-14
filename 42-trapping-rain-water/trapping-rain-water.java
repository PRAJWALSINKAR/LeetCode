class Solution {
    public int trap(int[] arr) {
        int len = arr.length;
        int leftMax =arr[0];
        int rightMax = arr[len-1];
        int left = 0;
        int right = len-1;
        int total = 0;

        while(left < right){
            if(leftMax < rightMax){
                left++;
                if(leftMax <= arr[left]){
                    leftMax = arr[left];
                }
                else{
                    total += leftMax - arr[left];
                }
            }
            else{
                right--;
                if(rightMax <= arr[right]){
                    rightMax = arr[right];
                }
                else{
                    total += rightMax - arr[right];
                }
            }
        } 
        return total;
    }
}