package main.designs.singleton;

import java.io.Serial;
import java.io.Serializable;

public class ThreadedSingleton implements Serializable {
    private static ThreadedSingleton instance = null;
    public static ThreadedSingleton getInstance(){
        if(instance == null){
            synchronized (ThreadedSingleton.class){
                instance = new ThreadedSingleton();
            }
        }
        return instance;
    }
    @Serial
    protected Object readResolve() {
        return instance;
    }
}
