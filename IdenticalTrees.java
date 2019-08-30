import java.util.*;
import java.io.*;
class IdenticalTrees{

    Node root;
public static void main(String []args){

//TWO TREES ARE IDENTICAL WHEN THEY HAVE THE SAME DATA AND THE ARRRANGEMENT OF THE DATA IS ALSO THE SAME
    
    IdenticalTrees tree_level=new IdenticalTrees();
    tree_level.root=new Node(2);
        tree_level.root.left=new Node(7);
        tree_level.root.right=new Node(5);
        tree_level.root.left.right=new Node(6);
        tree_level.root.right.right=new Node(9);
        tree_level.root.left.right.left=new Node(111);
        tree_level.root.left.right.right=new Node(11);
        tree_level.root.right.right.left=new Node(4);
    
    
    IdenticalTrees tree_levelb=new IdenticalTrees();
    
    tree_levelb.root=new Node(2);
        tree_levelb.root.left=new Node(7);
        tree_levelb.root.right=new Node(5);
        tree_levelb.root.left.right=new Node(6);
        tree_levelb.root.right.right=new Node(9);
        tree_levelb.root.left.right.left=new Node(111);
        tree_levelb.root.left.right.right=new Node(11);
        tree_levelb.root.right.right.left=new Node(4);
    
    System.out.println(checkIdentical(tree_level.root, tree_levelb.root));
    

    
}
    
    static boolean checkIdentical(Node roota, Node rootb){
        Queue<Node> qa=new LinkedList<Node>();
        Queue<Node> qb=new LinkedList<Node>();
        
        qa.add(roota);
        qb.add(rootb);
        
        while(!qa.isEmpty() && !qb.isEmpty()){
            
            Node tempa=qa.poll();
            Node tempb=qb.poll();
            
            if(tempa.data!=tempb.data) return false;
            
            if(tempa.left!=null && tempb.left!=null){
                qa.add(tempa.left);
                qb.add(tempb.left);
            }
            
           else if(tempa.left!=null || tempb.left!=null){
                
                return false;
            }
            
            
            
            if(tempa.right!=null && tempb.right!=null){
                qa.add(tempa.right);
                qb.add(tempb.right);
            }
            
            
            else if(tempa.right!=null || tempb.right!=null){
                
                return false;
            }
            
            
        }
        
        return true;
    }
    
}

class Node{
    int data;
    Node right;
    Node left;
    
    Node(int data){
        
        this.data=data;
        right=left=null;
        
    }
}