static int height(Node root) {
      	// Write your code here.
        if(root==null)
            return -1; //we put -1 so that when we reach leaf node we remove the excess addition.
        int left=1+height(root.left);
        int right=1+height(root.right);
        return (left>right)?left:right;
            
    }
    
    void preOrder(Node root) {
    if(root!=null)
    {
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    

}
