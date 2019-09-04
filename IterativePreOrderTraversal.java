import java.util.*;
import java.io.*;


class IterativePreOrderTraversal{
    
    Node root;
    
    void preOrderTraversal(){
         Stack<Node> stack=new Stack<Node>();
    
    stack.push(root);
    
    while(!stack.empty()){
        
        Node temp=stack.pop();
        
        System.out.print(temp.data+" ");
        
        
        if(temp.right!=null) stack.push(temp.right);
        if(temp.left!=null) stack.push(temp.left);
        
    }
    }

public static void main(String []agrs){
    
    IterativePreOrderTraversal tree_level=new IterativePreOrderTraversal();
    
      tree_level.root=new Node(1);
        tree_level.root.left=new Node(2);
        tree_level.root.right=new Node(3);
        tree_level.root.left.left=new Node(4);
        tree_level.root.left.right=new Node(5);
        
    tree_level.preOrderTraversal();
   
  
       
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