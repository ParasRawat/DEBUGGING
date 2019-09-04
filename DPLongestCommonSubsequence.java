import java.util.*;
import java.io.*;
class DPLongestCommonSubsequence{


public static void main(String []ar){


    Scanner scan=new Scanner(System.in);
    
    String a=scan.nextLine();
    String b=scan.nextLine();
    
    
    int [][]lcs=new int[a.length()+1][b.length()+1];
    char []A=a.toCharArray();
    char []B=b.toCharArray();
    
    for(int i=0;i<a.length();i++){
        
        for(int j=0;j<b.length();j++){
            
            if(A[i]==B[j]){
                lcs[i+1][j+1]=1+lcs[i][j];
            }else{
                lcs[i+1][j+1]=Math.max(lcs[i][j+1],lcs[i+1][j]);
                
            }
        }
    }
    
    System.out.println(lcs[a.length()][b.length()]);
}
}