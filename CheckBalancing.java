class CheckBalancing{

    
    Node root;
    
    boolean checkBalancing(Node root){
        
        
        if(root==null) return true;
        
        int lh=treeHeight(root.left);
        
        int rh=treeHeight(root.right);
        
        
        if(Math.abs(lh-rh)<=1 && checkBalancing(root.right) && checkBalancing(root.left)) return true;
        
        
        return false;
    }
    
    
    int treeHeight(Node node){
        
        if(node==null) return 0;
        
        return 1+ Math.max(treeHeight(node.right), treeHeight(node.left));
        
    }
    

    public static void main(String []a){
        
        CheckBalancing tree=new CheckBalancing();
        
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.left.left.left = new Node(8); 
        
        if(tree.checkBalancing(tree.root)) System.out.println("Balanced");
        else{
            
            System.out.println("Unbalanced");
        }
        
        
    }


}

class Node{
    int data;
    Node left;
    Node right;
    
    Node(int data){
        
        this.data=data;
        left=right=null;
        
    }
}