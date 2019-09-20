class CountLeafRecursion{
    
    Node root;
    
    
    int countLeaf(Node node){
       
        if(node.left==null && node.right==null) return 1;
        
        if(node==null) return 0;
        
        
        return countLeaf(node.left)+countLeaf(node.right);
        
    }

public static void main(String []args){

CountLeafRecursion tree_level=new CountLeafRecursion();
    
    tree_level.root=new Node(1);
    tree_level.root.left=new Node(2);
    tree_level.root.left.left=new Node(4);
    tree_level.root.left.right=new Node(5);
    tree_level.root.right=new Node(3);
    tree_level.root.right.right=new Node(9);
    tree_level.root.right.left=new Node(10);
    
    System.out.println(tree_level.countLeaf(tree_level.root));
    
    
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