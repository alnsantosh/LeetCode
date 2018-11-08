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
/*
Idea - Using backtracking approach. Consider this a n-ary tree. Consider all the possible combinations. We basically grow the tree exponentially.
*/
class Solution {
    int count=0;
    public int countArrangement(int N) {
        logic(N,new boolean[N],0);
        return count;
    }
    public void logic(int N,boolean[] vis,int pos)
    {
        if(pos==N)//breaking condition
        {
            count++;
            return;
        }
        // if(vis[pos] || pos>N)
        // {
        //     return;
        // }
        for(int i=0;i<N;i++)//Iterate through all the elements till N and recrsively call the same function. Check visited array and the beautiful arrangement condition while calling the same function recursively
        {
            //System.out.println((i+1)+" "+(pos+1));
            if(vis[i] || ( (i+1)%(pos+1)!=0 && (pos+1)%(i+1)!=0))
                continue;
            vis[i]=true;
            logic(N,vis,pos+1);
            vis[i]=false;
        }
    }
}
/*
Time Complexity - O(2^n) - Its like constructing a n-ary tree.The height of the tree will be n. So the total elements in the tree will be 2^n
Space Complexity - O(n^2) - n for the recursive stack(length of stack=length of tree=n), n for vis[] array. In every recursive call, we are creating a new array. So the total space cosumed = n*n = n^2
*/
