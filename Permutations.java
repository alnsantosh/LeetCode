/*
46. Permutations
DescriptionHintsSubmissionsDiscussSolution

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
/*
Idea - Backtracking approach. Start wil first node,make the corresponding vis element as true and recursively call the elements. If vis[i] is true, then we do not call the logic function for that element again recursively since it is already visited and present in list l. 
*/
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0)
            return res;
        boolean[] vis=new boolean[nums.length];
        List<Integer> l=new ArrayList<>();
        logic(nums,0,0,l,vis);
        return res;
    }
    public void logic(int[] nums,int count,int pos,List<Integer> l,boolean[] vis)
    {
        if(count>nums.length)
            return;
        if(count==nums.length)
        {
            res.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!vis[i])
            {
                l.add(nums[i]);
                vis[i]=true;
                logic(nums,count+1,i+1,l,vis);
                vis[i]=false;
                l.remove(l.size()-1);
            }
            
        }
    }
}
/*
Time Complexity - O(n!)
At level 1, we have n nodes. At level 1, we have n(n-1) nodes since each node in level 1 will have n-1 childs.
Similarly, at level 2, n(n-1)(n-2) nodes. At level n, n(n-1)(n-2)...1 = n!
n+n(n-1)+n(n-1)(n-2)+....+n! = n![1/(n-1)! + 1/(n-2)! + .. + 1] = O(n!)
Space Complexity - O(n) - Since the depth of the tree will be n. Also vis array size is n
*/
