import java.util.*;
import java.lang.*;
import java.io.*;
class LongestCommonSubStringDynamic
 {
	public static void main (String[] args)
	 {
	 //code
	 Scanner scan=new Scanner(System.in);
	 int t=scan.nextInt();
	 for(int k=0;k<t;k++){
	     int m= scan.nextInt();
	     int n= scan.nextInt();
	     scan.nextLine();
	     
	     String s1= scan.nextLine();
	     String s2= scan.nextLine();
	     
	     char []c1 =s1.toCharArray();
	     char []c2 =s2.toCharArray();
	     
	     int result =0;
	     
	     int [][]lcs =new int[m+1][n+1];
	     for(int i=0;i<=m;i++){
	         for(int j=0;j<=n;j++){
	             
	             if(i==0|| j==0) lcs[i][j]=0;
	             
	             else if(c1[i-1]==c2[j-1]){
	                 lcs[i][j]= 1+ lcs[i-1][j-1];
	                 result= Math.max(result, lcs[i][j]);
	             }
	             else{
	                 lcs[i][j]=0;
	             }
	         }
	     }
	     
	     System.out.println(result);
	     
	     
	 }
	 }
}