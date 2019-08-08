import java.util.*;
class GraphWebinar{

public static void main(String []args){
    
    //SELF TRAINED
    System.out.println("CODING BLOCKS WEBINAR");
    
    MyGraph g=new MyGraph(4);
    g.addEdge(0,1,true);
    g.addEdge(0,2,true);
    g.addEdge(0,3,true);
    g.addEdge(1,3,true);
    g.addEdge(3,2,true);
    g.printAdList();
    
    
}
}

class MyGraph{
    
    //YOU NEED A ARRAY OF LIST
    int V;
   LinkedList<Integer> adList[];
    MyGraph(int v){
        V=v;
        adList=new LinkedList[V];
        //ARRAYS OF  ARRAY OF LINKEDLIST
        
        for(int i=0;i<V;i++){
            adList[i]=new LinkedList<Integer>();
        }
        }
    
    
    void addEdge(int u,int v, boolean bidir){
        
        adList[u].add(v);
        
        if(bidir) adList[v].add(u);
        
    }
    
    void printAdList(){
        for(int i=0;i<V;i++){
            System.out.print(i+" -> ");
            
            for(Integer j:adList[i]){
                System.out.print(j+" ");
            }
            
            System.out.println();
        }
    }
}

