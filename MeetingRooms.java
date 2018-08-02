/*
920. Meeting Rooms

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
Example

Given intervals = [[0,30],[5,10],[15,20]], return false.

*/
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                int temp=i1.start-i2.start;
                if(temp==0)
                {
                    temp=i1.end-i2.end;
                }
                return temp;
            }
        });
        // for(int i=0;i<intervals.size();i++)
        // {
        //     System.out.print("["+intervals.get(i).start+","+intervals.get(i).end+"]");
        // }
        // System.out.println();
        
        for(int i=1;i<intervals.size();i++)
        {
            if(intervals.get(i-1).end>intervals.get(i).start)
            {
                return false;
            }
        }
        return true;
    }
}
/*
Time Complexity - O(nlogn) - Sorting the List
Space Complexity - O(1)
*/
