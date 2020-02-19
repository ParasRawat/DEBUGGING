class FenwickTree{

    
    private long []tree;
    
    //cloning constructor
    FenwickTree(long [] values){
        if(values!=null){
            this.tree= values.clone();
            
        }
        //constructing the fenwick tree;
        int length= values.length;
        
        tree= new long[length];
        
        for(int i=0;i<length;i++){
            tree[i]=values[i];
        }
        for(int i=1; i<tree.length;i++){
            int j= i +lsb(i);
            if(j<tree.length) tree[j]+=tree[i];
        }
        
    }
    
    public int  lsb(int i){
        int pos=1;
        while((i&1)!=1){
            i=i>>1;
            
            pos*=2;
        }
        
        return pos;
        
        //alternative return i & -i;
    }
    
    public  long prefixSum(int i){
        long sum=0L;
        
        while(i!=0){
            sum+=tree[i];
            i-=lsb(i);
        }
       return sum; 
    }
    
    long  sum(int i, int j){
        return prefixSum(j)- prefixSum(i-1);
        
    }
    
    void add(int i, long k){
        while(i<tree.length){
            tree[i]+=k;
            i+=lsb(i);
        }
    }
    
    void printArray(){
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
    }
 
    public static void main(String []args){
        long []arr= {0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L ,8L, 9L};
        FenwickTree tree= new FenwickTree(arr);
        System.out.println(tree.prefixSum(9));
        System.out.println(tree.sum(5,9));
        tree.add(1,10L);
        tree.printArray();
        
    }
}