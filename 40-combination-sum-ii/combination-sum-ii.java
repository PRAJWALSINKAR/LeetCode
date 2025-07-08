//my approch
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();

        helper(0, 0, res, new ArrayList<>(), target, candidates);
        return res;
    }

    public void helper(int index, int currSum, List<List<Integer>> res, List<Integer> temp, int target,
            int[] candidate) {
        if (currSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (index == candidate.length || currSum > target)
            return;

        temp.add(candidate[index]);
        helper(index+1, currSum + candidate[index], res, temp, target, candidate);
        temp.remove(temp.size() - 1);

        while (index < candidate.length - 1 && candidate[index] == candidate[index + 1]) {
            index++;
        }

        helper(index + 1, currSum, res, temp, target, candidate);

    }
}
