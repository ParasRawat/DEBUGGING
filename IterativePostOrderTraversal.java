import java.util.*;
import java.io.*;

class IterativePostOrderTraversal{
    
    
    Node root;
    
    void postOrderTraversal(){
        
        Stack<Node> stacka=new Stack<Node>();
        
        Stack<Node> stackb=new Stack<Node>();
        
        
        stacka.push(root);
        
        while(!stacka.empty()){
            
            Node temp=stacka.pop();
            
            stackb.push(temp);
            
            if(temp.left!=null) stacka.push(temp.left);
            
            if(temp.right!=null) stacka.push(temp.right);
            
            
        }
        
        while(!stackb.empty()){
            System.out.print(stackb.pop().data+" ");
        }
    }

public static void main(String []args){

    IterativePostOrderTraversal tree_level=new IterativePostOrderTraversal();
     tree_level.root=new Node(1);
        tree_level.root.left=new Node(2);
        tree_level.root.right=new Node(3);
        tree_level.root.left.left=new Node(4);
        tree_level.root.left.right=new Node(5);
    
tree_level.postOrderTraversal();
    

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