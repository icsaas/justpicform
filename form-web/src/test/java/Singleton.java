import java.io.Serializable;

public class Singleton implements Serializable {
    private volatile static Singleton singleton;
    private Singleton(){

    }

    public static Singleton getSingleton(){
        if (singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
    private Object readResolve() {
        return singleton;
    }
}
