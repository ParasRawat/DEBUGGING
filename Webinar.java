import java.util.*;
class Webinar{

    //USING THE STACK RECURSION METHODOLOGY HERE WOULD HELP
public static void main(String []args){
    Scanner scan=new Scanner(System.in);
   
    int n=scan.nextInt();
     int [][]board=new int[n][n];
    board[0][0]=1;
    boolean answer=solveKnightMove(board,n,1,0,0);
    if(answer){
        printBoard(board,n);
        
    }
    else{
        System.out.println("SORRY NOT POSSIBLE");
    }
     
    
}
    
   static boolean solveKnightMove(int[][] board,int n, int move_no,int currow,int curcol){
       if(move_no ==n*n){
           return true;
       }
       //EVERY MOOVE FOR THE KNIGHT HAS THE 8 POSSIBLE MOOVES
       // +-2 +-1 FROM EVERY MOOVE IS POSSIBLE 
       //WE NEED NEXT POSSIBLE 8 CELLS FROM WHERE WE ARE STANDING RIGTH NOW
       // ADD EACH POSSIBLE MOOVE , AND THEN FIRST CHECK IF IT IS IN THE BOARD AND THEN CHECK IF IT HAS BEEN VISITED
       int []rowdir={+2,+1,-1,-2,-2,-1,+1,+2};
       int []coldir={+1,+2,+2,+1,-1,-2,-2,-1};
       
       for(int curdir=0;curdir<8;++curdir){
          int nextRow=currow + rowdir[curdir];
           int nextCol=curcol+ coldir[curdir];
           if(canPlace(board,n,nextRow,nextCol))
           {
               board[nextRow][nextCol]=move_no+1;//place
              boolean isSuccessfull= solveKnightMove(board,n,move_no+1,nextRow,nextCol);
               if(isSuccessfull) return true;
               board[nextRow][nextCol]=0;// removing
           }
           
       }
       return false;
          
   }
    static boolean canPlace(int [][]board, int n, int r, int c){
        return r>=0 && r<n && c>=0 && c<n && board[r][c]==0;
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
    
    
}