//SORTING OF ARRAYS USING THE COMPARABLE INTERFACE
import java.io.*;
import java.util.*;
class KruskalMinimumSpanningTree{
    
    class Edge implements Comparable<Edge>{
        int src, dest, weight;
        
        public int compareTo(Edge compareEdge){
            return this.weight-compareEdge.weight;
        }
    }
    class subset{
        int parent, rank;
        
    }
    int v;
    Edge []edges;
    KruskalMinimumSpanningTree(int v, int e){
        this.v=v;
        edges=new Edge[e];
        for(int i=0;i<e;i++) edges[i]=new Edge();
        
    }
    
    int find(subset []subsets, int i){
        if(subsets[i].parent!=i){
            subsets[i].parent=find(subsets, subsets[i].parent);
        }
        
        return subsets[i].parent;
    }
    void union(subset[] subsets, int x, int y){
        int xroot= find(subsets,x);
        int yroot= find(subsets,y);
        
        if(subsets[xroot].rank<subsets[yroot].rank){
            subsets[xroot].parent=yroot;
        }
        else if(subsets[xroot].rank > subsets[yroot].rank){
            subsets[yroot].parent=xroot;
        }
        else{
            subsets[yroot].parent=xroot;
            subsets[xroot].rank++;
        }
        
    }
    void KruskalMst(){
        Edge []result= new Edge[v];
        int e=0;
        int i=0;
        for(int j=0;j<v;j++) result[j]=new Edge();
        Arrays.sort(edges);
        
        subset []subsets=new subset[v];
        for(int j=0;j<v;j++){
            subsets[j]=new subset();
            subsets[j].parent=j;
            subsets[j].rank=0;
        }
        
        while(e<v-1){
            Edge next_edge= edges[i++];
            
            int x=find(subsets,next_edge.src);
            int y=find(subsets,next_edge.dest);
            
            if(x!=y){
                result[e++]=next_edge;
                union(subsets,x,y);
            }
        }
        
        for(Edge edge : result) System.out.println(edge.src+"   "+edge.dest);
        
        
    }
    
    public static void main(String []args){
        int v=4;
        int e=5;
        KruskalMinimumSpanningTree graph=new KruskalMinimumSpanningTree(v,e);
        graph.edges[0].src = 0; 
        graph.edges[0].dest = 1; 
        graph.edges[0].weight = 10; 
  
        // add edge 0-2 
        graph.edges[1].src = 0; 
        graph.edges[1].dest = 2; 
        graph.edges[1].weight = 6; 
  
        // add edge 0-3 
        graph.edges[2].src = 0; 
        graph.edges[2].dest = 3; 
        graph.edges[2].weight = 5; 
  
        // add edge 1-3 
        graph.edges[3].src = 1; 
        graph.edges[3].dest = 3; 
        graph.edges[3].weight = 15; 
  
        // add edge 2-3 
        graph.edges[4].src = 2; 
        graph.edges[4].dest = 3; 
        graph.edges[4].weight = 4; 
  
        graph.KruskalMst();
    }
    
}