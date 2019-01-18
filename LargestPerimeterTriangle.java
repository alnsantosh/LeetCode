/*
976. Largest Perimeter Triangle

https://leetcode.com/discuss/career/217868/My-notes-for-the-night-before-interview.

Idea - Sort the given array and check the condition A[i]+A[i+1]>A[i+2]. Return A[i]+A[i+1]+A[i+2] such that the value is max.

Inspired from
https://leetcode.com/problems/largest-perimeter-triangle/solution/

*/
class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int p=0;
        for(int i=0;i<A.length-2;i++)
        {
            if(A[i]+A[i+1]>A[i+2])
            {
                int temp=A[i]+A[i+1]+A[i+2];
                if(temp>p)
                    p=temp;
            }
        }
        return p;
    }
}
/*
Time Complexity - O(nlog(n))
Space Complrxity - O(1)
*/
