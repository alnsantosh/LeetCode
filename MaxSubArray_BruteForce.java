class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums.length==0)
        {
            return 0;
        }
        else
        {
            int sum=Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++)
            {
                int temp=0;
                for(int j=i;j<nums.length;j++)
                {
                    temp+=nums[j];
                    if(temp>sum)
                    {
                        sum=temp;
                    }
                }
            }
            return sum;
        }
        
        
    }
}
