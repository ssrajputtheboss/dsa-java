package main.designs.singleton;

public class Main {
    public static void main(String[] args) {
        EnumSingleton.init();
        EnumSingleton.level = EnumSingleton.INFO;
        EnumSingleton.INFO.log("info");
        EnumSingleton.DEBUG.log("debug");
        EnumSingleton.ERROR.log("error");
        System.out.println(ThreadedSingleton.getInstance().toString());
        System.out.println(ThreadedSingleton.getInstance().toString());

        System.out.println(LazySingleton.getInstance().toString());
        System.out.println(LazySingleton.getInstance());
    }
}
