/*
280. Wiggle Sort

Given an unsorted array nums, reorder it in-place such that

nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example

Given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
Notice

Please complete the problem in-place.

*/
/*
Idea - Sort the elements in the descending order. Then swap consecutive elements.
eg: say the sorted reverse array is 6,5,4,3,2,1
Then after swapping - 5,6,3,4,1,2
*/
public class Solution {
    /*
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        while(i<j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
        // for(i=0;i<nums.length;i++)
        // {
        //     System.out.print(nums[i]+" ");
        // }
        for(i=0;i<nums.length-1;i++)
        {
            swap(nums,i,i+1);
            // int temp=nums[i];
            // nums[i]=nums[i+1];
            // nums[i+1]=temp;
            i++;//because I should not swap already swapped element
        }
    }
    public void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
/*
Time Complexity - O(nlog(n)) - since sorted the array
Space Complexity - O(1)
*/
