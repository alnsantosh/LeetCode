/*
31. Next Permutation

https://leetcode.com/problems/next-permutation/description/

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/

/*
Idea - Start from right. Traverse left untill nums[i-1]>=nums[i] condition fails. This means that all the element to the right of i-1 are sorted in decreasing order. if it goes on left of first element nums[0], means the entire array is sorted in te descending order. If not, then we take another pointer j and traverse from right to left until nums[i]>=nums[j] is being satisfied. Basically we are looking for a number which is just greater than nums[i] which is on right side of i. Now we swap these numbers. Even Now the elements on right side of i are sorted in descending order. There elements needs to be reversed. 
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        while(i-1>=0 && nums[i-1]>=nums[i])
        {
            i--;
        }
        i--;
        //System.out.println(i);
        int j=nums.length-1;
        if(i>=0)
        {
            while(nums[i]>=nums[j])
            {
                j--;
            }
            swap(nums,i,j);
        }
        i++;
        //System.out.println(i+" "+j);
        reverse(nums,i,nums.length-1);   
    }
    
    public void swap(int nums[],int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int nums[],int i,int j)
    {
        while(i<j)
        {
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}
/*
Time Complexity - O(n) - All the elements are traversed atmost twice if the array is sorted in descending order
Space Complexity - O(1)
*/
