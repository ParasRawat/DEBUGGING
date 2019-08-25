import java.util.*;
import java.io.*;

class CountHalfNodes{
Node root;
    
void countHalfNodes(){
    
    Queue<Node> q=new LinkedList<Node>();
    
    q.add(root);
    
    int count=0;
    
    while(!q.isEmpty()){
        
        Node temp=q.poll();
        
        if((temp.left!=null && temp.right==null) || (temp.left==null && temp.right!=null)  ) {
            count++;
            System.out.print(temp.data+" ");
        }
        
        if(temp.left!=null) q.add(temp.left);
        
        if(temp.right!=null) q.add(temp.right);
    }
    System.out.println("");
    System.out.println("Total Count is "+count);
    
}
public static void main(String []args){
CountHalfNodes tree_level=new CountHalfNodes();
    tree_level.root=new Node(2);
        tree_level.root.left=new Node(7);
        tree_level.root.right=new Node(5);
        tree_level.root.right.right=new Node(9);
        tree_level.root.right.right.left=new Node(4);
    
        tree_level.root.left.right=new Node(6);
        tree_level.root.left.right.left=new Node(7);
        tree_level.root.left.right.right=new Node(11);
    
    tree_level.countHalfNodes();

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
