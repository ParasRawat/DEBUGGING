import java.util.*;
import java.io.*;
class FlyodWarshall{
    public static final int INF= 99999, v=4;
    
    void findAllPairShortestPath(int [][]graph){
        int [][]dist=new int[v][v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                dist[i][j]=graph[i][j];
            }
        }
        
        for(int k=0;k<v;k++){
            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    dist[i][j]=Math.min((dist[i][k]+dist[k][j]),dist[i][j]);
                }
            }
        }
        printShortestPath(dist);
    }
    void printShortestPath(int [][]dist){
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(dist[i][j]==INF) System.out.print("INF ");
                else{
                    System.out.print(dist[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
public static void main(String []args){

    int [][]graph= {
       {0,   5,  INF, 10}, 
        {INF, 0,   3, INF}, 
        {INF, INF, 0,   1}, 
        {INF, INF, INF, 0} 
    };
    
    FlyodWarshall fw=new FlyodWarshall();
    fw.findAllPairShortestPath(graph);
}
}