import java.util.*;
class BSTSource<T extends Comparable<T>>{
    
    private int nodeCount=0;
    public Node root= null;
    private class Node{
        T data;
        Node left, right;
        public Node(Node left, Node right, T elem){
            this.data=elem;
            this.left= left;
            this.right=right;
        }
        
    }
    
    public boolean isEmpty(){
        return size()==0;
    }
    public int size(){
        return nodeCount;
    }
    //providing a layer of abstraction
    public boolean add(T elem){
        if(contains(elem)) return false;
        
        root = add(root, elem);
        nodeCount++;
        return true;
        
    }
    
    private Node add(Node node, T elem){
        if(node==null){
            node= new Node(null,null,elem);
            
        }else{
            
            if(elem.compareTo(node.data)<0){
                node.left=add(node.left,elem);
            }
            else{
                node.right=add(node.right,elem);
            }
            
        }
        return node;
        
    }
    
    public boolean remove(T elem){
        if(contains(elem)){
            root= remove(root,elem);
            nodeCount--;
            return true;
        }
        else{
            return false;
        }
    }
    private Node remove(Node node, T elem){
        if(node==null) return null;
        int cmp= elem.compareTo(node.data);
        if(cmp<0){
            node.left=remove(node.left, elem);
        }
        else if(cmp>0){
            node.right=remove(node.right, elem);
            
        }
        else{
            //we found the node that we want to remove
            
            if(node.left==null){
                Node rightChild=node.right;
                node.data=null;
                node=null;
                return rightChild;
                
            }
            else if(node.right==null){
                Node leftChild=node.left;
                node.data=null;
                node=null;
                return leftChild;
                    
            }
            else{
                //find left most element in the right subtree;
                Node temp=digLeft(node.right);
                //swap the data;
                //do not touch the pointers here, only the data is to swapped
                node.data=temp.data;
                //removing the swapped node
                node.right=remove(node.right, temp.data);
                
                
            }
        }
        //moving an entire left or the right subtree and placing it in the place of the deleted node 
        
       return node; 
    }
    
    //finding the left most node;
    private Node digLeft(Node node){
        Node cur=node;
        while(cur.left!=null){
            cur=cur.left;
            
        }
        return cur;
    }
    
    public boolean contains(T elem){
        return contains(root, elem);
    }
    //segregate and create as many functions as possible
    private boolean contains(Node node, T elem){
        
        if(node==null) return false;
        
        int cmp= elem.compareTo(node.data);
        if(cmp<0){
            return contains(node.left, elem);
        }
        else if(cmp>0){
            return contains(node.right,elem);
        }
        else{
            return true;
        }
    }
    
    public int hieght(){
        return hieght(root);
    }
    
    private int hieght(Node node){
        if(node==null) return 0;
        
        else return 1+ Math.max(hieght(node.left), hieght(node.right));
    }
    //TREETRAVERSAL ORDER IS AN ENUM TYPE
    public void traverse(TreeTraversalOrder order){
        switch(order) {
            case PRE_ORDER: preOrderTraversal(root);
                break;
            case POST_ORDER:postOrderTraversal(root);
                break;
            case IN_ORDER:  inOrderTraversal(root);
                break;
            default: System.out.println("NOT AN ORDER");
        }
    }
    
    private void preOrderTraversal(Node node){
        
    }
    private void postOrderTraversal(Node node){
        
    }
    private void inOrderTraversal(Node node){
        if(node==null) return;
        inOrderTraversal(node.left);
        System.out.print(node.data+" ");
        inOrderTraversal(node.right);
        
    }
    

    public static void main(String []args){
        //verification, inorder traversal gives the increasing order
        BSTSource<Integer> bst= new BSTSource<>();
        bst.add(1);
        bst.add(2);
        bst.add(3);
         bst.add(0);
         bst.add(5);
         bst.add(100);
         bst.add(10);
         bst.add(9);
         bst.add(7);
        
        bst.traverse(TreeTraversalOrder.IN_ORDER);
    }
}
enum TreeTraversalOrder{
    PRE_ORDER,
    IN_ORDER,
    POST_ORDER,
    LEVEL_ORDER
}