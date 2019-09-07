class Singleton{

    private static Singleton singleton_instance=null;

    public String s;
    
    private Singleton(){
        
        s=" CURRENTLY ISRO MIGHT NOT SUCCEED";
        
    }
    
    public static Singleton getInstance(){
        
        if(singleton_instance==null) singleton_instance=new Singleton();
        
        return singleton_instance;
    }

}

class Main{

public static void main(String []ar){

    Singleton a=Singleton.getInstance();
    Singleton b=Singleton.getInstance();
    Singleton c=Singleton.getInstance();
    
    System.out.println(a.s);
    System.out.println(b.s);
    System.out.println(c.s);
    
    a.s=" BUT ISRO WILL SUCCEED, WE HAVE FAITH !";
        

    System.out.println(a.s);
    System.out.println(b.s);
    System.out.println(c.s);
}
}