/*
559. Maximum Depth of N-ary Tree

https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/

Given a n-ary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
For example, given a 3-ary tree:
We should return its max depth, which is 3.
Note:
The depth of the tree is at most 1000.
The total number of nodes is at most 5000.

*/
/*
Idea - Similar to finding height of a binary tree
Start with base case 
1)If root==null, return 0
2)If the root is leaf node, return 1
For rest of the cases, just call the funtion recursively for all the childrens and store the max value obtained. Return that value after adding 1 to it which gives the heigh of the tree at that node
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        if(root==null)
            return 0;
        if(root.children==null || root.children.size()==0)
            return 1;
        int max=0;
        for(int i=0;i<root.children.size();i++)
        {
            int temp=maxDepth(root.children.get(i));
            if(temp>max)
                max=temp;
        }
        return max+1;
    }
}
/*
Time Complexity - O(n) - Since we are traversing through all the nodes of the tree
Space Complexity - O(h) = O(n) in case of a skewed tree
*/
