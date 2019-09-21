import java.util.*;

class LeftMostNode{

Node root;
    
    
void printCornerElements(Node node){
    
    Queue<Node> q=new LinkedList<Node>();
    
    q.add(node);
    q.add(null);
    boolean isFirst=false;
    boolean isOne=false;
    int last=-1; 
    
    while(!q.isEmpty()){
        
    Node temp=q.poll();
    
        
        if(isFirst){
            
            System.out.print(temp.data+" ");
            
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
            
            isFirst=false;
            isOne=true;
            
            
        }
        
        else if (temp==null){
            
            //MEANS THAT A LEVEL HAS BEEN COMPLETELY TRAVERSED, THEREFORE ALL ITS CHILDREN ARE ALSO ADDED IN THE QUEUE, NOW WE NEED A LEVEL BEAK
            if(q.size()>=1) q.add(null);
            
            isFirst=true;
            
            if(!isOne) System.out.print(last+" ");
            
            
        }
        
        else{
           
            last =temp.data;
            
            isOne=false;
            
            if(temp.left!=null) q.add(temp.left);
            
            if(temp.right!=null) q.add(temp.right);
            
        }
        
    }
    
}
    
public static void main(String []a){

    LeftMostNode tree_level=new LeftMostNode();
    
    tree_level.root=new Node(15);
    tree_level.root.left=new Node(10);
    tree_level.root.right=new Node(20);
    tree_level.root.left.left=new Node(8);
    tree_level.root.left.right=new Node(12);
    tree_level.root.right.left=new Node(16);
    tree_level.root.right.right=new Node(25);
    
    tree_level.printCornerElements(tree_level.root);
    

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