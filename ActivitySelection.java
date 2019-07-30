import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ActivitySelection {
    private static final Scanner scanner = new Scanner(System.in);
    
    static int ActivitySelection(int [][]arr,int col){
        //SORTING ON THE INPUT BASIS OF COLUMN 2 (INDEX 1)
        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int []a, int []b){
                if(a[col]>b[col])
                    return 1;
                else
                    return -1;
            }
        });
        
        int count=1;
        int n=arr.length;
        //J=LAST INSERTED ACTIVITY
        int j=0;
        
        //APPLYING THE GREEDY SELECTOR
        for(int i=1;i<n;i++){
            if(arr[i][0]>=arr[j][1]){
                count++;
                j=i;
                
            }
        }
        
        return count;
    }
    
    static void sortByColumn(int arr[][],int col){
    
    }
    public static final Scanner scan=new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        // N =NUMBER OF ACTIVITIES
        int n=scan.nextInt();
        int [][]arr=new int[n][2];
        //TAKING START AND END INDICES FOR THOSE ACTIVITIES
        // 1 3
        // 3 4 
        // ETC
        for(int i=0;i<n;i++){
            int x=scan.nextInt();
            int y=scan.nextInt();
            
            arr[i][0]=x;
            arr[i][1]=y;
        }
        
        
        
        int result= ActivitySelection(arr,1);
        System.out.println(result);
    }
}
