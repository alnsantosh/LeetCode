/*
554. Brick Wall

https://leetcode.com/problems/brick-wall/description/

There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

Example:

Input: 
[[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]
Output: 2
Explanation: 

Note:

    The width sum of bricks in different rows are the same and won't exceed INT_MAX.
    The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.

*/
/*
Iterate through each row,  store the count of sum in a Map and return wall.size()-least count in the map . wall.size() is the number of rows. Edge case is important here.
*/
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<wall.size();i++)
        {
            int sum=0;
            for(int j=0;j<wall.get(i).size()-1;j++)//here I have breaking condition as j<wall.get(i).size()-1. -1 because total sum in each row is same. That total sum count will be maximum always if I include j<wall.get(i).size() instead of j<wall.get(i).size()-1. 
            {
                sum+=wall.get(i).get(j);
                m.put(sum,m.getOrDefault(sum,0)+1);
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i: m.keySet())
        {
            //System.out.println(i+": "+m.get(i));
            if(m.get(i)>max)
                max=m.get(i);
        }
        if(max==Integer.MIN_VALUE)//edge case. - If there is only 1 element in the each row, then because of the above condition j<wall.get(i).size()-1, i.e., j<1-1 i.e., j<0 which is not possible, so the loop breaks immediately. For that this base case is added. If only 1 element is present, then answer should be the length of the list.
            return wall.size();
        return wall.size()-max;
    }
}
/*
Time Complexity - No. of bricks = O(mn)
Space Complexity - O(1)
*/
