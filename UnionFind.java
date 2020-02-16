import java.util.*;
class UnionFind{

    private int size;
    //tracking the sizes of each of the components this one us maybe for the ranks
    private int []sz;
    //id[i] points to parent of i
    private int []id;
    
    private int numComponents;
    
    UnionFind(int size){
        this.size= numComponents= size;
        sz= new int[size];
        id= new int[size];
        for(int i=0;i<size;i++){
            id[i]=i;
            sz[i]=1;
        }
        
    }
    
    public int find(int p){
        //find the root of the component;
        
        int root= p;
        while(root!=id[root])
            root= id[root];
        
        //applying the path compression
        //to achieve amortized path compression
        while(p!=root){
            int next =id[p];
            id[p]=root;
            p=next;
        }
        return root;
    }
    
    //return whether or not p and q belong to the same compoenets
    public boolean connected(int p, int q){
        return find(p)==find(q);
    }
    
    //return the size of the component that p belongs to.. it means returning the number of children of root node of component of p
    public int componentSize(int p){
        return sz[find(p)];
        
    }
    
    public int size(){
        return size;
    }
    
    //union of components containing p and q
    public void unify(int p, int q){
        int root1= find(p);
        int root2= find(q);
        
        if(root1==root2) return;
        
        if(sz[root1]<sz[root2]){
            sz[root2]+=sz[root1];
            id[root1]=root2;
            
        }
        else{
            sz[root1]+=sz[root2];
            id[root2]=root1;
        }
        //since two components are unified therefore 
        numComponents--;
    }
    
    public static void main(String []args){
        String []str= {"A","B","C","D","E","F","G","H","I"};
        HashMap<String, Integer> map= new HashMap<>();
        //creating a bijection mapping
        for(int i=0;i<str.length;i++) map.put(str[i],i);
        UnionFind uf= new UnionFind(9);
        
        uf.unify(map.get("A"), map.get("B"));
        uf.unify(map.get("B"), map.get("D"));
        uf.unify(map.get("F"), map.get("C"));
        uf.unify(map.get("H"), map.get("I"));
        uf.unify(map.get("I"), map.get("G"));
        
        System.out.println(uf.find(map.get("D")));
        System.out.println(uf.find(map.get("H")));
        System.out.println("Component Size "+uf.numComponents);
        
        
        
        
    }
    
    
}