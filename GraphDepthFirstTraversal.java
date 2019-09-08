import java.util.*;
import java.io.*;
class GraphDepthFirstTraversal{

    //NUMBER OF VERTICES
    int v;
    //ARRAY WHOSE EACH ELEMENT IS A LINKEDLIST OF INTEGER
    LinkedList<Integer> []adj;
    GraphDepthFirstTraversal(int v){
    this.v=v;
    adj=new LinkedList[v];
    
    for(int i=0;i<v;i++){
    adj[i]=new LinkedList();
    }
    
    }
    
    void addEdge(int u, int v){
        adj[u].add(v);
    }
    
    void Dfs(int n){
        
        boolean []visited=new boolean[v];
        DfsUtil(n,visited);
    }
    
    void DfsUtil(int v, boolean[] visited){

        visited[v]=true;
        
        System.out.print(v+" ");
        
        Iterator<Integer> itr=adj[v].listIterator();
        
        while(itr.hasNext()){
            int n=itr.next();
            
            if(!visited[n]){
                DfsUtil(n,visited);
            }
        }
    }
    
    
    
    public static void main(String []a){
    GraphDepthFirstTraversal g=new GraphDepthFirstTraversal(4);
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        
        g.Dfs(2);
        
    
    }
 
}