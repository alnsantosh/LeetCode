/*
117. Populating Next Right Pointers in Each Node II

https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/

Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    Recursive approach is fine, implicit stack space does not count as extra space for this problem.

Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7

After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL

*/

/*
Idea - BFS approach. I have used two arralist to implement the bfs approach. Keep alternating between two stacks for each level in the tree.
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        List<TreeLinkNode> l1=new ArrayList<>();
        List<TreeLinkNode> l2=new ArrayList<>();
        l1.add(root);
        while(l1.size()!=0 || l2.size()!=0)
        {
            TreeLinkNode x=null;//x is used to store the previous TreeLinkNode so that its next pointer can be assigned
            while(l1.size()!=0)
            {
                TreeLinkNode t=l1.get(0);//get the 0th element and remove it from the list
                t.next=null;//Making it null initially, later it is updated accordingly
                l1.remove(0);
                if(t.left!=null)
                    l2.add(t.left);
                if(t.right!=null)
                    l2.add(t.right);
                if(x!=null)//Next 3 lines from here is logic for updating the next pointer
                    x.next=t;
                x=t;
            }
            if(l1.size()==0 && l2.size()==0)//chcecking the condition again so that it doesnt give any errors or exception
                return;
            //same logic here too
            x=null;
            while(l2.size()!=0)
            {
                TreeLinkNode t=l2.get(0);
                t.next=null;
                l2.remove(0);
                if(t.left!=null)
                    l1.add(t.left);
                if(t.right!=null)
                    l1.add(t.right);
                if(x!=null)
                    x.next=t;
                x=t;
            }
            
        }
    }
}
/*
Time Complexity - O(n) - since we are iterating through all the elements in the array
Space Complexity - O(2^h) - where h is height of tree. 2^h - Number of nodes  at height h
*/
