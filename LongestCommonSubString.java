import java.util.*;
import java.io.*;
class LongestCommonSubString{
    
    int lcs(char[]c1, int x, char[]c2, int y, int count){
        if(x==0 || y==0) return count;// no solution possible from here
        
        if(c1[x-1] == c2[y-1]){
            
            count = lcs(c1,x-1,c2,y-1,count+1);
            
        }
        
        count = Math.max(count , Math.max(lcs(c1,x-1,c2,y,0),lcs(c1,x,c2,y-1,0)));
        
        return count;
    }
    
    public static void main(String []str){
        Scanner scan = new Scanner(System.in);
        
        String s1= scan.nextLine();
        String s2= scan.nextLine();
        
        char []c1= s1.toCharArray();
        char []c2= s2.toCharArray();
        
        int x=c1.length;
        int y=c2.length;
        
        System.out.println(new LongestCommonSubString().lcs(c1,x,c2,y,0));
    }
}