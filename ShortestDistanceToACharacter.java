/*
821. Shortest Distance to a Character

https://leetcode.com/problems/shortest-distance-to-a-character/description/

Idea - Traverse through the array twice. Once from left to right and next time from right to left.
During each iteration, update the prev value(the character which we are looking for) and calculate the distance accordingly.

Inspired from:
https://leetcode.com/problems/shortest-distance-to-a-character/solution/
*/
class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] res=new int[S.length()];
        int prev=Integer.MIN_VALUE/2;
        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)==C)
                prev=i;
            res[i]=Math.abs(i-prev);
        }
        prev=Integer.MAX_VALUE/2;
        for(int i=S.length()-1;i>=0;i--)
        {
            if(S.charAt(i)==C)
                prev=i;
            res[i]=Math.min(res[i],Math.abs(i-prev));
        }
        return res;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n) - Considering res as extra space
*/
