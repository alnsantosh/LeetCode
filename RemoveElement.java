/*
27. Remove Element

https://leetcode.com/problems/remove-element/description/

Idea - Two pointer approach. point j at 0. Iterate through the array, then replace nums[j] with nums[i] and increment j


*/
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0)
            return 0;
//         int i=0,j=nums.length-1;
//         int count=0;
//         while(i<j)
//         {
//             for(int k=0;k<nums.length;k++)
//             {
//                 System.out.print(nums[k]+" ");
//             }
//             System.out.println();
//             System.out.println(i+" "+j+" "+count);
            
//             while(i<nums.length && nums[i]!=val)
//             {
//                 i++;
//                 count++;
//             }
//             if(i>=j)
//                 break;
//             while(j>=0 && nums[j]==val)
//             {
//                 j--;
//             }
//             if(i>=j)
//                 break;
//             int temp=nums[i];
//             nums[i]=nums[j];
//             nums[j]=temp;
//             count++;
//             j--;
//             i++;
        
        int j=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=val)
                nums[j++]=nums[i];
        }
        //System.out.println(count);
        return j;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(1)
*/
