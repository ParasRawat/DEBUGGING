class GraphCycle{

int V,E;

Edge []edge;
 class Edge{

 int src;
 int des;

}
GraphCycle(int v, int e){
    V= v;
    E= e;
    edge=new Edge[E];
    for(int i=0;i<E;i++){
        edge[i]=new Edge();
        
    }
}

    int find(int []parent, int i ){
        
        if(parent[i]== -1) return i;
        
        return find(parent,parent[i]);
    }
    
    void union(int []parent, int x, int y){
        int xset= find(parent, x);
        int yset= find(parent, y);
        
        parent[xset]=yset;
    }
    
    int isCycle(GraphCycle graph){
        int []parent= new int [graph.V];
        for (int i=0; i<graph.V; ++i) 
            parent[i]=-1; 
        for(int i=0;i<graph.E;i++){
            
            int x=graph.find(parent, graph.edge[i].src);
            int y=graph.find(parent, graph.edge[i].des);
            
            if(x==y) return 1;
            
            graph.union(parent, x, y);
        }
        
        return 0;
    }
    
    public static void main(String []args){
        
        int v=3, e=3;
        GraphCycle graph=new GraphCycle(v,e);
        graph.edge[0].src = 0; 
        graph.edge[0].des = 1; 
  
      
        graph.edge[1].src = 1; 
        graph.edge[1].des = 2; 
  
        
        graph.edge[2].src = 0; 
        graph.edge[2].des = 2; 
        
        if(graph.isCycle(graph)==1){
            System.out.println(" YES ");
        }
        else{
            System.out.println(" YES ");
        }
        
    }

}