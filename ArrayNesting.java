/*
565. Array Nesting

https://leetcode.com/problems/array-nesting/description/

A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.

Example 1:

Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}

Note:

    N is an integer within the range [1, 20,000].
    The elements of A are all distinct.
    Each element of A is an integer within the range [0, N-1].

*/
class Solution {
    int len=0;
    boolean visited[];
    public int arrayNesting(int[] nums) {
        len=nums.length;
        visited=new boolean[nums.length];
        //System.out.println(visited[0]);
        int res=Integer.MIN_VALUE;
        while(len>0)
        {
            //System.out.println(len);
            for(int i=0;i<nums.length;i++)
            {
                if(visited[i]==false)
                {
                    int temp=logic(nums,i);
                    res=Math.max(temp,res);
                }
            }
            if(res>=nums.length/2)
                return res;
        }
        return res;
    }
    public int logic(int[] nums,int i)//To traverse the elements of array based on given condition
    {
        //System.out.println("i:"+i);
        int j=i,count=0;
        visited[j]=true;
        while(true)
        {
            j=nums[j];
            count++;//count tells us how many elements are traversed from i
            len--;//len=0 if all the elements are visited. Initially, len=nums.length
            visited[j]=true;
            if(i==j)
                break;
        }
        return count;
    }
}
/*
Time Complexity - O(n) - Since each element is traversed only once... I mean initially first element is chosen and traversed till the same element is reached(kind of a loop), then we
see the visited array, if it is false, only then we call logic() function, else we do not call that.
Space Complexity - O(n) since visited array is used. We can make this O(1) if instead of using visited array, if we set the
elements in nums to Integer.MAX_VALUE which are visited. This way we can differentiate between the elements which are already visited
and which are yet to be visited.
*/
