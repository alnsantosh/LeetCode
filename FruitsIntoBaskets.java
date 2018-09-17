/*
904. Fruit Into Baskets

https://leetcode.com/problems/fruit-into-baskets/description/

In a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:

Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure?

 

Example 1:

Input: [1,2,1]
Output: 3
Explanation: We can collect [1,2,1].
Example 2:

Input: [0,1,2,2]
Output: 3
Explanation: We can collect [1,2,2].
If we started at the first tree, we would only collect [0, 1].
Example 3:

Input: [1,2,3,2,2]
Output: 4
Explanation: We can collect [2,3,2,2].
If we started at the first tree, we would only collect [1, 2].
Example 4:

Input: [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
Explanation: We can collect [1,2,1,1,2].
If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 

Note:

1 <= tree.length <= 40000
0 <= tree[i] < tree.length
*/

/*
Idea - Used two pointers approach

Take left and right pointer both pointing at 0 index.
Use a map to store two keys atmost whose value would be the number of times the key is observed in tree
Move the right pointer till map has 2 keys and right is pointing to a number which is not in map.
Now move left pointer and decrement the count associated with the key. When the value associated with any key becomes zero, then remove that key and start incrementing the right pointer.
Continue this process till right reaches end of the tree array.
*/
class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer,Integer> s=new HashMap<>();
        int left=0,right=0;
        int max=0;//stores the difference between left and right pointer
        while(right<tree.length)
        {
            //System.out.println(left+" "+right+"");
            // for(int i:s.keySet())
            // {
            //     System.out.print("Map: "+i+" "+s.get(i));
            // }
            //System.out.println();
            if(s.containsKey(tree[right]) || s.size()<2)//logic to move right pointer
            {
                s.put(tree[right],s.getOrDefault(tree[right],0)+1);
                right++;
            }
            else//logic to move left pointer
            {
                s.put(tree[left],s.get(tree[left])-1);
                if(s.get(tree[left])==0)
                {
                    s.remove(tree[left]);
                }
                left++;
            }
            max=(right-left>max)?right-left:max;
        }
        return max;
    }
}

//[3,3,3,1,1,1,2,1,2,1,2] - good example

/*
Time Complexity - O(n)
Space Complexity - O(1) - Map is used but it always have 2 keys atmost
*/
