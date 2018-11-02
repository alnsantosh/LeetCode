/*
817. Linked List Components

https://leetcode.com/problems/linked-list-components/description/

We are given head, the head node of a linked list containing unique integer values.

We are also given the list G, a subset of the values in the linked list.

Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

Example 1:

Input: 
head: 0->1->2->3
G = [0, 1, 3]
Output: 2
Explanation: 
0 and 1 are connected, so [0, 1] and [3] are the two connected components.
Example 2:

Input: 
head: 0->1->2->3->4
G = [0, 3, 1, 4]
Output: 2
Explanation: 
0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
Note:

If N is the length of the linked list given by head, 1 <= N <= 10000.
The value of each node in the linked list will be in the range [0, N - 1].
1 <= G.length <= 10000.
G is a subset of all values in the linked list.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
Idea - Use a set to store all the values of G as contains() operation is O(1) iin set, however in araay, it is O(n)
Now iterate through all the elements in the linked list and increment the count whenever a new connected component is found
*/
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<G.length;i++)
        {
            s.add(G[i]);
        }
        int count=0;
        boolean connect=false;//to make sure that we do not increment count for the same connected component
        while(head!=null)
        {
            if(s.contains(head.val))
            {
                if(!connect)//when we see a connected component for the first time, at that time connect will be false, hence the count will be incremented. However after that I am making that boolean variable true so that I won't increment the count untill I stay in that connected component.When I reach a node which is not present in the set means the end of connected component, at this moment else part is executed where I am making connect=true so that I can increment count next time I see a connected component.
                    count++;    
                connect=true;
            }
            else
            {
                connect=false;
            }
            head=head.next;
        }
        return count;
    }
}
/*
Let n be the length of linked list and m be the length of G array
Time Complexity - O(n+m) = O(n) n>=m as it is given the G is subset of the values in the linked list
Space Complexity - O(m) - For storing the values in array G into a set as the contains() operation in set is O(1)
*/
