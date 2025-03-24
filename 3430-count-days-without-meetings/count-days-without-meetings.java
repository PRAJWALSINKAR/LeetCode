class Solution {
    public int countDays(int days, int[][] meetings) {
       int freeDays = 0, latestEnd = 0;

        // Sort meetings based on starting times
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            // Add current range of days without a meeting
            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }

            // Update latest meeting end
            latestEnd = Math.max(latestEnd, end);
        }

        // Add all days after the last day of meetings
        freeDays += days - latestEnd;

        return freeDays;
    }
}
        
        /*
        int [] arr = new int[days+1];
        int n = meetings.length;
        int count= 0 ;
        int max = meetings[0][1];
       Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        if(meetings[0][0] != 1){
           count += meetings[0][0]-1;//0
        }
        for(int i =0 ; i< n -1; i++){
            if(meetings[i+1][0] > meetings[i][1]){
                count += meetings[i+1][0] - meetings[i][1] -1;
                max = Math.max(max , meetings[i][1]);
            }
        }
        max = Math.max(max , meetings[n-1][1]);
        if(max != days ){
            count += days - max;
        }    
        return count;
    }
}
*/