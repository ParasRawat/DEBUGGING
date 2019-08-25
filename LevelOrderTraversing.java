import java.util.*;
import java.io.*;
class LevelOrderTraversing{
    
    Node root;
    
     void printLevelOrderTraversal(){
        
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            Node node=q.poll();
            System.out.print(node.data+" ");
            
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
        }
        
        
    }
    public static void main(String []args){
        System.out.println("Level Order Traversing");
        
        LevelOrderTraversing tree_level=new LevelOrderTraversing();
        tree_level.root=new Node(1);
        tree_level.root.left=new Node(2);
        tree_level.root.right=new Node(3);
        tree_level.root.left.left=new Node(4);
        tree_level.root.left.right=new Node(5);
        tree_level.root.left.right.left=new Node(6);
        
        tree_level.printLevelOrderTraversal();
        
        
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
    