import java.util.*;

public class GraphOfCities{

public static void main(String []args){
    //HASHMAP IMPLEMEMTATION
    
    CitiesGraph<String> g=new CitiesGraph<String>();
    
    g.addEdge("Amritsar","Delhi");
    g.addEdge("Amritsar","Jaipur");
    g.addEdge("Delhi","Siachen");
    g.addEdge("Delhi","Bangalore");
    g.addEdge("Delhi","Agra");
    g.addEdge("Amritsar","Siachen");
    
    g.printAdjList();
    
}
    
}
//WE ARE CREATING A GENERIC GRAPH
class CitiesGraph<T>{
    
    Map<T,List<T>> adjList=new HashMap<>();
    
    CitiesGraph(){
        
    }
    
    void addEdge(int u,int v){
        
    }
    
    //ADD VERTEX FUNCTION TO COMPENSATE FOR THE OOP PRINCIPLE OF NEW METHODOLOGY
    //AT FIRST WE WOULD NEED TO ADD ALL THE VERTICES
    void addVertex(T s){
        
        adjList.put(s, new LinkedList<T>());
        
    }
    
    void addEdge(T u,T v){
        
        //AUTOMATICALLY CREATING THE MAP
       if(!adjList.containsKey(u)) addVertex(u);
        
        if(!adjList.containsKey(v)) addVertex(v);
        
        adjList.get(u).add(v);
        adjList.get(v).add(u);
        
    }
    
    void printAdjList(){
        for(Map.Entry<T,List<T>> entry:adjList.entrySet()){
            
            
            System.out.print(entry.getKey()+" ->");
            
            for(T t: entry.getValue()){
                System.out.print(t+" ");
            }
            
            System.out.println("");
        }
        
    }
    
    
    
    
    
}

