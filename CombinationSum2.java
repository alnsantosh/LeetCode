/*
40. Combination Sum II

https://leetcode.com/problems/combination-sum-ii/description/

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]


*/
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);//Sorting is required to deal with duplicate values
        if(candidates.length==0)
            return res;
        List<Integer> l=new ArrayList<>();
        logic(candidates,target,0,0,l);
        return res;
    }
    public void logic(int[] candidates,int target,int pos,int sum,List<Integer> l)
    {
        if(sum>target)
            return;
        if(sum==target)
        {
            res.add(new ArrayList<>(l));
        }
        for(int i=pos;i<candidates.length;i++)
        {
            if(i>pos && candidates[i]==candidates[i-1])
                continue;
            l.add(candidates[i]);
            logic(candidates,target,i+1,sum+candidates[i],l);//we pass i+1 as pos, as the value cannot be repeated. Else we could have passed i
            l.remove(l.size()-1);
        }
    }
}
/*
Time Complexity - O(n^n) - See explainatiom in combination sum solution. Only difference is that height of graph is dependednt on length of array instead of target as the values cannot be used again.
Space Complexity - O(n)  - when the target is greated than sum of all elements, the height of graph will be of height=length of array

*/
