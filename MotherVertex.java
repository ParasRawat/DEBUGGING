import java.util.*;
import java.io.*;

class MotherVertex{

    int V;
    LinkedList<Integer> []adj;
    
    MotherVertex(int V){
        this.V=V;
        adj=new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i]=new LinkedList();
        }
    }
    
    void addEdge(int src, int des){
        adj[src].add(des);
    }
    
    int findMother(){
        boolean []visited=new boolean[V];
        for(boolean i: visited) i=false;
        
        int last_v=-1;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                Dfs(i,visited);
                last_v=i;
            }
        }
        
        
        
        
        
         for(int i=0;i<V;i++){
             visited[i]=false;
         }
        Dfs(last_v,visited);
        
        
        
        
        for(boolean i:visited){
            if(!i) return -1;
        }
        
        return last_v;
    }
    
    
    void Dfs(int i, boolean[] visited ){
        
        visited[i]=true;

        LinkedList<Integer> list= adj[i];
        
        for(int j: list){
            if(!visited[j]){
                Dfs(j, visited);
            }
        }
    }
    
    public static void main(String []args){
    MotherVertex g=new MotherVertex(7);
        
  g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(1, 3); 
    g.addEdge(4, 1); 
    g.addEdge(6, 4); 
    g.addEdge(5, 6); 
    g.addEdge(5, 2); 
    g.addEdge(6,0);
    
    int m=g.findMother();
        if(m==-1) System.out.println("Not possible");
        else{
            System.out.println(m);
        }
    }
}