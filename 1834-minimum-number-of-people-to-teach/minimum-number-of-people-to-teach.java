class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> lis = new HashSet<>();
        List<Set<Integer>> user = new ArrayList<>();
        for (int i = 0; i <= languages.length; i++) {
            user.add(new HashSet<>());
        }
        int j = 1;
        for (int arr[] : languages) {
            for (int i : arr) {
                user.get(j).add(i);
            }
            j++;
        }
        for (int ar[] : friendships) {
            int u = ar[0];
            int v = ar[1];
            if (cheak(user.get(u), user.get(v))) {
                lis.add(u);
                lis.add(v);
            }
        }
        int count = Integer.MAX_VALUE;
        for(int i= 1 ; i <= n ; i++){
            int tempCount = 0;
            for(int k : lis){
              if(!user.get(k).contains(i))tempCount++;
            }
            count = Integer.min(count , tempCount);
        }
    return count;
    }

    public boolean cheak(Set<Integer> set1, Set<Integer> set2) {
        for (int i : set1) {
            if (set2.contains(i))
                return false;
        }
        return true;
    }
}