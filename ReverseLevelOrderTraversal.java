import java.util.*;
import java.io.*;
class ReverseLevelOrderTraversal{
Node root;
    
void printReverseOrder(){
    Queue<Node> q=new LinkedList<Node>();
    Stack<Node> s=new Stack<Node>();
    q.add(root);
    
    while(!q.isEmpty()){
        
        Node temp=q.poll();
        
        s.push(temp);
        
        if(temp.right!=null) q.add(temp.right);
        
        if(temp.left!=null)  q.add(temp.left);
        
        
    }
    
    while(!s.empty()){
        Node temp=s.pop();
        
        System.out.print(temp.data+" ");
    }
    
}
public static void main(String []args){
ReverseLevelOrderTraversal tree_level=new ReverseLevelOrderTraversal();
    tree_level.root=new Node(1);
        tree_level.root.left=new Node(2);
        tree_level.root.right=new Node(3);
        tree_level.root.left.left=new Node(4);
        tree_level.root.left.right=new Node(5);
        tree_level.root.left.right.left=new Node(6);
    tree_level.printReverseOrder();

    
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