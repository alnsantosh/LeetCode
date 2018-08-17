/*
116. Populating Next Right Pointers in Each Node

https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

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
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7

After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL


*/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
/*
Idea - BFS approach
Take a bummy TreeeLinkNode , say the value is -1
The below code acheives

      -1 -> 1 -> NULL
          /  \
 -1  ->  2 -> 3 -> NULL
        / \  / \
-1 ->  4->5->6->7 -> NULL

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
            TreeLinkNode s=new TreeLinkNode(-1);
            while(l1.size()!=0)
            {
                TreeLinkNode tmp=l1.remove(0);
                s.next=tmp;
                s=tmp;
                if(tmp.left!=null)
                    l2.add(tmp.left);
                if(tmp.right!=null)
                    l2.add(tmp.right);
            }
            s.next=null;
            s=new TreeLinkNode(-1);
            if(l1.size()==0 && l2.size()==0)
                break;
            while(l2.size()!=0)
            {
                TreeLinkNode tmp=l2.remove(0);
                s.next=tmp;
                s=tmp;
                if(tmp.left!=null)
                    l1.add(tmp.left);
                if(tmp.right!=null)
                    l1.add(tmp.right);
            }
            s.next=null;
        }
    }
}
/*
Time Complexity - O(n) - Since all the nodes are being traversed
Space Complexity - O(2^h) - where h is the height of the tree.
Since at any moment, the arraylist will have atmost h nodes
*/
