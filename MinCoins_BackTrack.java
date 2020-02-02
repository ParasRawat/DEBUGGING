import java.util.*;
class MinCoins_BackTrack{
    static int minCoin(int []coins, int m, int V){
        
        if(V==0) return 0;
        
        int res= Integer.MAX_VALUE;
        
        
        
        for(int i=0;i<m;i++){
            
            if(coins[i]<=V){
            
            int subres = minCoin(coins, m, V-coins[i]);
            
            if(subres!=Integer.MAX_VALUE && res>subres+1){
                
                res=subres+1;
            }
            }
        }
        
        return res;
        
        
    }
    public static void main(String []ar){
        
        int []coins={9, 6, 5, 1};
        int V= 11;
        
        System.out.println(minCoin(coins, 4, V));
    }
    
}