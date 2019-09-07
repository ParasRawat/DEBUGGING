import java.util.*;
import java.io.*;


class SegmentTree{
    
    
    int st[];
    
    //CONSTRUCTOR
    
    SegmentTree(int arr[], int n){
        
        
        //HEIGHT
        
        int x = (int)Math.ceil(Math.log(n)/Math.log(2));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        
        st=new int[max_size]; 
        
        constructSTUtil(arr, 0, n - 1, 0);
        
        
    }
    
    //Mid point
    
    int getMid(int s, int e){
        
        return s + (e - s) / 2;
    }
    
    
    //CONSTRUCTING THE SEGMENT TREE
    
    int constructSTUtil(int []arr, int ss, int se, int si){
        
        if(ss == se){
            st[si]=arr[ss];
            return arr[ss];
        }
        
        //MORE ELEMENT ARE PRESENT , THEREFORE , WE WILL RECURR
        int mid= getMid(ss, se);
        
        st[si]=constructSTUtil(arr,ss, mid, si*2+1)+ constructSTUtil(arr,mid+1,se, si*2+2);
        
        return st[si];
            
    }
    

public static void main(String []args){
    
    int []arr={1,3,5,7,9,11};
    
    // 1 3 5 7 9 11
    //0 -> 1 3 5 + 7 9 11
    //1-> 1 3 + 5
    //3->   4
    //4->   9
    
    int n=arr.length;
    SegmentTree tree=new SegmentTree(arr,n);
    int []narr=tree.st;
    
    for(int i=0;i<narr.length;i++){
        System.out.print(narr[i]+" ");
    }
    

}

}