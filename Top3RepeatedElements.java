import java.io.*;
import java.util.*;

class Pair{
    
    int first;
    int second;
    
}
class Top3RepeatedElements{
    
    public static void top3Elements(int []arr, int n){

        LinkedHashMap<Integer,Integer> map =new LinkedHashMap<>();
        
        for(int a:arr){
            
            if(map.containsKey(a)){
                map.put(a, 1+map.get(a));       
            }
            else{   
                map.put(a,1);
                
            }
            
        }
        
        //take out the first 3 elements
        
        Pair x=new Pair();
        Pair y=new Pair();
        Pair z=new Pair();
        
        x.first = y.first = z.first = Integer.MIN_VALUE;
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            
            if(entry.getValue()>x.first){
                
                 z.first = y.first; 
                 z.second = y.second; 
                 y.first = x.first; 
                
                x.first=entry.getValue();
                x.second=entry.getKey();
                
                
                
            }
            else if (entry.getValue()>y.first){
                z.first = y.first; 
                z.second = y.second; 
                
                y.first=entry.getValue();
                y.second=entry.getKey();
                
                
            }
            else if(entry.getValue()>z.first){
                
                z.first= entry.getValue();
                z.second=entry.getKey();
                
                
            }
            
        }
        
        System.out.println(x.second+" "+y.second+" "+z.second);
        
        
        
        
        
        
    }
    

public static void main(String []args){

    
    Scanner scan=new Scanner(System.in);
    int n=scan.nextInt();
    
    int []arr=new int[n];
    
    for(int i=0;i<n;i++){
        int x=scan.nextInt();
        
        arr[i]=x;
    
    }
    
    top3Elements(arr,n);

}
    

}