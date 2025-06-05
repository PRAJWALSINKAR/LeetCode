class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        Map<Character , Integer > map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
       
        int n = s.length();
        for(int i = 0;i< n -1 ;i++){
            if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1))){
                ans += map.get(s.charAt(i));
            }else{
                ans -= map.get(s.charAt(i));
            }
        }
        return ans + map.get(s.charAt(n -1));
    }
}

/*
time = O(N)
space = O(1)
*/