class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        // List to store the largest elements from each row
        List<Integer> maxElements = new ArrayList<>(); 

        for (int i = 0; i < grid.length; i++) {
             // Sort the row to get the largest elements at the end
              Arrays.sort(grid[i]);
            // Determine how many elements we can take from this row
             int take = Math.min(limits[i], grid[i].length);
            // Collect the largest 'take' elements from the sorted row
            for (int j = grid[i].length - 1; j >= grid[i].length - take; j--) {
                maxElements.add(grid[i][j]); 
            }
        }

        // Sort all collected elements in descending order to prioritize largest values
        maxElements.sort(Collections.reverseOrder());

        long sum = 0;
        
        // Take the largest 'k' elements from the sorted list and calculate their sum
        for (int i = 0; i < Math.min(k, maxElements.size()); i++) {
            sum += maxElements.get(i);
        }

        return sum; // Return the maximum sum obtained
    }
}
