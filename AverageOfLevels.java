
import java.util.*;
import java.io.*;

class AverageOfLevels{
    
    Node root;
    
    
    void printAverages(Node node){
        
        Queue<Node> queue=new LinkedList<Node>();
        
        queue.add(node);
        
        int level=0;
        while(!queue.isEmpty()){
            
            int count =queue.size();
            int dec=count;
            
            int sum=0;
            
            while(count!=0){
                
                Node temp=queue.poll();
                sum=sum+temp.data;
                
                if(temp.left!=null) queue.add(temp.left);
                
                if(temp.right!=null) queue.add(temp.right);
                
                count --;    
                
            }
            
            System.out.println( "AVERAGE OF LEVEL  "+level+" is "+( (float)sum/dec ));
            level++;
            
        }
        
        
    }

public static void main(String []args){
    
    AverageOfLevels tree_level=new AverageOfLevels();
    
    tree_level.root=new Node(1);
    tree_level.root.left=new Node(2);
    tree_level.root.right=new Node(3);
    tree_level.root.left.left=new Node(4);
    tree_level.root.left.right=new Node(5);
    tree_level.root.right.left=new Node(6);
    tree_level.root.right.right=new Node(7);
    
   tree_level.printAverages(tree_level.root);


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