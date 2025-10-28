class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        char[] res = new char[n];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int k = n - 1; k >= 0; k--) {
            boolean possible = true;

            for (int i = 0; i < k; i++) {
                int idx = target.charAt(i) - 'a';

                if (freq[idx] == 0) {
                    possible = false;
                    break;
                }
                res[i] = target.charAt(i);
                freq[idx]--;
            }

            if (possible) {
                boolean found = false;
                int taregtIdx = target.charAt(k) - 'a';

                for (int next = taregtIdx + 1; next < 26; next++) {
                    if (freq[next] > 0) {
                        freq[next]--;
                        res[k] = (char) (next + 'a');
                        found = true;
                        break;
                    }
                }
                if (found) {
                    for (int i = k + 1; i < n; i++) {
                        for (int j = 0; j < 26; j++) {
                            if (freq[j] > 0) {
                                freq[j]--;
                                res[i] = (char) (j + 'a');
                                break;
                            }
                        }
                    }
                    return new String(res);
                }
            }
            Arrays.fill(freq, 0);
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
        }
        return "";
    }
}