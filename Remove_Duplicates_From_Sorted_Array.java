class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int count=1;
        for(int j=1;j<nums.length;)
        {
            if(nums[i]==nums[j])
            {
                j++;
            }
            else
            {
                nums[++i]=nums[j++];
                count++;
            }
        }
        System.out.println(count);
        return count;
        
    }
}
