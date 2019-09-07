import java.util.*;
import java.io.*;
class WordLadeer_ShortestChain{
    
    static boolean isNear(String a, String b){
        
        int count=0;
        
        int l=a.length();
        
        for(int i=0;i<l;i++){
            if(a.charAt(i)!=b.charAt(i)) count++;
            if(count>1) return false;
        }
        
        return count==1 ? true : false;
        
        
        
    }
    

    static void shortChain(String start, String target, ArrayList arr){
        
        Queue<Node> q=new LinkedList<Node>();
        
        Node num=new Node(start,1);
        q.add(num);
        
        while(!q.isEmpty()){
            
            Node temp=q.poll();
            
            System.out.print(" "+temp.word+" -> ");
            if(temp.word.equals(target)) {
                System.out.println(" FINAL COUNT "+temp.length+" ");
                break;
            }
            
            for(int i=0;i<arr.size();i++){
                //ADDING ALL THE NODES THAT ARE AT A DIFFERENCE OF 1
                if(isNear(temp.word,(String)arr.get(i))){
                    Node n=new Node((String)arr.get(i), temp.length+1);
                    q.add(n);
                    arr.remove(arr.get(i));                    
                    
                }
            }
            
            
        }
    }
    
public static void main(String []args){

    //STORING THE WORKS
    ArrayList<String> arr=new ArrayList<String>();
    
    arr.add("POON");
    arr.add("PLEE");
    arr.add("SAME");
    arr.add("POIE");
    arr.add("PLIE");
    arr.add("POIN");
    arr.add("PLEA");
    
    String start="TOON";
    String target="PLEA";
    shortChain(start, target,arr);
    
    
    
}
    
    
}

class Node{
    String word;
    int length;
    Node(String word, int length){
        this.word=word;
        this.length=length;
    }
}