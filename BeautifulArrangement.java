/*
526. Beautiful Arrangement

https://leetcode.com/problems/beautiful-arrangement/description/

Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?

Example 1:
Input: 2
Output: 2
Explanation: 

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
Note:
N is a positive integer and will not exceed 15.

*/
class Solution {
    int count=0;
    public int countArrangement(int N) {
        boolean visited[]=new boolean[N];
        logic(1,N,visited);
        return count;
        
    }
    
    public void logic(int pos,int N,boolean vis[])//use pos to track the currect positioin,visited array to track if the number is previously used or not
    {
        // System.out.print(pos+" ");
        // for(int i=0;i<N;i++)
        //     System.out.print(vis[i]);
        // System.out.println();
        for(int i=1;i<=N;i++)
        {
            if(!vis[i-1] && (pos%i==0 || i%pos==0))
            {
                if(pos==N)
                {
                    count++;
                    break;
                }
                pos++;
                vis[i-1]=true;
                logic(pos,N,vis);
                vis[i-1]=false;
                pos--;
            }
        }
    }
}
/*
Time Complexity - O(k) where k is the number of alid permutations of n. By valid, i mean that the conditions mentioned above whould be satisfied
Space Complexity - O(n) - Since visited array is being used
*/
