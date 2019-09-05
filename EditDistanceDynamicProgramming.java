import java.util.*;
import java.io.*;

class EditDistanceDynamicProgramming{

    
    static int min(int x,int y,int z) 
    { 
        if (x <= y && x <= z) return x; 
        if (y <= x && y <= z) return y; 
        else return z; 
    }
    
    static int editDistance(String s1, String s2, int m, int n){
        
        int [][]dp=new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            
            for(int j=0;j<=n;j++){
                
                if(i==0) dp[i][j]=j;
                else if(j==0) dp[i][j]=i;
                
                
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                
                else{
                    
                    dp[i][j]=1+min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
                }
            }
            
            
        }
        
        
        return dp[m][n];
        
    }
public static void main(String []args){

    Scanner scan=new Scanner(System.in);
    String s1=scan.nextLine();
    String s2=scan.nextLine();
    
    int m=s1.length();
    
    int n=s2.length();
    
    System.out.println(editDistance(s1,s2,m,n));

    
}

}