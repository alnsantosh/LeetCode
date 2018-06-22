/*
257. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3


*/
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
    List<String> res=new ArrayList<String>();//global variable
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        logic(root,"");
        return res;
    }
    public String logic(TreeNode root,String str)
    {
        if(root==null)
            return str;
        if(root.left==null && root.right==null)//if leaf node, then insert the string into the arraylist after adding the leaf node to the current string
        {
            str+=""+root.val;
            res.add(str);
        }
        else//for non-leaf nodes, update the string and call the function iteratively
        {
            str+=""+root.val+"->";
            logic(root.left,str);
            logic(root.right,str);
            
        }
        return str
    }
}
/*
Time Complexity - O(n + l*h) time complexity ... l : number of leaves ... at each leave your will iterate through all the h characters to do the final insertion

Space Complexity - O(h*space acquired by string in the above dfs approach) - i.e., whenever str+="" operation is performed, i.e., whenever string s1 is appended with some string s2, then a new string s3 is created since string is immutable, so no changes can be made to string.(In Java, the complexity of s1.concat(s2) or s1 + s2 is O(M1 + M2) where M1 and M2 are the respective String lengths. Turning that into the complexity of a sequence of concatenations is difficult in general.)

store 1 char in first call, 2 char in second call ... h char in last class ... total is h * (h + 1) / 2 ~ O(h^2)

Instead, if we use StringBuffer/StringBuilder, then insertion time is 1 as they are mutable.In that case space complexity will be O(h)
*/
