/*
146. LRU Cache

https://leetcode.com/problems/lru-cache/description/

Idea - LRU cache can be efficiently designed using HashMap and double linked list. HashMap() helps us to get the key i O(1) time and the LRU logic can be implemented using double linked list.
The HashMap stores Node object(custom double linked list class object) which stores both key,value. It has also links to prev and next node.
We use double linked list as deletion of a given node in the double linked list is O(1). This is the main advantage of double linked list over single linked list. We need to delete the node whenever we call get() or put() method. So it is very important to implement this method in O(1) time.


*/
class Node//custom double linked list implementation
{
    int key,val;
    Node prev,next;
    public Node(int key,int val)
    {
        this.key=key;
        this.val=val;
    }
}
class LRUCache {
    Map<Integer,Node> m=null;//Since we need to retreive the value associated with key in O(1) time, best data structure would be HashMap()
    Node head=null,tail=null;
    int capacity;
    public LRUCache(int capacity) {
        m=new HashMap<>();
        this.capacity=capacity;
    }
    
    public int get(int key) {//If the key is present in the HashMap, then retreive the node and return the value of the node. Also,place the node in the beginning of the linked list. If the key is not present, return -1
        if(!m.containsKey(key))
        {
            return -1;
        }
        Node n=m.get(key);
        remove(n);
        setHead(n);
        
        return n.val;
    }
    
    
    public void put(int key, int value) {//If the key is present in the HashMap(), then update the value associated with the node and place the node in the beginning of the double linked list. Else, create a new node with given key and value, place this node in the beginning of the double linked list
        if(m.containsKey(key))
        {
            Node n=m.get(key);
            n.val=value;
            remove(n);
            setHead(n);
            
        }
        else
        {
            Node n=new Node(key,value);
            if(m.size()==capacity)
            {
                //tail=tail.prev;
                m.remove(tail.key);//Order is very important i.e., m.remove(tail.key) followed by remove(tail). Not reverse as remove() method updates the head and tail values which mess up the entire logic if done in reverse order
                remove(tail);
            
            }
            setHead(n);
            m.put(key,n);
        }
        // for(int i:m.keySet())
        // {
        //     System.out.print(m.get(i).val+" ");
        // }
        // System.out.println("head: "+head.val+" tail: "+tail.val);
        
    }
   
    
    public void remove(Node node)//This method removes the node from the double linked list
    {
        if(node.prev!=null)
        {
            node.prev.next=node.next;
        }
        else
        {
            head=node.next;
        }
        if(node.next!=null)
        {
            node.next.prev=node.prev;
        }
        else
        {
            tail=node.prev;
        }
    }
    
    public void setHead(Node node)//This method is to set node as head i.e., we basically put the given node in the beginning of the double linked list
    {
        if(head!=null)
        {
            head.prev=node;
        }
        node.next=head;
        node.prev=null;
        head=node;
        if(tail==null)
        {
            tail=node;   
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
Time Complexity - O(1) for both get() and put() methods
Space Complexity - O(n) where n=capacity, capacity is passed as parameter to the LRUCache() constructor.
*/
