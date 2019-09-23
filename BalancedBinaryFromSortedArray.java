import java.util.*;
import java.io.*;

class BalancedBinaryFromSortedArray{

     
    Node createBalancedBinaryTree(int []arr, int ss, int se){
        
        if(ss>se) return null;
        
        int mid= (ss+se)/2;
        Node root=new Node(arr[mid]);
        
        root.left=createBalancedBinaryTree(arr,ss,mid-1);
        root.right=createBalancedBinaryTree(arr,mid+1, se);
        
        return root;
        
        
    }
    
    void printBfs(Node root){
        
        Queue<Node> q=new LinkedList<Node>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            Node temp=q.poll();
            
            System.out.print(temp.data);
            
            
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
            
        }
        
    }
public static void main(String []ar){
   

    
    Scanner scan=new Scanner(System.in);
    
    int n=scan.nextInt();
    int []arr=new int[n];
    
    for(int i=0;i<n;i++){
        
        arr[i]=scan.nextInt();
        
    }
    
    BalancedBinaryFromSortedArray tree=new BalancedBinaryFromSortedArray();
    Node root=tree.createBalancedBinaryTree(arr,0,arr.length-1);
    tree.printBfs(root);
    
    
    
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