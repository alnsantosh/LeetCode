/*
797. All Paths From Source to Target

https://leetcode.com/problems/all-paths-from-source-to-target/description/

Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

Note:

    The number of nodes in the graph will be in the range [2, 15].
    You can print different paths in any order, but you should keep the order of nodes inside one path.


*/
class Solution {
    List<List<Integer>> res=new ArrayList<>();//Take the global variable or we can create res inside allPathSourceTarget() method and can pass this as parameter of logic() method.
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> l=new ArrayList<>();
        l.add(0);
        logic(graph,0,l);
        return res;
        
    }
    public void logic(int[][] nums,int index,List<Integer> l)
    {
        if(index==nums.length-1)
        {
            res.add(l);
            return;
        } 
        for(int i=0;i<nums[index].length;i++)//Add node into list, perform logic, remove node from list
        {
            //System.out.println(nums[index][i]+" "+l.size());
            l.add(nums[index][i]);
            logic(nums,nums[index][i],new ArrayList<Integer>(l));
            l.remove(new Integer(nums[index][i]));
        }
    }
}
/*
Time Complexity - O(n^2) Considering a strongly connected directed acyclic graph, each node will be connected to remaining n-1 nodes. So total n(n-1) edges.
Space Complexity - O(n) as nodes are stored in implicit stack and can have atmost n nodes in it at any point of time

*/
