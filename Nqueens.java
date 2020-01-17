import java.util.*;
class Nqueens{
    public static final int N=10;
    
    static boolean isSafe(int row, int col, int [][]board){
        //check the row
        for(int i=0;i<col;i++){
            if(board[row][i]==1){
                return false;
            }
        }
        
        //uper diagonal
        for(int i=row, j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]==1) return false;
            
        }
        
        for(int i=row, j=col;i<N && j>=0; i++,j--){
            if(board[i][j]==1) return false;
        }
        
        return true;
        
    }
    
    static boolean solveQueen(int col, int [][]board){
        if(col>=N) return true;
        
        for(int i=0;i<N;i++){
            if(isSafe(i,col,board)){
                board[i][col]=1;
                if(solveQueen(col+1,board)) return true;
                
                
                 board[i][col]=0;
            }
            
           
        }
        return false;
        
    }
    
    

    public static void main(String []args){
        int [][]board=new int[N][N];
        
        if(solveQueen(0,board)){
            //print
            printBoard(board);
        }
        else{
            //NO FEASIBLE SOLUTION
            System.out.println("No feasible solution");
            
        }
        
    }
    static void printBoard(int [][]board){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
    }
}