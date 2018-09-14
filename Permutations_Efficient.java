/*
46. Permutations

https://leetcode.com/problems/permutations/description/

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null || nums.length==0)
        {
            return null;
        }
        List<Integer> l=new ArrayList<>();
        logic(nums,0,nums.length,l);
        return res;
    }
    public void logic(int[] nums,int pos,int len,List<Integer> temp)//backtracking in-place
    {
        // if(pos>len)
        //     return;
        if(pos==len)//base case
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        else
        {
            for(int i=0;i<len;i++)
            {
                if(nums[i]!=Integer.MIN_VALUE)
                {
                    temp.add(nums[i]);
                    int t=nums[i];
                    nums[i]=Integer.MIN_VALUE;
                    logic(nums,pos+1,len,temp);
                    nums[i]=t;
                    temp.remove(temp.size()-1);
                }
            }   
        }
    }
}
/*
Time Complexity - O(n!)
Space Complexity - O(1)
*/
