/*
173. Binary Search Tree Iterator

https://leetcode.com/problems/binary-search-tree-iterator/description/

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    int i;
    List<Integer> l;
    public BSTIterator(TreeNode root) {
        l=new ArrayList<>();
        logic(root);
        i=0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return i<=l.size()-1;
        
    }

    /** @return the next smallest number */
    public int next() {
        return l.get(i++);
    }
    
    public void logic(TreeNode root)
    {
        if(root==null)
            return;
        else
        {
            logic(root.left);
            l.add(root.val);
            logic(root.right);
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
/*
Time Complexity - 
1)hasNext()-O(1)
2)next()-O(1)
3)logic()-O(n)

Space Complexity-O(n)
*/
