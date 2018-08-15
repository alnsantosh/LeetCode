/*
77. Combinations

https://leetcode.com/problems/combinations/description/

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]


*/
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n==0 || k==0)
            return res;
        List<Integer> l=new ArrayList<>();
        logic(n,k,1,0,l);
        return res;
    }
    public void logic(int n,int k,int pos,int count,List<Integer> l)
    {
        if(count>k)
        {
            return;
        }
        if(count==k)
        {
            res.add(new ArrayList<>(l));
            return;
        }
        for(int i=pos;i<=n;i++)
        {
            l.add(i);
            logic(n,k,i+1,count+1,l);
            l.remove(l.size()-1);
        }
    }
}
/*
Time Complexity - O(n^2) - Consider it as a tree, level 0 has 1 node. Level 1 has n nodes ranging from 1 to n.Level 2 will have n*n nodes. Each node in level 1 will have n childs.
1+n+n^2=O(n^2)
Space Complexity - O(1) if res is not considered as extra space
Its in general O(k) where k is depth of the tree
Here k is 2
so, O(2)=O(1)
*/
