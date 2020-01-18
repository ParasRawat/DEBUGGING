import java.util.*;
import java.io.*;

class RatInTheMaze{
    
    public int N;
    RatInTheMaze(int N){
        this.N=N;
        
    }
    boolean isSafe(int x, int y, int[][]maze){
       
        return (x>=0 && x<N && y>=0 && y<N && maze[x][y]==0);
    }
    
    void findPath(int x, int y, StringBuilder str, int [][]maze, int nextx[], int nexty[], String []moves){
        
        if(x==N-1 && y==N-1){
            System.out.println(str.toString());
            
            return;
        }
        
        int next_x, next_y;
        
        for(int i=0;i<4;i++){
            next_x=x+nextx[i];
            next_y=y+nexty[i];
            
            if(isSafe(next_x, next_y,maze)){
                str.append(moves[i]);
                maze[next_x][next_y]=1;
                
                findPath(next_x, next_y,str,maze,nextx,nexty,moves);
                
                str.deleteCharAt(str.length()-1);
                
                maze[next_x][next_y]=0;
                
            }
        }
        
    }
    
    public static void main(String []args){
        
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        RatInTheMaze rt=new RatInTheMaze(n);
        
        String []moves={"D","L","R","U"};
        int []nextx={1,0,0,-1};
        int []nexty={0,-1,1,0};
         int [][]maze=new int[n][n];
        StringBuilder paths=new StringBuilder();    
        maze[0][0]=1;
        StringBuilder str=new StringBuilder();
        rt.findPath(0,0,str,maze,nextx,nexty,moves);
    }

}