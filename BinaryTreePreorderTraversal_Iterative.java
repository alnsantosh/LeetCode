
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        if(root==null)
            return res;
        else
        {
            s.push(root);
            while(!s.empty())
            {
                TreeNode top=(TreeNode)s.pop();
                res.add(top.val);
                if(top.right!=null)
                    s.push(top.right);
                if(top.left!=null)
                    s.push(top.left);
            }
            return res;
        }
        
        
    }
}
