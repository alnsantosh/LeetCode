/*
1266. Minimum Time Visiting All Points
Idea: Consider the two points (x1,y1),(x2,y2). Since we have three move options i.e., horizonally, vertically and diagonally 1 step. We basically calculate x1-x2,y1-y2. The max of the absolute value i.e., max(abs(x1-x2),abs(y1-y2)) gives the steps/time required to move from (x1,y1) to (x2,y2). 
*/
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time=0;
        for(int i=0;i<points.length-1;i++){
            int x=Math.abs(points[i][0]-points[i+1][0]);
            int y=Math.abs(points[i][1]-points[i+1][1]);
            time+=Math.max(x,y);
        }
        return time;
    }
}
/*
Time Complexity: O(n)
Space Complexity: O(1)
*/
