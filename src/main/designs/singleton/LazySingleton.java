package main.designs.singleton;

public class LazySingleton {
    private static LazySingleton instance = null;
    public static LazySingleton getInstance(){
        return instance =(instance == null ? new LazySingleton():instance);
    }
    private LazySingleton(){

    }
}
