import java.util.*;
import java.io.*;
class EditDistanceRecursion{

    static int min(int x,int y,int z) 
    { 
        if (x<=y && x<=z) return x; 
        if (y<=x && y<=z) return y; 
        else return z; 
    } 

    
    static int editDistance(String s1, String s2, int m, int n){
        
        if(m==0) return n;
        
        if(n==0) return m;
        
        
        //MATCHING LAST CHARACTORS:
        if(s1.charAt(m-1)==s2.charAt(n-1))
            return editDistance(s1,s2,m-1,n-1);
        
        
        //1 FOR ONE COST, REST CALCULATE MINIMUM IRRESPECTIVE OF WHATEVER OPERATION WE CHOOSE
        return 1+ min(editDistance(s1,s2,m,n-1),
                     editDistance(s1,s2,m-1,n),
                     editDistance(s1,s2,m-1,n-1));
        
        
    }
public static void main(String []ar){

    Scanner scan=new Scanner(System.in);
    
    String s1=scan.nextLine();
    String s2=scan.nextLine();
    
    int m=s1.length();
    int n=s2.length();
    
    System.out.println(editDistance(s1,s2,m,n));
    
    


}

}