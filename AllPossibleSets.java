import java.util.*;
import java.io.*;

class AllPossibleSets{
    
//RESETING OF VALUES IS MANDATORY FOR BACKTRACKING 
static int n=6;

static void findSolution(int cur_sum, String cur_set, int[]arr){
    
    if(cur_sum==n){
        System.out.println(cur_set.trim());
        
    }
     
    if(cur_sum>n){
        return;
    }
    
    for(int i=0;i<3;i++){
        
        cur_sum+=arr[i];
        cur_set=cur_set+" "+arr[i];
        findSolution(cur_sum, cur_set, arr);
        cur_sum-=arr[i];
        StringBuffer str=new StringBuffer(cur_set);
        str.deleteCharAt(str.length()-1);
        cur_set=str.toString();
    }
     
 }
static void callingUtil(){
    int []arr={1, 3, 5};
    
    int cur_sum=0;
    String cur_set="";
    
    findSolution(cur_sum, cur_set, arr);
}
public static void main(String []arr){
    callingUtil();
}
}