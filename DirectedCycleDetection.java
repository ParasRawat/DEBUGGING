import java.util.*;
import java.io.*;

class DirectedCycleDetection{
    //NUMBER OF VERTICES
    int v;
    
    //ADJACENCY LIST
    LinkedList<Integer> adj[];
    
    DirectedCycleDetection(int v){
        this.v=v;
        
        adj=new LinkedList[v];
        
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<Integer>();
        }
    }
        
        void addEdge(int u, int v){
            
            adj[u].add(v);
        }
        
        boolean cycleDetect(){
            
        boolean[] visited = new boolean[v]; 
        boolean[] recStack = new boolean[v];
        
            for(int i=0;i<v;i++){
                
                if(dfs(i,visited,recStack)){
                    return true;
                }
            }
            
            return false;
            
            
        }
        
        boolean dfs(int i, boolean[] visited,boolean[] recStack){
            
            if(recStack[i])
                return true;
            if(visited[i])
                return false;
            
            visited[i]=true;
            
            recStack[i]=true;
            
           
            Iterator<Integer> itr=adj[i].iterator();
            
            while(itr.hasNext()){
                
                int u=itr.next();
                
                if(dfs(u,visited,recStack))
                    return true;
            }
            
            recStack[i]=false;
            
            return false;
            
            
        }
        
        
    
    

public static void main(String []args){
DirectedCycleDetection g=new DirectedCycleDetection(4);
    g.addEdge(0,1);
    g.addEdge(1,2);
    g.addEdge(2,3);
    
    g.addEdge(0,2);
    
    //SOLVED THE QUERY PROBLEM WITH THE RECURSION

    System.out.println("DOES SYSTEM CONTAINS CYCLE?");
    System.out.println(g.cycleDetect());
    

}

}