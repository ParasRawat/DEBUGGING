import java.util.*;
import java.io.*;
class CountLeafNodes{
Node root;

void countPrintLeaf(){
    int count=0;
        Queue<Node> queue=new LinkedList<Node>();
        
        queue.add(root);
    
    while(!queue.isEmpty()){
        Node temp=queue.poll();
        //PERFORMING NORMAL BREADTH FIRST TRAVERSAL AND ADDING JUDGING THE INCOMMING ROOTS FOR CHILD ROOTS OR NOT
        
        
        if(temp.right==null && temp.left==null) {
            count++;
            System.out.println(temp.data);
        }
        
        if(temp.right!=null) queue.add(temp.right);
        
        if(temp.left!=null) queue.add(temp.left);
        
    }
    
    System.out.println(count);
}
public static void main(String []args){
//level order traversal and find which is a child node
   CountLeafNodes tree_level=new CountLeafNodes();
    tree_level.root=new Node(2);
        tree_level.root.left=new Node(7);
        tree_level.root.right=new Node(5);
        tree_level.root.left.right=new Node(6);
        tree_level.root.right.right=new Node(9);
        tree_level.root.left.right.left=new Node(1);
        tree_level.root.left.right.right=new Node(11);
        tree_level.root.right.right.left=new Node(4);

    tree_level.countPrintLeaf();
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