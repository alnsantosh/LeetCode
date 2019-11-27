/*
1094. Car Pooling

Idea: We know that there are atmost 1001 stops (anything between 0 and 1000) since trips.length<=1000. Taking that into account, we can calculate the total number of passengers present in each stop in the first iteration. At the end of first iteration, we have stops array which tells us the number of passengers present at each stop. During second iteration, for each stop we check if the passenger count is less than capacity. If this conditions is satisfied by every stop, we return true, else we return false. 
*/
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops=new int[1001];
        for(int i=0;i<trips.length;i++){
            for(int j=trips[i][1];j<trips[i][2];j++){
                stops[j]+=trips[i][0];
            }
            // stops[trips[i][1]]+=trips[i][0];
            // stops[trips[i][2]]-=trips[i][0];
        }
        for(int i=0;i<stops.length;i++){
            if(stops[i]>capacity){
                return false;
            }
        }
        return true;
    }
}
/*
Time Complexity : O(n*m) where n=length of trips, m=trips[i][2]-trips[i][1]
Space Complexity : O(1)
*/
