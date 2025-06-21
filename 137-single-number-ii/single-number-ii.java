class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for(int i =0 ;i<nums.length ; i++){
            ones = (nums[i] ^ ones) & (~twos);  //it's like condtion =>(a) and (b) is true Then save
            twos = (nums[i] ^ twos) & (~ones);
        }
        return ones;
    }
}

/* Reffer below approch also 

1) Approach 1: Brute Force

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return -1;
    }
}
--> Time Complexity: O(n)
One pass to build the map: O(n)
One pass to find the unique number: O(n) in worst case (all unique keys)

--> Space Complexity: O(n)
In worst case, all n numbers are unique → the map stores all n elements.
---------------------------------------------------------------------------------

2) Approach 2: Bit Manipulation

class Solution {
  public int singleNumber(int[] nums) {
    int ans = 0;

    for (int i = 0; i < 32; ++i) {
      int sum = 0;
      for (final int num : nums)
        sum += num >> i & 1;
      sum %= 3;
      ans |= sum << i;
    }

    return ans;
  }
}
 
-->Time Complexity: O(32 * n) = O(n)
32 iterations (for each bit) × n elements = O(n)

--> Space Complexity: O(1)
Uses only a few integer variables — no extra space that grows with input size.


*/