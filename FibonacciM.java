import java.util.*;
import java.io.*;

class FibonacciM{

public static void main(String []args){

    Scanner scan=new Scanner(System.in);
    
    int n=scan.nextInt();
    int []lookUp=new int[n+1]; // INITIALISING LOOK UP TABLE TO 0
    
    for(int i=0;i<n+1;i++){
        lookUp[i]=-1;
    }
    System.out.println(fib(n,lookUp));

}
    //WHEN THE SYSTEM TRIES TO COMPUTE ONCE ALREADY COMPUTED VALUES IN THAT CASE IT WILL RETURN ALREADY COMPUTED VALUE
    static int fib(int n, int []lookUp){
        
        if(lookUp[n]==-1){
            
            if(n<=1) lookUp[n]=n;
            else{
                lookUp[n]=fib(n-1,lookUp)+fib(n-2, lookUp);
            }
            
        }
        
        return lookUp[n];
    }

}