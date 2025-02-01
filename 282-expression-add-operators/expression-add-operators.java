public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        // Start the backtracking process
        backtrack(res, num, target, 0, 0, 0, "");
        return res;
    }

    private void backtrack(List<String> res, String num, int target, int index, long prevNum, long currentResult, String expression) {
        // If we have processed all characters
        if (index == num.length()) {
            if (currentResult == target) {
                res.add(expression);  // Add the expression to result
            }
            return;
        }
        
        // Try every possible cut in the string (i.e., all substrings)
        for (int i = index + 1; i <= num.length(); i++) {
            String currentStr = num.substring(index, i);
            long currValue = Long.parseLong(currentStr);
            
            // Skip numbers that start with '0' but are not "0"
            if (currentStr.length() > 1 && currentStr.charAt(0) == '0') {
                continue;
            }

            int lenBefore = expression.length();
            if (index == 0) {
                // First number, no operator before it
                backtrack(res, num, target, i, currValue, currValue, currentStr);
            } else {
                // Try adding '+'
                backtrack(res, num, target, i, currValue, currentResult + currValue, expression + "+" + currentStr);

                // Try adding '-'
                backtrack(res, num, target, i, -currValue, currentResult - currValue, expression + "-" + currentStr);

                // Try adding '*'
                backtrack(res, num, target, i, prevNum * currValue, currentResult - prevNum + prevNum * currValue, expression + "*" + currentStr);
            }
        }
    }
}