/*
42. Trapping Rain Water

https://leetcode.com/problems/trapping-rain-water/description/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/
/*
Idea - Take two pointers start,end pointing to first and the last node respectively. Move start towards right and end towards left alternatively will we reach a point where start=end. That point will be where the peak of the graph is present
*/
class Solution {
    public int trap(int[] height) {
        int start=0,i=start+1,end=height.length-1,j=end-1,sum=0;
        while(start<end)
        {
            int temp=0;//temperoraily stores the sum
            while(i<end && height[start]>height[i])
            {
                temp+=height[start]-height[i];
                i++;
            }
            if(height[i]<height[start])//it means we reached end and height[end] is less than height[start], it means that there is no bar on the right side of start whose height is greater than start. In that case, we again assign i to start.
            {
                i=start;
            }
                
            else
            {
                start=i;
                i=start+1;
                sum+=temp;//sum is updated only if position of start is moved towards right
            }
            temp=0;
            
            //System.out.println(start+" "+i+" "+end+" "+j+" "+sum);
            if(start==height.length)
                break;
            while(j>start && height[end]>height[j])
            {
                temp+=height[end]-height[j];
                j--;
            }
            if(height[j]<height[end])//if means we reach start and height[start]<height[end]
                j=end;
            else
            {
                end=j;
                j=end-1;
                sum+=temp;
            }
            
        }  
        //System.out.println(start+" "+i+" "+end+" "+j+" "+sum);
        return sum;
    }
}
/*
Time Complexity - O(n) 
Space Complexity - O(1)
*/
