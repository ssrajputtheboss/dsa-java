package main.logger;

// singleton
public class CustomLogger {
    private static CustomLogger instance = null;
    public static CustomLogger getInstance(){
        if(instance == null){
            synchronized (CustomLogger.class) {
                instance = new CustomLogger();
            }
        }
        return instance;
    }
    private volatile boolean enabled;
    public void enable(){
        this.enabled = true;
    }
    public void disable(){
        this.enabled = true;
    }
    public CustomLogger(){
        enabled = false;
    }
    public CustomLogger(boolean enabled){
        this.enabled = enabled;
    }

    private void log(String separator, Object[] objs){
        if(!enabled)return;
        StringBuilder sb = new StringBuilder();
        int objLen = objs.length;
        for(int i =0;i<objLen-1;++i){
            sb.append(objs[i].toString());
            sb.append(separator);
        }
        if(objLen > 0) {
            sb.append(objs[objLen-1]);
        }
        System.out.println(sb.toString());
    }

    public void log(Object... o){
        log(" ", o);
    }
    public void log2(String separator, Object... o){
        log(separator, o);
    }
}
