import java.util.*;
import java.io.*;

class LongestCommonSubsequence{
    
int lcs(char[]X, char[]Y, int m,int n){
    
    if(m==0 || n==0) return 0;
    
    if(X[m-1]==Y[n-1]){
        return 1+ lcs(X,Y,m-1,n-1);
    }
    
    else{
        
        return Math.max(lcs(X,Y,m-1,n),lcs(X,Y,m,n-1));
    }
}    

public static void main(String []args){

    Scanner scan=new Scanner(System.in);
    String s1=scan.nextLine();
    String s2=scan.nextLine();
    
    char []X=s1.toCharArray();
    char []Y=s2.toCharArray();
    
    int m=X.length;
    int n=Y.length;
    
    LongestCommonSubsequence lcs=new LongestCommonSubsequence();
    System.out.println("LENGTH OF THE COMMON SUBSEQUENCE IS "+" "+lcs.lcs(X,Y,m,n));
}


}