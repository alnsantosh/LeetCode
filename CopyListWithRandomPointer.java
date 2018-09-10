/*
138. Copy List with Random Pointer

https://leetcode.com/problems/copy-list-with-random-pointer/description/

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
 /*
 Use map to store the original node as key and the corresponding deep copy of the node as value. Then make all the connections as applicable
 */
 
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode,RandomListNode> m=new HashMap<>();
        RandomListNode temp=head;
        while(temp!=null)
        {
            m.put(temp,new RandomListNode(temp.label));
            temp=temp.next;
        }
        temp=head;
        while(temp!=null)
        {
            m.get(temp).next=m.get(temp.next);
            m.get(temp).random=m.get(temp.random);
            temp=temp.next;
        }
        return m.get(head);
    }
}

/*
Time Complexity - O(n) - two iterations across the linked list
Space Complexity - O(n) - Used map
*/
