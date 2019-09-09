import java.util.*;
import java.io.*;


class RangeMinimumBinaryTree{
    
    int []segment;
    
    RangeMinimumBinaryTree(int size){
        segment=new int[size];
    }
    
   int MinSegmentTree(int ss, int se, int si, int []arr){
        
        if(ss==se) return arr[ss];
        
       int mid= mid(ss, se);
       
        segment[si]= Math.min(MinSegmentTree(ss, mid, 2*si+1,arr), MinSegmentTree(mid+1, se,2*si+2,arr));
       
       return segment[si];
        
    }
    
    int mid(int a, int b){
        
        return a+ (b-a)/2;
    }
    
    void printSegmentTree(){
        for(int i=0;i<segment.length;i++){
            System.out.print(segment[i]+" ");
        }
        
        System.out.println();
    }
    
    
    int rmq(int qs, int qe, int ss, int se, int i){
        
        if(ss>=qs && se<=qe){
            return segment[i];
            
        }
        
        if(se<qs || ss>qe) return Integer.MAX_VALUE;
        
        int mid=mid(ss,se);
        
        return Math.min(rmq(qs,qe,ss,mid,2*i+1),rmq(qs,qe,mid+1,se,2*i+2));
    }


public static void main(String []asdds){
    
    Scanner scan=new Scanner(System.in);
    
    int N=scan.nextInt();
    int []arr=new int[N];
    
    for(int i=0;i<N;i++){
        
        arr[i]=scan.nextInt();
        
    }
    
    int h=  (int)(Math.log(N)/Math.log(2));
    int size= 2*(int)Math.pow(2,h) -1;
    
    System.out.println("HIEGHT "+h);
    System.out.println("SIZE "+size);
    
     RangeMinimumBinaryTree rg=new RangeMinimumBinaryTree(size);
    
    rg.MinSegmentTree(0,N-1,0,arr);
    
    System.out.println("Range Minimum Segment Tree");
    rg.printSegmentTree();
    
    System.out.println("PLEASE PROVIDE A GIVEN RANGE");
    int qs=scan.nextInt();
    int qe=scan.nextInt();
    
    System.out.println("RANGE RESUTL "+rg.rmq(qs,qe,0,N-1,0));
}

}