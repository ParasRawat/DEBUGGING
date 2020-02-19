import java.util.*;
import java.lang.*;
import java.io.*;
class MinCoinGreedy
 {
	public static void main (String[] args)
	 {
	 //code
	 Scanner scan=new Scanner(System.in);
	 int t=scan.nextInt();
	 for(int k=0;k<t;k++){
	     int n= scan.nextInt();
	     StringBuilder str=new StringBuilder();
	     int []denom ={2000,500,200,100,50,20,10,5,2,1};
	     
	     for(int i=0;i<denom.length;i++){
	         
	         while(n-denom[i]>=0){
	             n=n-denom[i];
	             str.append(denom[i]+" ");
	         }
	     }
	     System.out.println(str.toString());
	 }
	 }
}