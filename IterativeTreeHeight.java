import java.util.*;
import java.io.*;

class IterativeTreeHeight{
    
    Node root;
    
    void height(){
        
        Queue<Node> q=new LinkedList<Node>();
        
        q.add(root);
        int h=0;
        
        
        while(true){
            
            int nc=q.size();
            
            if(nc==0) break;
            
            h++;
            
            while(nc!=0){
                
                Node temp=q.poll();
                
                if(temp.left!=null) q.add(temp.left);
                
                if(temp.right!=null) q.add(temp.right);
                
                nc--;
            }
            
        }
        
        System.out.println("HEIGHT OF THE BINARY TREE IS "+h);
        
    }

    public static void main(String []args){
    
        IterativeTreeHeight tree_level=new IterativeTreeHeight();
        
          tree_level.root=new Node(1);
        tree_level.root.left=new Node(2);
        tree_level.root.right=new Node(3);
        tree_level.root.left.left=new Node(4);
        tree_level.root.left.right=new Node(5);
        
        
        tree_level.height();
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