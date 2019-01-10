/*
209. Minimum Size Subarray Sum

https://leetcode.com/problems/minimum-size-subarray-sum/description/

Idea -- Use two pointers logic to calculate the shorest length of subarray

For more efficient logic,
https://leetcode.com/problems/minimum-size-subarray-sum/solution/



*/
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0)//base case
            return 0;
        if(nums[0]>=s)//since j is set to 1, we have to consider the case where nums[0] itself is >=s, in that case we can simply return 1 
            return 1;
        int i=0,j=1;
        int length=Integer.MAX_VALUE;
        while(i<=j && j<nums.length)//logic using 2 pointers
        {
            int temp=0;
            for(int k=i;k<=j;k++)
            {
                temp+=nums[k];
            }
            //System.out.println(temp);
            if(temp>=s)
            {
                if(j-i+1<length)
                {
                    length=j-i+1;
                    //System.out.println("Length:"+length);
                }
                i++;
            }
            else if(temp<s)
            {
                j++;
            }
        }
        return length==Integer.MAX_VALUE?0:length;//since length variable is initialised to Integer.MAX_VALUE, if there is a case where if sum of all the elements in the array is <s, in that case we have to return 0, not Integer.MAX_VALUE.
    }
}
/*
Time Complexity - approximately O(n^2) since there is a for inside while loop. The code can be improved to get down the time complexity to O(n)
Space Complexity - O(1)
*/
