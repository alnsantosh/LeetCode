/*
307. Range Sum Query - Mutable

https://leetcode.com/problems/range-sum-query-mutable/description/

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8

Note:

    The array is only modifiable by the update function.
    You may assume the number of calls to update and sumRange function is distributed evenly.


*/

/*
Idea- Use segmented trees

https://leetcode.com/problems/range-sum-query-mutable/solution/#

https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
*/
class NumArray {
    int[] sum;
    int n;

    public NumArray(int[] nums) {
        sum=new int[2*nums.length];
        n=nums.length;
        for(int i=n;i<2*n;i++)
        {
            sum[i]=nums[i-n];
        }
        for(int i=n-1;i>0;i--)
        {
            sum[i]=sum[2*i]+sum[2*i+1];
        }
    }
    
    public void update(int i, int val) {
        int pos=i+n;
        sum[pos]=val;
        while(pos>0)
        {
            int right=pos,left=pos;
            if(pos%2==0)
            {
                right=pos+1;
            }
            else
            {
                left=pos-1;
            }
            pos=pos/2;
            sum[pos]=sum[right]+sum[left];
        }
        
    }
    
    public int sumRange(int i, int j) {
        // int l=n+i,r=n+j;
        // while(l!=r)
        // {
        //     //System.out.println(l+" "+r);
        //     if(l>r)
        //         l=l/2;
        //     else if(l<r)
        //         r=r/2;
        // }
        // return sum[l];
        
        //The above logic won't work - check the test case
        
        /*
        ["NumArray","sumRange","sumRange","sumRange","update","update","update","sumRange","update","sumRange","update"]
        [[[0,9,5,7,3]],[4,4],[2,4],[3,3],[4,5],[1,7],[0,8],[1,2],[1,9],[4,4],[3,4]]
        */
        
        int l=n+i,r=n+j;
        int s=0;
        while(l<=r)
        {
            if(l%2==1)
            {
                s+=sum[l];
                l++;
            }
            if(r%2==0)
            {
                s+=sum[r];
                r--;
            }
            l=l/2;
            r=r/2;
        }
        return s;
    }
}




/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */


/*
Time Complexity - NumArray - O(n), update - O(log(n)) , sumRange - O(log(n))
Space Complexity - O(2*n)=O(n)
*/
