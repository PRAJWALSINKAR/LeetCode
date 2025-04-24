class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // first we het set and covert word into it so that if we get word we detlt it from set directly
        //queue for  counting the string and steps
        //at every word position we put ato z value one by one
        //if we found word in setwe put it in q and remove from set 
        Queue<Pair<String , Integer >> q = new LinkedList<>();
        Set<String> st = new HashSet<>(wordList);

        if(!st.contains(endWord))return 0;

        q.add(new Pair<>(beginWord , 1));
        st.remove(beginWord);

        while(!q.isEmpty()){
            Pair<String , Integer> curr = q.poll();
            String word = curr.getKey();
            int steps = curr.getValue();

            if(word.equals(endWord)) return steps;
            for(int i =0 ;i<word.length() ; i++){
                char[] wordArr = word.toCharArray();
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    wordArr[i] = ch;
                    String newWord = new String(wordArr);
                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.add(new Pair<>(newWord , steps+1));
                    }
                }
            }
        }
         return 0;
    }
}