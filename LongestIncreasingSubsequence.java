import java.util.*;
import java.io.*;

class LongestIncreasingSubsequence{

   public static void main(String []args){
       
       
        Scanner scan=new Scanner(System.in);
    System.out.println("PLEASE PROVIDE ARRAY LENGTH");
    int n=scan.nextInt();
    
    int []arr=new int[n];
    for(int i=0;i<n;i++){
        arr[i]=scan.nextInt();
    }
    
    int []lis=new int[n];
    
    for(int i=0;i<n;i++){
        
        lis[i]=1;
    }
    
    for(int i=1;i<n;i++){
        
        for(int j=0;j<i;j++){
            
            if(arr[i]>arr[j]){
                
                lis[i]=Math.max(lis[i],lis[j]+1);
            }
        }
        
        
    }
       
       Arrays.sort(lis);
       System.out.println(lis[n-1]);
    
       for(int i=0;i<n;i++){
           System.out.print(lis[i]);
           System.out.println("");
           System.out.print(arr[i]);
       }
   }
    
}