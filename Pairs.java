import java.util.*;
import java.io.*;

class Pairs{


    public static void countDistinct(int []arr, int n, int sum){
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],1+map.get(arr[i]));
                
            }
            else{
                map.put(arr[i],1);
                
            }
        }
        int counter=0;
        
        
        for(int i=0;i<n;i++){
        
            if(map.get(sum-arr[i])!=null){
                counter=counter+map.get(sum-arr[i]);
            }
            
            
            if(sum-arr[i]==arr[i]){
                counter--;
            }
        }
        
        
        System.out.println(counter/2);
    }
    
    
public static void main(String []aaasasa){

    Scanner scan=new Scanner(System.in);
    int n=scan.nextInt();
    
    int []arr=new int[n];
    
    for(int i=0;i<n;i++){
        
        int x=scan.nextInt();
        arr[i]=x;
    }
    System.out.println("Please enter the sum");
    
    int sum=scan.nextInt();
    
    countDistinct(arr,n,sum);
}

}