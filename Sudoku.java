import java.util.*;
class Sudoku{
public static final Scanner scan=new Scanner(System.in);
public static void main(String []args){
    int n=scan.nextInt();
    int [][]board={
        {5,3,0,0,7,0,0,0,0},
        {6,0,0,1,9,5,0,0,0},
        {0,9,8,0,0,0,0,6,0},
        {8,0,0,0,6,0,0,0,3},
        {4,0,0,8,0,3,0,0,1},
        {7,0,0,0,2,0,0,0,6},
        {0,6,0,0,0,0,2,8,0},
        {0,0,0,4,1,9,0,0,5},
        {0,0,0,0,8,0,0,7,9}
    };
    
    boolean sucess=solveSudoku(board,n,0,0);
    
    if(sucess){
        printBoard(board,n);
        
    }
    else{
        
        System.out.println("I AM SORRY, WE CANNOT SOLVE THIS ONE");
        
    }
}
    
    static boolean solveSudoku(int [][]board,int n,int row, int col){
        
        if(row ==n){ return true;
                   }
        if(col==n){
            //START WITH A NEW ROW;
            return solveSudoku(board,n,row+1,0);    
        }
        
        if(board[row][col]!=0) return solveSudoku(board,n,row,col+1);
        
        for(int curNum=1;curNum<=n;++curNum){
            
            if(canPlace(board,n,row,col,curNum)){
                board[row][col]=curNum;
                
                boolean success=solveSudoku(board,n,row,col+1);
                if(success) return true;
                board[row][col]=0;
                
            }
        }
        return false;
    }
    
    static void printBoard(int board[][], int n){
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                System.out.print(board[i][j]+"   ");
                
            }
            System.out.println("");
            System.out.println("");
        }
    }
    
    static boolean canPlace(int [][]board,int n, int row, int col,int curNum){
        
        if(board[row][col]!=0) return false;
        //check the row and column are in the box or not 
        for(int i=0;i<n;i++){
            if(board[row][i]==curNum) return false;
            if(board[i][col]==curNum) return false;
        }
        
        // x/ root(n)
        // y/root(n) will give us the index of those big rows and columns that form the boxes in a sudoku
        
        int rootn =(int)Math.sqrt(n);
        int boxrow=row/rootn;
        int boxcol=col/rootn;
        int boxStartCellRow = boxrow*rootn;
        int boxStartCellCol=  boxcol*rootn;
        
        for(int i=boxStartCellRow; i<boxStartCellRow+rootn;i++){
            
            for(int j=boxStartCellCol ;j<boxStartCellCol+rootn;j++){
               
                if(board[i][j]==curNum) return false;
            }
        }
        
        return true;
        
        
    }
}