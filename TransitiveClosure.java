import java.util.*;
class TransitiveClosure{
int v;
LinkedList<Integer> [] adj;
TransitiveClosure(int v){
    this.v=v;
    adj=new LinkedList[v];
    for(int i=0;i<v;i++) adj[i]=new LinkedList();
}
void addEdge(int u,int v){
    adj[u].add(v);

}
void closure(int v){

    int [][]tc=new int[v][v];
    
    for(int i=0;i<v;i++){
        
        dfs(i,i, tc);
    }
    
    print(tc);
}
void dfs(int s, int des, int [][]tc){
    
    tc[s][des]=1;
    
    
    for(int i: adj[des]) {
        if(tc[s][i]==0){
        dfs(s,i,tc);
    }
    }
        
}
void print(int [][]tc){
    for(int i=0;i<v;i++){
        for(int j=0;j<v;j++){
            System.out.print(tc[i][j]+"  ");
        }
        System.out.println();
    }
}
public static void main(String []args){
    TransitiveClosure g=new TransitiveClosure(4);
    g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
    g.closure(4);
    
    
}
}