static int height(Node root) {
      	// Write your code here.
        if(root==null)
            return -1; //we put -1 so that when we reach leaf node we remove the excess addition.
        int left=1+height(root.left);
        int right=1+height(root.right);
        return (left>right)?left:right;
            
    }
///////////////
/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	static int height(Node root) { //Alternate way to find height of binary tree
      	// Write your code here.
        int left=0,right=0;
        if(root.left!=null)
           left=1+height(root.left);
        if(root.right!=null)
            right=1+height(root.right);
        return (left>right)?left:right;
            
    }
//////////////    
    void preOrder(Node root) {
    if(root!=null)
    {
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    

}
//////////////
/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	void topView(Node root) {
        Node temp=root;
        Stack<Node> s=new Stack<>();
        while(temp!=null)
        {
            s.push(temp);
            temp=temp.left;
        }
        //System.out.println(s.size());
        while(!s.isEmpty())
        {
            Node tmp=s.pop();
            System.out.print(tmp.data+" ");
        }
        root=root.right;
        while(root!=null)
        {
            System.out.print(root.data+" ");
            root=root.right;
        }
    }

////////////////////////////////
	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	void levelOrder(Node root) { //For the level order traversal, we can use queue or list, and keep pushing the left and right childs of each node and then removing that node from the queue/list. This is for left to right level order traversal
        List<Node> l=new ArrayList<>();
        l.add(root);
        while(l.size()!=0)
        {
            
            Node temp=l.remove(0);
            System.out.print(temp.data+" ");
            if(temp.left!=null)
            {
                l.add(temp.left);
            }
            if(temp.right!=null)
            {
                l.add(temp.right);
            }
            
        }
        
        
    }

//Complexity time -
//Complexity space- 


///////////////////////////


