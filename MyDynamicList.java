import java.util.*;
import java.io.*;

class MyDynamicList<T> implements Iterable<T>{

    private T[] arr;
    private int len=0; //the length user thinks array is 
    private int capacity=0; //Actual array size;
    
    public MyDynamicList(){
        this(16);
    }
    public MyDynamicList(int capacity){
        this.capacity=capacity;
        arr= (T[]) new Object[capacity];
        
    }
    public int size(){return len;}
    public boolean isEmpty(){
        return size()==0;
    }
    public T get(int index){
        return arr[index];
        
    }
    public void set(int index, T element){
        arr[index]=element;
    }
    public void clear(){
        for(int i=0;i<capacity;i++){
            arr[i]=null;
        }
        len=0;
    }
    public void add(T element){
        
        if(len+1 >=capacity){
            //means we have reached the capacity
            if(capacity==0){
                
                capacity=1;
                           }
            else{
                capacity*=2;
                
            }
            
            T []newarr= (T[]) new  Object[capacity];
            for(int i=0;i<len;i++){
                newarr[i]=arr[i];
                
            }
            arr=newarr;

            
            
        }
        arr[len++]=element;
    }
    public T removeAt(int rmindex){
        
        T data=arr[rmindex];
        T[] narr=(T[]) new Object[len-1];
        
        for(int i=0, j=0;i<len;i++,j++){
            if(i==rmindex) j--; //holding temporaray increase in the value of j
            else{
                narr[j]=arr[i];
            }
            
        }
        arr=narr;
        capacity= --len;
         return data;
    }
    
    public int indexOf(Object obj){
        for(int i=0;i<len;i++){
            if(arr[i].equals(obj))
                return i;
        }
        return -1;
        
    }
    public boolean contains(Object obj){
        return indexOf(obj)==-1;
        
    }
    public Iterator <T> iterator(){
        return new Iterator<T>(){
            int index=0;
            public boolean hasNext(){return index<len;}
            
            public T next(){ return arr[index++];}
            
        };
    }
    
    public String toString(){
        if(len==0) return "[]";
        else{
            StringBuilder sb= new StringBuilder(len).append("[");
            
            for(int i=0;i<len-1;i++)
                sb.append(arr[i]+" , ");
            return sb.append(arr[len-1]+"]").toString();
            
        }
    }
    
    public static void main(String []ar){
        MyDynamicList<Integer> md=new MyDynamicList(2);
        md.add(1);
        md.add(2);
        md.add(3);
        md.add(90);
        
        System.out.println(md.toString());
    }
    
    
} 