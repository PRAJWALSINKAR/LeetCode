class Solution {
public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, sb, num, target, 0, 0, 0);
        return res;
    }

    public void helper(List<String> res, StringBuilder sb, String num, int target, int index, long prevNum, long currentNum) {
        if (index == num.length()) {
            if (currentNum == target) {
                res.add(sb.toString());
            }
            return;
        }

        // Loop through the string and add operators
        for (int i = index + 1; i <= num.length(); i++) {
            String currentStr = num.substring(index, i);
            long currValue = Long.parseLong(currentStr);

            // Skip numbers that start with '0' but are not "0"
            if (currentStr.length() > 1 && currentStr.charAt(0) == '0') {
                continue;
            }

            int lenBefore = sb.length();
            if (index == 0) {
                // No operator before the first number
                sb.append(currentStr);
                helper(res, sb, num, target, i, currValue, currValue);
                sb.delete(lenBefore, sb.length());
            } else {
                // Try the '+' operator
                sb.append("+").append(currentStr);
                helper(res, sb, num, target, i, currValue, currentNum + currValue);
                sb.delete(lenBefore, sb.length());

                // Try the '-' operator
                sb.append("-").append(currentStr);
                helper(res, sb, num, target, i, -currValue, currentNum - currValue);
                sb.delete(lenBefore, sb.length());

                // Try the '*' operator
                sb.append("*").append(currentStr);
                helper(res, sb, num, target, i, prevNum * currValue, currentNum - prevNum + prevNum * currValue);
                sb.delete(lenBefore, sb.length());
            }
        }
    }
    public long calculate(StringBuilder sb) {
        long result = 0;
        long currentNum = 0;
        long prevNum = 0;
        char operator = '+';

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');
            }

            if (i == sb.length() - 1 || ch == '+' || ch == '-' || ch == '*') {
                if (operator == '+') {
                    result += currentNum;
                } else if (operator == '-') {
                    result -= currentNum;
                } else if (operator == '*') {
                    result = result - prevNum + prevNum * currentNum;
                }

                if (ch == '+' || ch == '-' || ch == '*') {
                    operator = ch;
                }

                prevNum = currentNum;
                currentNum = 0;
            }
        }
        return result;
    }
}