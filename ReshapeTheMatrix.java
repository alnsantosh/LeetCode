/*
566. Reshape the Matrix

https://leetcode.com/problems/reshape-the-matrix/description/

Idea - Create res array. Place each value in nums into res.

.
*/
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c!=nums.length*nums[0].length)//base case
            return nums;
        int[][] res=new int[r][c];
        int m=0,n=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                
                if(n==nums[0].length)
                {
                    m+=1;
                    n=0;
                }
                if(m==nums.length)//Missing this will give ArrayOutOfBoundException
                    break;
                res[i][j]=nums[m][n++];
                //System.out.println(m+" "+n+" "+nums[m][n]);
            }
        }
        return res;
    }
}
/*
Time Complexity - O(r*c)
Space Complexity - O(r*c)
*/
