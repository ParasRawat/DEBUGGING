import java.util.*;
import java.io.*;

class TopologicalSort{
    
    private int V; // number of vertices
    private LinkedList<Integer> adj[];
    
    TopologicalSort(int v){
        
        V=v;
        adj=new LinkedList[V];
        
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }
    
    }
    
    //ADDING EDGE FUNCTION
    void addEdge(int v, int w){
        adj[v].add(w);
    }
    
    void topologicalSort(int v, boolean visited[], Stack stack){
        visited[v]=true;
        
        Integer i;
        
        //RECURRING FOR ALL THE VERTICES ADJACENT TO THIS VERTEX;
        Iterator<Integer> it=adj[v].iterator();
        
        while(it.hasNext()){
            
            i=it.next();
            if(!visited[i]) topologicalSort(i,visited,stack);
        }
        
        stack.push(new Integer(v));
        
    }
    
    void tp(){
        
        Stack stack=new Stack();
        
        boolean []visited=new boolean[V];
        
        for(int i=0;i<V;i++){
            
            visited[i]=false;
        }
        
        for(int i=0;i<V;i++){
            if(visited[i]==false) topologicalSort(i, visited, stack);
        }
        
        while(stack.empty()==false){
            
            System.out.print(stack.pop()+" ");
        }
    }
    
    public static void main(String []a){
        
        TopologicalSort g = new TopologicalSort(6); 
         g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
        
        System.out.println("TOPOLOGICAL SORTING  ");
        g.tp();
        
    
    }

}