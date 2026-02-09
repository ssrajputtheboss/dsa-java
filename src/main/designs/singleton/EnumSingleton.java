package main.designs.singleton;

import java.util.HashMap;

public enum EnumSingleton {
    DEBUG,INFO,ERROR,NONE;
    public static  EnumSingleton level = DEBUG;
    private static  HashMap<EnumSingleton,Integer> priority = new HashMap<>();

    public static void init(){
        priority.put(DEBUG,1);
        priority.put(INFO,2);
        priority.put(ERROR,3);
        priority.put(NONE,4);
    }
    public void log(String s){
        if(level.equals(NONE) || this.equals(NONE))return;
        if(priority.get(this) >= priority.get(level)){
            System.out.println(s);
        }
    }
}
