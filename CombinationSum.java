/*
39. Combination Sum

https://leetcode.com/problems/combination-sum/description/

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]


*/
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0)
            return res;
        List<Integer> l=new ArrayList<>();
        logic(candidates,target,0,0,l);
        return res;
    }
    public void logic(int[] candidates, int target,int pos, int sum,List<Integer> l)//pos helps us to remove the duplicates from the res.If we had no pos and if for loop was from 0 to candidates.length, then res will have all the duplicates. Now the pos makes sure that we are going from left to right and not backwards.
    {
        //System.out.println(target+" "+sum+" ");
        if(sum>target)
            return;
        if(sum==target)
        {
            res.add(new ArrayList<>(l));//new is used as ArrayList is mutable. So we need to create a new ArrayList to store those values.
            return;
        }
        for(int i=pos;i<candidates.length;i++)
        {
            l.add(candidates[i]);
            logic(candidates,target,i,sum+candidates[i],l);
            l.remove(l.size()-1);
        }
    }
}
/*
Time Complexity - O(n^t)
Let n be the number of elements in the array
First level in the graph will have 0, Second level in graph will have n nodes.(for each element in the array). Further more for lebel 3, there will be n*n nodes as for each node in level 2, there will be n nodes in level 3. Similarly so on
1+n+n^2+n^3+...+n^t =n^t-1/n-1=O(n^t)
where t is the target. Worst case when array has only one element and that value is 1. Height of this tree/grapg will be equal to target t. Rest of the cases, the depth will be less than t.
Space Complexity - O(n)
*/
