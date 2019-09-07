import java.util.*;
import java.io.*;


class BinomialIDp{


public static void main(String []args){

        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int k=scan.nextInt();
    
    int [][]dp=new int[n+1][k+1];
    
    dp[0][0]=0;
    
    for(int i=1;i<=n;i++){
        
        dp[i][0]=1;
    }
    
    for(int i=1;i<=n;i++){
        
        for(int j=1;j<=k;j++){
            
            if(j==i){
                dp[i][j]=1;
            }
            if(j<i){
                
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
            
            
        }
    }
    
    System.out.println("ANSWER IS "+dp[n][k]);   
    
    for(int i=0;i<=n;i++){
        for(int j=0;j<=k;j++){
            
            System.out.print(dp[i][j]+" ");
        }
        System.out.println();
    }
    
}

}