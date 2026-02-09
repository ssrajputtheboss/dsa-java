package main.designs.command;

public class Operand {
    private String s = "";
    public void add(String s){
        System.out.println("add: " + s);
        this.s =s;
    }
    public void delete(String s){
        System.out.println("delete: " + s);
        this.s =s;
    }
    public void undo(){
        s="";
    }
}
