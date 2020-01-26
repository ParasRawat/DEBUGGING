import java.io.*;
import java.util.*;

class UniquePossibleCombinations{
//lets make this generic one 
static void callingUtil(int n, int []arr){
    int cur_sum=0;
    StringBuffer cur_set=new StringBuffer();
    int l=arr.length;
    
    
        
        findSol(0, cur_sum, cur_set, arr, n,l);
    
}
static void findSol(int index, int cur_sum, StringBuffer cur_set, int []arr, int n, int l){
    
    if(cur_sum==n) {
        System.out.println(cur_set.toString());
        return;
    }
    if(cur_sum>n) return;
    
    for(int i=index; i<l;i++){
        
        cur_set.append(arr[i]);
        cur_sum=cur_sum+arr[i];
        findSol(i, cur_sum, cur_set, arr, n,l);
        
        cur_sum=cur_sum-arr[i];
        cur_set.deleteCharAt(cur_set.length()-1);
        
    }
     
}
 public static void main(String []args){
     Scanner scan=new Scanner(System.in);
     
     int n=scan.nextInt();
     int l=scan.nextInt();
    
     int []arr=new int[l];
     for(int i=0;i<l;i++){
         arr[i]=scan.nextInt();
     }
     
     callingUtil(n,arr);
 }
}