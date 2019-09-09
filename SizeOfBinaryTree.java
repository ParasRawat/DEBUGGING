import java.util.*;
import java.io.*;

class SizeOfBinaryTree{
    
   Node root;
    
     int count(Node node){
        
         if(node==null) return 0;
        
         return 1+ count(node.left)+ count(node.right);
    }
    

public static void main(String []args){
    
         SizeOfBinaryTree tree=new  SizeOfBinaryTree();
        tree.root=new Node(1);
    tree.root.left =new Node(2);
    tree.root.right=new Node(3);
    tree.root.left.left=new Node(4);
    tree.root.left.right=new Node(5);
    tree.root.left.right.left=new Node(5);
    
    System.out.println(tree.count(tree.root));
    
    
    
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