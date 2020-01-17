import java.util.*;
import java.io.*;

class KnightTour{

    public static int N;
    KnightTour(int n){
        N=n;
    }
    
    boolean isSafe(int x, int y, int [][]board){
        
        return (x>=0 && x<N && y>=0 && y<N && board[x][y]==-1);
        
    }
    
    boolean solveKt(int x, int y, int mooveNumber, int []nextx, int []nexty, int [][]board){
        
        if(mooveNumber==N*N) return true;
        
        int next_x, next_y;
        for(int i=0;i<8;i++){
            
            next_x= x+ nextx[i];
            next_y=y+nexty[i];
            
            if(isSafe(next_x, next_y, board)){
                board[next_x][next_y]=mooveNumber;
                
                if(solveKt(next_x,next_y,mooveNumber+1,nextx,nexty,board)){
                    return true;
                }
                else{
                    board[next_x][next_y]=-1;
                }
            }
        }
        
        return false;
    }
    void util(int n){
        int [][]board=new int[n][n];
        int []x={2, 1, -1, -2, -2, -1, 1, 2};
        int []y={1, 2, 2, 1, -1, -2, -2, -1};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=-1;
            }
        }
        
        board[0][0]=0;
        if(solveKt(0,0,1,x,y,board)){
            printBoard(board);
            
        }
        else{
            System.out.println("No feasible solution");
        }
    }
public static void main(String []args){

    Scanner scan=new Scanner(System.in);
    int n=scan.nextInt();
    KnightTour kt=new KnightTour(n);
    kt.util(n);
    
}
    
    static void printBoard(int [][]board){
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j]+"    ");
                
            }
            System.out.println();
            
        }
    }

}