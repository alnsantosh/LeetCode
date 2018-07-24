/*
11. Container With Most Water

https://leetcode.com/problems/container-with-most-water/description/

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

 

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49


*/
class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int prod=(j-i)*Math.min(height[i],height[j]);
        while(i<j)
        {
            if(height[i]>height[j])//we increment i if height[j]*(j-i)>height[j]*(j-i) i.e., we are trying to maximize the area.
            {
                j--;
            }
            else
            {
                i++;
            }
            prod=Math.max(prod,(j-i)*Math.min(height[i],height[j]));//store the max prod
        }
        return prod;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
