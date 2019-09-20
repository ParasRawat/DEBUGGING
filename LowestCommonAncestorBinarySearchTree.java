class LowestCommonAncestorBinarySearchTree{
    
    Node root;
    
    
    Node lowestBSTAncestor(Node node, int key1, int key2){
        
        if(node==null) return null;

        if(node.data==key1 || node.data==key2) return node;
        
        
        Node rnode=lowestBSTAncestor(node.right, key1, key2);
        
        Node lnode=lowestBSTAncestor(node.left, key1, key2);
        
        if(rnode!=null && lnode!=null) return node;
        
        return (rnode!=null)?rnode:lnode;
        
        
    }

    
    

public static void main(String []a){

 LowestCommonAncestorBinarySearchTree tree_level=new LowestCommonAncestorBinarySearchTree();
    
    tree_level.root= new Node(20);
    tree_level.root.left=new Node(8);
    tree_level.root.left.left=new Node(4);
    tree_level.root.left.right=new Node(12);
    tree_level.root.left.right.left=new Node(10);
    tree_level.root.left.right.right=new Node(14);
    tree_level.root.right=new Node(22);
    
    System.out.println(tree_level.lowestBSTAncestor(tree_level.root,60,14).data);
 

}

}

class Node{
    
    int data;
    
    Node left, right;
    
    Node(int data){
        
        this.data=data;
        left=right=null;
    }
    
}