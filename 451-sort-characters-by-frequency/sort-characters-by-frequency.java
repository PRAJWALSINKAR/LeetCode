class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;

        for (char ch : s.toCharArray()) {
            int freq = map.getOrDefault(ch, 0) + 1;
            map.put(ch, freq);
            maxFreq = Math.max(maxFreq, freq);
        }

        // Step 2: Create buckets where index = frequency,
        // Each bucket contains list of characters with that frequenc
        List<List<Character>> bucket = new ArrayList<>();

        for (int i = 0; i <= maxFreq; i++) {
            bucket.add(new ArrayList<>());
        }

        // Step 3: Put characters in their frequency bucket
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            bucket.get(freq).add(ch);
        }

        // Step 4: Build result string by iterating buckets from high freq to low

        StringBuilder sb = new StringBuilder();
        for (int i = maxFreq; i > 0; i--) {
            for (char ch : bucket.get(i)) {
                for (int j = 0; j < i; j++) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}