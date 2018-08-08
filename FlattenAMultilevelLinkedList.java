/*
430. Flatten a Multilevel Doubly Linked List

https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/

You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

Example:

Input:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

Output:
1-2-3-7-8-11-12-9-10-4-5-6-NULL

Explanation for the above example:

Given the following multilevel doubly linked list:

We should return the following flattened doubly linked list:


*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
/*
Idea - Traverse till u find a node which has child. If such node not found, then return the head.
Else, assign the head.next to child of that head and call the same function recursively on the child i.e.,new next. 
Assign the returned node of internal recursive function to previous next value of the head node. Apply the funtion recursively again on the right side of the node.
*/
class Solution {
    public Node flatten(Node head) {
        
        logic(head);
        return head;
    }
    
    public Node logic(Node head)
    {
        if(head==null)
            return head;
        while(head.child==null)
        {
            if(head.next!=null)
            {
                head=head.next;
            }
            else
            {
                break;
            }
        }
        Node next2=head.next;
        if(head.child!=null)
        {
            head.next=head.child;
            head.next.prev=head;
            head.child=null;
            head=logic(head.next);
        }
        if(next2!=null)
        {
            head.next=next2;
            next2.prev=head;
            return logic(head.next);
        }
        return head;
    }
}    

/*
Time Complexity - O(n) - In place adjustments made
Space Complexity - O(1)
*/
