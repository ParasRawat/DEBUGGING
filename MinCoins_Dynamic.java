import java.util.*;
class MinCoins_Dynamic{
    static int minCoins(int []coins, int m, int V){
        //entry table[i] will be storing minimum number of coins for the i value;
        
        int []table= new int [V+1];
        
        for(int i=0;i<=V;i++) table[i] = Integer.MAX_VALUE;
        
        
        
        table[0]=0;
        
        for(int i=1;i<=V;i++){
            
            for(int j=0; j<m;j++){
                
                if(coins[j]<=i){
                    
                    int subres= 1+ table[ i - coins[j]];
                    
                    if(subres<table[i]) {
                        
                        table[i]=subres
                    }
                    
                }
            }
        }
        
        
        return table[V];
       
        
    }
    
    public static void main(String []args){
        
        int []coins= {9, 6, 5, 1};
        int V=30;
        int m= coins.length;
        
        System.out.println("Min coins "+minCoins(coins, m, V));
        
    }

}