class Solution {
public:
    int findFinalValue(vector<int>& nums, int t) {
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums.at(j) == t) {
                     t = t *2;
                     break;
                }
                if(j == n-1)return t;
            }
        }
        return t;
    }
};